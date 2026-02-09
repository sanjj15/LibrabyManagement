package com.wipro.book.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    public static Connection getDBConnection() {
        Connection connection = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            String url = "jdbc:oracle:thin:@localhost:1521:XE";
            String user = "system";
            String pass = "admin";
            connection = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }
}
