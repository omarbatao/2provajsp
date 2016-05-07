/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "WA2P_PROVINCE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Provincia.findAll", query = "SELECT p FROM Provincia p"),
    @NamedQuery(name = "Provincia.findByIdProvincia", query = "SELECT p FROM Provincia p WHERE p.idProvincia = :idProvincia"),
    @NamedQuery(name = "Provincia.findByIdRegione", query = "SELECT p FROM Provincia p WHERE p.idRegione = :idRegione"),
    @NamedQuery(name = "Provincia.findByNomeProvincia", query = "SELECT p FROM Provincia p WHERE p.nomeProvincia = :nomeProvincia"),
    @NamedQuery(name = "Provincia.findBySiglaProvincia", query = "SELECT p FROM Provincia p WHERE p.siglaProvincia = :siglaProvincia")})
public class Provincia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idProvincia")
    private String idProvincia;
    @Basic(optional = false)
    @Column(name = "idRegione")
    private String idRegione;
    @Basic(optional = false)
    @Column(name = "nomeProvincia")
    private String nomeProvincia;
    @Basic(optional = false)
    @Column(name = "siglaProvincia")
    private String siglaProvincia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "luogo")
    private Collection<Evento> eventoCollection;

    public Provincia() {
    }

    public Provincia(String idProvincia) {
        this.idProvincia = idProvincia;
    }

    public Provincia(String idProvincia, String idRegione, String nomeProvincia, String siglaProvincia) {
        this.idProvincia = idProvincia;
        this.idRegione = idRegione;
        this.nomeProvincia = nomeProvincia;
        this.siglaProvincia = siglaProvincia;
    }

    public String getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(String idProvincia) {
        this.idProvincia = idProvincia;
    }

    public String getIdRegione() {
        return idRegione;
    }

    public void setIdRegione(String idRegione) {
        this.idRegione = idRegione;
    }

    public String getNomeProvincia() {
        return nomeProvincia;
    }

    public void setNomeProvincia(String nomeProvincia) {
        this.nomeProvincia = nomeProvincia;
    }

    public String getSiglaProvincia() {
        return siglaProvincia;
    }

    public void setSiglaProvincia(String siglaProvincia) {
        this.siglaProvincia = siglaProvincia;
    }

    @XmlTransient
    public Collection<Evento> getEventoCollection() {
        return eventoCollection;
    }

    public void setEventoCollection(Collection<Evento> eventoCollection) {
        this.eventoCollection = eventoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProvincia != null ? idProvincia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Provincia)) {
            return false;
        }
        Provincia other = (Provincia) object;
        if ((this.idProvincia == null && other.idProvincia != null) || (this.idProvincia != null && !this.idProvincia.equals(other.idProvincia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.Provincia[ idProvincia=" + idProvincia + " ]";
    }
    
}
