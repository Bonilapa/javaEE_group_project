package org.innopolis.javaEE.fileIO.service.interfaces;

import org.innopolis.javaEE.fileIO.service.util.ServiceException;

public interface ExportService {
    byte[] getExportFile() throws ServiceException;
}
