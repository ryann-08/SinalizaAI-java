package org.example;

import java.sql.Connection;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // 1. Testar a conexão
        System.out.println("Testando conexão...");
        Connection con = Conexao.getConexao();
        if (con != null) {
            System.out.println("✓ Conectado ao MySQL!");
        } else {
            System.out.println("✗ Falhou. Verifique o MySQL Workbench.");
            return;
        }

        // 2. Cria um sinal de teste
        System.out.println("\nSalvando sinal...");
        Sinal sinal = new Sinal();
        sinal.setNome("AGUA");
        sinal.setCategoria("Substantivo");
        sinal.setAtivo(true);

        SinalDAO dao = new SinalDAO();
        dao.salvar(sinal);

        // 3. Busca todos os sinais e exibe
        System.out.println("\nSinais no banco:");
        List<Sinal> lista = dao.buscarTodos();
        for (Sinal s : lista) {
            System.out.println("ID: " + s.getId() + " | Nome: " + s.getNome() + " | Categoria: " + s.getCategoria());
        }
    }
}