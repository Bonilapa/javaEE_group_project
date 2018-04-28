package org.innopolis.javaEE.aureg.controller;

import org.innopolis.javaEE.aureg.forms.*;
import org.innopolis.javaEE.aureg.services.impl.UserRightsEditServiceImpl;
import org.innopolis.javaEE.dataService.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/editAdmin")
public class AdminEdit {
    public AdminEdit() {
    }
    UserRightsEditServiceImpl userRightsEditService = new UserRightsEditServiceImpl();

    @RequestMapping(method=POST)
    public String editAdminRights(@ModelAttribute EditRights editRights){
        Integer admin = editRights.getAdminRights(),
                user = editRights.getUserRights(),
                delete = editRights.getDeleteUser();
        if(admin!=null && user==null && delete==null) {
            userRightsEditService.giveAdminRights(admin);
        }else {
            if (admin == null && user != null && delete == null) {
                userRightsEditService.giveUserRights(user);
            }else {
                if(admin == null && user == null && delete != null) {
                    userRightsEditService.deleteUser(delete);
                }
            }
        }
//        System.out.println(editRights.getAdminRights()
//                +" "+editRights.getUserRights()
//                +" "+editRights.getDeleteUser());
        return "redirect:editAdmin";
    }
    @RequestMapping(method=GET)
    public ModelAndView index() {
        return new ModelAndView("editAdmin",
                Collections.singletonMap("list", userRightsEditService.getAll()));
    }


}
