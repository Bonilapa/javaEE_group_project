package org.innopolis.javaEE.aureg.services.impl;

import org.innopolis.javaEE.aureg.services.interfaces.RegisterService;
import org.innopolis.javaEE.fileIO.service.util.ServiceException;

public class RegisterServiceImpl implements RegisterService {
    @Override
public boolean register(String login, String password) throws ServiceException {
    throw new ServiceException();
}
}
