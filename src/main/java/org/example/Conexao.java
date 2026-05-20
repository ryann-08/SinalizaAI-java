package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String URL = "jdbc:mysql://localhost:3307/sinalizaai_db";
    private static final String USER = "root";
    private static final String PASSWORD = "MySQL@2022";

    public static Connection getConexao() {
        try {
            // Tenta abrir o cano de água (conexão)
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
            return null;
        }
    }
}