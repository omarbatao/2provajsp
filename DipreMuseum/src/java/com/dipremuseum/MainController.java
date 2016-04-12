/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dipremuseum;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author FSEVERI\loreggian3064
 */
@Controller
public class MainController {
    
    
    
    public MainController(){
    }
    
    @RequestMapping(value="/")
    public String index(ModelMap map){
        map.put("titolo", "Dipr&egrave Museum");
        return "index";
    }
    
    @RequestMapping(value="/admin")
    public String admin(ModelMap map){
        map.put("titolo", "Admin");
        return "admin";
    }
    
}
