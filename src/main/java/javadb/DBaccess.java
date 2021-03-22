package javadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBaccess {

    private Connection connection;
    private String databaseName;
    private String mainUser;
    private String mainUserPassword;
    private static final String SQL_EXCEPTION = "SQL Exception: ";
    private static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String PREFIX_CONNECTION_URL = "jdbc:mysql://localhost:3306/";
    private static final String CONNECTION_SETTINGS = "?useSSL=false" +
            "&allowPublicKeyRetrieval=true" +
            "&useJDBCCompliantTimezoneShift=true" +
            "&useLegacyDatetimeCode=false" +
            "&serverTimezone=UTC";

    public DBaccess(String databaseName, String mainUser, String mainUserPassword) {
        super();
        this.databaseName = databaseName;
        this.mainUser = mainUser;
        this.mainUserPassword = mainUserPassword;
        loadDriver();
    }

    /**
     * Open database connection
     */
    public void openConnection() {
        System.out.println("Opening connection to " + databaseName + "....");
        String connectionURL = PREFIX_CONNECTION_URL + databaseName + CONNECTION_SETTINGS;
        try {
            connection = DriverManager.getConnection(connectionURL, mainUser, mainUserPassword);
            System.out.println("OK, Connection open");
        } catch (SQLException sqlFout) {
            System.out.println(SQL_EXCEPTION + sqlFout.getMessage());
        }
    }

    /**
     * Close database connection
     */
    public void closeConnection() {
        try {
            connection.close();
            System.out.println("Connection closed");
        } catch (Exception connectionFout) {
            System.err.println(connectionFout.getMessage());
        }
    }

    private void loadDriver() {
        try {
            System.out.print("Load driver... ");
            Class.forName(MYSQL_DRIVER); // Explicitly load the JDBC-driver.
            System.out.println("Loading driver succesful");
        } catch (ClassNotFoundException driverFout) {
            System.out.println("Driver niet gevonden");
        }
    }

    public Connection getConnection() {
        if (connection == null) {
            this.openConnection();
        }
        try {
            if (connection.isClosed()) {
                this.openConnection();
            }
        }
        catch (SQLException sqlFout) {
            System.out.println("connection fout");
        }
        return connection;
    }

}
