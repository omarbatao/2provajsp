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
import models.Amministratore;
import models.Biglietto;
import models.Visitatore;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String admin(ModelMap map) {// --- request menu 
        return "adminviews/login";
    }
    
    @RequestMapping(value = "/adminchecklogin", method = RequestMethod.POST)
    public String check(ModelMap map, @RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {
        if (username != null && password != null) {
            //   List<Amministratore> admins = db.getAmministratori();
            List<Amministratore> visitatori = db.getAmministratori();
            //    Amministratore a = new Amministratore();
            //     a.setEmail(email);
            //    a.setPw(password);
//            if (admins.contains(a)) {
//                map.put("login", "true");
//                map.put("admin", "true");
//                map.put("email", email);
//                map.put("password", password);
//            }

            for (int i = 0; i < visitatori.size(); i++) {
                if (visitatori.get(i).getPw().equals(password) && visitatori.get(i).getEmail().equals(username)) {
                    Visitatore v = db.getVisitatoreById(visitatori.get(i).getId());
                   
                   
                    map.put("username", username);
                    map.put("userid", v.getId());
                    return "adminviews/checklogin";
                }
            }
            return "redirect:adminviews/login?error=true";
        } else {
            return "redirect:adminviews/login";
        }
    }

    @RequestMapping(value = "/adminchecklogin", method = RequestMethod.GET)
    public String check(ModelMap map) {
        return "redirect:/admin";
    }

    @RequestMapping(value = "/adminlogout", method = RequestMethod.GET)
    public String logout(ModelMap map) {
        return "adminviews/logout";
    }
    
    

    @RequestMapping(value = "/adminhome")
    public String home(ModelMap map) {// --- request menu 0
        init();
        List<Visita> eventi = db.getEventi();
        List<Biglietto> biglietti = db.getBiglietti();
        menustate[0]="active";
        map.put("biglietti",biglietti);
        map.put("eventi", eventi);
        map.put("menustate",menustate);
        map.put("titolo", "Admin");
        map.put("username", "Username");
        return "admin";
        
        
    }

    
    @RequestMapping(value = "/adminevents")
    public String events(ModelMap map) {// --- request menu 1
        init();
        List<Visita> eventi = db.getEventi();
        menustate[1]="active";
        map.put("menustate",menustate);
        map.put("eventi",eventi);
        map.put("titolo", "Admin - Events");
        map.put("username", "Username");
        return "adminviews/events";

    }
    
    @RequestMapping(value = "/adminvisits")
    public String visits(ModelMap map) {// --- request menu 2
        init();
        List<Visita> visite = db.getVisite();
        menustate[2]="active";
        map.put("menustate",menustate);
        map.put("titolo", "Admin - Visits");
        map.put("username", "Username");
        map.put("visite",visite);
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
