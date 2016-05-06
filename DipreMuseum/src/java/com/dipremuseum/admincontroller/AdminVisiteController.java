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
        }
        map.put("visite", visite);
        return "adminviews/visite";

    }
    
     @RequestMapping(value="/addvisita",method = RequestMethod.POST)
    public String addvisits(HttpServletRequest request,
           @RequestParam(value = "code") String code,
           @RequestParam(value = "desc") String desc,
           @RequestParam(value = "price") double price){
        if (!UtilityAdmin.authcheck(admins, request)) {
            return "redirect: admin";
        }
        /*Servizio s = new Servizio();
        s.setCodS(code);
        s.setDescrizione(desc);
        s.setPrezzo(new BigDecimal(price, MathContext.DECIMAL64));
        db.inserisciServizio(s);*/
        return "redirect: /adminvisits?inseriti=true";
    }
    
    @RequestMapping(value="/modificavisit",method = RequestMethod.POST)
    public String modificavisits(HttpServletRequest request,
           @RequestParam(value = "oldcode") String oldcode, 
           @RequestParam(value = "newcode") String newcode,
           @RequestParam(value = "desc") String desc,
           @RequestParam(value = "price") double price){
        if (!UtilityAdmin.authcheck(admins, request)) {
            return "redirect: admin";
        }
        
        /*Servizio so = db.getServizio(oldcode);
        Servizio s = new Servizio();
        s.setCodS(newcode);
        s.setDescrizione(desc);
        s.setPrezzo(new BigDecimal(price, MathContext.DECIMAL64));
        db.updateServizio(so,s);*/
        return "redirect: /adminvisits?aggiornato=true";
    }
    
    
    @RequestMapping(value="/cercavisit",method = RequestMethod.POST)
    public String cercaservice(ModelMap map,HttpServletRequest request,
           @RequestParam(value = "code") String code){
        //Servizio so = db.getServizio(code);
        //if(so==null)return "redirect: /adminvisits?cerca=fasle";
        visite = new ArrayList<>();
        //visite.add(so);
        cerca=true;
        return "redirect: /adminvisits?cerca=true";
    }
    
    
            
    @RequestMapping(value="/eliminavisita",method = RequestMethod.POST)
    @ResponseBody
    public String eliminavisita(HttpServletRequest request,
           @RequestParam(value = "cods") String cods
           ){
        if (!UtilityAdmin.authcheck(admins, request)) {
            return "error";
        }
        //Servizio s = db.getServizio(cods);
        //db.deleteServizio(s);
        return "success";
    }

    private void init() {
        menustate = new String[]{"", "", "", ""};
    }
}
