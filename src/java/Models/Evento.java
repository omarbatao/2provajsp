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
    @NamedQuery(name = "WA2P_Evento.findByData", query = "SELECT w FROM WA2P_Evento w WHERE w.data = :data")})
public class Evento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @Column(name = "titolo")
    private String titolo;
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @ManyToMany(mappedBy = "wA2PEventoCollection")
    private Collection<Artista> wA2PArtistaCollection;
    @OneToMany(mappedBy = "evento")
    private Collection<Commento> wA2PCommentoCollection;
    @JoinColumn(name = "idU", referencedColumnName = "nickname")
    @ManyToOne
    private Utente idU;
    @JoinColumn(name = "categoria", referencedColumnName = "id")
    @ManyToOne
    private Categoria categoria;
    @ManyToOne
    @JoinColumn(name = "luogo",referencedColumnName="idProvincia")
    private Provincia luogo;

    public Evento() {
    }

    public Evento(String id) {
        this.id = id;
    }

    public Evento(String id, String titolo) {
        this.id = id;
        this.titolo = titolo;
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @XmlTransient
    public Collection<Artista> getWA2PArtistaCollection() {
        return wA2PArtistaCollection;
    }

    public void setWA2PArtistaCollection(Collection<Artista> wA2PArtistaCollection) {
        this.wA2PArtistaCollection = wA2PArtistaCollection;
    }

    @XmlTransient
    public Collection<Commento> getWA2PCommentoCollection() {
        return wA2PCommentoCollection;
    }

    public void setWA2PCommentoCollection(Collection<Commento> wA2PCommentoCollection) {
        this.wA2PCommentoCollection = wA2PCommentoCollection;
    }

    public Utente getIdU() {
        return idU;
    }

    public void setIdU(Utente idU) {
        this.idU = idU;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Provincia getLuogo() {
        return luogo;
    }

    public void setLuogo(Provincia luogo) {
        this.luogo = luogo;
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
        if (!(object instanceof Evento)) {
            return false;
        }
        Evento other = (Evento) object;
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
