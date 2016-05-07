package com.site.controller;

/**
 *
 * @author FSEVERI\reginato2906
 */

import com.site.Database;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ArtistaController {
    Database db;

    public ArtistaController() {
        try {
            db= new Database();
        } catch (Throwable ex) {
            Logger.getLogger(ArtistaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @RequestMapping(value="/artista",method=RequestMethod.GET)
    public String getServizi(ModelMap map){
        map.put("artista", db.getArtisti());
        return "artista";
    }
}

