/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionnegocio.persistencia;

import gestionnegocio.entidades.Categoria;
import gestionnegocio.entidades.Producto;
import gestionnegocio.entidades.Proveedor;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author brunopc
 */
public class ProductoDAO {
    
    
    //=======================================
    //=============AGREGAR NUEVO=============
    //=======================================
    public void addProducto(Producto producto) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("GNPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(producto);
        em.getTransaction().commit();
    }
    //======================================
    //=============CONSULTAS================
    //======================================

    public List<Producto> consultarStock() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("GNPU");
        EntityManager em = emf.createEntityManager();
        try {
            List<Producto> productos = em.createQuery("SELECT p FROM Producto p WHERE p.cantidad>=1").getResultList();
            return productos;
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Producto> consultarCategoria(Categoria categoria) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("GNPU");
        EntityManager em = emf.createEntityManager();
        try {
            List<Producto> productos = em.createQuery("SELECT p FROM Producto p JOIN p.categoria "
                    + "c WHERE c.id=:categoriaId").setParameter("categoriaId", categoria.getId()).getResultList();
            return productos;

        } catch (Exception e) {
            throw e;
        }
    }
    
    
    
    
    
    //BUSCAR POR ID
    public Producto buscarPorId(String id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("GNPU");
        EntityManager em = emf.createEntityManager();
        try {
            Producto producto = (Producto) em.createQuery("SELEC pro FROM Producto pro WHERE "
                    + "pro.id=:id").setParameter("id", id).getSingleResult();
            return producto;
        } catch (Exception e) {
            throw e;
        }
    }
    
    //VER LISTA DE PRODUCTOS
    public List<Producto> obtenerProductos(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("GNPU");
        EntityManager em = emf.createEntityManager();
        try {
            
            List<Producto> productos = em.createQuery("SELECT p  FROM "
                    + "Producto p").getResultList();
            return productos;
        } catch (Exception e) {
            throw e;
        }
        
        
    }
    
    
    
    //BUSCAR PRODUCTOS POR ID PROVEEDOR
    public List<Producto> consultarProveedor(String id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("GNPU");
        EntityManager em = emf.createEntityManager();
        try {
            List<Producto> productos = em.createQuery("SELECT p FROM Producto p JOIN FETCH p.proveedor "
                    + "c WHERE c.id_proveedor=:id").setParameter("id", id).getResultList();
            return productos;

        } catch (Exception e) {
            throw e;
        }
    }
    
    //BUSCAR PRODUCTOS POR CATEGORIA
    public List<Producto> consultarCategoria(String id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("GNPU");
        EntityManager em = emf.createEntityManager();
        try {
            List<Producto> productos = em.createQuery("SELECT p FROM Producto p JOIN FETCH p.categoria "
                    + "c WHERE c.categoria=:id").setParameter("id", id).getResultList();
            return productos;

        } catch (Exception e) {
            throw e;
        }
    }
    
    
    //BUSCAR CATEGORIA Y PROVEEDOR
    public List<Producto> consultarProducto(String idCategoria, String idProveedor) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("GNPU");
    EntityManager em = emf.createEntityManager();
    List<Producto> productos;
    try {
        if(idCategoria == null && idProveedor != null){
            productos = consultarProveedor(idProveedor);
        }else if(idCategoria != null && idProveedor == null){
            productos = consultarCategoria(idCategoria);
        }else if(idCategoria != null && idProveedor != null){
            productos = em.createQuery(
            "SELECT p FROM Producto p " +
            "JOIN FETCH p.categoria c " +
            "JOIN FETCH p.proveedor pr " +
            "WHERE c.categoria = :idCategoria AND pr.id_proveedor = :idProveedor"
        )
        .setParameter("idCategoria", idCategoria)
        .setParameter("idProveedor", idProveedor)
        .getResultList();
        }else{
            productos = obtenerProductos();
        }
        

        return productos;
    } catch (Exception e) {
        throw e;
    }
}


   

    public int totalProductos() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("GNPU");
        EntityManager em = emf.createEntityManager();
        List<Producto> productos = em.createQuery("SELECT p FROM Producto p").getResultList();
        int cantidadTot = productos.size();
        return cantidadTot;
    }
    
    
    //======================================
    //=============MODIFICACIONES================
    //======================================
    
    

}
