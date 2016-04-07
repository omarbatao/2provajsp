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
@Table(name = "Visitatori")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Visitatori.findAll", query = "SELECT v FROM Visitatori v"),
    @NamedQuery(name = "Visitatori.findById", query = "SELECT v FROM Visitatori v WHERE v.id = :id"),
    @NamedQuery(name = "Visitatori.findByNome", query = "SELECT v FROM Visitatori v WHERE v.nome = :nome"),
    @NamedQuery(name = "Visitatori.findByCognome", query = "SELECT v FROM Visitatori v WHERE v.cognome = :cognome"),
    @NamedQuery(name = "Visitatori.findByDataN", query = "SELECT v FROM Visitatori v WHERE v.dataN = :dataN"),
    @NamedQuery(name = "Visitatori.findByUsername", query = "SELECT v FROM Visitatori v WHERE v.username = :username"),
    @NamedQuery(name = "Visitatori.findByPassword", query = "SELECT v FROM Visitatori v WHERE v.password = :password")})
public class Visitatori implements Serializable {
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
    private Collection<Cartedicredito> cartedicreditoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVisitatore")
    private Collection<Biglietti> bigliettiCollection;
    @JoinColumn(name = "Categoria", referencedColumnName = "CodC")
    @ManyToOne(optional = false)
    private Categorie categoria;

    public Visitatori() {
    }

    public Visitatori(Integer id) {
        this.id = id;
    }

    public Visitatori(Integer id, String nome, String cognome, Date dataN, String username, String password) {
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
    public Collection<Cartedicredito> getCartedicreditoCollection() {
        return cartedicreditoCollection;
    }

    public void setCartedicreditoCollection(Collection<Cartedicredito> cartedicreditoCollection) {
        this.cartedicreditoCollection = cartedicreditoCollection;
    }

    @XmlTransient
    public Collection<Biglietti> getBigliettiCollection() {
        return bigliettiCollection;
    }

    public void setBigliettiCollection(Collection<Biglietti> bigliettiCollection) {
        this.bigliettiCollection = bigliettiCollection;
    }

    public Categorie getCategoria() {
        return categoria;
    }

    public void setCategoria(Categorie categoria) {
        this.categoria = categoria;
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
        if (!(object instanceof Visitatori)) {
            return false;
        }
        Visitatori other = (Visitatori) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Visitatori[ id=" + id + " ]";
    }
    
}
