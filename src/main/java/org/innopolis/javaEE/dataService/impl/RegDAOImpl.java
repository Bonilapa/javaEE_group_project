package org.innopolis.javaEE.dataService.impl;

import org.innopolis.javaEE.dataService.interfaces.RegDAO;
import org.innopolis.javaEE.dataService.pojo.User;
import org.innopolis.javaEE.utils.DataSourceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegDAOImpl implements RegDAO {

    private final static Logger LOGGER = LoggerFactory.getLogger(RegDAOImpl.class);

    @Override
    public void addNewUser(User user) {

        LOGGER.error("RegDAO. addNewUser.");

        String sql = "INSERT INTO Users(login, password, rights) VALUES (?, ?, ?);";

        LOGGER.debug("Set user with login: " +
                user.getLogin() +
                "; and password: " +
                user.getPassword() +
                "; and rights: " +
                user.getRights() +
                "; into Users");

        try(Connection connection = DataSourceFactory.getDataSource().getConnection()) {

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getRights());
            statement.execute();

            statement.close();
            connection.close();

        } catch (SQLException e) {

            LOGGER.error("SQLException ", e);
        }

    }

}