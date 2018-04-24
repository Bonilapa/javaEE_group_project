package org.innopolis.javaEE.aureg.controller;


import org.innopolis.javaEE.aureg.forms.LoginFrom;
import org.innopolis.javaEE.aureg.services.impl.LoginServiceImpl;
import org.innopolis.javaEE.aureg.services.interfaces.LoginService;
import org.innopolis.javaEE.fileIO.service.util.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/auth")
public class Authorize {
    private final static Logger LOGGER = LoggerFactory.getLogger(org.innopolis.javaEE.fileIO.controller.ExportController.class);

    private final LoginService loginService = new LoginServiceImpl();

//    @Autowired
//    public Authorize(LoginService loginService){
//        this.loginService = loginService;
//    }

    @RequestMapping(method = POST)
    public String auth(@ModelAttribute LoginFrom loginFrom) throws IOException, ServiceException {
//        LOGGER.debug("user auth");

        if (loginService.auth(loginFrom.getLogin(), loginFrom.getPassword())) {
            System.out.println("authed");
//            req.getSession().setAttribute("userLogin", loginFrom.getLogin());
            return "index";
        }else{
            System.out.println("NOT");
            return "register";
        }
    }
    @RequestMapping(method = GET)
    public String show(){
        return "login";
    }
}
