/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author FSEVERI\benetti3004
 */
@Entity
@Table(name = "WA2P_CATEGORIE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WA2P_Categoria.findAll", query = "SELECT w FROM WA2P_Categoria w"),
    @NamedQuery(name = "WA2P_Categoria.findById", query = "SELECT w FROM WA2P_Categoria w WHERE w.id = :id"),
    @NamedQuery(name = "WA2P_Categoria.findByNome", query = "SELECT w FROM WA2P_Categoria w WHERE w.nome = :nome")})
public class Categoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @ManyToMany(mappedBy = "wA2PCategoriaCollection")
    private Collection<Utente> wA2PUtenteCollection;
    @OneToMany(mappedBy = "categoria")
    private Collection<Evento> wA2PEventoCollection;

    public Categoria() {
    }

    public Categoria(String id) {
        this.id = id;
    }

    public Categoria(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public Collection<Utente> getWA2PUtenteCollection() {
        return wA2PUtenteCollection;
    }

    public void setWA2PUtenteCollection(Collection<Utente> wA2PUtenteCollection) {
        this.wA2PUtenteCollection = wA2PUtenteCollection;
    }

    @XmlTransient
    public Collection<Evento> getWA2PEventoCollection() {
        return wA2PEventoCollection;
    }

    public void setWA2PEventoCollection(Collection<Evento> wA2PEventoCollection) {
        this.wA2PEventoCollection = wA2PEventoCollection;
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
        if (!(object instanceof Categoria)) {
            return false;
        }
        Categoria other = (Categoria) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.WA2P_Categoria[ id=" + id + " ]";
    }
    
}
