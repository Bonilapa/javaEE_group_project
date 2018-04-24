package org.innopolis.javaEE.fileIO.controller;


import org.innopolis.javaEE.fileIO.service.interfaces.ExportService;
import org.innopolis.javaEE.fileIO.service.util.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Controller
@RequestMapping("/export")
public class ExportController {
    private final static Logger LOGGER = LoggerFactory.getLogger(ExportController.class);

//    private final ExportService exportService;

//    @Autowired
//    public ExportController(ExportService exportService){
//        this.exportService = exportService;
//    }

//    public void getExportFile(HttpServletResponse response) throws IOException, ServiceException {
//        LOGGER.debug("Getting export file");
//        byte[] file = exportService.getExportFile();
//        ServletOutputStream out = response.getOutputStream();
//        out.write(file);
//        out.flush();
//    }
}
