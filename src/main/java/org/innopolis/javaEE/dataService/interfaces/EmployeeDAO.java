package org.innopolis.javaEE.dataService.interfaces;

import org.innopolis.javaEE.dataService.pojo.Employee;
import org.innopolis.javaEE.dataService.utils.DAOException;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> getEmployees() throws DAOException;
    Employee getEmployee(int id) throws DAOException;

    void addEmployee(Employee employee) throws DAOException;

    void clearEmployees() throws DAOException;
}
