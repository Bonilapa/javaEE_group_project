package org.innopolis.javaEE.aureg.services.interfaces;

import org.innopolis.javaEE.fileIO.service.util.ServiceException;

public interface RegisterService {
    boolean register(String login, String password)throws ServiceException;
}