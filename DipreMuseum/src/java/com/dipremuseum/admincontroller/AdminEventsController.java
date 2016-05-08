/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dipremuseum.admincontroller;

import hibernate.ManageDatabase;
import java.math.BigDecimal;
import java.math.MathContext;
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
import models.Servizio;
import models.Visita;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Omar
 */
@Controller
public class AdminEventsController {

    private ManageDatabase db;
    private String menustate[];
    private List<Amministratore> admins;
    private boolean cerca;
    private List<Visita> eventi;

    public AdminEventsController() {

        try {
            db = new ManageDatabase();
            admins = db.getAmministratori();
            cerca=false;
            eventi = db.getEventi();
        } catch (Throwable ex) {
            Logger.getLogger(AdminEventsController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @RequestMapping(value = "/adminevents")
    public String events(ModelMap map, HttpServletRequest request) {// --- request menu 1
        if (!UtilityAdmin.authcheck(admins, request)) {
            return "redirect: /admin";
        }
        init();
        
        menustate[1] = "active";
        map.put("menustate", menustate);
        if(cerca) {
            map.put("eventi", eventi);
            cerca=false;
        }else{
            eventi=db.getEventi();
            map.put("eventi", eventi);
            cerca=false;
        }
        
        map.put("titolo", "Admin - Events");
        map.put("username", "Username");
        return "adminviews/events";
    }

    @RequestMapping(value = "/adminaddevent", method = RequestMethod.POST)
    public String addevent(ModelMap map, HttpServletRequest request,
            @RequestParam(value = "idvisita") String idevento,
            @RequestParam(value = "titolo") String titolo,
            @RequestParam(value = "desc") String desc,
            @RequestParam(value = "price") double tariffa,
            @RequestParam(value = "dataI") Date dataI,
            @RequestParam(value = "dataF") Date dataF,
            @RequestParam(value = "maxp") int maxp) {

        if (!UtilityAdmin.authcheck(admins, request)) {
            return "redirect: admin";
        }
        Amministratore admin = db.getAmministratore((int) request.getSession().getAttribute("useridadmin"));
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
    
  @RequestMapping(value="/modificaevent", method=RequestMethod.POST)
    public String modificaevent(HttpServletRequest request,
            @RequestParam(value = "oldidevento") String oldidevento,
            @RequestParam(value = "newidevento") String idevento,
            @RequestParam(value = "titolo") String titolo,
            @RequestParam(value = "desc") String desc,
            @RequestParam(value = "price") double tariffa,
            @RequestParam(value = "dataI") String dataI,
            @RequestParam(value = "dataF") String dataF,
            @RequestParam(value = "maxp") int maxp) {

        if (!UtilityAdmin.authcheck(admins, request)) {
            return "redirect: admin";
        }
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Amministratore admin = db.getAmministratore((int) request.getSession().getAttribute("useridadmin"));
        Visita o = db.getVisita(oldidevento);
        Visita v = new Visita();
        v.setIdVisita(idevento);
        v.setTitolo(titolo);
        v.setDescrizione(desc);
        v.setTariffa(new BigDecimal(tariffa, MathContext.DECIMAL64));
        try {
            v.setDataI(df.parse(dataI));
            v.setDataF(df.parse(dataF));
        } catch (ParseException ex) {
            Logger.getLogger(AdminEventsController.class.getName()).log(Level.SEVERE, null, ex);
             return "redirect: /adminevents?aggiornato=false";
        }
        
        v.setIdA(admin);
        v.setMaxPartecipanti(maxp);
        db.updateEvento(o,v);
        return "redirect: /adminevents?aggiornato=true";
    }
    
    @RequestMapping(value="/cercaevent",method = RequestMethod.POST)
    public String cercaservice(ModelMap map,HttpServletRequest request,
           @RequestParam(value = "idevento") String idevento){
        Visita so = db.getVisita(idevento);
        if(so==null){
            cerca=false;
            return "redirect: /adminevents?cerca=fasle";
        }
        eventi = new ArrayList<>();
        eventi.add(so);
        cerca=true;
        return "redirect: /adminevents?cerca=true";
    }
    
    
            
    @RequestMapping(value="/eliminaevent",method = RequestMethod.POST)
    @ResponseBody
    public String eliminaservizio(HttpServletRequest request,
           @RequestParam(value = "idevento") String idevento
           ){
        if (!UtilityAdmin.authcheck(admins, request)) {
            return "error";
        }
        Visita e = db.getVisita(idevento);
        db.deleteEvento(e);
        return "success";
    }

    private void init() {
        menustate = new String[]{"", "", "", ""};
    }
}
