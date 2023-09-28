package views;

import models.EmployeeData;

public class Mainconsole {
    public Mainconsole(){
        EmployeeData empd = new EmployeeData();
        empd.getEmployees();
    }
}
