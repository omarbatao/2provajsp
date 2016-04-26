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

    public List<Amministratore> getAmministratoreByEmail(String email,String pw) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        SQLQuery query = session.createSQLQuery("select * from Amministratori where email='"+email+"' and pw='"+pw+"'").addEntity(Amministratore.class);
        List<Amministratore> rows = query.list();
        
        session.getTransaction().commit();
        session.close();
        return rows;
    }
    //ricorda di fare il punto length
    public List<Biglietto> getBigliettiByEsposizione(String idVisita) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        SQLQuery query = session.createSQLQuery("select * from Biglietti where idVisita='"+idVisita+"'").addEntity(Biglietto.class);
        List<Biglietto> rows = query.list();
        
        session.getTransaction().commit();
        session.close();
        return rows;
    }
    //ricorda di fare il punto length
    public List<Visita> getEventiInCorso(Date dataI,Date dataF) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        SQLQuery query = session.createSQLQuery("select * from Visite where DataI='"+dataI+"'and DataF='"+dataF+"'").addEntity(Visita.class);
        List<Visita> rows = query.list();
        
        session.getTransaction().commit();
        session.close();
        return rows;
    }
    public List<Visita> query1(String idVisita) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        SQLQuery query = session.createSQLQuery("select SUM(Tariffa) from Biglietti B inner join Visite V on B.IdVisita= V.IdVisita where IdVisita='"+idVisita+"'").addEntity(Object[].class);
        query.addJoin("V","B.idVisita");
        List<Visita> rows = query.list();
        
        session.getTransaction().commit();
        session.close();
        return rows;
    }
    
    public List<Object[]> query2(String idVisita) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        SQLQuery query = session.createSQLQuery("select count(*) from Biglietti IdVisita where IdVisita='"+idVisita+"'").addEntity(Object[].class);
        List<Object[]> rows = query.list();
        
        session.getTransaction().commit();
        session.close();
        return rows;
    }
    
    public void vista1(String idVisita) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        int query = session.createSQLQuery("CREATE VIEW Vista1 AS SELECT IdVisita,Categoria,COUNT(*) as Conta, Sconto FROM Biglietti INNER JOIN Visitatori ON IdVisitaore=Id WHERE IdVisita='"+idVisita+"' GROUP BY IdVisita,Categoria,Conta,Sconto").executeUpdate();
        if(query == 1)
        session.getTransaction().commit();
        session.close();
       
    }
    
}
