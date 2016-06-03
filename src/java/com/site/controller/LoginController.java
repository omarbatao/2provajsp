/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.site.controller;

import Models.Utente;
import databaseUtility.Database;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpRequest;
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

    public LoginController() {

        try {
            db = new Database();
        } catch (Throwable ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(ModelMap map, HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect: /";
    }

    @RequestMapping(value = "/joinus", method = RequestMethod.GET)
    public String joinus(ModelMap map) {
        return "utente/joinus";
    }

    //------------------- correzione omar
    @RequestMapping(value = "/verificaLogin", method = RequestMethod.POST)
    public String verificaLogin(ModelMap map, HttpServletRequest request,
            @RequestParam(value = "username", required = true) String username,
            @RequestParam(value = "password", required = true) String pw) {

        String nicknamesession = (String) request.getSession().getAttribute("utente");        
        if (nicknamesession != null){
            if(nicknamesession.equals(username)) {
                map.put("error", "true");
                map.put("alreadylogged", "true");
                return "redirect: /";
            }
        }
        Utente user = db.getUtente(username);
        if (user == null) {
            map.put("error", "true");
            map.put("nomach", "true");
            return "redirect: /";
        }
        if (!user.getPw().equals(Utility.md5(pw))) {
            map.put("error", "true");
            map.put("errpw", "true");
            return "redirect: /";
        }
        
        request.getSession().setAttribute("utente", user.getNickname());
        map.put("error", "false");  
        map.put("logged", "true");
        return "redirect: /";

    }

    @RequestMapping(value = "/registra", method = RequestMethod.POST)
    public String registra(ModelMap map, HttpServletRequest request,
            @RequestParam(value = "utente", required = true) String nickname,
            @RequestParam(value = "nome", required = true) String nome,
            @RequestParam(value = "cognome", required = true) String cognome,
            @RequestParam(value = "email", required = true) String email,
            @RequestParam(value = "password", required = true) String password,
            @RequestParam(value = "verificaPassword", required = true) String verificaPassword) {

        String nicknamesession = (String) request.getSession().getAttribute("utente");
        if (nicknamesession != null && nicknamesession.equals(nickname)) {
            map.put("error", "true");
            map.put("alreadylogged", "true");
        }
        Utente user = db.getUtente(nickname);
        if (user == null) {
            map.put("error", "true");
            map.put("nomach", "true");
        } else {
            if (!password.equals(verificaPassword)) {
                map.put("error", "true");
                map.put("errpw", "true");
            } else {
                user = new Utente();
                user.setNickname(nickname);
                user.setNome(nome);
                user.setCognome(cognome);
                user.setEmail(email);
                user.setPw(password);
                request.getSession().setAttribute("utente", user.getNickname());
                db.salvaUtente(user);
                map.put("error", "false");
                map.put("benvenuto", "true"); 
                return "redirect: /";
            }
        }
        return "redirect: /joinus";
    }
    
}
