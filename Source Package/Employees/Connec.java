package Employees;

import java.sql.*;

public class Connec {
    
    private Connection connection;
    private Statement statement;

    public Connec() {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create a connection to the database
            connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagementsystem", "root", "mysqlsahil123");

            // Create a statement object
            statement = connection.createStatement();
        } catch (ClassNotFoundException e) {
            // Handle ClassNotFoundException
            System.err.println("Error: MySQL JDBC driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            // Handle SQLException
            System.err.println("Error: Failed to connect to the database.");
            e.printStackTrace();
        }
    }

    // Add getter methods for connection and statement if needed
    public Connection getConnection() {
        return connection;
    }

    public Statement getStatement() {
        return statement;
    }

    // Close the connection and statement when no longer needed
    public void close() {
        try {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            // Handle SQLException while closing resources
            e.printStackTrace();
        }
    }
}
