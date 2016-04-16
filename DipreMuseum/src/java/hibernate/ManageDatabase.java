package hibernate;
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
        SQLQuery query = session.createSQLQuery("select * from Visite").addEntity(Visita.class);
        List<Visita> rows = query.list();
        
        System.out.println("getVisite:"+rows.get(0).getTitolo());
        session.getTransaction().commit();
        session.close();
        return rows;
    }

}
