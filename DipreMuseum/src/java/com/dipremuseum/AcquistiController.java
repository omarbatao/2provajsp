/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dipremuseum;

import hibernate.ManageDatabase;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Biglietto;
import models.Visitatore;
import org.springframework.stereotype.Controller;
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

    private List<Biglietto> biglietti;
    private ManageDatabase db;

    public AcquistiController() {
        try {
            db = new ManageDatabase();
        } catch (Throwable ex) {
            Logger.getLogger(AcquistiController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @RequestMapping(value = "/addbiglietto", method = RequestMethod.GET)
    @ResponseBody
    public String addBiglietto(
            @RequestParam(value = "idVisitatore", required = true) String idVisitatore,
            @RequestParam(value = "idVisita", required = true) String idVisita,
            @RequestParam(value = "tipo", required = true) int tipo,
            @RequestParam(value = "categoria", required = true) String categoria) {

        //Visitatore user = db.getVisitatore(idVisitatore);
        //Visita visita = db.getVisita(idVisita);
        //Categoria cat = db.getCategoria(categoria);
        Biglietto b = new Biglietto();
        b.setValidita(validita());
        b.setTipo(tipo);
        //b.setCategoria(cat);
        //b.setIdVisita(visita);
        //b.setIdVisitatore(user);
        //db.inserisciBiglietto(b);
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
