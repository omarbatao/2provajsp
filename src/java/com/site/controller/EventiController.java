/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.site.controller;

import Models.Commento;
import Models.Evento;
import Models.Utente;
import databaseUtility.Database;
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
public class EventiController {

    private Database db;

    public EventiController() {
        try {
            db = new Database();
        } catch (Throwable ex) {
            Logger.getLogger(EventiController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @RequestMapping(value = "/infoevento", method = RequestMethod.GET)
    public String infoEvento(ModelMap map, @RequestParam(value = "eventoid") String eventoid) {
        Evento e = db.getEvento(eventoid);
        List<Commento> commenti = db.getCommentiPerEvento(eventoid);
        System.out.println("Commenti per evento:" + commenti.get(0).getIdU().getNickname());
        map.put("evento", e);
        map.put("commenti", commenti);
        return "evento/infoEvento";
    }

    @RequestMapping(value = "/addComment", method = RequestMethod.GET)
    public String addComment(ModelMap map,
            @RequestParam(value = "testo") String testo,
            @RequestParam(value = "voto") Integer voto,
            @RequestParam(value = "utente") String utente,
            @RequestParam(value = "eventoid") String eventoid) {
        
        Utente u = db.getUtente(utente);
        Evento e = db.getEvento(eventoid);
        Commento c = new Commento();
        c.setCommento(testo);
        c.setVoto(voto);
        c.setEvento(e);
        c.setIdU(u);
        return "redirect: /infoevento?inserito=true ";
    }

    @RequestMapping(value = "/addevento", method = RequestMethod.GET)
    public String addEvento(ModelMap map, @RequestParam(value = "eventoid") String eventoid) {
        return "evento/addEvento";
    }

}
