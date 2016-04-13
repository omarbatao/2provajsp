/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author FSEVERI\depaula2995
 */
@Entity
@Table(name = "Biglietti")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Biglietti.findAll", query = "SELECT b FROM Biglietti b"),
    @NamedQuery(name = "Biglietti.findByCodB", query = "SELECT b FROM Biglietti b WHERE b.codB = :codB"),
    @NamedQuery(name = "Biglietti.findByValidita", query = "SELECT b FROM Biglietti b WHERE b.validita = :validita"),
    @NamedQuery(name = "Biglietti.findByTipo", query = "SELECT b FROM Biglietti b WHERE b.tipo = :tipo")})
public class Biglietto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CodB")
    private Integer codB;
    @Basic(optional = false)
    @Column(name = "Validita")
    @Temporal(TemporalType.DATE)
    private Date validita;
    @Basic(optional = false)
    @Column(name = "Tipo")
    private int tipo;
    @JoinTable(name = "B_S", joinColumns = {
        @JoinColumn(name = "CodB", referencedColumnName = "CodB")}, inverseJoinColumns = {
        @JoinColumn(name = "CodS", referencedColumnName = "CodS")})
    @ManyToMany
    private Collection<Servizio> serviziCollection;
    @JoinColumn(name = "IdVisitatore", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Visitatore idVisitatore;
    @JoinColumn(name = "IdVisita", referencedColumnName = "IdVisita")
    @ManyToOne(optional = false)
    private Visita idVisita;

    public Biglietto() {
    }

    public Biglietto(Integer codB) {
        this.codB = codB;
    }

    public Biglietto(Integer codB, Date validita, int tipo) {
        this.codB = codB;
        this.validita = validita;
        this.tipo = tipo;
    }

    public Integer getCodB() {
        return codB;
    }

    public void setCodB(Integer codB) {
        this.codB = codB;
    }

    public Date getValidita() {
        return validita;
    }

    public void setValidita(Date validita) {
        this.validita = validita;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public Collection<Servizio> getServiziCollection() {
        return serviziCollection;
    }

    public void setServiziCollection(Collection<Servizio> serviziCollection) {
        this.serviziCollection = serviziCollection;
    }

    public Visitatore getIdVisitatore() {
        return idVisitatore;
    }

    public void setIdVisitatore(Visitatore idVisitatore) {
        this.idVisitatore = idVisitatore;
    }

    public Visita getIdVisita() {
        return idVisita;
    }

    public void setIdVisita(Visita idVisita) {
        this.idVisita = idVisita;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codB != null ? codB.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Biglietto)) {
            return false;
        }
        Biglietto other = (Biglietto) object;
        if ((this.codB == null && other.codB != null) || (this.codB != null && !this.codB.equals(other.codB))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Biglietti[ codB=" + codB + " ]";
    }
    
}
