package org.innopolis.javaEE.userStatPart.controllers;

import org.innopolis.javaEE.userStatPart.model.Stat;
import org.innopolis.javaEE.userStatPart.model.services.interfaces.StatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.SQLException;
//import org.apache.log4j.Logger;

@Controller
public class StatController {
    //private static final Logger LOGGER = Logger.getLogger(StatController.class);
    private final StatService statService;

    @Autowired
    public StatController(StatService statService) {
        this.statService = statService;
    }

    @RequestMapping(value = "/stat/{id}", method = RequestMethod.GET)
    public String getStatInfo(@PathVariable("id") Integer id) {
        try {
            Stat stat = statService.getStatByUserId(id);
        } catch (SQLException e) {
            //LOGGER.debug(e);
        }
        return "stat";
    }
}
