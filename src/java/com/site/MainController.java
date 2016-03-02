/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.site;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author FSEVERI\ceretta2991
 */
@Controller
public class MainController {
    
    
    
    public MainController(){
        
    }
    
    
    @RequestMapping(value = "/", method = RequestMethod.GET)//defaulr get metod
    public String index(ModelMap map/*, @RequestParam(value = "id",required=false) String id*/){
        
        map.put("titolopagina","LFH - home");
        return "home";
    }
   
    
}
