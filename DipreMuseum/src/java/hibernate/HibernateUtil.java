/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate;

import models.Amministratori;
import models.Biglietti;
import models.Cartedicredito;
import models.Categorie;
import models.Servizi;
import models.Visitatori;
import models.Visite;
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
            sessionFactory = new AnnotationConfiguration().configure().addAnnotatedClass(Amministratori.class)
                    .addAnnotatedClass(Biglietti.class)
                    .addAnnotatedClass(Cartedicredito.class)
                    .addAnnotatedClass(Categorie.class)
                    .addAnnotatedClass(Servizi.class)
                    .addAnnotatedClass(Visitatori.class)
                    .addAnnotatedClass(Visite.class)
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
