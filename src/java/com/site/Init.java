/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.site;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 *
 * @author FSEVERI\ceretta2991
 */
public class Init implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext sc) throws ServletException {
        AnnotationConfigWebApplicationContext cx = new AnnotationConfigWebApplicationContext();
        cx.register(Config.class);
        cx.setServletContext(sc);
        Dynamic server = sc.addServlet("dispatcher", new DispatcherServlet(cx));
        server.addMapping("/");
        server.setLoadOnStartup(1);
    }
    
}
