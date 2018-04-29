package org.innopolis.javaEE.fileIO.service.implementations;

import org.innopolis.javaEE.dataService.interfaces.EmployeeDAO;
import org.innopolis.javaEE.dataService.pojo.Employee;
import org.innopolis.javaEE.dataService.pojo.Time;
import org.innopolis.javaEE.fileIO.service.interfaces.ImportService;
import org.innopolis.javaEE.fileIO.service.util.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.*;
import java.util.ArrayList;

@Service
public class ImportServiceImpl implements ImportService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ImportServiceImpl.class);

    private final EmployeeDAO employeeDAO;

    @Autowired
    public ImportServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }


    @Override
    public void processFile(File file) throws ServiceException {
        try (JsonReader reader = Json.createReader(new FileInputStream(file))){
            JsonObject jsonObject = reader.readObject();
            JsonArray employees = jsonObject.getJsonArray("employees");
            ArrayList<Employee> employeesToLoad = new ArrayList<>();
            for (int i = 0; i < employees.size(); i++){
                JsonObject employee = employees.getJsonObject(i);
                Employee newEmployee = new Employee();
                Time inputTime = new Time();
                Time outputTime = new Time();
                newEmployee.id = employee.getInt("id");
                newEmployee.numberOfInputs = employee.getInt("numberOfInputs");
                newEmployee.numberOfOutputs = employee.getInt("numberOfOutputs");

                inputTime.hours = employee.getJsonObject("meanInputTime").getInt("hour");
                inputTime.minutes = employee.getJsonObject("meanInputTime").getInt("minute");
                inputTime.seconds = employee.getJsonObject("meanInputTime").getInt("second");

                outputTime.hours = employee.getJsonObject("meanOutputTime").getInt("hour");
                outputTime.minutes = employee.getJsonObject("meanOutputTime").getInt("minute");
                outputTime.seconds = employee.getJsonObject("meanOutputTime").getInt("second");

                newEmployee.meanOutputTime = outputTime;
                newEmployee.meanInputTime = inputTime;

                employeesToLoad.add(newEmployee);
            }

            employeeDAO.clearEmployees();
            for (Employee employee: employeesToLoad){
                employeeDAO.addEmployee(employee);
            }
        } catch (FileNotFoundException e) {
            LOGGER.error("Error while file processing + {}", e.getMessage());
        }
        throw new ServiceException();
    }
}
