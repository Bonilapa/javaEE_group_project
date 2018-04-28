package org.innopolis.javaEE.dataService.impl;

import org.innopolis.javaEE.dataService.interfaces.EmployeeDAO;
import org.innopolis.javaEE.dataService.pojo.Employee;
import org.innopolis.javaEE.dataService.pojo.Time;
import org.innopolis.javaEE.dataService.utils.DAOException;
import org.innopolis.javaEE.utils.DataSourceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeDAOImpl.class);

    @Override
    public List<Employee> getEmployees() throws DAOException {
        String sql = "SELECT * FROM Employees;";

        List<Employee> employees = new LinkedList<>();

        try (Connection connection = DataSourceFactory.getDataSource().getConnection();
             PreparedStatement st = connection.prepareStatement(sql);
             ResultSet resultSet = st.executeQuery()) {
            while (resultSet.next()) {
                employees.add(new Employee(resultSet.getInt("id"),
                        resultSet.getInt("numberOfInputs"),
                        resultSet.getInt("numberOfOutputs"),
                        new Time(resultSet.getInt("mean_input_hour"),
                                resultSet.getInt("mean_input_minute"),
                                resultSet.getInt("mean_input_second")),
                        new Time(resultSet.getInt("mean_output_hour"),
                                resultSet.getInt("mean_output_minute"),
                                resultSet.getInt("mean_output_second"))));
            }
            LOGGER.trace("Employees collection generated");
            return employees;
        } catch (SQLException e) {
            int error = e.getErrorCode();
            if (error >= 8050 && error <= 8070) { //Problems with connection
                LOGGER.trace(e.getMessage());
            } else {
                LOGGER.error(e.getMessage());
            }
            throw new DAOException();

        }

    }

    @Override
    public Employee getEmployee(int id) throws DAOException {
        String sql = "SELECT * FROM Employees WHERE id = ?";

        List<Employee> employees = new LinkedList<>();

        try (Connection connection = DataSourceFactory.getDataSource().getConnection();
             PreparedStatement st = connection.prepareStatement(sql);
        ){
            st.setInt(1, id);
            try (ResultSet resultSet = st.executeQuery();) {
                return new Employee(resultSet.getInt("id"),
                        resultSet.getInt("numberOfInputs"),
                        resultSet.getInt("numberOfOutputs"),
                        new Time(resultSet.getInt("mean_input_hour"),
                                resultSet.getInt("mean_input_minute"),
                                resultSet.getInt("mean_input_second")),
                        new Time(resultSet.getInt("mean_output_hour"),
                                resultSet.getInt("mean_output_minute"),
                                resultSet.getInt("mean_output_second")));
            }
        } catch (SQLException e) {
            int error = e.getErrorCode();
            if (error >= 8050 && error <= 8070) { //Problems with connection
                LOGGER.trace(e.getMessage());
            } else {
                LOGGER.error(e.getMessage());
            }
            throw new DAOException();

        }
    }

    @Override
    public void addEmployee(Employee employee) throws DAOException {
        String sql = "INSERT INTO Employees(numberOfInputs, numberOfOutputs, mean_input_hour, mean_input_minute, mean_input_second, mean_output_hour,mean_output_minute. mean_output_second) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";


        try (Connection connection = DataSourceFactory.getDataSource().getConnection();
             PreparedStatement st = connection.prepareStatement(sql);
            ) {
            st.setInt(1, employee.numberOfInputs);
            st.setInt(2, employee.numberOfOutputs);
            st.setInt(3, employee.meanInputTime.hours);
            st.setInt(4, employee.meanInputTime.minutes);
            st.setInt(5, employee.meanInputTime.seconds);
            st.setInt(6, employee.meanOutputTime.hours);
            st.setInt(7, employee.meanOutputTime.minutes);
            st.setInt(8, employee.meanOutputTime.seconds);

            st.execute();


        } catch (SQLException e) {
            int error = e.getErrorCode();
            if (error >= 8050 && error <= 8070) { //Problems with connection
                LOGGER.trace(e.getMessage());
            } else {
                LOGGER.error(e.getMessage());
            }
            throw new DAOException();

        }
    }

    @Override
    public void clearEmployees() throws DAOException {
        String sql = "DELETE * FROM Employees";


        try (Connection connection = DataSourceFactory.getDataSource().getConnection();
             PreparedStatement st = connection.prepareStatement(sql);
        ) {
            st.execute();


        } catch (SQLException e) {
            int error = e.getErrorCode();
            if (error >= 8050 && error <= 8070) { //Problems with connection
                LOGGER.trace(e.getMessage());
            } else {
                LOGGER.error(e.getMessage());
            }
            throw new DAOException();

        }
    }
}
