package org.innopolis.javaEE.aureg.controller;

import org.innopolis.javaEE.aureg.forms.Dislogin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/error")
public class ErrorController {

    private final static Logger LOGGER = LoggerFactory.getLogger(ErrorController.class);
    @RequestMapping(method=POST)
    public String dislogin(HttpSession httpSession,
                            @ModelAttribute Dislogin dislogin) {
        if (dislogin != null) {
            httpSession.setAttribute("userName", "");
            httpSession.setAttribute("rights", "");
            return "redirect:/auth";

        }
        return "error";
    }
    @RequestMapping(method=GET)
    public String sendError(HttpSession httpSession){

        httpSession.setAttribute("errorMessage", "You have no power here!");
        return "error";
    }
}
