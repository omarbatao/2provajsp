/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseUtility;
import Models.*;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author FSEVERI\benetti3004
 */
public class NewHibernateUtil {
private static SessionFactory sessionFactory;


public static SessionFactory getSessionFactory() {
            if(sessionFactory==null){
        Configuration configuration = new Configuration();         
        configuration.addAnnotatedClass(Categoria.class)
                .addAnnotatedClass(Artista.class)
                .addAnnotatedClass(Commento.class)
                .addAnnotatedClass(Utente.class)
                .addAnnotatedClass(Provincia.class);
            configuration.configure();
            ServiceRegistry serviceRegistry
                = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

            // builds a session factory from the service registry
            sessionFactory = configuration.buildSessionFactory(serviceRegistry); 
        }
      return sessionFactory;
}
}
