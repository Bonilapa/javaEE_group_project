package org.innopolis.javaEE.fileIO.service.interfaces;

import org.innopolis.javaEE.fileIO.service.util.ServiceException;

import javax.json.JsonObject;

public interface ExportService {
    JsonObject getExportFile() throws ServiceException;
}
