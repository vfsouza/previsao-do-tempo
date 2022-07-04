package com.tempo.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory implements AutoCloseable {
    public static Connection conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/questao2?useTimezone=true&serverTimezone=UTC", "root", "root");
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void close() throws Exception {

    }
}