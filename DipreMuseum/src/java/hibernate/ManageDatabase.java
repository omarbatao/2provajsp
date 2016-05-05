package hibernate;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import hibernate.HibernateUtil;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import models.Amministratore;
import models.Biglietto;
import models.CartaDiCredito;
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
import org.hibernate.criterion.Projections;

/**
 *
 * @author FSEVERI\trovo2987
 */
public class ManageDatabase {

    private SessionFactory factory;

    public ManageDatabase() throws Throwable {
        factory = HibernateUtil.getSessionFactory();
    }

    public void inserisciEvento(Visita evento) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(evento);
        session.getTransaction().commit();
        session.close();
    }

    public void inserisciVisita(Visita visita) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(visita);
        session.getTransaction().commit();
        session.close();
    }

    public void inserisciBiglietto(Biglietto biglietto) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(biglietto);
        session.getTransaction().commit();
        session.close();
    }

    public void inserisciAmministratore(Amministratore amministratore) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(amministratore);
        session.getTransaction().commit();
        session.close();
    }

    public void inserisciCartaDiCredito(CartaDiCredito carta) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(carta);
        session.getTransaction().commit();
        session.close();
    }

    public void inserisciCategorie(Categoria categoria) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(categoria);
        session.getTransaction().commit();
        session.close();
    }

    public void inserisciVisitatori(Visitatore visitatore) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(visitatore);
        session.getTransaction().commit();
        session.close();
    }

    public void inserisciServizi(Servizio servizio) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(servizio);
        session.getTransaction().commit();
        session.close();
    }

    public int inserisciVisitatore(Visitatore visitatore) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        int id=  (Integer)session.save(visitatore);
        session.getTransaction().commit();
        session.close();
        return id;
    }

    /*
    public void inserisciBiglietto(int codB,Date validita,int tipo,int idVisitatore,String idVisita,String categoria){
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        SQLQuery query = session.createSQLQuery("INSERT INTO Biglietti(CodB,Validita,Tipo,IdVisitatore,IdVisita,Categoria) VALUES("+idVisita+","+titolo+","+tariffa+","+idA+","+descrizione+")");
        int result=query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }
    
    public void inserisciVisita(String idVisita,String titolo,Double tariffa,int idA,String descrizione){
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        SQLQuery query = session.createSQLQuery("INSERT INTO Viste(IdVisita,Titolo,Tariffa,IdA,Descrizione) VALUES("+idVisita+","+titolo+","+tariffa+","+idA+","+descrizione+")");
        int result=query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }
     */
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

    public List<CartaDiCredito> getCartaDiCredito() {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        SQLQuery query = session.createSQLQuery("select * from Cartedicredito ").addEntity(CartaDiCredito.class);
        List<CartaDiCredito> rows = query.list();

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
    public List<Biglietto> getBigliettiByEsposizione(String idVisita) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        SQLQuery query = session.createSQLQuery("SELECT * FROM BIGLIETTI WHERE IdVisita = '" + idVisita + "'").addEntity(Biglietto.class);
        List<Biglietto> rows = query.list();
        session.getTransaction().commit();
        session.close();
        return rows;
    }

    //ricorda di fare il punto length
    public Visitatore getVisitatoreById(Integer idVisitatore) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        SQLQuery query = session.createSQLQuery("SELECT * FROM Visitatori WHERE id = '" + idVisitatore + "'").addEntity(Visitatore.class);
        List<Visitatore> rows = query.list();
        if (rows.size() > 0) {
            session.getTransaction().commit();
            session.close();
            return (Visitatore) rows.get(0);
        }
        session.getTransaction().commit();
        session.close();
        return null;
    }
    //ricorda di fare il punto length

    public void aggiornaVisitatore(Visitatore visitatore) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Visitatore visit
                    = (Visitatore) session.get(Visitatore.class, visitatore.getId());
            visit.setUsername(visitatore.getUsername());
            visit.setPassword(visitatore.getPassword());
            visit.setNome(visitatore.getNome());
            visit.setCognome(visitatore.getCognome());
            visit.setDataN(visitatore.getDataN());
            session.update(visit);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    //ricorda di fare il punto length
    public List<Visita> getEventiInCorso() {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        SQLQuery query = session.createSQLQuery("SELECT * FROM Visite WHERE DataF >= CURDATE( ) AND NOT DataI > CURDATE( ) ").addEntity(Visita.class);
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

    public List<Visita> getEventiPassati() {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        SQLQuery query = session.createSQLQuery("select * from Visite where  DataF<=CURDATE() order by DataF DESC ").addEntity(Visita.class);
        List<Visita> rows = query.list();
        session.getTransaction().commit();
        session.close();
        return rows;
    }

    public List<Visita> query1(Date dataI, Date dataF) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            SQLQuery query = session.createSQLQuery("select * from Visite where DataI >= :datai and DataF <= :dataf").addEntity(Visita.class);
            query.setDate("datai", dataI);
            query.setDate("dataf", dataF);
            List cats = query.list();
            if (cats.size() > 0) {
                session.getTransaction().commit();
                session.close();
                return cats;
            }
            return null;
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return null;
    }

    public int query2(String idVisita) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            SQLQuery query = session.createSQLQuery("select COUNT(*) from Biglietti where IdVisita =?");
            query.setString(0, idVisita);
            BigInteger value = (BigInteger) query.uniqueResult();
            return value.intValue();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return 0;
    }

    //non so se il group by è giusto perchè nel foglio delle query è diverso
    public void vista1(String idVisita) {
        
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        SQLQuery query = session.createSQLQuery("CREATE OR REPLACE  VIEW Vista1 (IdVisita,Categoria,Conta,Sconto) AS "
                + "SELECT IdVisita,Categoria,COUNT(*) AS Conta,Sconto FROM Biglietti INNER JOIN Categorie ON Categoria=CodC WHERE IdVisita=:id GROUP BY IdVisita,Categoria,Sconto");
        query.setString("id",idVisita);
        int result = query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    public void vista2(String idVisita) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        SQLQuery query = session.createSQLQuery("CREATE OR REPLACE  VIEW Vista2 (Tariffa,IdVisita) AS"
                + "SELECT Tariffa,IdVisita FROM Visite WHERE IdVisita=" + idVisita + " ");
        int result = query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    public void vista3() {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        SQLQuery query = session.createSQLQuery("CREATE OR REPLACE  VIEW Vista3 (Categoria,Totale) AS"
                + "SELECT Categoria,(Tariffa * Conta)-(Tariffa*100/Sconto)*Conta AS Totale FROM Vista1 NATURAL JOIN Vista2 GROUP BY Categoria");
        int result = query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }



    public Integer query3() {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            SQLQuery query = session.createSQLQuery("SELECT SUM(Totale) FROM Vista3").addEntity(Biglietto.class);
            List cats = query.list();
            if (cats.size() > 0) {
                session.getTransaction().commit();
                session.close();
                return (Integer) cats.get(0);
            }
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return null;
    }

    public Visitatore getVisitatore(String idVisitatore) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.getNamedQuery("Visitatore.findById");
        query.setString("id", idVisitatore);
        Visitatore v = (Visitatore) query.uniqueResult();
        tx.commit();
        session.close();
        return v;
    }

    public Visita getVisita(String idVisita) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.getNamedQuery("Visita.findByIdVisita");
        query.setString("idVisita", idVisita);
        Visita v = (Visita) query.uniqueResult();
        tx.commit();
        session.close();
        return v;
    }

    public Categoria getCategoria(String categoria) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        SQLQuery query = session.createSQLQuery("SELECT * FROM Categorie WHERE Descrizione =  :desrizione").addEntity(Categoria.class);
        query.setString("desrizione", categoria);
           List cats = query.list();
            if (cats.size() > 0) {
                return (Categoria) cats.get(0);
            }
        tx.commit();
        session.close();
        return null;
    }

}
