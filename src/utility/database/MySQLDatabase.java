package utility.database;

import utility.Props;
import utility.logger.Level;
import utility.logger.Log;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLDatabase implements Database {
    private final String driver = "jdbc:mysql";
    private final String hostname = Props.getProperty("MYSQL_HOSTNAME");
    private final String database = Props.getProperty("MYSQL_DATABASE");
    private final String port = Props.getProperty("MYSQL_PORT");
    private final String username = Props.getProperty("MYSQL_USER");
    private final String password = Props.getProperty("MYSQL_PASSWORD");
    private Connection connection;

    public MySQLDatabase() {
        String url = String.format("%s://%s:%s/%s", driver, hostname, port,
                database);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            Log.println(Level.INFO, "MySQL Connected");
        } catch (Exception e) {
            Log.println(Level.INFO, String.format("Failed to Connect to " +
                    "MySQL: %s", e.getMessage()));
        }
    }

    @Override
    public Connection connection() {
        return connection;
    }
}
