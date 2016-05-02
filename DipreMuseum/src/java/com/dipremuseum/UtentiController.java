/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dipremuseum;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import hibernate.ManageDatabase;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import models.Amministratore;
import models.Visita;
import models.Visitatore;
import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author FSEVERI\loreggian3064
 */
@Controller
public class UtentiController {

    ManageDatabase db;

    public UtentiController() {
        try {
            db = new ManageDatabase();
        } catch (Throwable ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(ModelMap map) {
        return "login";
    }

    @RequestMapping(value = "/checklogin", method = RequestMethod.POST)
    public String check(ModelMap map, @RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {
        if (username != null && password != null) {
            //   List<Amministratore> admins = db.getAmministratori();
            List<Visitatore> visitatori = db.getVisitatori();
            //    Amministratore a = new Amministratore();
            //     a.setEmail(email);
            //    a.setPw(password);
//            if (admins.contains(a)) {
//                map.put("login", "true");
//                map.put("admin", "true");
//                map.put("email", email);
//                map.put("password", password);
//            }

            for (int i = 0; i < visitatori.size(); i++) {
                if (visitatori.get(i).getPassword().equals(password) && visitatori.get(i).getUsername().equals(username)) {
                    Visitatore v = db.getVisitatoreById(visitatori.get(i).getId());
                    map.put("login", "true");
                    map.put("admin", "false");
                    map.put("username", username);
                    map.put("userid", v.getId());
                    return "checklogin";
                }
            }
            return "redirect:/login?error=true";
        } else {
            return "redirect:/login";
        }
    }

    @RequestMapping(value = "/checklogin", method = RequestMethod.GET)
    public String check(ModelMap map) {
        return "redirect:/";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(ModelMap map) {
        return "logout";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerG(ModelMap map) {

        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerP(ModelMap map, @RequestParam(value = "dataN") String dataN,
            @RequestParam(value = "username") String username,
            @RequestParam(value = "password") String password,
            @RequestParam(value = "nome") String nome,
            @RequestParam(value = "cognome") String cognome) {
        System.out.println("DATAN: " + dataN);
        if (!username.isEmpty() && !password.isEmpty() && !nome.isEmpty() && !cognome.isEmpty() && !dataN.isEmpty()) {

            List<Visitatore> visitatori = db.getVisitatori();

            for (Visitatore v : visitatori) {
                if (v.getUsername().equals(username)) {
                    return "redirect:/register?exists=true";
                }

            }
            Visitatore newVisitatore = new Visitatore();
            DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
            Date startDate;
            try {
                startDate = df.parse(dataN);
                newVisitatore.setDataN(startDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            newVisitatore.setNome(nome);
            newVisitatore.setCognome(cognome);
            newVisitatore.setPassword(password);
            newVisitatore.setUsername(username);
            db.inserisciVisitatore(newVisitatore);
            return "redirect:/login";
        } else {
            return "redirect:/register?fields=true";
        }

    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String profile(ModelMap map, HttpServletRequest request) {
        Integer id = (Integer) request.getSession().getAttribute("userid");
        System.out.println("ID: " + id);
        if (id != null && !id.equals("")) {
            Visitatore visitatore = db.getVisitatoreById(id);
            map.put("profilo", visitatore);
            return "profile";
        } else {
            return "redirect:/";
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(ModelMap map, HttpServletRequest request,
            @RequestParam(value = "dataN") String dataN,
            @RequestParam(value = "username") String username,
            @RequestParam(value = "password") String password,
            @RequestParam(value = "nome") String nome,
            @RequestParam(value = "cognome") String cognome) {
        Visitatore v = new Visitatore();
        v.setUsername(username);
        v.setPassword(password);
        v.setNome(nome);
        v.setCognome(cognome);
        v.setId((Integer)request.getSession().getAttribute("userid"));
        db.aggiornaVisitatore(v);
        return "profilo";
    }

}
