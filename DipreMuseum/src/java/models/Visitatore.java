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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
 * @author FSEVERI\ceretta2991
 */
@Entity
@Table(name = "Visitatori")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Visitatore.findAll", query = "SELECT v FROM Visitatore v"),
    @NamedQuery(name = "Visitatore.findById", query = "SELECT v FROM Visitatore v WHERE v.id = :id"),
    @NamedQuery(name = "Visitatore.findByNome", query = "SELECT v FROM Visitatore v WHERE v.nome = :nome"),
    @NamedQuery(name = "Visitatore.findByCognome", query = "SELECT v FROM Visitatore v WHERE v.cognome = :cognome"),
    @NamedQuery(name = "Visitatore.findByDataN", query = "SELECT v FROM Visitatore v WHERE v.dataN = :dataN"),
    @NamedQuery(name = "Visitatore.findByUsername", query = "SELECT v FROM Visitatore v WHERE v.username = :username"),
    @NamedQuery(name = "Visitatore.findByPassword", query = "SELECT v FROM Visitatore v WHERE v.password = :password")})
public class Visitatore implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "Cognome")
    private String cognome;
    @Basic(optional = false)
    @Column(name = "DataN")
    @Temporal(TemporalType.DATE)
    private Date dataN;
    @Basic(optional = false)
    @Column(name = "Username")
    private String username;
    @Basic(optional = false)
    @Column(name = "Password")
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVisitatore")
    private Collection<CartaDiCredito> cartaDiCreditoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVisitatore")
    private Collection<Biglietto> bigliettoCollection;

    public Visitatore() {
    }

    public Visitatore(Integer id) {
        this.id = id;
    }

    public Visitatore(Integer id, String nome, String cognome, Date dataN, String username, String password) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.dataN = dataN;
        this.username = username;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Date getDataN() {
        return dataN;
    }

    public void setDataN(Date dataN) {
        this.dataN = dataN;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlTransient
    public Collection<CartaDiCredito> getCartaDiCreditoCollection() {
        return cartaDiCreditoCollection;
    }

    public void setCartaDiCreditoCollection(Collection<CartaDiCredito> cartaDiCreditoCollection) {
        this.cartaDiCreditoCollection = cartaDiCreditoCollection;
    }

    @XmlTransient
    public Collection<Biglietto> getBigliettoCollection() {
        return bigliettoCollection;
    }

    public void setBigliettoCollection(Collection<Biglietto> bigliettoCollection) {
        this.bigliettoCollection = bigliettoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Visitatore)) {
            return false;
        }
        Visitatore other = (Visitatore) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Visitatore[ id=" + id + " ]";
    }
    
}
