/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dipremuseum;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import hibernate.ManageDatabase;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Visita;
import org.springframework.stereotype.Controller;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author FSEVERI\loreggian3064
 */
@Controller
public class UtentiController {

    ManageDatabase db;

    public UtentiController() {
        try {
            db = new ManageDatabase();
        } catch (Throwable ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(ModelMap map) {
        return "login";
    }
    
     @RequestMapping(value = "/checklogin", method = RequestMethod.POST)
    public String check(ModelMap map) {
        return "checklogin";
    }
   
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(ModelMap map){
        return "logout";
    }
    
 
}
