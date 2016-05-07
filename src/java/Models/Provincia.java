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
    @NamedQuery(name = "WA2P_Provincia.findAll", query = "SELECT w FROM WA2P_Provincia w"),
    @NamedQuery(name = "WA2P_Provincia.findByIdProvincia", query = "SELECT w FROM WA2P_Provincia w WHERE w.idProvincia = :idProvincia"),
    @NamedQuery(name = "WA2P_Provincia.findByIdRegione", query = "SELECT w FROM WA2P_Provincia w WHERE w.idRegione = :idRegione"),
    @NamedQuery(name = "WA2P_Provincia.findByNomeProvincia", query = "SELECT w FROM WA2P_Provincia w WHERE w.nomeProvincia = :nomeProvincia"),
    @NamedQuery(name = "WA2P_Provincia.findBySiglaProvincia", query = "SELECT w FROM WA2P_Provincia w WHERE w.siglaProvincia = :siglaProvincia")})
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
    
    @OneToMany(mappedBy = "luogo")
    private Collection<Evento> eventi;

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
    public Collection<Evento> getWA2PEventoCollection() {
        return eventi;
    }

    public void setWA2PEventoCollection(Collection<Evento> wA2PEventoCollection) {
        this.eventi = wA2PEventoCollection;
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
        return "Models.WA2P_Provincia[ idProvincia=" + idProvincia + " ]";
    }
    
}
