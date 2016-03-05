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
@Table(name = "WA2P_CATEGORIE")

public class WA2P_Categoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "nome")
    private String nome;
    @ManyToMany(mappedBy = "wA2PCategoriaCollection")
    private Collection<WA2P_Utente> wA2PUtenteCollection;
    @OneToMany(mappedBy = "categoria")
    private Collection<WA2P_Evento> wA2PEventoCollection;

    public WA2P_Categoria() {
    }

    public WA2P_Categoria(String id) {
        this.id = id;
    }

    public WA2P_Categoria(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    @Override
    public String toString() {
        return "Models.WA2P_Categoria[ id=" + id + " ]";
    }
    
}
