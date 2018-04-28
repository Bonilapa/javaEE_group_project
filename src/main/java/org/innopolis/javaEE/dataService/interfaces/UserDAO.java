package org.innopolis.javaEE.dataService.interfaces;

import org.innopolis.javaEE.aureg.forms.UserForm;
import org.innopolis.javaEE.dataService.pojo.User;

import java.util.ArrayList;
import java.util.List;

public interface UserDAO {
    ArrayList<UserForm> getAll();
    boolean updateAdminRights(Integer id);
    boolean updateUserRights(Integer id);
    boolean deleteUser(Integer id);
}
