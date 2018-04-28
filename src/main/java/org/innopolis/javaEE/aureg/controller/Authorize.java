package org.innopolis.javaEE.aureg.controller;


import org.innopolis.javaEE.aureg.forms.LoginForm;
import org.innopolis.javaEE.aureg.services.impl.LoginServiceImpl;
import org.innopolis.javaEE.dataService.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/auth")
public class Authorize {

    private final static Logger LOGGER = LoggerFactory.getLogger(Authorize.class);
    private final LoginServiceImpl loginService;

    @Autowired
    public Authorize(LoginServiceImpl loginService) {
        this.loginService = loginService;
    }

    @RequestMapping(method = POST)
    public String auth(@ModelAttribute LoginForm loginForm,
                       HttpSession httpSession){

        LOGGER.debug("POST: auth");

        User user = loginService.auth(loginForm.getLogin(), loginForm.getPassword());

        if (user != null && user.getLogin() != null) {

            LOGGER.debug("Authorized user: " + user.getLogin());

            httpSession.setAttribute("userName", user.getLogin());
            httpSession.setAttribute("rights", user.getRights());
            return "redirect:/hello";
        }else{

            LOGGER.debug("Unsuccessful attempt to authorize user: " + user.getLogin());

            httpSession.setAttribute("errorMessage", "Incorrect login or password.");
            return "login";
        }
    }

    @RequestMapping(method = GET)
    public String show(){

        LOGGER.debug("GET: show");

        return "login";
    }

}
