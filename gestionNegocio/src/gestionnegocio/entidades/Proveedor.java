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
public class Proveedor implements Serializable {

    @Id
    private String id_proveedor;
    private String nombre;
    private String direccion;
    private String contacto;

    public String getId() {
        return id_proveedor;
    }

    public void setId(String id) {
        this.id_proveedor = id;
    }

    public String getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(String id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_proveedor != null ? id_proveedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proveedor)) {
            return false;
        }
        Proveedor other = (Proveedor) object;
        if ((this.id_proveedor == null && other.id_proveedor != null) || (this.id_proveedor != null && !this.id_proveedor.equals(other.id_proveedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gestionnegocio.entidades.Proveedores[ id=" + id_proveedor + " ]";
    }
    
}
