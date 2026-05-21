package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RespostaDAO {

    public void salvar(Resposta resposta) {
        String sql = "INSERT INTO respostas (intencao_id, texto_resposta, arquivo_avat) VALUES (?, ?, ?)";

        try (Connection con = Conexao.getConexao();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, resposta.getIntencaoId());
            stmt.setString(2, resposta.getTextoResposta());
            stmt.setString(3, resposta.getArquivoAvatar());

            stmt.executeUpdate();
            System.out.println("Resposta salva com sucesso!");

        } catch (SQLException e) {
            System.out.println("ERRO ao salvar resposta: " + e.getMessage());
        }
    }

    public List<Resposta> buscarTodos() {
        List<Resposta> lista = new ArrayList<>();
        String sql = "SELECT * FROM respostas";

        try (Connection con = Conexao.getConexao();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Resposta r = new Resposta();
                r.setId(rs.getInt("id"));
                r.setIntencaoId(rs.getInt("intencao_id"));
                r.setTextoResposta(rs.getString("texto_resposta"));
                r.setArquivoAvatar(rs.getString("arquivo_avat"));
                lista.add(r);
            }

        } catch (SQLException e) {
            System.out.println("ERRO ao buscar respostas: " + e.getMessage());
        }

        return lista;
    }

    public void deletar(int id) {
        String sql = "DELETE FROM respostas WHERE id = ?";

        try (Connection con = Conexao.getConexao();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Resposta deletada com sucesso!");

        } catch (SQLException e) {
            System.out.println("ERRO ao deletar: " + e.getMessage());
        }
    }
}