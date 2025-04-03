package com.BudgetApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    static DatabaseConfig databaseConfig = new DatabaseConfig();
    private static final String URL = databaseConfig.getDatabaseUrl();
    private static final String User = databaseConfig.getDatabaseUser();
    private static final String Password = databaseConfig.getDatabasePassword();

    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL,User,Password);
    }
}
