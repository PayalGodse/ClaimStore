package com.mitchell.examples.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
    //static reference to itself
    private static ConnectionFactory instance = new ConnectionFactory();
    private static final String URL = 	"jdbc:mysql://localhost:3306/mitchell_schema";
    private static final String USER = "root";
    private static final String PASSWORD = "rootpwd";
    private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver"; 

    private ConnectionFactory() {
    try {
        Class.forName(DRIVER_CLASS);
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
}
 
private Connection createConnection() {
    Connection connection = null;
    try {
        connection = DriverManager.getConnection(URL, USER, PASSWORD);
    } catch (SQLException e) {
        System.out.println("ERROR: Unable to Connect to Database.");
    }
    return connection;
}   
 
public static Connection getConnection() {
    return instance.createConnection();
}
}