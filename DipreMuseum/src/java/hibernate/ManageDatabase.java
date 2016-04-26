package hibernate;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import hibernate.HibernateUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import models.Amministratore;
import models.Biglietto;
import models.Cartadicredito;
import models.Categoria;
import models.Servizio;
import models.Visita;
import models.Visitatore;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author FSEVERI\trovo2987
 */
public class ManageDatabase {

    private SessionFactory factory;

    public ManageDatabase() throws Throwable {
        factory = HibernateUtil.getSessionFactory();
    }

    public List<Visita> getVisite() {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        SQLQuery query = session.createSQLQuery("select * from Visite where DataI is null and DataF is null").addEntity(Visita.class);
        List<Visita> rows = query.list();
        
        session.getTransaction().commit();
        session.close();
        return rows;
    }
    
    public List<Visita> getEventi() {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        SQLQuery query = session.createSQLQuery("select * from Visite where DataI is not null and DataF is not null").addEntity(Visita.class);
        List<Visita> rows = query.list();
        
        session.getTransaction().commit();
        session.close();
        return rows;
    }
        
    public List<Categoria> getCategorie() {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        SQLQuery query = session.createSQLQuery("select * from Categorie ").addEntity(Categoria.class);
        List<Categoria> rows = query.list();
        
        session.getTransaction().commit();
        session.close();
        return rows;
    }
    public List<Visitatore> getVisitatori() {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        SQLQuery query = session.createSQLQuery("select * from Visitatori ").addEntity(Visitatore.class);
        List<Visitatore> rows = query.list();
        
        session.getTransaction().commit();
        session.close();
        return rows;
    }
    public List<Cartadicredito> getCartaDiCredito() {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        SQLQuery query = session.createSQLQuery("select * from Cartedicredito ").addEntity(Cartadicredito.class);
        List<Cartadicredito> rows = query.list();
        
        session.getTransaction().commit();
        session.close();
        return rows;
    }
    public List<Biglietto> getBiglietti() {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        SQLQuery query = session.createSQLQuery("select * from Biglietti ").addEntity(Biglietto.class);
        List<Biglietto> rows = query.list();
        
        session.getTransaction().commit();
        session.close();
        return rows;
    }
    public List<Amministratore> getAmministratori() {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        SQLQuery query = session.createSQLQuery("select * from Amministratori ").addEntity(Amministratore.class);
        List<Amministratore> rows = query.list();
        
        session.getTransaction().commit();
        session.close();
        return rows;
    }
    
    public List<Servizio> getServizi() {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        SQLQuery query = session.createSQLQuery("select * from Servizi ").addEntity(Servizio.class);
        List<Servizio> rows = query.list();
        
        session.getTransaction().commit();
        session.close();
        return rows;
    }


    //ricorda di fare il punto length
    /*public List<Biglietto> getBigliettiByEsposizione(String idVisita) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.getTransaction().commit();
        session.close();
        return rows;
    }*/

    //ricorda di fare il punto length
    public List<Visita> getEventiInCorso(Date dataI, Date dataF) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        SQLQuery query = session.createSQLQuery("select * from Visite where DataI='" + dataI + "'and DataF='" + dataF + "'").addEntity(Visita.class);
        List<Visita> rows = query.list();

        session.getTransaction().commit();
        session.close();
        return rows;
    }

    public List<Visita> query1(String idVisita) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        SQLQuery query = session.createSQLQuery("select * from Biglietti where idVisita='" + idVisita + "'").addEntity(Visita.class);
        List<Visita> rows = query.list();


        session.getTransaction().commit();
        session.close();
        return rows;
    }

    public Visita getEventoById(String id) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            SQLQuery query = session.createSQLQuery("select * from Visite where IdVisita =?").addEntity(Visita.class);
            query.setString(0, id);
            List cats = query.list();
            if (cats.size() > 0) {
                session.getTransaction().commit();
                session.close();
                return (Visita) cats.get(0);
            }
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return null;
    }

    public List<Visita> getEventiRecenti() {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        SQLQuery query = session.createSQLQuery("select * from Visite where  DataI is not null order by DataI desc").addEntity(Visita.class);
        List<Visita> rows = query.list();
        session.getTransaction().commit();
        session.close();
        return rows;
    }
    
    public void insertEvento(Visita evento){
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(evento);
        session.getTransaction().commit();
        session.close();
    }
    
}
    

