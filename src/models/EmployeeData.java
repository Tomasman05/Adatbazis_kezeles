package models;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
 
public class EmployeeData {

   public void getEmployees(){
    try {
        tryGetEmployees();
    } catch (SQLException e) {
        System.err.println("Hiba, Az SQL lekérés sikertelen");
        System.err.println(e.getMessage());
    }
   }
   public void tryGetEmployees() throws SQLException{
    Connection con = Mariadb.connectDB();
    String sql = "select * from employees";
    Statement stmt = con.createStatement();
    ResultSet res = stmt.executeQuery(sql);
    while(res.next()){
        System.out.println(res.getString("name"));
        System.out.println(res.getString("city"));
        System.out.println(res.getDouble("salary"));
    }
   }
}