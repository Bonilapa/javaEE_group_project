package org.innopolis.javaEE.controller;

import org.innopolis.javaEE.aureg.forms.Dislogin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/hello")
public class HelloController {
    private final static Logger LOGGER = LoggerFactory.getLogger(HelloController.class);
    @RequestMapping(method = POST)
    public String dislogin(HttpSession httpSession,
                        @ModelAttribute Dislogin dislogin) {
        if (dislogin != null) {
            httpSession.setAttribute("userName", "");
            httpSession.setAttribute("rights", "");
            return "redirect:/auth";

        }
        return "index";
    }

    @RequestMapping(method = GET)
    public String index(HttpSession httpSession) {
        httpSession.setAttribute("errorMessage", "");
        LOGGER.debug("GET: index");
        return "index";
    }
}