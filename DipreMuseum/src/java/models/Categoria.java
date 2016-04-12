/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author FSEVERI\depaula2995
 */
@Entity
@Table(name = "Categorie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categorie.findAll", query = "SELECT c FROM Categorie c"),
    @NamedQuery(name = "Categorie.findByCodC", query = "SELECT c FROM Categorie c WHERE c.codC = :codC"),
    @NamedQuery(name = "Categorie.findByDescrizione", query = "SELECT c FROM Categorie c WHERE c.descrizione = :descrizione"),
    @NamedQuery(name = "Categorie.findBySconto", query = "SELECT c FROM Categorie c WHERE c.sconto = :sconto"),
    @NamedQuery(name = "Categorie.findByTipoDoc", query = "SELECT c FROM Categorie c WHERE c.tipoDoc = :tipoDoc")})
public class Categoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CodC")
    private String codC;
    @Column(name = "Descrizione")
    private String descrizione;
    @Basic(optional = false)
    @Column(name = "Sconto")
    private int sconto;
    @Basic(optional = false)
    @Column(name = "TipoDoc")
    private String tipoDoc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoria")
    private Collection<Visitatore> visitatoriCollection;

    public Categoria() {
    }

    public Categoria(String codC) {
        this.codC = codC;
    }

    public Categoria(String codC, int sconto, String tipoDoc) {
        this.codC = codC;
        this.sconto = sconto;
        this.tipoDoc = tipoDoc;
    }

    public String getCodC() {
        return codC;
    }

    public void setCodC(String codC) {
        this.codC = codC;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public int getSconto() {
        return sconto;
    }

    public void setSconto(int sconto) {
        this.sconto = sconto;
    }

    public String getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    @XmlTransient
    public Collection<Visitatore> getVisitatoriCollection() {
        return visitatoriCollection;
    }

    public void setVisitatoriCollection(Collection<Visitatore> visitatoriCollection) {
        this.visitatoriCollection = visitatoriCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codC != null ? codC.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categoria)) {
            return false;
        }
        Categoria other = (Categoria) object;
        if ((this.codC == null && other.codC != null) || (this.codC != null && !this.codC.equals(other.codC))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Categorie[ codC=" + codC + " ]";
    }
    
}
