package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Util {
    private static final String hostName = "localhost";
    private static final String dbName = "dbtest";
    private static final String userName = "root";;
    private static final String password = "root";
    private static final String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;

    public static Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(connectionURL, userName,password);
            System.out.println("conn ok");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("conn error");
        }
        return connection;
    }
/*    public static Connection getMySQlConnection() throws SQLException, ClassNotFoundException {
        String hostName = "localhost";
        String dbName = "dbtest";
        String userName = "root";
        String password = "root";
        return getMySQLConnection(hostName, dbName, userName, password);
    }

    public static Connection getMySQLConnection(String hostName, String dbName, String userName, String password) throws SQLException {
        String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
        Connection conn = DriverManager.getConnection(connectionURL, userName, password);
        return conn;
    }*/
}
