package org.innopolis.javaEE.aureg.controller;

import org.innopolis.javaEE.aureg.forms.Dislogin;
import org.innopolis.javaEE.aureg.forms.LoginForm;
import org.innopolis.javaEE.aureg.services.impl.LoginServiceImpl;
import org.innopolis.javaEE.aureg.services.impl.RegisterServiceImpl;
import org.innopolis.javaEE.dataService.pojo.User;
import org.innopolis.javaEE.utils.Valid;
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
@RequestMapping("/reg")
public class Register {

    private final static Logger LOGGER = LoggerFactory.getLogger(Register.class);
    private final RegisterServiceImpl registerService;
    private final LoginServiceImpl loginService;

    @Autowired
    public Register(RegisterServiceImpl registerService,
                    LoginServiceImpl loginService) {

        this.registerService = registerService;
        this.loginService = loginService;
    }

    @RequestMapping(method = POST)
    public String registerUser(@ModelAttribute LoginForm loginFrom,
                               @ModelAttribute Dislogin dislogin,
                               HttpSession httpSession){
        if(dislogin != null){
            httpSession.setAttribute("userName", "");
            httpSession.setAttribute("rights", "");
            return "redirect:/auth";

        }
        LOGGER.debug("POST: Register new user");

        if (loginFrom.getRights() == null) {
            loginFrom.setRights("user");
        }

        User user = new User(loginFrom.getLogin(), loginFrom.getPassword(), loginFrom.getRights());

        Valid.Error state;

        LOGGER.debug("Check user if exists");

            state = registerService.register(user);

        if (state == Valid.Error.Exists) {

            httpSession.setAttribute("errorMessage", "Such user already exists.");

            return "login";

        } else {

            switch (state) {

                case Correct: {

                    httpSession.setAttribute("errorMessage", "");
                    return "redirect:/auth";
                }

                case EmptyPassword: {

                    httpSession.setAttribute("errorMessage", new String("Empty Password."));
                    return "register";
                }

                case EmptyLogin: {

                    httpSession.setAttribute("errorMessage", new String("Empty Login."));
                    return "register";
                }

            }
        }
        return "index";
    }

    @RequestMapping(method = GET)
    public String registerUser(HttpSession httpSession){

        httpSession.setAttribute("errorMessage", "");

        LOGGER.debug("GET: show register page");

        return "register";
    }
}