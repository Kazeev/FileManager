package org.barbecue.security;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RequestToDatabase {

    public static boolean checkInBD(String username, String password) {

        String sqlFind = "" +
                "select * " +
                "from filemanager.file_manager.account f " +
                "where f.login = '"+ username + "';";

        try(Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://195.133.147.196:5432/filemanger"
                , "postgres"
                ,"mysecretpassword");
            ResultSet resultSet = conn.prepareStatement(sqlFind).executeQuery()) {

            resultSet.next();
            String s = resultSet.getString("password");
                if (s.equals(password)){
                    return true;
                }

        } catch (SQLException e) {
            e.getErrorCode();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}

