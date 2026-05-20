package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AmostraDatasetDAO {

    public void salvar(AmostraDataset amostra) {
        String sql = "INSERT INTO amostras_dataset (sinal_id, arquivo, gravado_por) VALUES (?, ?, ?)";

        try (Connection con = Conexao.getConexao();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, amostra.getSinalId());
            stmt.setString(2, amostra.getArquivo());
            stmt.setString(3, amostra.getGravadoPor());

            stmt.executeUpdate();
            System.out.println("Amostra salva com sucesso!");

        } catch (SQLException e) {
            System.out.println("ERRO ao salvar amostra: " + e.getMessage());
        }
    }

    public List<AmostraDataset> buscarTodos() {
        List<AmostraDataset> lista = new ArrayList<>();
        String sql = "SELECT * FROM amostras_dataset";

        try (Connection con = Conexao.getConexao();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                AmostraDataset a = new AmostraDataset();
                a.setId(rs.getInt("id"));
                a.setSinalId(rs.getInt("sinal_id"));
                a.setArquivo(rs.getString("arquivo"));
                a.setGravadoPor(rs.getString("gravado_por"));
                lista.add(a);
            }

        } catch (SQLException e) {
            System.out.println("ERRO ao buscar amostras: " + e.getMessage());
        }

        return lista;
    }

    public void deletar(int id) {
        String sql = "DELETE FROM amostras_dataset WHERE id = ?";

        try (Connection con = Conexao.getConexao();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Amostra deletada com sucesso!");

        } catch (SQLException e) {
            System.out.println("ERRO ao deletar: " + e.getMessage());
        }
    }
}