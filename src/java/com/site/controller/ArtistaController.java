package com.site.controller;

/**
 *
 * @author FSEVERI\reginato2906
 */

import Models.Artista;
import databaseUtility.Database;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ArtistaController {
    List<Artista> artisti= new ArrayList<>();
    Database db;
    

    public ArtistaController() {
        try {
            db= new Database();
            artisti=db.getArtisti();
        } catch (Throwable ex) {
            Logger.getLogger(ArtistaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @RequestMapping(value="/artisti",method=RequestMethod.GET)
    public String getArtista(ModelMap map){
        System.out.println(artisti.toString());
        map.put("artisti",artisti );
        return "artista/artisti";
    }
}

