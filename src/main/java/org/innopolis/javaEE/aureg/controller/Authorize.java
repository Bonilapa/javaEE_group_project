package org.innopolis.javaEE.aureg.controller;


import org.innopolis.javaEE.aureg.forms.ErrorMessage;
import org.innopolis.javaEE.aureg.forms.LoginForm;
import org.innopolis.javaEE.aureg.services.impl.LoginServiceImpl;
import org.innopolis.javaEE.aureg.services.interfaces.LoginService;
import org.innopolis.javaEE.dataService.pojo.User;
import org.innopolis.javaEE.fileIO.service.util.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
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
    public String auth(@ModelAttribute LoginForm loginForm,
                       HttpSession httpSession) throws IOException, ServiceException {
//        LOGGER.debug("user auth");
        User user = loginService.auth(loginForm.getLogin(), loginForm.getPassword());
        if (user != null && user.getLogin() != null) {


            httpSession.setAttribute("userName", user.getLogin());
            httpSession.setAttribute("rights", user.getRights());

                return "redirect:/hello";
        }else{
            httpSession.setAttribute("errorMessage", "Incorrect login or password.");
            return "login";
        }
    }

    @RequestMapping(method = GET)
    public String show(){
        return "login";
    }
}
