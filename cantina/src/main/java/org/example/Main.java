package org.example;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.file.Path;
import java.sql.SQLException;
import java.util.Set;

public class Main {

    private static final int PORTA = 8080;
    private static final Gson GSON = new Gson();
    private static final PedidoDAO PEDIDO_DAO = new PedidoDAO();
    private static final ProdutoDAO PRODUTO_DAO = new ProdutoDAO();
    private static final Set<String> PEDIDOS = Set.of(
            "Manhã", "Tarde", "Noite"
    );

    public static void main(String[] args) {
        Conexao.testar();

        HttpServer servidor = HttpServer.create(new InetSocketAddress(PORTA), 0);

        servidor.createContext("/api/cardapio", Main::tratarCardapio);
        servidor.createContext("/api/pedidos", Main::tratarPedido);

        Path pastaFrontend = Path.of("src/main/resources/static")
                .toAbsolutePath()
                .normalize();
    }

    private static void tratarPedido(HttpExchange httpExchange) {
    }

    private static void tratarCardapio(HttpExchange httpExchange) {
    }
}