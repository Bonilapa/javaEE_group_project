package org.innopolis.javaEE.fileIO.controller;


import org.innopolis.javaEE.fileIO.service.interfaces.ExportService;
import org.innopolis.javaEE.fileIO.service.util.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Controller
//@RequestMapping("/export")
public class ExportController {
    private final static Logger LOGGER = LoggerFactory.getLogger(ExportController.class);

    private final ExportService exportService;

    @Autowired
    public ExportController(ExportService exportService){
        this.exportService = exportService;
    }

    @RequestMapping(value = "/export", method = RequestMethod.GET)
    public void getExportFile(HttpServletResponse response) throws IOException, ServiceException {
        LOGGER.debug("Getting request to export file");
        JsonObject file = exportService.getExportFile();
        ServletOutputStream out = response.getOutputStream();

        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=\"export.gaus\"");

        JsonWriter writer = Json.createWriter(out);
        writer.writeObject(file);
        writer.close();
    }
}
