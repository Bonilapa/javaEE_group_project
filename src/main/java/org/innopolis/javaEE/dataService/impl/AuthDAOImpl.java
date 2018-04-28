package org.innopolis.javaEE.dataService.impl;

import org.innopolis.javaEE.dataService.interfaces.AuthDAO;
import org.innopolis.javaEE.dataService.pojo.User;
import org.innopolis.javaEE.utils.DataSourceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthDAOImpl implements AuthDAO {

    private final static Logger LOGGER = LoggerFactory.getLogger(AuthDAOImpl.class);

    @Override
    public User getUserByLoginPassword(String login, String password) {

        LOGGER.debug("AuthDAO. getUserByLoginAndPassword.");

        User user = null;
        String sql = "SELECT * FROM Users WHERE Login = ? AND Password = ?;";

        try {
            Connection connection = DataSourceFactory.getDataSource().getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            resultSet.next();
            user = new User(resultSet.getInt("id"),
                    resultSet.getString("login"),
                    resultSet.getString("password"),
                    resultSet.getString("rights"));

            LOGGER.debug("Attempt to take user "+login+" from table Users");
            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {

            LOGGER.error("SQLException ");
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User getUserByLogin(String login){

        LOGGER.debug("AuthDAO. getUserByLogin.");

        User user = null;
        String sql = "SELECT * FROM Users WHERE Login = ?;";

        try {
            Connection connection = DataSourceFactory.getDataSource().getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, login);

            LOGGER.debug("Take user " + login + " from table Users");

            ResultSet resultSet = statement.executeQuery();

            resultSet.next();
            user = new User(resultSet.getInt("id"), resultSet.getString("login"),
                    resultSet.getString("password"));


            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {

            LOGGER.error("SQLException ");
            e.printStackTrace();
        }

        return user;
    }
}