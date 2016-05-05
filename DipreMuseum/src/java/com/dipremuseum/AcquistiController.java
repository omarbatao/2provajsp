/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dipremuseum;

import hibernate.ManageDatabase;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import models.Biglietto;
import models.Categoria;
import models.Visita;
import models.Visitatore;
import org.springframework.stereotype.Controller;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author FSEVERI\ceretta2991
 */
@Controller
public class AcquistiController {

    
    private List<Biglietto> bigliettitmp;
    private ManageDatabase db;
    
    public AcquistiController() {
        try {
            db = new ManageDatabase();
            bigliettitmp = new ArrayList<Biglietto>();
        } catch (Throwable ex) {
            Logger.getLogger(AcquistiController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @RequestMapping(value = "/carrello")
    public String carrello(ModelMap map, HttpServletRequest request) {
        map.put("titolo", "Carrello");
        map.put("biglietti",request.getSession().getAttribute("biglietti"));
        return "carrello";
    }

    @RequestMapping(value = "/bigliettocompra", method = RequestMethod.POST)
    
    public String compraBiglietti(
            @RequestParam(value = "comprabiglietti", required = true) boolean compra,
            HttpServletRequest request
            ){
        if(!compra) return "redirect: /carrello?comprati=false";
        List<Biglietto> biglietti= (List<Biglietto>) request.getSession().getAttribute("biglietti");
        if(biglietti==null)return "redirect: /carrello?comprati=false";
        
        for(Biglietto b:biglietti){
            db.inserisciBiglietto(b);
        }
        request.getSession().setAttribute("biglietti",null);
        return "redirect: /carrello?comprati=true";
    }
    
    @RequestMapping(value = "/addgruppobigliettocategoria", method = RequestMethod.GET)
    @ResponseBody
    public String addGruppoBiglietti(
            @RequestParam(value = "idVisita", required = true) String idVisita,
            @RequestParam(value = "tipo", required = true) int tipo,
            @RequestParam(value = "categoria", required = true) String categoria,
            @RequestParam(value = "qty", required = true) int qty,
            HttpServletRequest request) {
        if(qty<0||qty>10) return "errore";
        if(qty==0) return "nessun";
        Integer idVisitatore =(Integer) request.getSession().getAttribute("userid");
        Visitatore user = db.getVisitatore(""+idVisitatore);
        Visita visita = db.getVisita(idVisita);
        Categoria cat = db.getCategoria(categoria);
         List<Biglietto> butente= (List<Biglietto>) request.getSession().getAttribute("biglietti");
        if(butente==null)butente= new ArrayList<Biglietto>();
        for(int i = 0; i<qty;i++){
            Biglietto b = new Biglietto();
            if(tipo==1) b.setValidita(visita.getDataF());
            else b.setValidita(validita());
            b.setTipo(tipo);
            b.setCategoria(cat);
            b.setIdVisita(visita);
            b.setIdVisitatore(user);
           System.out.println("for: "+b.toString());

            butente.add(b);
            
        }
        /*for(Biglietto b:butente){
            System.out.println("Biglietto: "+b.toString());
        }*/
        Collections.sort(butente, new Comparator<Biglietto>() {
            @Override
            public int compare(Biglietto t, Biglietto t1) {
                return t.getCategoria().getCodC().compareTo(t1.getCategoria().getCodC());
            }
        
       } );
        request.getSession().setAttribute("biglietti", butente);
        return "inserito";
    }
    
   
    
    
    

    private Date validita() {
        Date today = Calendar.getInstance().getTime();
        Calendar c = Calendar.getInstance();
        c.setTime(today);
        c.add(Calendar.YEAR, 1);
        return c.getTime();
    }

}
