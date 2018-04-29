package org.innopolis.javaEE.fileIO.service.implementations;

import org.innopolis.javaEE.dataService.interfaces.EmployeeDAO;
import org.innopolis.javaEE.dataService.pojo.Employee;
import org.innopolis.javaEE.fileIO.service.interfaces.ExportService;
import org.innopolis.javaEE.fileIO.service.util.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.json.*;

@Service
public class ExportServiceImpl implements ExportService {

    private final EmployeeDAO employeeDAO;

    @Autowired
    public ExportServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public JsonObject getExportFile() throws ServiceException {
        Employee[] employees = employeeDAO.getEmployees();
        JsonArrayBuilder jsonArrayBuilder =Json.createArrayBuilder();
        for (Employee employee: employees){
            jsonArrayBuilder = jsonArrayBuilder
                    .add(Json.createObjectBuilder()
                        .add("id", employee.id)
                        .add("numberOfInputs", employee.numberOfInputs)
                        .add("numberOfOutputs", employee.numberOfOutputs)
                        .add("meanInputTime", Json.createObjectBuilder()
                            .add("hour", employee.meanInputTime.hours)
                            .add("minute", employee.meanInputTime.minutes)
                            .add("second", employee.meanInputTime.seconds))
                        .add("meanOutputTime", Json.createObjectBuilder()
                            .add("hour", employee.meanOutputTime.hours)
                            .add("minute", employee.meanOutputTime.minutes)
                            .add("second", employee.meanOutputTime.seconds)));
        }
        return Json.createObjectBuilder()
                    .add("employees", jsonArrayBuilder)
                .build();
//        throw new ServiceException();
    }
}
