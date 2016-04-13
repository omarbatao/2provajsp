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
import models.Visitatore;
import models.Visita;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author FSEVERI\depaula2995
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            sessionFactory = new AnnotationConfiguration().configure().addAnnotatedClass(Amministratore.class)
                    .addAnnotatedClass(Biglietto.class)
                    .addAnnotatedClass(Cartadicredito.class)
                    .addAnnotatedClass(Categoria.class)
                    .addAnnotatedClass(Servizio.class)
                    .addAnnotatedClass(Visitatore.class)
                    .addAnnotatedClass(Visita.class)
                    .buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
