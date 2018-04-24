package org.innopolis.javaEE.dataService.impl;

import org.innopolis.javaEE.dataService.interfaces.AuthDAO;
import org.innopolis.javaEE.dataService.pojo.User;
import org.innopolis.javaEE.utils.DataSourceFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthDAOImpl implements AuthDAO {
    @Override
    public User getUserByLoginPassword(String login, String password) {
        User user = null;
        String sql = "SELECT * FROM Users WHERE Login = ? AND Password = ?;";

        try {
            Connection connection = DataSourceFactory.getDataSource().getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            resultSet.next();
            user = new User(resultSet.getInt("id"), resultSet.getString("login"),
                    resultSet.getString("password"));

//            LOGGER.debug("Attempt to take user "+login+" from table Users");
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
//            LOGGER.debug(e);
        }
        return user;
    }
}
