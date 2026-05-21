package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LogUsoDAO {

    public void salvar(LogUso log) {
        String sql = "INSERT INTO logs_uso (sinal_id, usuario_id, resposta_dac) VALUES (?, ?, ?)";

        try (Connection con = Conexao.getConexao();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, log.getSinalId());
            stmt.setInt(2, log.getUsuarioId());
            stmt.setString(3, log.getRespostaDac());

            stmt.executeUpdate();
            System.out.println("Log salvo com sucesso!");

        } catch (SQLException e) {
            System.out.println("ERRO ao salvar log: " + e.getMessage());
        }
    }

    public List<LogUso> buscarTodos() {
        List<LogUso> lista = new ArrayList<>();
        String sql = "SELECT * FROM logs_uso";

        try (Connection con = Conexao.getConexao();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                LogUso l = new LogUso();
                l.setId(rs.getInt("id"));
                l.setSinalId(rs.getInt("sinal_id"));
                l.setUsuarioId(rs.getInt("usuario_id"));
                l.setRespostaDac(rs.getString("resposta_dac"));
                l.setCriadoEm(rs.getString("criado_em"));
                lista.add(l);
            }

        } catch (SQLException e) {
            System.out.println("ERRO ao buscar logs: " + e.getMessage());
        }

        return lista;
    }

    public void deletar(int id) {
        String sql = "DELETE FROM logs_uso WHERE id = ?";

        try (Connection con = Conexao.getConexao();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Log deletado com sucesso!");

        } catch (SQLException e) {
            System.out.println("ERRO ao deletar: " + e.getMessage());
        }
    }
}