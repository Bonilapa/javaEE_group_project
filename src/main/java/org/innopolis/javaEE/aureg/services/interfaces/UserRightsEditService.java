package org.innopolis.javaEE.aureg.services.interfaces;

import org.innopolis.javaEE.aureg.forms.UserForm;
import org.innopolis.javaEE.dataService.pojo.User;

import java.util.List;

public interface UserRightsEditService {
    List<UserForm> getAll();
    Boolean deleteUser(Integer id);
    Boolean giveAdminRights(Integer id);
    Boolean giveUserRights(Integer id);
}
