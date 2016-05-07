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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author FSEVERI\benetti3004
 */
@Entity
@Table(name = "WA2P_UTENTI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WA2P_Utente.findAll", query = "SELECT w FROM WA2P_Utente w"),
    @NamedQuery(name = "WA2P_Utente.findByNickname", query = "SELECT w FROM WA2P_Utente w WHERE w.nickname = :nickname"),
    @NamedQuery(name = "WA2P_Utente.findByNome", query = "SELECT w FROM WA2P_Utente w WHERE w.nome = :nome"),
    @NamedQuery(name = "WA2P_Utente.findByCognome", query = "SELECT w FROM WA2P_Utente w WHERE w.cognome = :cognome"),
    @NamedQuery(name = "WA2P_Utente.findByEmail", query = "SELECT w FROM WA2P_Utente w WHERE w.email = :email"),
    @NamedQuery(name = "WA2P_Utente.findByPw", query = "SELECT w FROM WA2P_Utente w WHERE w.pw = :pw")})
public class Utente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "nickname")
    private String nickname;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "cognome")
    private String cognome;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "pw")
    private String pw;
    @JoinTable(name = "WA2P_C_U", joinColumns = {
        @JoinColumn(name = "idU", referencedColumnName = "nickname")}, inverseJoinColumns = {
        @JoinColumn(name = "idC", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Categoria> wA2PCategoriaCollection;
    @OneToMany(mappedBy = "idU")
    private Collection<Commento> wA2PCommentoCollection;
    @OneToMany(mappedBy = "idU")
    private Collection<Evento> wA2PEventoCollection;

    public Utente() {
    }

    public Utente(String nickname) {
        this.nickname = nickname;
    }

    public Utente(String nickname, String nome, String cognome, String email, String pw) {
        this.nickname = nickname;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.pw = pw;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    @XmlTransient
    public Collection<Categoria> getWA2PCategoriaCollection() {
        return wA2PCategoriaCollection;
    }

    public void setWA2PCategoriaCollection(Collection<Categoria> wA2PCategoriaCollection) {
        this.wA2PCategoriaCollection = wA2PCategoriaCollection;
    }

    @XmlTransient
    public Collection<Commento> getWA2PCommentoCollection() {
        return wA2PCommentoCollection;
    }

    public void setWA2PCommentoCollection(Collection<Commento> wA2PCommentoCollection) {
        this.wA2PCommentoCollection = wA2PCommentoCollection;
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
        hash += (nickname != null ? nickname.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utente)) {
            return false;
        }
        Utente other = (Utente) object;
        if ((this.nickname == null && other.nickname != null) || (this.nickname != null && !this.nickname.equals(other.nickname))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.WA2P_Utente[ nickname=" + nickname + " ]";
    }
    
}
