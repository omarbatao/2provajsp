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
public class VisiteController {

    ManageDatabase db;

    public VisiteController() {
        try {
            db = new ManageDatabase();
        } catch (Throwable ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @RequestMapping(value = "/visite", method = RequestMethod.GET)
    public String visite(ModelMap map) {
        try {
            List<Visita> visitedb = db.getVisite();
            if (visitedb != null) {
                map.put("visite", visitedb);
            }

            map.put("titolo", "Visite");
        } catch (Throwable ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "visite";
    }
}

