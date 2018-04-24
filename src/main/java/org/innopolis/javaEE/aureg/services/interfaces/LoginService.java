package org.innopolis.javaEE.aureg.services.interfaces;

import org.innopolis.javaEE.fileIO.service.util.ServiceException;

public interface LoginService {
    boolean auth(String login, String password) throws ServiceException;
}