package org.example;

import java.sql.*;

public class PedidoDAO {

    public double buscarDescontoDoDia() throws SQLException {
        String sql = """
                SELECT percentual
                FROM cupom
                WHERE data_cupom = CURRENT_DATE()
                AND ativo = TRUE
                LIMIT 1
                """;
        try(
                Connection conexao = Conexao.conectar();
                PreparedStatement comando = conexao.prepareStatement(sql);
                ResultSet resultado = comando.executeQuery()
                ){
            if (resultado.next()){
                return resultado.getDouble("percentual");
            }
        }
        return 0;
    }
    public Pedido salvar(Pedido pedido) throws SQLException{
        String sql = """
                INSERT INTO pedidos(
                codigo, nome_aluno, matricula, periodo,
                produto_id, quantidade, valor_original,
                percentual_desconto, valor_final, status
                )
                VALUES (?,?,?,?,?,?,?,?,?,?)
                """;
        try (
                Connection conexao = Conexao.conectar();
                PreparedStatement comando = conexao.prepareStatement(
                        sql, Statement.RETURN_GENERATED_KEYS
                )
                ){
            comando.setString(1, pedido.getCodigo());
            comando.setString(2, pedido.getNomeAluno());
            comando.setString(3, pedido.getMatricula());
            comando.setString(4, pedido.getPeriodo());
            comando.setInt(5, pedido.getProdutoId());
            comando.setInt(6, pedido.getQuantidade());
            comando.setDouble(7, pedido.getValorOriginal());
            comando.setDouble(8, pedido.getPercentualDesconto());
            comando.setDouble(9, pedido.getValorFinal());
            comando.setString(10, pedido.getStatus());
            comando.executeUpdate();
            try (ResultSet chaves = comando.getGeneratedKeys()){
                if (chaves.next()){
                    pedido.setId(chaves.getInt(1));
                }
            }
        }
        return pedido;
    }
}
