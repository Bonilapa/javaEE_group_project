package org.innopolis.javaEE.dataService.impl;

import org.innopolis.javaEE.aureg.forms.UserForm;
import org.innopolis.javaEE.dataService.interfaces.UserDAO;
import org.innopolis.javaEE.dataService.pojo.User;
import org.innopolis.javaEE.utils.DataSourceFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    @Override
    public boolean updateAdminRights(Integer id){
        String sql = "UPDATE users SET RIGHTS='admin' WHERE ID=?;";

        try {

            Connection connection = DataSourceFactory.getDataSource().getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

//            LOGGER.debug("Set tour: " + entity.getTour() + " for userId: " + userId);

            statement.execute();

            statement.close();
            connection.close();

        } catch (SQLException e) {

//            LOGGER.error(e);
            return false;
        }

        return true;
    }
    @Override
    public boolean updateUserRights(Integer id){
        String sql = "UPDATE users SET RIGHTS='user' WHERE ID=?;";

        try {

            Connection connection = DataSourceFactory.getDataSource().getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

//            LOGGER.debug("Set tour: " + entity.getTour() + " for userId: " + userId);

            statement.execute();

            statement.close();
            connection.close();

        } catch (SQLException e) {

//            LOGGER.error(e);
            return false;
        }

        return true;
    }

    @Override
    public boolean deleteUser(Integer id){
        String sql = "DELETE FROM users WHERE ID=?;";

        try {

            Connection connection = DataSourceFactory.getDataSource().getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

//            LOGGER.debug("Set tour: " + entity.getTour() + " for userId: " + userId);

            statement.execute();

            statement.close();
            connection.close();

        } catch (SQLException e) {

//            LOGGER.error(e);
            return false;
        }

        return true;
    }
    @Override
    public ArrayList<UserForm> getAll(){
        ArrayList<UserForm> list = new ArrayList<>();

        try {

            Connection connection = DataSourceFactory.getDataSource().getConnection();
            Statement statement = connection.createStatement();

//            LOGGER.debug("Get all tours from Tours");

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

//            LOGGER.error(e);
        }

        return list;
    }
}
