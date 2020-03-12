package org.barbecue.module.account;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDataBaceConnector {

    private static Connection connection;
    private static final String URL ="jdbc:postgresql://localhost:5432/FileManager";
    private static final String LOGIN ="postgres";
    private static final String PASS ="admin";

    public AccountDataBaceConnector() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, LOGIN, PASS);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public ResultSet getExecuteQuery(String sql) throws SQLException {
        return connection.createStatement().executeQuery( sql );
    }
}
