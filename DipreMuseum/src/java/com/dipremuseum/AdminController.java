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

    private ManageDatabase db;
    private String menustate[];

    public AdminController() {
        try {
            db = new ManageDatabase();
        } catch (Throwable ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        init();
        
    }
    
    @RequestMapping(value = "/adminprofile")
    public String adminprofile(ModelMap map) {
        map.put("titolo", "Admin - Profile");
        map.put("username", "Username");
        return "adminviews/profile";
    }


    @RequestMapping(value = "/admin")
    public String admin(ModelMap map) {// --- request menu 0
        init();
        menustate[0]="active";
        map.put("menustate",menustate);
        map.put("titolo", "Admin");
        map.put("username", "Username");
        return "admin";
    }

    
    @RequestMapping(value = "/adminevents")
    public String events(ModelMap map) {// --- request menu 1
        init();
        //List<Visita> visite = db.getEventi();
        menustate[1]="active";
        map.put("menustate",menustate);
        map.put("titolo", "Admin - Events");
        map.put("username", "Username");
        return "adminviews/events";

    }
    
    @RequestMapping(value = "/adminvisits")
    public String visits(ModelMap map) {// --- request menu 2
        init();
        
        menustate[2]="active";
        map.put("menustate",menustate);
        map.put("titolo", "Admin - Visits");
        map.put("username", "Username");
        return "adminviews/visite";

    }
    
    @RequestMapping(value = "/adminservices")
    public String services(ModelMap map) {// --- request menu 3
        init();
        
        menustate[3]="active";
        map.put("menustate",menustate);
        map.put("titolo", "Admin - Services");
        map.put("username", "Username");
        return "adminviews/services";

    }
    
    private void init(){ 
        menustate = new String[] {"","","",""};
    }
}
