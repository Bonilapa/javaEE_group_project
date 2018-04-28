package org.innopolis.javaEE.aureg.services.impl;

import org.innopolis.javaEE.aureg.services.interfaces.RegisterService;
import org.innopolis.javaEE.dataService.impl.AuthDAOImpl;
import org.innopolis.javaEE.dataService.impl.RegDAOImpl;
import org.innopolis.javaEE.dataService.interfaces.RegDAO;
import org.innopolis.javaEE.dataService.pojo.User;
import org.innopolis.javaEE.fileIO.service.util.ServiceException;

public class RegisterServiceImpl implements RegisterService {
    private final RegDAOImpl regDAO = new RegDAOImpl();
    private final AuthDAOImpl authDAO = new AuthDAOImpl();

    @Override
    public Integer register(User user) throws ServiceException {
//        LOGGER.debug("UserService. addUser.");

        if (user.getLogin() == "") {

//            LOGGER.debug("Empty login put.");
            return -1;

        } else if (user.getPassword() == "") {

//            LOGGER.debug("Empty password put.");
            return 1;

        } else {

            User isUser = authDAO.getUserByLogin(user.getLogin());

            if (isUser == null) {

//                LOGGER.debug("Add new user:" + user.getLogin());
                regDAO.addNewUser(user);
                return 0;

            } else {

//                LOGGER.debug("User: " + user.getLogin() + " is already exists.");
                return null;
            }

        }

    }

//        LOGGER.debug("user: " + user);
//        if((user == null)){
//            return false;
//        }
//        LOGGER.debug(" exists ");
//        System.out.println("exists");
//        return true;
}
