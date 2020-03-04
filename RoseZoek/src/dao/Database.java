package dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Database {
    private static  String url;
    private static  String user;
    private static  String password;

    private static Database instance;
    private Connection connection;

    private Database() throws SQLException {
        readDbPropertiesFromResource();
        connection = createConnection();
    }

    public static Database getInstance() throws SQLException {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    private void readDbPropertiesFromResource() {
        ClassLoader cl = Database.class.getClassLoader();
        try (InputStream inputStream =
                     cl.getResourceAsStream("config.properties")) {
            Properties prop = new Properties();
            // load a properties file
            prop.load(inputStream);
            // get the property value
            url = prop.getProperty("db.url");
            user = prop.getProperty("db.user");
            password = prop.getProperty("db.password");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private Connection createConnection() throws SQLException {
        Connection dbConnection = DriverManager.getConnection(url, user,password);
        return dbConnection;
    }

}
