/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionnegcio.entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author brunopc
 */
@Entity
public class Producto implements Serializable {


    @Id
    private String id;
    private String codigo_producto;
    private String nombre;
    private String marca;
    private String descripcion;
    private int cantidad;
    private double precio_sin_IVA;
    private double precio_con_IVA;
    @ManyToOne
    private Proveedor id_proveedor;
    @ManyToOne
    private Categoria id_categoria;

    public String getNombre() {
        return nombre;
    }

    public Producto() {
        cantidad = 0;
    }
    

    public String getCodigo_producto() {
        return codigo_producto;
    }

    public void setCodigo_producto(String codigo_producto) {
        this.codigo_producto = codigo_producto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio_sin_IVA() {
        return precio_sin_IVA;
    }

    public void setPrecio_sin_IVA(double precio_sin_IVA) {
        this.precio_sin_IVA = precio_sin_IVA;
    }

    public double getPrecio_con_IVA() {
        return precio_con_IVA;
    }

    public void setPrecio_con_IVA(double precio_con_IVA) {
        this.precio_con_IVA = precio_con_IVA;
    }

    public Proveedor getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(Proveedor id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public Categoria getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(Categoria id_categoria) {
        this.id_categoria = id_categoria;
    }

    
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gestionnegocio.entidades.Productos[ id=" + id + " ]";
    }
    
}
