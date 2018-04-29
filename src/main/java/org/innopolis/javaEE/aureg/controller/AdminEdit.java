package org.innopolis.javaEE.aureg.controller;

import org.innopolis.javaEE.aureg.forms.*;
import org.innopolis.javaEE.aureg.services.impl.UserRightsEditServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collections;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/editAdmin")
public class AdminEdit {
    private final static Logger LOGGER = LoggerFactory.getLogger(AdminEdit.class);
    private final UserRightsEditServiceImpl userRightsEditService;

    @Autowired
    public AdminEdit(UserRightsEditServiceImpl userRightsEditService) {
        this.userRightsEditService = userRightsEditService;
    }


    @RequestMapping(method = POST)
    public String editAdminRights(@ModelAttribute EditRights editRights,
                                  @ModelAttribute Dislogin dislogin,
                                  HttpSession httpSession){
        if(dislogin != null){
            httpSession.setAttribute("userName", "");
            httpSession.setAttribute("rights", "");
            return "redirect:/auth";

        }
        LOGGER.debug("POST: edit admin rights");

        Integer admin = editRights.getAdminRights(),
                user = editRights.getUserRights(),
                delete = editRights.getDeleteUser();

        if(admin != null && user == null && delete == null) {

            LOGGER.debug("Set admin user: " + admin);
            userRightsEditService.giveAdminRights(admin);

        }else {

            if (admin == null && user != null && delete == null) {

                LOGGER.debug("Set user user: " + user);
                userRightsEditService.giveUserRights(user);

            }else {

                if(admin == null && user == null && delete != null) {

                    LOGGER.debug("Delete user: " + delete);
                    userRightsEditService.deleteUser(delete);
                }

            }

        }

        return "redirect:editAdmin";
    }

    @RequestMapping(method=GET)
    public ModelAndView index(HttpSession httpSession) {

        httpSession.setAttribute("errorMessage", "");
        LOGGER.debug("GET: index");
        return new ModelAndView("editAdmin",
                Collections.singletonMap("list", userRightsEditService.getAll()));
    }

}