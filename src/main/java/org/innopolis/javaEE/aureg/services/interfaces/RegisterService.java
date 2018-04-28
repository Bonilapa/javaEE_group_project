package org.innopolis.javaEE.aureg.services.interfaces;

import org.innopolis.javaEE.dataService.pojo.User;
import org.innopolis.javaEE.fileIO.service.util.ServiceException;

public interface RegisterService {
    Integer register(User user)throws ServiceException;
}