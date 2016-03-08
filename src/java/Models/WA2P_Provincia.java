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
    @NamedQuery(name = "Wa2pProvince.findAll", query = "SELECT w FROM Wa2pProvince w"),
    @NamedQuery(name = "Wa2pProvince.findByIdProvincia", query = "SELECT w FROM Wa2pProvince w WHERE w.idProvincia = :idProvincia"),
    @NamedQuery(name = "Wa2pProvince.findByIdRegione", query = "SELECT w FROM Wa2pProvince w WHERE w.idRegione = :idRegione"),
    @NamedQuery(name = "Wa2pProvince.findByNomeProvincia", query = "SELECT w FROM Wa2pProvince w WHERE w.nomeProvincia = :nomeProvincia"),
    @NamedQuery(name = "Wa2pProvince.findBySiglaProvincia", query = "SELECT w FROM Wa2pProvince w WHERE w.siglaProvincia = :siglaProvincia")})
public class WA2P_Provincia implements Serializable {
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
    private Collection<WA2P_Evento> wA2PEventoCollection;

    public WA2P_Provincia() {
    }

    public WA2P_Provincia(String idProvincia) {
        this.idProvincia = idProvincia;
    }

    public WA2P_Provincia(String idProvincia, String idRegione, String nomeProvincia, String siglaProvincia) {
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
    public Collection<WA2P_Evento> getWA2PEventoCollection() {
        return wA2PEventoCollection;
    }

    public void setWA2PEventoCollection(Collection<WA2P_Evento> wA2PEventoCollection) {
        this.wA2PEventoCollection = wA2PEventoCollection;
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
        if (!(object instanceof WA2P_Provincia)) {
            return false;
        }
        WA2P_Provincia other = (WA2P_Provincia) object;
        if ((this.idProvincia == null && other.idProvincia != null) || (this.idProvincia != null && !this.idProvincia.equals(other.idProvincia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.Wa2pProvince[ idProvincia=" + idProvincia + " ]";
    }
    
}
