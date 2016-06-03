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
    @NamedQuery(name = "Evento.findAll", query = "SELECT e FROM Evento e"),
    @NamedQuery(name = "Evento.findById", query = "SELECT e FROM Evento e WHERE e.id = :id"),
    @NamedQuery(name = "Evento.findByTitolo", query = "SELECT e FROM Evento e WHERE e.titolo = :titolo"),
    @NamedQuery(name = "Evento.findByData", query = "SELECT e FROM Evento e WHERE e.data = :data")})
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
    @Column(name="descrizione")
    private String descrizione;
    @Column (name="Immagine")
    private String Immagine;
    
    @ManyToMany(mappedBy = "eventoCollection")
    private Collection<Artista> artistaCollection;
    @OneToMany(mappedBy = "evento")
    private Collection<Commento> commentoCollection;
    @JoinColumn(name = "idU", referencedColumnName = "nickname")
    @ManyToOne
    private Utente idU;
    @JoinColumn(name = "categoria", referencedColumnName = "id")
    @ManyToOne
    private Categoria categoria;
    @JoinColumn(name = "luogo", referencedColumnName = "idProvincia")
    @ManyToOne(optional = false)
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
    public Collection<Artista> getArtistaCollection() {
        return artistaCollection;
    }

    public void setArtistaCollection(Collection<Artista> artistaCollection) {
        this.artistaCollection = artistaCollection;
    }

    @XmlTransient
    public Collection<Commento> getCommentoCollection() {
        return commentoCollection;
    }

    public void setCommentoCollection(Collection<Commento> commentoCollection) {
        this.commentoCollection = commentoCollection;
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
        return "Models.Evento[ id=" + id + " ]";
    }

    public String getDescrizione() {
        return descrizione;
    }

    public String getImmagine() {
        return Immagine;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public void setImmagine(String Immagine) {
        this.Immagine = Immagine;
    }
    
    
    
    
}
