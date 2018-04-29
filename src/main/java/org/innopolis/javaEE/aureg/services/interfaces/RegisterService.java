package org.innopolis.javaEE.aureg.services.interfaces;

import org.innopolis.javaEE.dataService.pojo.User;
import org.innopolis.javaEE.fileIO.service.util.ServiceException;
import org.innopolis.javaEE.utils.Valid;

public interface RegisterService {
    Valid.Error register(User user)throws ServiceException;
}