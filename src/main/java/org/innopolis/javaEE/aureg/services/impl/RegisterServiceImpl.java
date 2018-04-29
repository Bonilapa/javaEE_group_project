package org.innopolis.javaEE.aureg.services.impl;

import org.innopolis.javaEE.aureg.services.interfaces.RegisterService;
import org.innopolis.javaEE.dataService.impl.AuthDAOImpl;
import org.innopolis.javaEE.dataService.impl.RegDAOImpl;
import org.innopolis.javaEE.dataService.pojo.User;
import org.innopolis.javaEE.utils.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {

    private final static Logger LOGGER = LoggerFactory.getLogger(RegisterServiceImpl.class);
    private static RegDAOImpl regDAO = new RegDAOImpl();
    private static AuthDAOImpl authDAO = new AuthDAOImpl();

    @Override
    public Valid.Error register(User user){
        LOGGER.debug("UserService. addUser.");

        if (user.getLogin() == "") {

            LOGGER.debug("Empty login put.");
            return Valid.Error.EmptyLogin;

        } else if (user.getPassword() == "") {

            LOGGER.debug("Empty password put.");
            return Valid.Error.EmptyPassword;

        } else {

            User isUser = authDAO.getUserByLogin(user.getLogin());

            if (isUser == null) {

                LOGGER.debug("Add new user:" + user.getLogin());
                regDAO.addNewUser(user);
                return Valid.Error.Correct;

            } else {

                LOGGER.debug("User: " + user.getLogin() + " is already exists.");
                return Valid.Error.Exists;
            }

        }

    }

}
