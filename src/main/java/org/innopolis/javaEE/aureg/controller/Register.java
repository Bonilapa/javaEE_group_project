package org.innopolis.javaEE.aureg.controller;

import org.innopolis.javaEE.aureg.forms.ErrorMessage;
import org.innopolis.javaEE.aureg.forms.LoginForm;
import org.innopolis.javaEE.aureg.services.impl.LoginServiceImpl;
import org.innopolis.javaEE.aureg.services.impl.RegisterServiceImpl;
import org.innopolis.javaEE.aureg.services.interfaces.LoginService;
import org.innopolis.javaEE.aureg.services.interfaces.RegisterService;
import org.innopolis.javaEE.dataService.pojo.User;
import org.innopolis.javaEE.fileIO.controller.ExportController;
import org.innopolis.javaEE.fileIO.service.util.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;


@Controller
@RequestMapping("/reg")
public class Register {
    private final static Logger LOGGER = LoggerFactory.getLogger(ExportController.class);
    private final LoginService loginService = new LoginServiceImpl();

    private final RegisterService registerService = new RegisterServiceImpl();

//    @Autowired
//    public Register(RegisterService registerService) {
//        this.registerService = registerService;
//    }

    @RequestMapping(method = POST)
    public String registerUser(@ModelAttribute LoginForm loginFrom,
                               HttpSession httpSession) throws IOException, ServiceException {
//        LOGGER.debug("Register new user");/


        if (loginFrom.getRights() == null) {
            loginFrom.setRights("user");
        }
        User user = new User(loginFrom.getLogin(), loginFrom.getPassword(), loginFrom.getRights());

        LOGGER.debug("RegisterServlet adds new user");
        Integer state = registerService.register(user);

        if (state == null) {

            httpSession.setAttribute("errorMessage", "Such user already exists.");

            return "login";

        } else {

            switch (state) {

                case 0: {

                    User user1 = loginService.auth(user.getLogin(), user.getPassword());
                    httpSession.setAttribute("userName", user1.getLogin());
                    httpSession.setAttribute("rights", user1.getRights());

                    return "redirect:/hello";
                }

                case 1: {

                    httpSession.setAttribute("errorMessage", new String("Empty Password."));
                    return "register";
                }

                case -1: {

                    httpSession.setAttribute("errorMessage", new String("Empty Login."));
                    return "register";
                }

            }
        }
        return "index";
    }

    @RequestMapping(method = GET)
    public String registerUser(HttpSession httpSession){
        if(httpSession.getAttribute("userName") != null){
            if( httpSession.getAttribute("rights") == "admin") {
                return "registerAdmin";
            }else{
                return "register";
            }
        }else{
            return "register";
        }
    }
}