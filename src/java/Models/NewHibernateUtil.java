/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author FSEVERI\ceretta2991
 */
public class NewHibernateUtil {

    private static final SessionFactory sessionFactory;
    
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            sessionFactory = (SessionFactory) new AnnotationConfiguration()
                    .addAnnotatedClass(Artista.class)
                    .addAnnotatedClass(Categoria.class)
                    .addAnnotatedClass(Commento.class)
                    .addAnnotatedClass(Evento.class)
                    .addAnnotatedClass(Utente.class)
                    .addAnnotatedClass(Provincia.class)
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
    }
}
