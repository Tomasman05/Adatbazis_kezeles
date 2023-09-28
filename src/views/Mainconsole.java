package views;

import java.util.ArrayList;

import models.Employee;
import models.EmployeeData;

public class Mainconsole {
    public Mainconsole(){
        printEmployees(new EmployeeData().getEmployees());
    }
    public void printEmployees(ArrayList<Employee> emplist){
        for(Employee emp : emplist){
            System.out.print(emp.getName()+", ");
            System.out.print(emp.getCity()+", ");
            System.out.print(emp.getSalary()+"\n");
        }
    }
}
