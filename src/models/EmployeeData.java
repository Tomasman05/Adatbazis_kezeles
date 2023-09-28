package models;

import java.sql.Statement;
import java.util.ArrayList;
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
   public ArrayList<Employee> tryGetEmployees() throws SQLException{
        Connection con = Mariadb.connectDB();
        String sql = "select * from employees";
        Statement stmt = con.createStatement();
        ResultSet res = stmt.executeQuery(sql);
        ArrayList<Employee> emplist = new ArrayList<>();
        while(res.next()){
            Employee emp = new Employee();
            emp.setId(res.getInt("id"));
            emp.setName(res.getString("name"));
            emp.setCity(res.getString("city"));
            emp.setSalary(res.getDouble("salary"));
            emplist.add(emp);
        }
        return emplist;
   }
}