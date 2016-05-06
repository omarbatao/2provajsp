/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dipremuseum.admincontroller;

import hibernate.ManageDatabase;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import models.Amministratore;
import models.Visita;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Omar
 */
@Controller
public class AdminEventsController {

    private ManageDatabase db;
    private String menustate[];
    private List<Amministratore> admins;

    public AdminEventsController() {

        try {
            db = new ManageDatabase();
            admins = db.getAmministratori();
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
        List<Visita> eventi = db.getEventi();
        menustate[1] = "active";
        map.put("menustate", menustate);
        map.put("eventi", eventi);
        map.put("titolo", "Admin - Events");
        map.put("username", "Username");
        return "adminviews/events";
    }

    @RequestMapping(value = "/adminaddevent", method = RequestMethod.POST)

    public String addevent(ModelMap map, HttpServletRequest request,
            @RequestParam(value = "idevento") String idevento,
            @RequestParam(value = "title") String titolo,
            @RequestParam(value = "desc") String desc,
            @RequestParam(value = "tariffa") double tariffa,
            @RequestParam(value = "dataI") Date dataI,
            @RequestParam(value = "dataF") Date dataF,
            @RequestParam(value = "maxp") int maxp) {

        int i = (int) request.getSession().getAttribute("useridadmin");
        Amministratore admin = null;
        for (Amministratore a : admins) {
            if (a.getId() == i) {
                admin = a;
                break;
            }
        }
        if (admin == null) {
            return "redirect:/adminevents?inserito=fasle";
        }
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
}
