package com.BudgetApp;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class DatabaseConfig {
    private static final String CONFIG_FILE = "config.properties";
    private final Properties properties;

    public DatabaseConfig(){
        properties = new Properties();
        loadProperties();
    }

    private void loadProperties(){
        try (var input = getClass().getClassLoader().getResourceAsStream(CONFIG_FILE)){
            if(input != null){
                properties.load(input);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    private void saveProperties(){
        try(var output = new FileOutputStream(CONFIG_FILE)){
            properties.store(output, "Updated Properties");
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public String getDatabaseUrl(){
        return properties.getProperty("database.url");
    }

    public void setDatabaseUrl(String newUrl){
        properties.setProperty("database.url", newUrl);
        saveProperties();
    }
}
