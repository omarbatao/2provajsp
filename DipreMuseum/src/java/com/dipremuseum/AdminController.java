/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dipremuseum;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author FSEVERI\ceretta2991
 */
@Controller
public class AdminController {
    
    public AdminController(){
    }
    
    @RequestMapping(value="/admin")
    public String admin(ModelMap map){
        map.put("titolo", "Admin");
        return "admin";
    }
}
