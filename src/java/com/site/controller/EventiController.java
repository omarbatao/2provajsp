/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.site.controller;

import Models.Evento;
import databaseUtility.Database;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author FSEVERI\ceretta2991
 */

@Controller
public class EventiController {
    
    private Database db;
    
    public EventiController(){
        try {
            db= new Database();
        } catch (Throwable ex) {
            Logger.getLogger(EventiController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @RequestMapping(value = "/infoevento", method = RequestMethod.GET)
    public String infoEvento(ModelMap map,@RequestParam(value = "eventoid") String eventoid){
        Evento e = db.getEvento(eventoid);
        map.put("evento", e);
        return "evento/infoEvento";
    }
    
    @RequestMapping(value = "/addevento", method = RequestMethod.GET)
    public String addEvento(ModelMap map,@RequestParam(value = "eventoid") String eventoid){
        Evento e = db.getEvento(eventoid);
        map.put("evento", e);
        return "evento/addEvento";
    }
    
    
}
