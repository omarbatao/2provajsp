/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author FSEVERI\benetti3004
 */
@Entity
@Table(name = "WA2P_COMMENTI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WA2P_Commento.findAll", query = "SELECT w FROM WA2P_Commento w"),
    @NamedQuery(name = "WA2P_Commento.findById", query = "SELECT w FROM WA2P_Commento w WHERE w.id = :id"),
    @NamedQuery(name = "WA2P_Commento.findByCommento", query = "SELECT w FROM WA2P_Commento w WHERE w.commento = :commento"),
    @NamedQuery(name = "WA2P_Commento.findByVoto", query = "SELECT w FROM WA2P_Commento w WHERE w.voto = :voto")})
public class WA2P_Commento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @Column(name = "commento")
    private String commento;
    @Basic(optional = false)
    @Column(name = "voto")
    private Character voto;
    @JoinColumn(name = "idU", referencedColumnName = "nickname")
    @ManyToOne
    private WA2P_Utente idU;
    @JoinColumn(name = "evento", referencedColumnName = "id")
    @ManyToOne
    private WA2P_Evento evento;

    public WA2P_Commento() {
    }

    public WA2P_Commento(String id) {
        this.id = id;
    }

    public WA2P_Commento(String id, String commento, Character voto) {
        this.id = id;
        this.commento = commento;
        this.voto = voto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCommento() {
        return commento;
    }

    public void setCommento(String commento) {
        this.commento = commento;
    }

    public Character getVoto() {
        return voto;
    }

    public void setVoto(Character voto) {
        this.voto = voto;
    }

    public WA2P_Utente getIdU() {
        return idU;
    }

    public void setIdU(WA2P_Utente idU) {
        this.idU = idU;
    }

    public WA2P_Evento getEvento() {
        return evento;
    }

    public void setEvento(WA2P_Evento evento) {
        this.evento = evento;
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
        if (!(object instanceof WA2P_Commento)) {
            return false;
        }
        WA2P_Commento other = (WA2P_Commento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.WA2P_Commento[ id=" + id + " ]";
    }
    
}
