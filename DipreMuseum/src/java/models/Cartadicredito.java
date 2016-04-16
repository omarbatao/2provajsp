/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author FSEVERI\depaula2995
 */
@Entity
@Table(name = "Cartedicredito")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cartadicredito.findAll", query = "SELECT c FROM Cartadicredito c"),
    @NamedQuery(name = "Cartadicredito.findByCodC", query = "SELECT c FROM Cartadicredito c WHERE c.codC = :codC"),
    @NamedQuery(name = "Cartadicredito.findByDataS", query = "SELECT c FROM Cartadicredito c WHERE c.dataS = :dataS"),
    @NamedQuery(name = "Cartadicredito.findByPin", query = "SELECT c FROM Cartadicredito c WHERE c.pin = :pin")})
public class Cartadicredito implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CodC")
    private String codC;
    @Basic(optional = false)
    @Column(name = "DataS")
    @Temporal(TemporalType.DATE)
    private Date dataS;
    @Basic(optional = false)
    @Column(name = "Pin")
    private String pin;
    @JoinColumn(name = "IdVisitatore", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Visitatore idVisitatore;

    public Cartadicredito() {
    }

    public Cartadicredito(String codC) {
        this.codC = codC;
    }

    public Cartadicredito(String codC, Date dataS, String pin) {
        this.codC = codC;
        this.dataS = dataS;
        this.pin = pin;
    }

    public String getCodC() {
        return codC;
    }

    public void setCodC(String codC) {
        this.codC = codC;
    }

    public Date getDataS() {
        return dataS;
    }

    public void setDataS(Date dataS) {
        this.dataS = dataS;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public Visitatore getIdVisitatore() {
        return idVisitatore;
    }

    public void setIdVisitatore(Visitatore idVisitatore) {
        this.idVisitatore = idVisitatore;
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
        if (!(object instanceof Cartadicredito)) {
            return false;
        }
        Cartadicredito other = (Cartadicredito) object;
        if ((this.codC == null && other.codC != null) || (this.codC != null && !this.codC.equals(other.codC))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Cartadicredito[ codC=" + codC + " ]";
    }
    
}
