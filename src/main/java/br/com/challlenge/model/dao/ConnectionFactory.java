package br.com.challlenge.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static Connection connection;

    public static Connection getConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                return connection;
            }

            Class.forName("oracle.jdbc.driver.OracleDriver");
            final String url = System.getenv("DB_USER");
            final String USER = System.getenv("DB_USER");
            final String PASSWORD = System.getenv("DB_PASSWORD");

            System.out.printf("\nURL: %s\nUser: %s\nPassword: %s\n", url, USER, PASSWORD);

            if (url == null || USER == null || PASSWORD == null) {
                throw new RuntimeException("Variáveis de ambiente do banco não configuradas!");
            }

            connection = DriverManager.getConnection(url, USER, PASSWORD);

        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Erro nome da classe: " + e.getMessage());
        }

        return connection;
    }
}
