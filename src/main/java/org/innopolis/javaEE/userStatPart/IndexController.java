package org.innopolis.javaEE.userStatPart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String indexGetRequest(){
        logger.error("Get request for index");
        return "index";
    }

    @RequestMapping(value = "/asd", method = RequestMethod.GET)
    public String index1GetRequest(){
        logger.error("Get request for index");
        return "index";
    }

}
