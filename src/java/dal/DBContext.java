
package dal;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBContext {
    protected Connection connection;
    public DBContext()
    {
        try {
            Properties props = new Properties();
            InputStream input = DBContext.class.getClassLoader().getResourceAsStream("config.properties");
            
            if (input == null) {
                throw new IOException("Config file not found");
            }
            props.load(input);

            String url = props.getProperty("db.url");
            String username = props.getProperty("db.username");
            String password = props.getProperty("db.password");

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException | IOException ex) {
            System.out.println("Database connection error: " + ex.getMessage());
        }
    }
}
