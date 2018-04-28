package org.innopolis.javaEE.aureg.services.impl;

import org.innopolis.javaEE.aureg.forms.UserForm;
import org.innopolis.javaEE.aureg.services.interfaces.UserRightsEditService;
import org.innopolis.javaEE.dataService.impl.UserDAOImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class UserRightsEditServiceImpl implements UserRightsEditService {

    private final static Logger LOGGER = LoggerFactory.getLogger(UserRightsEditServiceImpl.class);
    private static UserDAOImpl userDAO = new UserDAOImpl();

    @Override
    public ArrayList<UserForm> getAll(){

        LOGGER.debug("UserRightEditService. getAll ");
        return userDAO.getAll();
    }
    @Override
    public Boolean giveAdminRights(Integer id){

        LOGGER.debug("UserRightEditService. Make user: " + id + " admin.");
        return userDAO.updateAdminRights(id);
    }
    @Override
    public Boolean giveUserRights(Integer id){

        LOGGER.debug("UserRightEditService. Make user: " + id + " user.");
        return userDAO.updateUserRights(id);
    }
    @Override
    public Boolean deleteUser(Integer id){

        LOGGER.debug("UserRightEditService. Delete user: " + id);
        return userDAO.deleteUser(id);
    }

}
