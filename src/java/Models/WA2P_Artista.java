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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author FSEVERI\benetti3004
 */
@Entity
@Table(name = "WA2P_ARTISTI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WA2P_Artista.findAll", query = "SELECT w FROM WA2P_Artista w"),
    @NamedQuery(name = "WA2P_Artista.findById", query = "SELECT w FROM WA2P_Artista w WHERE w.id = :id"),
    @NamedQuery(name = "WA2P_Artista.findByNomeArte", query = "SELECT w FROM WA2P_Artista w WHERE w.nomeArte = :nomeArte")})
public class WA2P_Artista implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @Column(name = "nomeArte")
    private String nomeArte;
    @JoinTable(name = "WA2P_E_A", joinColumns = {
        @JoinColumn(name = "idA", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "idE", referencedColumnName = "id")})
    @ManyToMany
    private Collection<WA2P_Evento> wA2PEventoCollection;

    public WA2P_Artista() {
    }

    public WA2P_Artista(String id) {
        this.id = id;
    }

    public WA2P_Artista(String id, String nomeArte) {
        this.id = id;
        this.nomeArte = nomeArte;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomeArte() {
        return nomeArte;
    }

    public void setNomeArte(String nomeArte) {
        this.nomeArte = nomeArte;
    }

    @XmlTransient
    public Collection<WA2P_Evento> getWA2PEventoCollection() {
        return wA2PEventoCollection;
    }

    public void setWA2PEventoCollection(Collection<WA2P_Evento> wA2PEventoCollection) {
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
        if (!(object instanceof WA2P_Artista)) {
            return false;
        }
        WA2P_Artista other = (WA2P_Artista) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.WA2P_Artista[ id=" + id + " ]";
    }
    
}
