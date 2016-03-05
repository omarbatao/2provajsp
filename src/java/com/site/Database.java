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
        Session session = factory.openSession();
         try{
              tx = session.beginTransaction();
             
             List eventi = session.createCriteria(WA2P_Evento.class).list();
             /*for (Iterator iterator =
                 eventi.iterator(); iterator.hasNext();){
                 WA2P_Evento persona = (WA2P_Evento) iterator.next();
                 
             }*/
             
             tx.commit();
             return (ArrayList<WA2P_Evento>) eventi;
         }catch (HibernateException e) {
             if (tx!=null) tx.rollback();
             e.printStackTrace();
         }
         session.close();
         return null;
    }
    
}
