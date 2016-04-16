/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dipremuseum;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Visita;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import hibernate.ManageDatabase;

/**
 *
 * @author FSEVERI\ceretta2991
 */
@Controller
public class AdminController {

    ManageDatabase db;

    public AdminController() {
        try {
            db = new ManageDatabase();
        } catch (Throwable ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @RequestMapping(value = "/admin")
    public String admin(ModelMap map) {
        map.put("titolo", "Admin");
        map.put("username", "Username");
        return "admin";
    }

    @RequestMapping(value = "/adminprofile")
    public String adminprofile(ModelMap map) {
        map.put("titolo", "Admin - Profile");
        map.put("username", "Username");
        return "adminviews/profile";
    }

    @RequestMapping(value = "/adminevents")
    public String events(ModelMap map) {
        //List<Visita> visite = db.getEventi();
        
        
        map.put("titolo", "Admin - Events");
        map.put("username", "Username");
        return "adminviews/events";

    }
}
