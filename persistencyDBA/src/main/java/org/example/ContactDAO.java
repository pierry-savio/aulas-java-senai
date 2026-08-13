package org.example;

import javax.xml.crypto.Data;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactDAO {

    //CREATE
    public void add(Contact contact){
        // ? placeholder informar o que será adicionado e evita SQL injection
        String sql = "INSERT INTO contacts(name, phoneNumber) VALUES(?, ?)";
        try (Connection conn = Database.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)){
            //Define os valores para os placeholders
            pstmt.setString(1, contact.getName());
            pstmt.setString(2, contact.getPhoneNumber());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro: ao adicionar contato: " + e.getMessage());
        }
    }

    //READ
    public List<Contact> list(){
        List<Contact> contacts = new ArrayList<>();
        String sql = "SELECT * FROM contacts";

        try (Connection conn = Database.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)){

            while(rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String phoneNumber = rs.getString("phoneNumber");
                contacts.add(new Contact(id, name, phoneNumber));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar contatos: " + e.getMessage());
        }
        return contacts;
    }

    //UPDATE
    public void update(Contact contact){
        String sql = "UPDATE contacts SET name = ?, phoneNumber = ? WHERE id = ?";
        try (Connection conn = Database.connect();
        PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, contact.getName());
            pstmt.setString(2, contact.getPhoneNumber());
            pstmt.setInt(3, contact.getId());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar contato: " + e.getMessage());
        }
    }

    //DELETE
    public void delete(int id){
        String sql = "DELETE FROM contacts WHERE id = ?";
        try (Connection conn = Database.connect();
        PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }catch (SQLException e){
            System.out.println("Erro ao remover contato: " + e.getMessage());
        }
    }
}
