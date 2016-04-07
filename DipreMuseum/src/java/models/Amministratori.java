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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "Amministratori")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Amministratori.findAll", query = "SELECT a FROM Amministratori a"),
    @NamedQuery(name = "Amministratori.findById", query = "SELECT a FROM Amministratori a WHERE a.id = :id"),
    @NamedQuery(name = "Amministratori.findByNome", query = "SELECT a FROM Amministratori a WHERE a.nome = :nome"),
    @NamedQuery(name = "Amministratori.findByCognome", query = "SELECT a FROM Amministratori a WHERE a.cognome = :cognome"),
    @NamedQuery(name = "Amministratori.findByEmail", query = "SELECT a FROM Amministratori a WHERE a.email = :email"),
    @NamedQuery(name = "Amministratori.findByPw", query = "SELECT a FROM Amministratori a WHERE a.pw = :pw")})
public class Amministratori implements Serializable {
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
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "pw")
    private String pw;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idA")
    private Collection<Visite> visiteCollection;

    public Amministratori() {
    }

    public Amministratori(Integer id) {
        this.id = id;
    }

    public Amministratori(Integer id, String nome, String cognome, String email, String pw) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.pw = pw;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    @XmlTransient
    public Collection<Visite> getVisiteCollection() {
        return visiteCollection;
    }

    public void setVisiteCollection(Collection<Visite> visiteCollection) {
        this.visiteCollection = visiteCollection;
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
        if (!(object instanceof Amministratori)) {
            return false;
        }
        Amministratori other = (Amministratori) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Amministratori[ id=" + id + " ]";
    }
    
}
