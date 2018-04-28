package org.innopolis.javaEE.dataService.impl;

import org.innopolis.javaEE.dataService.interfaces.RegDAO;
import org.innopolis.javaEE.dataService.pojo.User;
import org.innopolis.javaEE.utils.DataSourceFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegDAOImpl implements RegDAO {

    @Override
    public void addNewUser(User user) {
        String sql = "INSERT INTO Users(login, password, rights) VALUES (?, ?, ?);";

        try {
            Connection connection = DataSourceFactory.getDataSource().getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getRights());
            statement.execute();

//            LOGGER.debug("Attempt to take user "+login+" from table Users");
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}