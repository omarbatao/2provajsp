/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.site.controller;

import Models.Utente;
import com.site.Database;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author FSEVERI\benetti3004
 */
@Controller
public class LoginController {
    
    private Database db;
    public LoginController(){
       
        try {
            db=new Database();
        } catch (Throwable ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
      
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(ModelMap map,
            @RequestParam(value = "username", required = false) String nomeUtente,
            @RequestParam(value = "password", required = false) String password) {
        
                return "login";
    }

    @RequestMapping(value = "/verificaLogin", method = RequestMethod.POST)
    public String verificaLogin(ModelMap map, @RequestParam(value = "utente", required = true) String nomeUtente, @RequestParam(value = "password", required = true) String password) {
        String passwordCifrata=db.cifraPassword(password);
        
        if(nomeUtente != null && passwordCifrata != null ){
            int i;
            i = db.verificaUtente(nomeUtente, passwordCifrata);
           /**
            String s= ""+i;
            map.put("risposta",s);
            map.put("utente",nomeUtente);
            **/

            if (i == 1) {
                map.put("risposta","Il nome utente è inesistente");

            }
            else if (i == 0) {
                //login affettuato correttamente
               map.put("username",nomeUtente);
               map.put("accesso",true);
            }else{
               map.put("risposta","La password è errata");
               return "login";

            }
        }
        return "login";
        

    }

    @RequestMapping(value = "/registra", method = RequestMethod.POST)
    public String registra(ModelMap map, @RequestParam(value = "utente", required = true) String nickname, @RequestParam(value = "password", required = true) String password, @RequestParam(value = "verificaPassword", required = true) String verificaPassword,@RequestParam(value = "nome", required = true) String nome,@RequestParam(value = "cognome", required = true) String cognome,@RequestParam(value = "email", required = true) String email) {
        String pass=db.cifraPassword(password);
        String verPassword=db.cifraPassword(verificaPassword);
        if (0 == db.utenteEsistente(nickname)) {
            if (pass.equals(verPassword)) {
                db.salvaUtente(new Utente(nickname,nome,cognome,email,password));
                return "login";
            } else {
                map.put("risposta","La password non coincide");
            }
        } else {
            map.put("risposta","Nome utente già esistente");
        }
        return "login";
                
    }

     @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(ModelMap map) {
        return "logout";
    }
}
