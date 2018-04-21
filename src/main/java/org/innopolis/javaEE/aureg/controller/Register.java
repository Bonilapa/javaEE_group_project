package org.innopolis.javaEE.aureg.controller;

import org.innopolis.javaEE.aureg.services.interfaces.RegisterService;
import org.innopolis.javaEE.fileIO.controller.ExportController;
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
@RequestMapping("/reg")
public class Register {
    private final static Logger LOGGER = LoggerFactory.getLogger(ExportController.class);

    private final RegisterService registerService;

    @Autowired
    public Register(RegisterService registerService){
        this.registerService = registerService;
    }

    public void getExportFile(HttpServletResponse response) throws IOException, ServiceException {
        LOGGER.debug("Register new user");
    }
}
