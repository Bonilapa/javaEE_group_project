package org.innopolis.javaEE.dataService.interfaces;

import org.innopolis.javaEE.dataService.pojo.User;

public interface AuthDAO{
    User getUserByLoginPassword(String login, String password);
    User getUserByLogin(String login);
}
