package shopgiay.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {

    public static Connection getConnection() {
        Connection cons = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cons = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/shopgiay", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cons;
    }
    
}
