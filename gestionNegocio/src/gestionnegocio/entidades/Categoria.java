/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionnegocio.entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author brunopc
 */
@Entity
public class Categoria implements Serializable {

    @Id
    private String id_categoria;
    private String nombre;

    public String getId() {
        return id_categoria;
    }

    public void setId(String id) {
        this.id_categoria = id;
    }

    public String getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(String id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_categoria != null ? id_categoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categoria)) {
            return false;
        }
        Categoria other = (Categoria) object;
        if ((this.id_categoria == null && other.id_categoria != null) || (this.id_categoria != null && !this.id_categoria.equals(other.id_categoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gestionnegocio.Categoria[ id=" + id_categoria + " ]";
    }
    
}
