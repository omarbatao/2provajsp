package po;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import hibernate.HibernateUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import models.Visita;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author FSEVERI\trovo2987
 */
public class ManageDatabase {
     private SessionFactory factory;
    
    public ManageDatabase() throws Throwable{
        factory=  HibernateUtil.getSessionFactory();
    }

  
    public List<Visita> getVisite() {
       Transaction tx = null;
        ArrayList<Visita> eve= new ArrayList<>(); ;
        Session session = factory.openSession();
         try{
              tx = session.beginTransaction();
             
             List eventi = session.createCriteria(Visita.class).list();
             for (Iterator iterator =
                 eventi.iterator(); iterator.hasNext();){
                 Visita visita = (Visita) iterator.next();
                 System.out.println("Evento: "+visita.toString());
                 eve.add(visita);
             }
             
             tx.commit();
             return  eve;
         }catch (HibernateException e) {
             if (tx!=null) tx.rollback();
         }
         session.close();
         return null;
    }

    public Visita getVisitaById(int id) {
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Query q = session.createSQLQuery("SELECT * FROM Visite where id= ? ");
            q.setInteger(0, id);
            if (q.list().size() > 0) {
                return (Visita) q.list().get(0);
            }
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

}
