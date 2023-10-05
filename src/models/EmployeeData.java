package models;

import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeData {

    public ArrayList<Employee> getEmployees() {
        ArrayList<Employee> empList = null;
        try {
            empList = tryGetEmployees();
        } catch (SQLException e) {
            System.err.println("Hiba, Az SQL lekérés sikertelen");
            System.err.println(e.getMessage());
        }
        return empList;
    }

    public ArrayList<Employee> tryGetEmployees() throws SQLException {
        Connection con = Mariadb.connectDB();
        String sql = "select * from employees";
        Statement stmt = con.createStatement();
        ResultSet res = stmt.executeQuery(sql);
        ArrayList<Employee> emplist = new ArrayList<>();
        while (res.next()) {
            Employee emp = new Employee();
            emp.setId(res.getInt("id"));
            emp.setName(res.getString("name"));
            emp.setCity(res.getString("city"));
            emp.setSalary(res.getDouble("salary"));
            emplist.add(emp);
        }
        return emplist;
    }

    public void addEmployee(Employee emp) {
        try {
            tryAddEmployee(emp);
        } catch (SQLException e) {
            System.err.println("Hiba az adatok hozzáadásában.");
            System.err.println(e.getMessage());
        }
    }
    public void tryAddEmployee(Employee emp) throws SQLException {
        Connection con = Mariadb.connectDB();
        String sql = "insert into employees" + 
        "(name, city, salary) values" + 
        "(?, ?, ?)";
        PreparedStatement prepstate = con.prepareStatement(sql);
        prepstate.setString(0,emp.getName());
        prepstate.setString(1,emp.getCity());
        prepstate.setDouble(2,emp.getSalary());
        prepstate.execute();
        con.close();
    }
}