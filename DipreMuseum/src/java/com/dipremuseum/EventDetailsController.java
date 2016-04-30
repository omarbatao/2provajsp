package com.dipremuseum;

import hibernate.ManageDatabase;
import java.util.ArrayList;
import java.util.Collections;
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
public class EventDetailsController {
    
    ManageDatabase db; 
    
    public EventDetailsController(){
        try {
            db = new ManageDatabase();
        } catch (Throwable ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @RequestMapping(value="/evento",  method = RequestMethod.GET)
    public String infoevento(ModelMap map,@RequestParam(value="id") String id){
        try {
            
            Visita evento = db.getEventoById(id);
            
            if(evento!=null){
                map.put("evento", evento);
                map.put("titolo", evento.getTitolo());
            }
        } catch (Throwable ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "dettaglievento";
    }
   
}