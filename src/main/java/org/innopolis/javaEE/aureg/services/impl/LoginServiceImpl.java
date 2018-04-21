package org.innopolis.javaEE.aureg.services.impl;

import org.innopolis.javaEE.aureg.services.interfaces.LoginService;
import org.innopolis.javaEE.fileIO.service.util.ServiceException;

public class LoginServiceImpl implements LoginService{
    @Override
    public boolean auth(String login, String password) throws ServiceException {
        throw new ServiceException();
    }
}
