package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SellDAO {
    private static final String URL = "jdbc:h2:./sells_db";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public SellDAO() {
        createTableIfNotExists();
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    private void createTableIfNotExists() {
        String sql = """
                CREATE TABLE IF NOT EXISTS sell(
                id INT AUTO_INCREMENT PRIMARY KEY,
                product VARCHAR(100), 
                category VARCHAR(50),
                unit_value DOUBLE,
                quantity INT
                );
                """;
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement()){
            stmt.execute(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void save(Sell sell){
        String sql = "INSERT INTO sell(product, category, unit_value, quantity)" +
                "VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, sell.getProduct());
            pstmt.setString(2, sell.getCategory());
            pstmt.setDouble(3, sell.getUnitValue());
            pstmt.setInt(4, sell.getQuantity());
            pstmt.executeUpdate();
            System.out.println("Venda registrada com sucesso!!!");

        } catch (SQLException e) {
            System.out.println("Erro ao salvar no banco: " + e.getMessage());
        }
    }

    public List<Sell> listAll(){
        List<Sell> list = new ArrayList<>();
        String sql = "SELECT * FROM sell";
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()){
                Sell s = new Sell();
                s.setId(rs.getInt("id"));
                s.setProduct(rs.getString("product"));
                s.setCategory(rs.getString("category"));
                s.setUnitValue(rs.getDouble("unit_value"));
                s.setQuantity(rs.getInt("quantity"));
                list.add(s);
            }
        }catch (SQLException e){
            System.out.println("Erro ao buscar vendas: " + e.getMessage());
        }
        return list;
    }
}
