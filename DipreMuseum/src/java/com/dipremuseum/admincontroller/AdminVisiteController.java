/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dipremuseum.admincontroller;

import hibernate.ManageDatabase;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
public class AdminVisiteController {

    private ManageDatabase db;
    private String menustate[];
    private List<Amministratore> admins;
    private List<Visita> visite;
    private boolean cerca; 

    public AdminVisiteController() {

        try {
            db = new ManageDatabase();
            admins = db.getAmministratori();
            visite=db.getVisite();
            cerca=false;
        } catch (Throwable ex) {
            Logger.getLogger(AdminEventsController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    @RequestMapping(value = "/adminvisits")
    public String visits(ModelMap map, HttpServletRequest request) {// --- request menu 2
        if (!UtilityAdmin.authcheck(admins,request)) {
            return "redirect: /admin";
        }
        init();
        menustate[2] = "active";
        map.put("menustate", menustate);
        map.put("titolo", "Admin - Visits");
        map.put("username", "Username");
        if(!cerca) {
            visite=db.getVisite(); 
            cerca=false;
        }
        map.put("visite", visite);
        return "adminviews/visite";

    }
    
     @RequestMapping(value="/addvisit",method = RequestMethod.POST)
    public String addvisits(HttpServletRequest request,
           @RequestParam(value = "idvisita") String idvisita,
           @RequestParam(value = "titolo") String titolo,
           @RequestParam(value = "desc") String desc,
           @RequestParam(value = "price") double price){
        if (!UtilityAdmin.authcheck(admins, request)) {
            return "redirect: admin";
        }
        int idA = (int) request.getSession().getAttribute("useridadmin");
        Visita v = new Visita();
        v.setIdVisita(idvisita);
        v.setTitolo(titolo);
        v.setDescrizione(desc);
        v.setTariffa(new BigDecimal(price, MathContext.DECIMAL64));
        v.setIdA(db.getAmministratore(idA));
        db.inserisciVisita(v);
        return "redirect: /adminvisits?inseriti=true";
    }
    
    @RequestMapping(value="/modificavisit",method = RequestMethod.POST)
    public String modificavisits(HttpServletRequest request,
           @RequestParam(value = "oldidvisita") String ololdidvisita, 
           @RequestParam(value = "newidvisita") String newidvisita,
           @RequestParam(value = "titolo") String titolo,
           @RequestParam(value = "desc") String desc,
           @RequestParam(value = "price") double price){
        if (!UtilityAdmin.authcheck(admins, request)) {
            return "redirect: admin";
        }
        
        Visita vo= db.getVisita(ololdidvisita);
        int idA = (int) request.getSession().getAttribute("useridadmin");
        Visita v = new Visita();
        v.setIdVisita(newidvisita);
        v.setTitolo(titolo);
        v.setDescrizione(desc);
        v.setTariffa(new BigDecimal(price, MathContext.DECIMAL64));
        v.setIdA(db.getAmministratore(idA));
        db.updateVisita(vo,v);
        return "redirect: /adminvisits?aggiornato=true";
    }
    
    
    @RequestMapping(value="/cercavisit",method = RequestMethod.POST)
    public String cercaservice(ModelMap map,HttpServletRequest request,
           @RequestParam(value = "idvisita") String idvisita){
        Visita v = db.getVisita(idvisita);
        if(v==null)return "redirect: /adminvisits?cerca=fasle";
        visite = new ArrayList<>();
        visite.add(v);
        cerca=true;
        return "redirect: /adminvisits?cerca=true";
    }
    
    
            
    @RequestMapping(value="/eliminavisita",method = RequestMethod.POST)
    @ResponseBody
    public String eliminavisita(HttpServletRequest request,
           @RequestParam(value = "idvisita") String idvisita
           ){
        if (!UtilityAdmin.authcheck(admins, request)) {
            return "error";
        }
        
        Visita v = db.getVisita(idvisita);
        db.deleteVisita(v);
        return "success";
    }

    private void init() {
        menustate = new String[]{"", "", "", ""};
    }
}
