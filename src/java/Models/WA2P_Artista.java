/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;

/**
 *
 * @author FSEVERI\benetti3004
 */
@Entity
@Table(name = "WA2P_ARTISTI")

public class WA2P_Artista implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @Column(name = "nomeArte")
    private String nomeArte;
    @JoinTable(name = "WA2P_E_A", joinColumns = {
        @JoinColumn(name = "idA", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "idE", referencedColumnName = "id")})
    @ManyToMany
    private Collection<WA2P_Evento> wA2PEventoCollection;

    public WA2P_Artista() {
    }

    public WA2P_Artista(String id) {
        this.id = id;
    }

    public WA2P_Artista(String id, String nomeArte) {
        this.id = id;
        this.nomeArte = nomeArte;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomeArte() {
        return nomeArte;
    }

    public void setNomeArte(String nomeArte) {
        this.nomeArte = nomeArte;
    }



   
    
}
