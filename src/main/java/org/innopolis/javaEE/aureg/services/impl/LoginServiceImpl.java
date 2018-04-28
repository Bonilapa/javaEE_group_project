package org.innopolis.javaEE.aureg.services.impl;

import org.innopolis.javaEE.aureg.services.interfaces.LoginService;
import org.innopolis.javaEE.dataService.impl.AuthDAOImpl;
import org.innopolis.javaEE.dataService.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    private final static Logger LOGGER = LoggerFactory.getLogger(LoginServiceImpl.class);
    private AuthDAOImpl authDAO = new AuthDAOImpl();

    @Override
    public User auth(String login, String password) {

        User user = authDAO.getUserByLoginPassword(login, password);

        if ((user == null)) {

            LOGGER.debug("User: " + login + " does not exist.");
            return null;
        }

        LOGGER.debug("user: " + user.getLogin());
        return user;
    }
}