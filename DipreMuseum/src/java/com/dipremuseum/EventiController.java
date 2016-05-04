package com.dipremuseum;

import hibernate.ManageDatabase;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Categoria;
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
public class EventiController {
    ManageDatabase db; 
    
    public EventiController(){
        try {
            db = new ManageDatabase();
        } catch (Throwable ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @RequestMapping(value="/eventi",  method = RequestMethod.GET)
    public String infoevento(ModelMap map){
        try {
            List<Categoria> categorie = db.getCategorie();
            
            for(Categoria c :categorie){
                System.out.println("categoria:  ->"+c.getDescrizione());
            }
            List<Visita> eventi = db.getEventi();
            
            if(eventi!=null){
                map.put("eventi", eventi);           
            }
        } catch (Throwable ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "eventi";
    }
   
}