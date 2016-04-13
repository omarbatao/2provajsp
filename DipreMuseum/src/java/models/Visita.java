/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "Visite")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Visite.findAll", query = "SELECT v FROM Visite v"),
    @NamedQuery(name = "Visite.findByIdVisita", query = "SELECT v FROM Visite v WHERE v.idVisita = :idVisita"),
    @NamedQuery(name = "Visite.findByTitolo", query = "SELECT v FROM Visite v WHERE v.titolo = :titolo"),
    @NamedQuery(name = "Visite.findByTariffa", query = "SELECT v FROM Visite v WHERE v.tariffa = :tariffa"),
    @NamedQuery(name = "Visite.findByDataI", query = "SELECT v FROM Visite v WHERE v.dataI = :dataI"),
    @NamedQuery(name = "Visite.findByDataF", query = "SELECT v FROM Visite v WHERE v.dataF = :dataF"),
    @NamedQuery(name = "Visite.findByMaxPartecipanti", query = "SELECT v FROM Visite v WHERE v.maxPartecipanti = :maxPartecipanti"),
    @NamedQuery(name = "Visite.findByDescrizione", query = "SELECT v FROM Visite v WHERE v.descrizione = :descrizione")})
public class Visita implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IdVisita")
    private String idVisita;
    @Basic(optional = false)
    @Column(name = "Titolo")
    private String titolo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Tariffa")
    private BigDecimal tariffa;
    @Column(name = "DataI")
    @Temporal(TemporalType.DATE)
    private Date dataI;
    @Column(name = "DataF")
    @Temporal(TemporalType.DATE)
    private Date dataF;
    @Column(name = "MaxPartecipanti")
    private Integer maxPartecipanti;
    @Column(name = "Descrizione")
    private String descrizione;
    @JoinColumn(name = "IdA", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Amministratore idA;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVisita")
    private Collection<Biglietto> bigliettiCollection;

    public Visita() {
    }

    public Visita(String idVisita) {
        this.idVisita = idVisita;
    }

    public Visita(String idVisita, String titolo) {
        this.idVisita = idVisita;
        this.titolo = titolo;
    }

    public String getIdVisita() {
        return idVisita;
    }

    public void setIdVisita(String idVisita) {
        this.idVisita = idVisita;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public BigDecimal getTariffa() {
        return tariffa;
    }

    public void setTariffa(BigDecimal tariffa) {
        this.tariffa = tariffa;
    }

    public Date getDataI() {
        return dataI;
    }

    public void setDataI(Date dataI) {
        this.dataI = dataI;
    }

    public Date getDataF() {
        return dataF;
    }

    public void setDataF(Date dataF) {
        this.dataF = dataF;
    }

    public Integer getMaxPartecipanti() {
        return maxPartecipanti;
    }

    public void setMaxPartecipanti(Integer maxPartecipanti) {
        this.maxPartecipanti = maxPartecipanti;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Amministratore getIdA() {
        return idA;
    }

    public void setIdA(Amministratore idA) {
        this.idA = idA;
    }

    @XmlTransient
    public Collection<Biglietto> getBigliettiCollection() {
        return bigliettiCollection;
    }

    public void setBigliettiCollection(Collection<Biglietto> bigliettiCollection) {
        this.bigliettiCollection = bigliettiCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVisita != null ? idVisita.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Visita)) {
            return false;
        }
        Visita other = (Visita) object;
        if ((this.idVisita == null && other.idVisita != null) || (this.idVisita != null && !this.idVisita.equals(other.idVisita))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Visite[ idVisita=" + idVisita + " ]";
    }
    
}
