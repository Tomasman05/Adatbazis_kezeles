package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class Mariadb {
 
 
    public static Connection connectDB(){
        Connection con = null;
        try {
            con = tryConnectDB();
        }catch(SQLException e) {
            System.err.println("Hiba! A kapcsolódás sikertelen");
            System.err.println(e.getMessage());
        }
        return con;
    }

    public static Connection tryConnectDB() throws SQLException {
        String url = "jdbc:mariadb://localhost:3306/adaba";
        return DriverManager.getConnection(url, "adaba", "titok");
    }
 
    public void tryCloseDB(Connection con) throws SQLException {
        con.close();
    }
 
    public void closeDB(Connection con){        
        try {
            tryCloseDB(con);
        }catch(SQLException e) {
            System.err.println("Hiba! A kapcsolat zárása sikertelen!");
            System.err.println(e.getMessage());
        }
    }
 
}