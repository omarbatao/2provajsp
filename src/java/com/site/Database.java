/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.site;



import Models.*;
import databaseUtility.NewHibernateUtil;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import org.hibernate.HibernateException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import org.hibernate.*;

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
      
      public int verificaUtente(String username, String password) {
        Transaction tx = null;
        Session session = factory.openSession();
        try {
            tx = session.beginTransaction();
            Query q = session.createSQLQuery("SELECT pw FROM WA2P_UTENTI  WHERE nickname= ?" );
            q.setParameter(0, username);
            if (q.list().isEmpty()) {
                return 1;
            }
            if (q.list().size() > 0) {
                String passUser = (String) q.list().get(0);
                if (passUser.equals(password)) {
                    return 0;
                } else {
                    return -1;
                }
            }
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
            return 1;
        } finally {
            session.close();
        }
        return -2;
    }
      public String cifraPassword(String password) {
        String generatedPassword = null;
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(password.getBytes());
            //Get the hash's bytes 
            byte[] bytes = md.digest();
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        System.out.println(generatedPassword);
        return (generatedPassword);
    }
      
          public int utenteEsistente(String utente) {
        Transaction tx = null;
        Session session = factory.openSession();
        try {
            tx = session.beginTransaction();
             Query q = session.createSQLQuery("SELECT nickname FROM WA2P_UTENTI  WHERE nickname= ?" );
            q.setParameter(0, utente);
            if (q.list().isEmpty()) {
                return 0;
            }
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return 1;
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
}
