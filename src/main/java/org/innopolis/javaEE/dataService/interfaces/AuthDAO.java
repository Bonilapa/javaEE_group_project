package org.innopolis.javaEE.dataService.interfaces;

import org.innopolis.javaEE.dataService.pojo.User;

public interface AuthDAO{
    User getUserByCredentials(String login, String password);
    void createUser(User user);
}
