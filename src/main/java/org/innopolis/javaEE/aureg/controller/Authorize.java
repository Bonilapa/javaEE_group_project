package org.innopolis.javaEE.aureg.controller;


import org.innopolis.javaEE.aureg.services.interfaces.LoginService;
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
@RequestMapping("/auth")
public class Authorize {
    private final static Logger LOGGER = LoggerFactory.getLogger(org.innopolis.javaEE.fileIO.controller.ExportController.class);

    private final LoginService loginService;

    @Autowired
    public Authorize(LoginService loginService){
        this.loginService = loginService;
    }

    public void auth(HttpServletResponse response) throws IOException, ServiceException {
        LOGGER.debug("user auth");
    }
}
