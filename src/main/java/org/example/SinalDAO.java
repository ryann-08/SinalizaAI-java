package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SinalDAO {

    // SALVAR um sinal novo no banco
    public void salvar(Sinal sinal) {
        String sql = "INSERT INTO sinais (nome, categoria, ativo) VALUES (?, ?, ?)";

        try (Connection con = Conexao.getConexao();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, sinal.getNome());
            stmt.setString(2, sinal.getCategoria());
            stmt.setBoolean(3, sinal.isAtivo());

            stmt.executeUpdate();
            System.out.println("PARABÉNS! Sinal salvo com sucesso no MySQL!");

        } catch (SQLException e) {
            System.out.println("ERRO ao salvar no banco: " + e.getMessage());
        }
    }


    public List<Sinal> buscarTodos() {
        List<Sinal> lista = new ArrayList<>();
        String sql = "SELECT * FROM sinais";

        try (Connection con = Conexao.getConexao();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Sinal s = new Sinal();
                s.setId(rs.getInt("id"));
                s.setNome(rs.getString("nome"));
                s.setCategoria(rs.getString("categoria"));
                s.setAtivo(rs.getBoolean("ativo"));
                lista.add(s);
            }

        } catch (SQLException e) {
            System.out.println("ERRO ao buscar sinais: " + e.getMessage());
        }

        return lista;
    }

    // BUSCAR um sinal pelo ID
    public Sinal buscarPorId(int id) {
        String sql = "SELECT * FROM sinais WHERE id = ?";

        try (Connection con = Conexao.getConexao();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Sinal s = new Sinal();
                s.setId(rs.getInt("id"));
                s.setNome(rs.getString("nome"));
                s.setCategoria(rs.getString("categoria"));
                s.setAtivo(rs.getBoolean("ativo"));
                return s;
            }

        } catch (SQLException e) {
            System.out.println("ERRO ao buscar por ID: " + e.getMessage());
        }

        return null;
    }

    // DELETAR um sinal pelo ID
    public void deletar(int id) {
        String sql = "DELETE FROM sinais WHERE id = ?";

        try (Connection con = Conexao.getConexao();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Sinal deletado com sucesso!");

        } catch (SQLException e) {
            System.out.println("ERRO ao deletar: " + e.getMessage());
        }
    }
}