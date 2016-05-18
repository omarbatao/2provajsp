package com.dipremuseum;

import hibernate.ManageDatabase;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Categoria;
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
 * @author FSEVERI\loreggian3064
 */
@Controller
public class EventiController {

    private ManageDatabase db;
    private List<Visita> eventi;

    public EventiController() {
        try {
            db = new ManageDatabase();
            eventi = db.getEventi();
        } catch (Throwable ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @RequestMapping(value = "/eventi", method = RequestMethod.GET)
    public String infoevento(ModelMap map) {
        try {
            if (eventi != null) {
                map.put("eventi", eventi);
            }
        } catch (Throwable ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "eventi";
    }

    @RequestMapping(value = "/evento", method = RequestMethod.GET)
    public String infoevento(ModelMap map, @RequestParam(value = "id", required = true) String id) {
        if (id != null && !id.isEmpty()) {
            try {
                List<Categoria> categorie = db.getCategorie();
                List<Servizio> servizi = db.getServizi();

                for (Categoria c : categorie) {
                    System.out.println("categoria:  ->" + c.getDescrizione());
                }
                Visita evento = db.getEventoById(id);

                if (evento != null) {
                    map.put("evento", evento);
                    map.put("titolo", evento.getTitolo());
                    map.put("categorie", categorie);
                    map.put("servizi", servizi);
                    return "dettaglievento";
                } else {
                    return "redirect:/";
                }

            } catch (Throwable ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                return "redirect:/";
            }
        } else {
            return "redirect:/";
        }
    }

    @RequestMapping(value = "/cercaevento", method = RequestMethod.GET)
    public @ResponseBody
    String cercaeventi(ModelMap map,
            @RequestParam(value = "titoloevento") String titoloevento) {
        
        boolean x = false;
        StringBuffer sb = new StringBuffer();
        String arr[] = titoloevento.split(" ", 2);
        titoloevento = arr[0];   
        
        for(Visita evento: eventi){
            if(evento.getTitolo().toLowerCase().contains(titoloevento.toLowerCase())){
                sb.append("<evento>");
                sb.append("<id>"+evento.getIdVisita()+"</id>");
                sb.append("<titolo>"+evento.getTitolo()+"</titolo>");
                sb.append("</evento>");
                x=true;
            }
        }
        
        if(x){
            return "<eventi>"+sb.toString()+"</eventi>";
        }
        
        return "errore";
    }

}
