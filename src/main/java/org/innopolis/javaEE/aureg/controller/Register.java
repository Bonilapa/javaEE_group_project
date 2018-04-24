package org.innopolis.javaEE.aureg.controller;

import org.innopolis.javaEE.aureg.forms.LoginFrom;
import org.innopolis.javaEE.aureg.services.impl.RegisterServiceImpl;
import org.innopolis.javaEE.aureg.services.interfaces.LoginService;
import org.innopolis.javaEE.aureg.services.interfaces.RegisterService;
import org.innopolis.javaEE.dataService.pojo.User;
import org.innopolis.javaEE.fileIO.controller.ExportController;
import org.innopolis.javaEE.fileIO.service.interfaces.ExportService;
import org.innopolis.javaEE.fileIO.service.util.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;


@Controller
@RequestMapping("/reg")
public class Register {
    private final static Logger LOGGER = LoggerFactory.getLogger(ExportController.class);

    private final RegisterService registerService = new RegisterServiceImpl();

//    @Autowired
//    public Register(RegisterService registerService) {
//        this.registerService = registerService;
//    }

    @RequestMapping(method = POST)
    public String registerUser(@ModelAttribute LoginFrom loginFrom) throws IOException, ServiceException {
//        LOGGER.debug("Register new user");/
        User user = new User(loginFrom.getLogin(), loginFrom.getPassword());
        registerService.register(user);
        return "redirect:/auth";
    }

    @RequestMapping(method = GET)
    public String registerUser(){
        return "register";
    }
}