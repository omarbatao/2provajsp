/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dipremuseum;

import hibernate.ManageDatabase;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Visita;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author FSEVERI\loreggian3064
 */
@Controller
public class MainController {
    
    ManageDatabase db; 
    
    public MainController(){
        try {
            db = new ManageDatabase();
        } catch (Throwable ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @RequestMapping(value="/",  method = RequestMethod.GET)
    public String index(ModelMap map){
        try {
            db = new ManageDatabase();
            
            List<Visita> visite = db.getVisite();
            Visita v= visite.get(0);
            System.out.println("visite:"+v.getTitolo());
            if(visite!=null){
                map.put("visite", visite);
            }
            map.put("titolo", "Dipr&egrave Museum");
        } catch (Throwable ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "index";
    }
   
}
