package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IntencaoDAO {

    public void salvar(Intencao intencao) {
        String sql = "INSERT INTO intencoes (descricao, sinal_id) VALUES (?, ?)";

        try (Connection con = Conexao.getConexao();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, intencao.getDescricao());
            stmt.setInt(2, intencao.getSinalId());

            stmt.executeUpdate();
            System.out.println("Intenção salva com sucesso!");

        } catch (SQLException e) {
            System.out.println("ERRO ao salvar intenção: " + e.getMessage());
        }
    }

    public List<Intencao> buscarTodos() {
        List<Intencao> lista = new ArrayList<>();
        String sql = "SELECT * FROM intencoes";

        try (Connection con = Conexao.getConexao();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Intencao i = new Intencao();
                i.setId(rs.getInt("id"));
                i.setDescricao(rs.getString("descricao"));
                i.setSinalId(rs.getInt("sinal_id"));
                i.setCriadoEm(rs.getString("criado_em"));
                lista.add(i);
            }

        } catch (SQLException e) {
            System.out.println("ERRO ao buscar intenções: " + e.getMessage());
        }

        return lista;
    }

    public void deletar(int id) {
        String sql = "DELETE FROM intencoes WHERE id = ?";

        try (Connection con = Conexao.getConexao();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Intenção deletada com sucesso!");

        } catch (SQLException e) {
            System.out.println("ERRO ao deletar: " + e.getMessage());
        }
    }
}