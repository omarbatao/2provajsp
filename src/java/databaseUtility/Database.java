/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseUtility;



import Models.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author FSEVERI\ceretta2991
 */
public class Database {
    private  SessionFactory factory;

    public Database() throws Throwable  {
       
        factory = NewHibernateUtil.getSessionFactory();
      
    }
   
    
    
    public  ArrayList<Evento> getEventi(){
        Transaction tx = null;
        ArrayList<Evento> eve= new ArrayList<>(); 
        Session session = factory.openSession();
         try{
              tx = session.beginTransaction();
             
             List eventi = session.createCriteria(Evento.class).list();
             for (Iterator iterator = eventi.iterator(); iterator.hasNext();){
                 Evento evento = (Evento) iterator.next();
                 System.out.println("Evento: "+evento.toString());
                 eve.add(evento);
             }
             
             tx.commit();
             return  eve;
         }catch (HibernateException e) {
             if (tx!=null) tx.rollback();
         }
         session.close();
         return null;
    }
    
      public  ArrayList<Categoria> getCategorie(){
        Transaction tx = null;
        Session session = factory.openSession();
         try{
              tx = session.beginTransaction();
             
             List categorie = session.createCriteria(Categoria.class).list();
             /*for (Iterator iterator =
                 eventi.iterator(); iterator.hasNext();){
                 Evento persona = (Evento) iterator.next();
                 
             }*/
             
             tx.commit();
             return (ArrayList<Categoria>) categorie;
         }catch (HibernateException e) {
             if (tx!=null) tx.rollback();
         }
         session.close();
         return null;
    }  
 
      public  ArrayList<Artista> getArtisti(){
        Transaction tx = null;
        Session session = factory.openSession();
         try{
              tx = session.beginTransaction();
             
             List artisti = session.createCriteria(Artista.class).list();
             /*for (Iterator iterator =
                 eventi.iterator(); iterator.hasNext();){
                 Evento persona = (Evento) iterator.next();
                 
             }*/
             
             tx.commit();
             return (ArrayList<Artista>) artisti;
         }catch (HibernateException e) {
             if (tx!=null) tx.rollback();
         }
         session.close();
         return null;
    }      

      public  ArrayList<Commento> getCommenti(){
        Transaction tx = null;
        Session session = factory.openSession();
         try{
              tx = session.beginTransaction();
             
             List artisti = session.createCriteria(Commento.class).list();
             /*for (Iterator iterator =
                 eventi.iterator(); iterator.hasNext();){
                 Evento persona = (Evento) iterator.next();
                 
             }*/
             
             tx.commit();
             return (ArrayList<Commento>) artisti;
         }catch (HibernateException e) {
             if (tx!=null) tx.rollback();
         }
         session.close();
         return null;
    }       
      

      public  ArrayList<Provincia> getProvince(){
        Transaction tx = null;
        Session session = factory.openSession();
         try{
              tx = session.beginTransaction();
             
             List province = session.createCriteria(Provincia.class).list();
             /*for (Iterator iterator =
                 eventi.iterator(); iterator.hasNext();){
                 Evento persona = (Evento) iterator.next();
                 
             }*/
             
             tx.commit();
             return (ArrayList<Provincia>) province;
         }catch (HibernateException e) {
             if (tx!=null) tx.rollback();
         }
         session.close();
         return null;
    }          
      
      
      public  ArrayList<Utente> getUtenti(){
        Transaction tx = null;
        Session session = factory.openSession();
         try{
              tx = session.beginTransaction();
             
             List utenti = session.createCriteria(Utente.class).list();
             /*for (Iterator iterator =
                 eventi.iterator(); iterator.hasNext();){
                 Evento persona = (Evento) iterator.next();
                 
             }*/
             
             tx.commit();
             return (ArrayList<Utente>) utenti;
         }catch (HibernateException e) {
             if (tx!=null) tx.rollback();
         }
         session.close();
         return null;
    }            

    public Evento getEvento(String id) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        SQLQuery query = session.createSQLQuery("SELECT * FROM WA2P_EVENTI WHERE Id= :id").addEntity(Evento.class);
        query.setString("id", id);
        Evento v = (Evento) query.uniqueResult();
        tx.commit();
        session.close();
        return v;
    }
    
    public List<Commento> getCommentiPerEvento(String idevento){
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        SQLQuery query = session.createSQLQuery("SELECT * FROM WA2P_COMMENTI WHERE evento= :id ORDER BY dataC DESC").addEntity(Commento.class);
        query.setString("id", idevento);
        List<Commento> v = (List<Commento>) query.list();
        tx.commit();
        session.close();
        return v;
        
    }

    public Utente getUtente(String utente) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        SQLQuery query = session.createSQLQuery("SELECT * FROM WA2P_UTENTI WHERE nickname= :username").addEntity(Utente.class);
        query.setString("username", utente);
        Utente u = (Utente) query.uniqueResult();
        tx.commit();
        session.close();
        return u;
    }
    

          
    public void salvaUtente(Utente u) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(u);
            session.getTransaction().commit();
        } catch (HibernateException ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    public void insertCommento(Commento c) {
        System.out.println("inserisci "+c.getCommento());
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(c);
            session.getTransaction().commit();
        } catch (HibernateException ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
        }
    }
    
         public void inviaEmail (Email e) {
        System.out.println("invia "+e.getEmail());
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(e);
            session.getTransaction().commit();
        } catch (HibernateException ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
        }
    }
}
