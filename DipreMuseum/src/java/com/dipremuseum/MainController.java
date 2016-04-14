/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dipremuseum;

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
import po.ManageDatabase;

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
        List<Visita> visite = db.getVisite();
        if(visite!=null){
            map.put("visite", visite);
        }
        map.put("titolo", "Dipr&egrave Museum");
        return "index";
    }
      
}
