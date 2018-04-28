package org.innopolis.javaEE.dataService.interfaces;

import org.innopolis.javaEE.dataService.pojo.Employee;

public interface EmployeeDAO {
    Employee[] getEmployees();
    Employee getEmployee(int id);

    void addEmployee(Employee employee);

    void clearEmployees();
}
