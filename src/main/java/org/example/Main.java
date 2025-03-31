package org.example;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.*;


public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        // Database URL, username, and password
        String url = "jdbc:mysql://192.168.12.88:3306";
        String username = "Trasketo";
        String password = "your_password";


        FileInputStream fileStream = null;
        try {
            fileStream = new FileInputStream("src/main/resources/application.properties");
            System.out.println("File opened successfully.");

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }

        Properties properties = new Properties();
        try{
            properties.load(fileStream);
        }catch (IOException e)
        {

        }

        String URL = properties.getProperty("URL");

        System.out.println(URL);

        try {
            // Establish the connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Check if the connection is successful
            if (connection != null) {
                System.out.println("Connected to MySQL database!");
                // Close the connection
                connection.close();
            }

        } catch (SQLException e) {
            // Log the exception instead of printing the stack trace
            logger.error("An error occurred: {}", e.getMessage(), e);

        }


    }
}