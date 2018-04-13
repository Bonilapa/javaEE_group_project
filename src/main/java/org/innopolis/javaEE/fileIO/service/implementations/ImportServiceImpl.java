package org.innopolis.javaEE.fileIO.service.implementations;

import org.innopolis.javaEE.fileIO.service.interfaces.ImportService;
import org.innopolis.javaEE.fileIO.service.util.ServiceException;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.File;

public class ImportServiceImpl implements ImportService {
    @Override
    public void processFile(File file) throws ServiceException {
        throw new ServiceException();
    }
}
