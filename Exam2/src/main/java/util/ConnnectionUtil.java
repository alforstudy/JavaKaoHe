package util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnnectionUtil {
    static {

        Properties pro = new Properties();
        try {
            pro.load(ConnnectionUtil.class.getResourceAsStream("/db.properties"));
        } catch (IOException e) {
        }
        String jdbc_driver = pro.getProperty("jdbc_driver");
        String db_url = pro.getProperty("db_url");
        String username = pro.getProperty("username");
        String password = pro.getProperty("password");
        try {
            Class.forName(jdbc_driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private static Connection connection;
    private static String db_url;
    private static String username;
    private static String password;
    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection(db_url,username,password);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }
}
