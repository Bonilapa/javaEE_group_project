package org.innopolis.javaEE.fileIO.service.interfaces;

import org.innopolis.javaEE.fileIO.service.util.ServiceException;

import java.io.File;

public interface ImportService {
    void processFile(File file) throws ServiceException;
}
