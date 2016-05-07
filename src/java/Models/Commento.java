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
    @NamedQuery(name = "Commento.findAll", query = "SELECT c FROM Commento c"),
    @NamedQuery(name = "Commento.findById", query = "SELECT c FROM Commento c WHERE c.id = :id"),
    @NamedQuery(name = "Commento.findByCommento", query = "SELECT c FROM Commento c WHERE c.commento = :commento"),
    @NamedQuery(name = "Commento.findByVoto", query = "SELECT c FROM Commento c WHERE c.voto = :voto")})
public class Commento implements Serializable {
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
    private Utente idU;
    @JoinColumn(name = "evento", referencedColumnName = "id")
    @ManyToOne
    private Evento evento;

    public Commento() {
    }

    public Commento(String id) {
        this.id = id;
    }

    public Commento(String id, String commento, Character voto) {
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

    public Utente getIdU() {
        return idU;
    }

    public void setIdU(Utente idU) {
        this.idU = idU;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
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
        if (!(object instanceof Commento)) {
            return false;
        }
        Commento other = (Commento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.Commento[ id=" + id + " ]";
    }
    
}
