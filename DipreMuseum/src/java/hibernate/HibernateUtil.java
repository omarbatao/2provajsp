/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate;

import models.Amministratore;
import models.Biglietto;
import models.Cartadicredito;
import models.Categoria;
import models.Servizio;
import models.Visita;
import models.Visitatore;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author FSEVERI\depaula2995
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory;
   /* 
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            sessionFactory = new AnnotationConfiguration()
                    .addAnnotatedClass(Amministratore.class)
                    .addAnnotatedClass(Biglietto.class)
                    .addAnnotatedClass(Cartadicredito.class)
                    .addAnnotatedClass(Categoria.class)
                    .addAnnotatedClass(Servizio.class)
                    .addAnnotatedClass(Visitatore.class)
                    .addAnnotatedClass(Visita.class)
                    .addAnnotatedClass(MainController.class)
                    .configure()
                    .buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }*/
    
     public static SessionFactory getSessionFactory() {
      if (sessionFactory == null) {
            // loads configuration and mappings
            Configuration configuration = new Configuration()
                    .addAnnotatedClass(Amministratore.class)
                    .addAnnotatedClass(Biglietto.class)
                    .addAnnotatedClass(Cartadicredito.class)
                    .addAnnotatedClass(Categoria.class)
                    .addAnnotatedClass(Servizio.class)
                    .addAnnotatedClass(Visitatore.class)
                    .addAnnotatedClass(Visita.class)
                    .configure();
            ServiceRegistry serviceRegistry
                = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
             
            // builds a session factory from the service registry
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);           
        }
         
        return sessionFactory; 
    }
}
