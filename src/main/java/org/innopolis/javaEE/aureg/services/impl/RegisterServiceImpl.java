package org.innopolis.javaEE.aureg.services.impl;

import org.innopolis.javaEE.aureg.services.interfaces.RegisterService;
import org.innopolis.javaEE.dataService.impl.RegDAOImpl;
import org.innopolis.javaEE.dataService.interfaces.RegDAO;
import org.innopolis.javaEE.dataService.pojo.User;
import org.innopolis.javaEE.fileIO.service.util.ServiceException;

public class RegisterServiceImpl implements RegisterService {
    private final RegDAOImpl regDAO = new RegDAOImpl();
    @Override
    public void register(User user) throws ServiceException {

        regDAO.addNewUser(user);

//        LOGGER.debug("user: " + user);
//        if((user == null)){
//            return false;
//        }
//        LOGGER.debug(" exists ");
//        System.out.println("exists");
//        return true;
    }
}
