package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

    //Diz ao jdbc para usar o Sqlite e qual arquivo
    private static final String URL = "jdbc:sqlite:agenda.db";

    //Retorna um objeto de conexão com o banco
    public static Connection connect(){
        try{
            return DriverManager.getConnection(URL);
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            return null;
        }
    }
    public static void createTable(){
        String sql = "CREATE TABLE IF NOT EXISTS contacts ("
                   + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                   + "name TEXT NOT NULL,"
                   + "phoneNumber TEXT"
                   + ");";
        try (
             Connection conn = connect();
             Statement stmt = conn.createStatement()
            )
        {
             stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println("Erro ao criar tabela: " + e.getMessage());
        }
    }
}
