/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dipremuseum;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Visita;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import hibernate.ManageDatabase;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import javax.servlet.http.HttpServletRequest;
import models.Amministratore;
import models.Biglietto;
import models.Visitatore;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author FSEVERI\ceretta2991
 */
@Controller
public class AdminController {

    private ManageDatabase db;
    private String menustate[];
    private List<Amministratore> admins;

    public AdminController() {
        try {
            db = new ManageDatabase();
            admins = db.getAmministratori();
        } catch (Throwable ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        init();

    }

    @RequestMapping(value = "/adminprofile")
    public String adminprofile(ModelMap map) {
        map.put("titolo", "Admin - Profile");
        map.put("username", "Username");
        return "adminviews/profile";
    }

    @RequestMapping(value = "/admin")
    public String admin(ModelMap map, HttpServletRequest request) {// --- request menu
        if (authcheck(request)) {
            adminhome(map);
            return "/admin";
        }
        return "adminviews/login";
    }

   

    @RequestMapping(value = "/adminchecklogin", method = RequestMethod.POST)
    public String check(ModelMap map, @RequestParam(value = "username") String username, @RequestParam(value = "password") String password, HttpServletRequest request) {
        if (authcheck(request)) {
            adminhome(map);
            return "/admin";
        }
        if (username != null && password != null) {
            for (Amministratore admin : admins) {
                if (admin.getPw().equals(password) && admin.getEmail().equals(username)) {
                    request.getSession().setAttribute("usernameadmin", username);
                    request.getSession().setAttribute("adminame", admin.getNome());                    
                    request.getSession().setAttribute("useridadmin", admin.getId());
                    adminhome(map);
                    return "admin";

                }
            }
            return "redirect: /admin?error=true";
        } else {
            return "redirect: /admin";
        }
    }

    

    @RequestMapping(value = "/adminevents")
    public String events(ModelMap map, HttpServletRequest request) {// --- request menu 1
        if (!authcheck(request)) {
            return "redirect: /admin";
        }
        init();
        List<Visita> eventi = db.getEventi();
        menustate[1] = "active";
        map.put("menustate", menustate);
        map.put("eventi", eventi);
        map.put("titolo", "Admin - Events");
        map.put("username", "Username");
        return "adminviews/events";

    }

    @RequestMapping(value = "/adminvisits")
    public String visits(ModelMap map, HttpServletRequest request) {// --- request menu 2
        if (!authcheck(request)) {
            return "redirect: /admin";
        }
        init();
        List<Visita> visite = db.getVisite();
        menustate[2] = "active";
        map.put("menustate", menustate);
        map.put("titolo", "Admin - Visits");
        map.put("username", "Username");
        map.put("visite", visite);
        return "adminviews/visite";

    }

    @RequestMapping(value = "/adminservices")
    public String services(ModelMap map, HttpServletRequest request) {// --- request menu 3
        if (!authcheck(request)) {
            return "redirect: admin";
        }
        init();
        menustate[3] = "active";
        map.put("menustate", menustate);
        map.put("titolo", "Admin - Services");
        map.put("username", "Username");
        return "adminviews/services";

    }
    
     @RequestMapping(value = "/adminaddevent", method = RequestMethod.POST)
     
    public String addevent(ModelMap map,HttpServletRequest request,
            @RequestParam(value = "idevento") String idevento,
            @RequestParam(value = "title") String titolo,
            @RequestParam(value = "desc") String desc,
            @RequestParam(value = "tariffa") double tariffa,
            @RequestParam(value = "dataI") Date dataI,
            @RequestParam(value = "dataF") Date dataF,
            @RequestParam(value = "maxp") int maxp) {
        
            int i = (int) request.getSession().getAttribute("useridadmin");
            Amministratore admin =null;
            for(Amministratore a : admins){
                if(a.getId()==i) {
                   admin=a;
                   break;
                }
            }
            if(admin==null) return "redirect:/adminevents?inserito=fasle";
            Visita v = new Visita();
            
            v.setIdVisita(idevento);
            v.setTitolo(titolo);
            v.setDescrizione(desc);
            v.setTariffa(new BigDecimal(tariffa, MathContext.DECIMAL64));
            v.setDataI(dataI);
            v.setDataF(dataF);
            v.setIdA(admin);
            v.setMaxPartecipanti(maxp);
            db.inserisciEvento(v);
            return "redirect:/adminevents?inserito=true";
    }
    
    

    private void init() {
        menustate = new String[]{"", "", "", ""};
    }
    private boolean authcheck(HttpServletRequest request) {
        Integer uid = (Integer) request.getSession().getAttribute("useridadmin");
        if (uid == null) {
            return false;
        }
        for (Amministratore admin : admins) {
            if (admin.getId() == uid) {
                return true;
            }
        }
        return false;
    }
     private void adminhome(ModelMap map) {
        init();
        Calendar c =  Calendar.getInstance();
        Date startw,endw;
        startw =c.getTime();
        c.add(Calendar.DATE, 6);
        endw=c.getTime();
        List<Visita> pastevents = db.getEventiPassati(startw);
        Visita past= pastevents.get(0);
        System.out.println(past.getDescrizione());
        List<Visita> eventithisweek = db.query1(startw, endw);
        int tiklasteve =0;
        if(eventithisweek!=null) tiklasteve = db.query2(eventithisweek.get(0).getIdVisita());
        List<Visita> eventi = db.getEventi();
        List<Biglietto> biglietti = db.getBiglietti();
        menustate[0] = "active";
        int n =0;
        if(eventithisweek!=null) n = eventithisweek.size();
        int npastevents = 0;
        if(pastevents!=null) npastevents= db.query2(past.getIdVisita());
        map.put("eventithisweek",n);
        map.put("bigliettipassati",npastevents);
        map.put("tiklasteve",tiklasteve);
        map.put("biglietti", biglietti);
        map.put("eventi", eventi);
        map.put("menustate", menustate);
        map.put("titolo", "Admin");

    }
}
