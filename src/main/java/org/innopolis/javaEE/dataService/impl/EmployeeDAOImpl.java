package org.innopolis.javaEE.dataService.impl;

import org.innopolis.javaEE.dataService.interfaces.EmployeeDAO;
import org.innopolis.javaEE.dataService.pojo.Employee;
import org.innopolis.javaEE.dataService.pojo.Time;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public Employee[] getEmployees() {
        Employee first = new Employee();
        Time inputTime = new Time();
        Time outputTime = new Time();

        first.id = 1;
        first.numberOfInputs = 100;
        first.numberOfOutputs = 101;

        inputTime.hours = 8;
        inputTime.minutes = 30;
        inputTime.seconds = 39;

        outputTime.hours = 18;
        outputTime.minutes = 15;
        outputTime.seconds = 30;

        first.meanInputTime = inputTime;
        first.meanOutputTime = outputTime;

        Employee second = new Employee();
        inputTime = new Time();
        outputTime = new Time();

        second.id = 2;
        second.numberOfInputs = 110;
        second.numberOfOutputs = 101;

        inputTime.hours = 9;
        inputTime.minutes = 35;
        inputTime.seconds = 33;

        outputTime.hours = 19;
        outputTime.minutes = 11;
        outputTime.seconds = 35;

        second.meanInputTime = inputTime;
        second.meanOutputTime = outputTime;
        return new Employee[]{first, second};
    }

    @Override
    public Employee getEmployee(int id) {
        return null;
    }

    @Override
    public void addEmployee(Employee employee) {
        System.out.println("Added");
    }

    @Override
    public void clearEmployees() {
        System.out.println("Cleared");
    }
}
