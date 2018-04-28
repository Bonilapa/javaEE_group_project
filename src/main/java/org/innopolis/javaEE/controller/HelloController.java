package org.innopolis.javaEE.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping("/hello")
public class HelloController {
    private final static Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping(method = GET)
    public String index() {

        LOGGER.debug("GET: index");
        return "index";
    }
}