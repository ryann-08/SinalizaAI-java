package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ModeloTreinadoDAO {

    public void salvar(ModeloTreinado modelo) {
        String sql = "INSERT INTO modelos_treinados (nome, versao, arquivo_mod, ativo) VALUES (?, ?, ?, ?)";

        try (Connection con = Conexao.getConexao();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, modelo.getNome());
            stmt.setString(2, modelo.getVersao());
            stmt.setString(3, modelo.getArquivoMod());
            stmt.setBoolean(4, modelo.isAtivo());

            stmt.executeUpdate();
            System.out.println("Modelo salvo com sucesso!");

        } catch (SQLException e) {
            System.out.println("ERRO ao salvar modelo: " + e.getMessage());
        }
    }

    public List<ModeloTreinado> buscarTodos() {
        List<ModeloTreinado> lista = new ArrayList<>();
        String sql = "SELECT * FROM modelos_treinados";

        try (Connection con = Conexao.getConexao();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                ModeloTreinado m = new ModeloTreinado();
                m.setId(rs.getInt("id"));
                m.setNome(rs.getString("nome"));
                m.setVersao(rs.getString("versao"));
                m.setArquivoMod(rs.getString("arquivo_mod"));
                m.setAtivo(rs.getBoolean("ativo"));
                lista.add(m);
            }

        } catch (SQLException e) {
            System.out.println("ERRO ao buscar modelos: " + e.getMessage());
        }

        return lista;
    }

    public void deletar(int id) {
        String sql = "DELETE FROM modelos_treinados WHERE id = ?";

        try (Connection con = Conexao.getConexao();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Modelo deletado com sucesso!");

        } catch (SQLException e) {
            System.out.println("ERRO ao deletar: " + e.getMessage());
        }
    }

}
