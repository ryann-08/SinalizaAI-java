package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioAdmDAO {

    public void salvar(UsuarioAdm usuario) {
        String sql = "INSERT INTO usuarios_adm (nome, email, senha, nivel_acesso) VALUES (?, ?, ?, ?)";

        try (Connection con = Conexao.getConexao();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());
            stmt.setString(4, usuario.getNivelAcesso());

            stmt.executeUpdate();
            System.out.println("Usuário salvo com sucesso!");

        } catch (SQLException e) {
            System.out.println("ERRO ao salvar usuário: " + e.getMessage());
        }
    }

    public List<UsuarioAdm> buscarTodos() {
        List<UsuarioAdm> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuarios_adm";

        try (Connection con = Conexao.getConexao();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                UsuarioAdm u = new UsuarioAdm();
                u.setId(rs.getInt("id"));
                u.setNome(rs.getString("nome"));
                u.setEmail(rs.getString("email"));
                u.setSenha(rs.getString("senha"));
                u.setNivelAcesso(rs.getString("nivel_acesso"));
                u.setCriadoEm(rs.getString("criado_em"));
                lista.add(u);
            }

        } catch (SQLException e) {
            System.out.println("ERRO ao buscar usuários: " + e.getMessage());
        }

        return lista;
    }

    public void deletar(int id) {
        String sql = "DELETE FROM usuarios_adm WHERE id = ?";

        try (Connection con = Conexao.getConexao();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Usuário deletado com sucesso!");

        } catch (SQLException e) {
            System.out.println("ERRO ao deletar: " + e.getMessage());
        }
    }
}