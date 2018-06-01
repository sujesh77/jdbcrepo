package org.itglance.connection;

import java.sql.*;

public class ConnectionFactory {

    private static ConnectionFactory connectionFactory = new ConnectionFactory();
    static final String DATABASE_NAME = "jdbc:mysql://localhost:3306/student";
    static final String USERNAME = "root";
    static final String PASSWORD = "";

    private ConnectionFactory() {
    }

    public static ConnectionFactory getInstance() {
        return connectionFactory;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DATABASE_NAME, USERNAME, PASSWORD);
    }

}
