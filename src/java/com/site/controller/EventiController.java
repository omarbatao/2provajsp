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
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author FSEVERI\ceretta2991
 */
@Controller
public class EventiController {

    private Database db;
    private List<Evento> e;

    public EventiController() {
        try {
            db = new Database();
            e= db.getEventi();
        } catch (Throwable ex) {
            Logger.getLogger(EventiController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @RequestMapping(value = "/infoevento", method = RequestMethod.GET)
    public String infoEvento(ModelMap map, @RequestParam(value = "eventoid") String eventoid) {
        Evento e = db.getEvento(eventoid);
        List<Commento> commenti = db.getCommentiPerEvento(eventoid);
        //System.out.println("Commenti per evento:" + commenti.get(0).getIdU().getNickname());
        map.put("evento", e);
        
        if(commenti== null){ 
            map.put("errore","nocommenti");
            return "evento/infoEvento";
        }
        System.out.println(commenti);
        map.put("commenti", commenti);
        map.put("errore","false");
        return "evento/infoEvento";
    }

    @RequestMapping(value = "/addComment", method = RequestMethod.POST)
    public String addComment(ModelMap map,
            HttpServletRequest request,
            @RequestParam(value = "testo") String testo,
            @RequestParam(value = "voto") Integer voto,
            @RequestParam(value = "eventoid") String eventoid) {
        
        Utente u = db.getUtente((String)request.getSession().getAttribute("utente"));
        if(u==null) {
            map.put("errore","nocommenti");
            return "evento/infoEvento";
        }
        Evento e = db.getEvento(eventoid);
        Commento c = new Commento();
        c.setCommento(testo);
        c.setVoto(voto);
        c.setEvento(e);
        c.setIdU(u);
        c.setDataC(new Date());
        db.insertCommento(c);
        
        
        return "redirect: /infoevento?errore=false&inserito=true&eventoid="+eventoid;
    }

    @RequestMapping(value = "/addevento", method = RequestMethod.GET)
    public String addEvento(ModelMap map, @RequestParam(value = "eventoid") String eventoid) {
        return "evento/addEvento";
    }
    
    
    @RequestMapping(value = "/cercaevento", method = RequestMethod.GET)
    public @ResponseBody
    String cercaeventi(ModelMap map,
            @RequestParam(value = "titoloevento") String titoloevento) {
        
        boolean x = false;
        StringBuffer sb = new StringBuffer();
        String arr[] = titoloevento.split(" ", 2);
        titoloevento = arr[0];   
        
        for(Evento evento: e){
            if(evento.getTitolo().toLowerCase().contains(titoloevento.toLowerCase())){
                sb.append("<evento>");
                sb.append("<id>"+evento.getId()+"</id>");
                sb.append("<titolo>"+evento.getTitolo()+"</titolo>");
                sb.append("</evento>");
                x=true;
            }
        }
        
        if(x){
            return "<eventi>"+sb.toString()+"</eventi>";
        }
        
        return "errore";
    }
    
    
    

}
