/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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
 * @author FSEVERI\benetti3004
 */
@Entity
@Table(name = "WA2P_EVENTI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WA2P_Evento.findAll", query = "SELECT w FROM WA2P_Evento w"),
    @NamedQuery(name = "WA2P_Evento.findById", query = "SELECT w FROM WA2P_Evento w WHERE w.id = :id"),
    @NamedQuery(name = "WA2P_Evento.findByTitolo", query = "SELECT w FROM WA2P_Evento w WHERE w.titolo = :titolo"),
    @NamedQuery(name = "WA2P_Evento.findByLuogo", query = "SELECT w FROM WA2P_Evento w WHERE w.luogo = :luogo"),
    @NamedQuery(name = "WA2P_Evento.findByData", query = "SELECT w FROM WA2P_Evento w WHERE w.data = :data")})
public class WA2P_Evento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @Column(name = "titolo")
    private String titolo;
    @Basic(optional = false)
    @Column(name = "luogo")
    private String luogo;
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @ManyToMany(mappedBy = "wA2PEventoCollection")
    private Collection<WA2P_Artista> wA2PArtistaCollection;
    @OneToMany(mappedBy = "evento")
    private Collection<WA2P_Commento> wA2PCommentoCollection;
    @JoinColumn(name = "idU", referencedColumnName = "nickname")
    @ManyToOne
    private WA2P_Utente idU;
    @JoinColumn(name = "categoria", referencedColumnName = "id")
    @ManyToOne
    private WA2P_Categoria categoria;

    public WA2P_Evento() {
    }

    public WA2P_Evento(String id) {
        this.id = id;
    }

    public WA2P_Evento(String id, String titolo, String luogo) {
        this.id = id;
        this.titolo = titolo;
        this.luogo = luogo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getLuogo() {
        return luogo;
    }

    public void setLuogo(String luogo) {
        this.luogo = luogo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @XmlTransient
    public Collection<WA2P_Artista> getWA2PArtistaCollection() {
        return wA2PArtistaCollection;
    }

    public void setWA2PArtistaCollection(Collection<WA2P_Artista> wA2PArtistaCollection) {
        this.wA2PArtistaCollection = wA2PArtistaCollection;
    }

    @XmlTransient
    public Collection<WA2P_Commento> getWA2PCommentoCollection() {
        return wA2PCommentoCollection;
    }

    public void setWA2PCommentoCollection(Collection<WA2P_Commento> wA2PCommentoCollection) {
        this.wA2PCommentoCollection = wA2PCommentoCollection;
    }

    public WA2P_Utente getIdU() {
        return idU;
    }

    public void setIdU(WA2P_Utente idU) {
        this.idU = idU;
    }

    public WA2P_Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(WA2P_Categoria categoria) {
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
        if (!(object instanceof WA2P_Evento)) {
            return false;
        }
        WA2P_Evento other = (WA2P_Evento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.WA2P_Evento[ id=" + id + " ]";
    }
    
}
