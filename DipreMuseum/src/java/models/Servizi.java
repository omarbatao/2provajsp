/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author FSEVERI\depaula2995
 */
@Entity
@Table(name = "Servizi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Servizi.findAll", query = "SELECT s FROM Servizi s"),
    @NamedQuery(name = "Servizi.findByCodS", query = "SELECT s FROM Servizi s WHERE s.codS = :codS"),
    @NamedQuery(name = "Servizi.findByDescrizione", query = "SELECT s FROM Servizi s WHERE s.descrizione = :descrizione"),
    @NamedQuery(name = "Servizi.findByPrezzo", query = "SELECT s FROM Servizi s WHERE s.prezzo = :prezzo")})
public class Servizi implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CodS")
    private String codS;
    @Column(name = "Descrizione")
    private String descrizione;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "Prezzo")
    private BigDecimal prezzo;
    @ManyToMany(mappedBy = "serviziCollection")
    private Collection<Biglietti> bigliettiCollection;

    public Servizi() {
    }

    public Servizi(String codS) {
        this.codS = codS;
    }

    public Servizi(String codS, BigDecimal prezzo) {
        this.codS = codS;
        this.prezzo = prezzo;
    }

    public String getCodS() {
        return codS;
    }

    public void setCodS(String codS) {
        this.codS = codS;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public BigDecimal getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(BigDecimal prezzo) {
        this.prezzo = prezzo;
    }

    @XmlTransient
    public Collection<Biglietti> getBigliettiCollection() {
        return bigliettiCollection;
    }

    public void setBigliettiCollection(Collection<Biglietti> bigliettiCollection) {
        this.bigliettiCollection = bigliettiCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codS != null ? codS.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servizi)) {
            return false;
        }
        Servizi other = (Servizi) object;
        if ((this.codS == null && other.codS != null) || (this.codS != null && !this.codS.equals(other.codS))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Servizi[ codS=" + codS + " ]";
    }
    
}
