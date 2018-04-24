package org.innopolis.javaEE.aureg.services.impl;

import org.innopolis.javaEE.aureg.services.interfaces.LoginService;
import org.innopolis.javaEE.dataService.impl.AuthDAOImpl;
import org.innopolis.javaEE.dataService.interfaces.AuthDAO;
import org.innopolis.javaEE.dataService.pojo.User;
import org.innopolis.javaEE.fileIO.service.util.ServiceException;

public class LoginServiceImpl implements LoginService{
    private AuthDAOImpl authDAO = new AuthDAOImpl();
    @Override
    public boolean auth(String login, String password){

        User user = authDAO.getUserByLoginPassword(login, password);

//        LOGGER.debug("user: " + user);
        if((user == null)){
            return false;
        }
//        LOGGER.debug(" exists ");
        System.out.println("exists");
        return true;
    }
}
