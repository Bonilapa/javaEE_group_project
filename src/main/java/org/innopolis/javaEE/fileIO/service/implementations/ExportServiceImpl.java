package org.innopolis.javaEE.fileIO.service.implementations;

import org.innopolis.javaEE.fileIO.service.interfaces.ExportService;
import org.innopolis.javaEE.fileIO.service.util.ServiceException;

public class ExportServiceImpl implements ExportService {
    @Override
    public byte[] getExportFile() throws ServiceException {
        throw new ServiceException();
    }
}
