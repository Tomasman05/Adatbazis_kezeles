package controllers;

import models.EmployeeData;

public class MainController {
    public MainController(){
        new EmployeeData().getEmployees();
    }
}
