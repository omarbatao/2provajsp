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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author FSEVERI\reginato2906
 */
@Entity
@Table(name = "WA2P_EMAIL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Email.findAll", query = "SELECT e FROM Email e"),
    @NamedQuery(name = "Email.findByIdemail", query = "SELECT e FROM Email e WHERE e.idemail = :idemail"),
    @NamedQuery(name = "Email.findByNome", query = "SELECT e FROM Email e WHERE e.nome = :nome"),
    @NamedQuery(name = "Email.findByEmail", query = "SELECT e FROM Email e WHERE e.email = :email"),
    @NamedQuery(name = "Email.findByTesto", query = "SELECT e FROM Email e WHERE e.testo = :testo")})
public class Email implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id_email")
    private Integer idemail;
    @Basic(optional = false)
    @Column(name = "Nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "Email")
    private String email;
    @Basic(optional = false)
    @Column(name = "Testo")
    private String testo;

    public Email() {
    }

    public Email(Integer idemail) {
        this.idemail = idemail;
    }

    public Email(Integer idemail, String nome, String email, String testo) {
        this.idemail = idemail;
        this.nome = nome;
        this.email = email;
        this.testo = testo;
    }

    public Integer getIdemail() {
        return idemail;
    }

    public void setIdemail(Integer idemail) {
        this.idemail = idemail;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTesto() {
        return testo;
    }

    public void setTesto(String testo) {
        this.testo = testo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idemail != null ? idemail.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Email)) {
            return false;
        }
        Email other = (Email) object;
        if ((this.idemail == null && other.idemail != null) || (this.idemail != null && !this.idemail.equals(other.idemail))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.Email[ idemail=" + idemail + " ]";
    }
    
}
