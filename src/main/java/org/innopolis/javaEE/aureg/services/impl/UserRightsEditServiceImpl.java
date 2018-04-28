package org.innopolis.javaEE.aureg.services.impl;

import org.innopolis.javaEE.aureg.forms.UserForm;
import org.innopolis.javaEE.aureg.services.interfaces.UserRightsEditService;
import org.innopolis.javaEE.dataService.impl.UserDAOImpl;
import org.innopolis.javaEE.dataService.interfaces.UserDAO;
import org.innopolis.javaEE.dataService.pojo.User;

import java.util.ArrayList;
import java.util.List;

public class UserRightsEditServiceImpl implements UserRightsEditService {
    private static UserDAOImpl userDAO = new UserDAOImpl();
    @Override
    public ArrayList<UserForm> getAll(){
        return userDAO.getAll();
    }
    @Override
    public Boolean giveAdminRights(Integer id){
        return userDAO.updateAdminRights(id);
    }
    @Override
    public Boolean giveUserRights(Integer id){
        return userDAO.updateUserRights(id);
    }
    @Override
    public Boolean deleteUser(Integer id){
        return userDAO.deleteUser(id);
    }
}
