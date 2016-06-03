package com.site.controller;

/**
 *
 * @author FSEVERI\reginato2906
 */


import Models.Email;
import Models.Evento;
import Models.Utente;
import databaseUtility.Database;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InfoController {
    
    private Database db;
    
    public InfoController() {
        try {
            db = new Database();
        } catch (Throwable ex) {
            Logger.getLogger(EventiController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @RequestMapping(value="/info",method=RequestMethod.GET)
    public String getInfo(ModelMap map){
        return "info";
    }
    
    @RequestMapping(value = "/email", method = RequestMethod.GET)
  public String email(ModelMap map, 
          @RequestParam(value = "nome", required = true) String Nome, 
          @RequestParam(value = "email", required = true) String email, 
          @RequestParam(value = "messaggio", required = true) String messaggio) {
              
        Email c = new Email();
        c.setNome(Nome);
        c.setEmail(email);
        c.setTesto(messaggio);
        db.inviaEmail(c);
        return "redirect: /info?emailinviata=true";
  }
  

}
