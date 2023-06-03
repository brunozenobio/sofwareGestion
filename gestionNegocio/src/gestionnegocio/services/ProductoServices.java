/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionnegocio.services;

import gestionnegocio.entidades.*;
import gestionnegocio.persistencia.ProductoDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

/**
 *
 * @author brunopc
 */
public class ProductoServices {
    ProductoDAO pDAO = new ProductoDAO();

    private Scanner read = new Scanner(System.in).useDelimiter("\n");
    
    //=======================================
    //=============AGREGAR NUEVO=============
    //=======================================
    public Producto crearProducto(String codigo,String nombre,String marca,String 
            descripcion,int cantidad,double precioSinIva,
            Proveedor prov, Categoria cat) throws Exception {
        Producto producto = new Producto();
        producto.setId(UUID.randomUUID().toString());
        producto.setId_categoria(cat);
        producto.setId_proveedor(prov);
        System.out.println("Creando producto: ");
        double precioConIva = precioSinIva * 0.21;
        try {
            if (codigo == null || codigo.trim().isEmpty()) {
                throw new Exception("Debe indicar el codigo del producto");
            }
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre");
            }
            if (marca == null || marca.trim().isEmpty()) {
                throw new Exception("Debe indicar una marca");
            }
            if (cantidad < 0) {
                throw new Exception("Debe ingresar una cantidad correcta");
            }
            if (precioSinIva <= 0) {
                throw new Exception("Debe indicar el precio de lista");
            }

        } catch (Exception e) {
            throw e;
        }

        producto.setCodigo_producto(codigo);
        producto.setNombre(nombre);
        producto.setMarca(marca);
        producto.setDescripcion(descripcion);
        producto.setCantidad(cantidad);
        producto.setPrecio_sin_IVA(precioSinIva);
        producto.setPrecio_con_IVA(precioConIva);
        pDAO.addProducto(producto);
        //METODO PARA AGREGAR EL PRODUCTO
        return producto;
    }

    
    //======================================
    //=============CONSULTAS================
    //======================================
    public Producto consultarCodigo(String codigo){
       return  pDAO.buscarPorCodigo(codigo);
    }
    
    public List<Producto> consultarNombre(String nombre){
       return  pDAO.buscarPorNombre(nombre);
    }
    
    public List<Producto> obtenerProductos(String id_proveedor,String id_categoria){
        try {
            return pDAO.consultarProducto(id_categoria, id_proveedor);
            
        } catch (Exception e) {
            throw e;
        }
    }
    
    public List<Producto> obtenerProductos(){
        try {
            return pDAO.obtenerProductos();
            
        } catch (Exception e) {
            throw e;
        }
    }
    public List<Producto> consultarProductosEnStock(){
        
        try {
            return pDAO.consultarStock();
            
        } catch (Exception e) {
            throw e;
        }
        
    }
    
    
    //======================================
    //=============MODIFICACIONES================
    //======================================

    public void borrarProducto(Producto producto){
        try {
            if(producto != null){
                pDAO.deleteProducto(producto);
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    

}
