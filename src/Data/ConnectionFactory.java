package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class ConnectionFactory {
    private static Connection conn = null;

    private static Connection getConnection() throws SQLException {
        if(conn == null)
            conn = DriverManager.getConnection("jdbc:sqlite:copa.db");

        return conn;
    }
    public static PreparedStatement createStatement(String  sql) throws SQLException {
        return getConnection().prepareStatement(sql);
    }






}
