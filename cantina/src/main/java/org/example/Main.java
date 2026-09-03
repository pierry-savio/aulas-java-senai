package org.example;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.SimpleFileServer;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Executable;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Main {

    private static final int PORTA = 8080;
    private static final Gson GSON = new Gson();
    private static final PedidoDAO PEDIDO_DAO = new PedidoDAO();
    private static final ProdutoDAO PRODUTO_DAO = new ProdutoDAO();
    private static final Set<String> PERIODOS = Set.of(
            "Manhã", "Tarde", "Noite"
    );

    public static void main(String[] args) throws Exception {
        Conexao.testar();

        HttpServer servidor = HttpServer.create(new InetSocketAddress(PORTA), 0);

        servidor.createContext("/api/cardapio", Main::tratarCardapio);
        servidor.createContext("/api/pedidos", Main::tratarPedido);

        Path pastaFrontend = Path.of("src/main/resources/static")
                .toAbsolutePath()
                .normalize();
        if (!Files.isDirectory(pastaFrontend)){
            throw new IllegalStateException("Fronted não encontrado em: " + pastaFrontend);
        }
        HttpHandler arquivos = SimpleFileServer.createFileHandler(pastaFrontend);
        servidor.createContext("/", exchange -> {
            if (exchange.getRequestURI().getPath().equals("/")){
                exchange.getResponseHeaders().set("Location", "/index.html");
                exchange.sendResponseHeaders(302, -1);
                exchange.close();
                return;
            }
            arquivos.handle(exchange);
        });
        servidor.setExecutor(Executors.newFixedThreadPool(8));
        servidor.start();

        System.out.println("Banco conectado com sucesso!!!");
        System.out.println("Cantina SENAI http://localhost:" + PORTA);
        System.out.println("Pressione Ctrl + C para encerrar.");
    }

    private static void tratarCardapio(HttpExchange exchange) throws IOException {
        if (!exchange.getRequestMethod().equals("GET")){
            responder(exchange, 405, Map.of(
               "erro", "Use o método GET"
            ));
            return;
        }
        try{
            List<Produto> produtos = PRODUTO_DAO.listarDisponiveis();
            double descontoHoje = PEDIDO_DAO.buscarDescontoDoDia();
            responder(exchange, 200, Map.of(
                    "descontoHoje", descontoHoje, "produtos", produtos
            ));
        } catch (SQLException exception) {
            exception.printStackTrace();
            responder(exchange, 500, Map.of(
                    "erro", "Não foi possível consultar o banco"
            ));
        }
    }

    private static void tratarPedido(HttpExchange exchange) throws IOException {
        if (!exchange.getRequestMethod().equals("POST")){
            responder(exchange, 405, Map.of(
               "erro", "Use o método POST!!!"
            ));
            return;
        }
        try {
            Pedido pedido;
            try (InputStreamReader leitor = new InputStreamReader(
                    exchange.getRequestBody(),
                    StandardCharsets.UTF_8
            )){
                pedido = GSON.fromJson(leitor, Pedido.class);
            }
            Optional<String> erro = validar(pedido);
            if (erro.isPresent()){
                responder(exchange, 400, Map.of("erro", erro.get()));
                return;
            }
            Optional<Produto> produtoEncontrado = PRODUTO_DAO.buscarPorId(
                    pedido.getProdutoId()
            );
            if (produtoEncontrado.isEmpty()){
                responder(exchange, 404, Map.of(
                        "erro", "Produto indisponível ou não encontrado."
                ));
                return;
            }
            Produto produto = produtoEncontrado.get();
            double percentual = PEDIDO_DAO.buscarDescontoDoDia();
            double original = arredondar(
                    produto.getPreco() * pedido.getQuantidade()
            );
            double finalComDesconto = arredondar(
                    original - (original * percentual / 100)
            );
            pedido.setNomeAluno(pedido.getNomeAluno().trim());
            pedido.setMatricula(pedido.getMatricula().trim());
            pedido.setProdutoNome(produto.getNome());
            pedido.setCodigo(gerarCodigo());
            pedido.setValorOriginal(original);
            pedido.setPercentualDesconto(percentual);
            pedido.setValorFinal(finalComDesconto);
            pedido.setStatus("RECEBIDO");

            PEDIDO_DAO.salvar(pedido);
            responder(exchange, 202, pedido);
        } catch (JsonSyntaxException exception) {
            responder(exchange, 400, Map.of(
                    "erro", "O JSON enviado é inválido"
            ));
        } catch (SQLException exception){
            exception.printStackTrace();
            responder(exchange, 500, Map.of(
                    "erro", "Não foi possível salvar o pedido."
            ));
        }
    }

    private static Optional<String> validar(Pedido pedido) {
        if (pedido == null){
            return Optional.of("Envie os dados do pedido.");
        }
        if (pedido.getNomeAluno() == null || pedido.getNomeAluno().isBlank()) {
            return Optional.of("Informe o nome do aluno");
        }
        if (pedido.getNomeAluno().trim().length() > 100){
            return Optional.of("O nome deve ter no máximo 100 caracteres.");
        }
        if (pedido.getMatricula() == null || pedido.getMatricula().isBlank()){
            return Optional.of("Informe a matrícula.");
        }
        if (pedido.getMatricula().trim().length() > 30) {
            return Optional.of("A matrícula deve ter no máximo 30 caracteres");
        }

        if (!PERIODOS.contains(pedido.getPeriodo())){
            return Optional.of("Selecione Manhã, Tarde ou Noite");
        }
        if (pedido.getProdutoId() <= 0){
            return Optional.of("Escolha um produto.");
        }
        if (pedido.getQuantidade() < 1 || pedido.getQuantidade() > 10){
            return Optional.of("A quantidade deve estar entre 1 e 10");
        }
        return Optional.empty();
    }

    private static String gerarCodigo() {
        return "CANT-" + UUID.randomUUID().toString().substring(0,8).toUpperCase();
    }

    private static double arredondar(double valor) {
        return Math.round(valor * 100.0) / 100.0;
    }

    private static void responder(
            HttpExchange exchange, int status, Object conteudo) throws IOException{
        byte[] resposta = GSON.toJson(conteudo).getBytes(StandardCharsets.UTF_8);
        exchange.getRequestHeaders().set(
                "Content-Type", "application/json/ charset=UTF-8");
        exchange.getRequestHeaders().set("Cache-Control", "no-store");
        exchange.sendResponseHeaders(status, resposta.length);
        try (OutputStream saida = exchange.getResponseBody()) {
            saida.write(resposta);
        }
    }
}