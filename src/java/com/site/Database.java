/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.site;


import Models.NewHibernateUtil;
import Models.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
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
   
    
    
    public  ArrayList<WA2P_Evento> getEventi(){
        Transaction tx = null;
        ArrayList<WA2P_Evento> eve= new ArrayList<>(); ;
        Session session = factory.openSession();
         try{
              tx = session.beginTransaction();
             
             List eventi = session.createCriteria(WA2P_Evento.class).list();
             for (Iterator iterator =
                 eventi.iterator(); iterator.hasNext();){
                 WA2P_Evento evento = (WA2P_Evento) iterator.next();
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
    
      public  ArrayList<WA2P_Categoria> getCategorie(){
        Transaction tx = null;
        Session session = factory.openSession();
         try{
              tx = session.beginTransaction();
             
             List categorie = session.createCriteria(WA2P_Categoria.class).list();
             /*for (Iterator iterator =
                 eventi.iterator(); iterator.hasNext();){
                 WA2P_Evento persona = (WA2P_Evento) iterator.next();
                 
             }*/
             
             tx.commit();
             return (ArrayList<WA2P_Categoria>) categorie;
         }catch (HibernateException e) {
             if (tx!=null) tx.rollback();
         }
         session.close();
         return null;
    }  
 
      public  ArrayList<WA2P_Artista> getArtisti(){
        Transaction tx = null;
        Session session = factory.openSession();
         try{
              tx = session.beginTransaction();
             
             List artisti = session.createCriteria(WA2P_Artista.class).list();
             /*for (Iterator iterator =
                 eventi.iterator(); iterator.hasNext();){
                 WA2P_Evento persona = (WA2P_Evento) iterator.next();
                 
             }*/
             
             tx.commit();
             return (ArrayList<WA2P_Artista>) artisti;
         }catch (HibernateException e) {
             if (tx!=null) tx.rollback();
         }
         session.close();
         return null;
    }      

      public  ArrayList<WA2P_Commento> getCommenti(){
        Transaction tx = null;
        Session session = factory.openSession();
         try{
              tx = session.beginTransaction();
             
             List artisti = session.createCriteria(WA2P_Commento.class).list();
             /*for (Iterator iterator =
                 eventi.iterator(); iterator.hasNext();){
                 WA2P_Evento persona = (WA2P_Evento) iterator.next();
                 
             }*/
             
             tx.commit();
             return (ArrayList<WA2P_Commento>) artisti;
         }catch (HibernateException e) {
             if (tx!=null) tx.rollback();
         }
         session.close();
         return null;
    }       
      

      public  ArrayList<WA2P_Provincia> getProvince(){
        Transaction tx = null;
        Session session = factory.openSession();
         try{
              tx = session.beginTransaction();
             
             List province = session.createCriteria(WA2P_Provincia.class).list();
             /*for (Iterator iterator =
                 eventi.iterator(); iterator.hasNext();){
                 WA2P_Evento persona = (WA2P_Evento) iterator.next();
                 
             }*/
             
             tx.commit();
             return (ArrayList<WA2P_Provincia>) province;
         }catch (HibernateException e) {
             if (tx!=null) tx.rollback();
         }
         session.close();
         return null;
    }          
      
      
      public  ArrayList<WA2P_Utente> getUtenti(){
        Transaction tx = null;
        Session session = factory.openSession();
         try{
              tx = session.beginTransaction();
             
             List utenti = session.createCriteria(WA2P_Utente.class).list();
             /*for (Iterator iterator =
                 eventi.iterator(); iterator.hasNext();){
                 WA2P_Evento persona = (WA2P_Evento) iterator.next();
                 
             }*/
             
             tx.commit();
             return (ArrayList<WA2P_Utente>) utenti;
         }catch (HibernateException e) {
             if (tx!=null) tx.rollback();
         }
         session.close();
         return null;
    }            
    
}
