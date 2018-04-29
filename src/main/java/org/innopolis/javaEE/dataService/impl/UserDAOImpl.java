package org.innopolis.javaEE.dataService.impl;

import org.innopolis.javaEE.aureg.forms.UserForm;
import org.innopolis.javaEE.dataService.interfaces.UserDAO;
import org.innopolis.javaEE.utils.DataSourceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.*;
import java.util.ArrayList;

public class UserDAOImpl implements UserDAO {

    private final static Logger LOGGER = LoggerFactory.getLogger(UserDAOImpl.class);

    @Override
    public boolean updateAdminRights(Integer id){

        LOGGER.debug("UserDAO. updateAdminRights.");

        String sql = "UPDATE users SET RIGHTS='admin' WHERE ID=?;";

        LOGGER.debug("Make user with id: " + id + " admin.");

        try(Connection connection = DataSourceFactory.getDataSource().getConnection()) {

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.execute();

            statement.close();
            connection.close();

        } catch (SQLException e) {

            LOGGER.error("SQLException ", e);
            return false;
        }

        return true;
    }

    @Override
    public boolean updateUserRights(Integer id){

        LOGGER.debug("UserDAO. updateUserRights.");

        String sql = "UPDATE users SET RIGHTS='user' WHERE ID=?;";

        LOGGER.debug("Make user with id: " + id + " user.");
        try(Connection connection = DataSourceFactory.getDataSource().getConnection()) {

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.execute();

            statement.close();
            connection.close();

        } catch (SQLException e) {

            LOGGER.error("SQLException", e);
            return false;
        }

        return true;
    }

    @Override
    public boolean deleteUser(Integer id){

        LOGGER.debug("UserDAO. deleteUser");

        String sql = "DELETE FROM users WHERE ID=?;";

        LOGGER.debug("Delete user: " + id);

        try(Connection connection = DataSourceFactory.getDataSource().getConnection()) {

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.execute();

            statement.close();
            connection.close();

        } catch (SQLException e) {

            LOGGER.error("SQLException", e);
            return false;
        }

        return true;
    }

    @Override
    public ArrayList<UserForm> getAll(){
        ArrayList<UserForm> list = new ArrayList<>();

        LOGGER.debug("Get all users from users");

        try(Connection connection = DataSourceFactory.getDataSource().getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users;");

            while (resultSet.next()) {
                UserForm user = new UserForm();
                user.setId(resultSet.getInt("id"));
                user.setLogin(resultSet.getString("login"));
                user.setRights(resultSet.getString("rights"));
                list.add(user);
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {

            LOGGER.error("SQLException", e);
        }

        return list;
    }

}