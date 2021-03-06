/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.site.controller;

import Models.Categoria;
import Models.Evento;
import databaseUtility.Database;
import java.util.ArrayList;
import java.util.List;
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
public class MainController {
    
    List<Categoria> categorie = new ArrayList<>();
    List<Evento> eventi = new ArrayList<>();
    Database db;
    
    
    public MainController(){
        try {
            this.db = new Database();
            
        } catch (Throwable ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    @RequestMapping(value = "/", method = RequestMethod.GET)//defaulr get metod
    public String index(ModelMap map/*, @RequestParam(value = "risposta",required=false) String risp*/){
        
        map.put("titolopagina","LFH - home");
        if(db!=null){
            eventi = db.getEventi();
            categorie = db.getCategorie();
        }
        
        //map.put("risposta",risp);
        map.put("eventi",eventi);
        map.put("categorie",categorie);
        return "home";
    }

    
}
