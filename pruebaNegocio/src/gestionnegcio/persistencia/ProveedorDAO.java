/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionnegcio.persistencia;

import gestionnegcio.entidades.Proveedor;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author brunopc
 */
public class ProveedorDAO {

    
    //=======================================
    //=============AGREGAR NUEVO=============
    //=======================================
    public void agregarProvedor(Proveedor proveedor) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("UN");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(proveedor);
        em.getTransaction().commit();

    }
    
    //======================================
    //=============CONSULTAS================
    //======================================

    public Proveedor buscarProvedor(String nombre) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("UN");
        EntityManager em = emf.createEntityManager();
        try {
            Proveedor proveedor = (Proveedor) em.createQuery("SELECT p FROM Proveedor p WHERE p.nombre=:nombre").setParameter("nombre", nombre).getSingleResult();
            return proveedor;
        } catch (Exception e) {
            throw e;
        }
    }
    
    
    //VER LISTA DE PROVEEDORES
    public List<Proveedor> obtenerProveedores(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("UN");
        EntityManager em = emf.createEntityManager();
        try {
            
            List<Proveedor> provedores = em.createQuery("SELECT p  FROM "
                    + "Proovedor p").getResultList();
            return provedores;
        } catch (Exception e) {
            throw e;
        }
        
        
    }
    
    
    
    //BUSCAR POR ID
    public Proveedor buscarPorId(String id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("UN");
        EntityManager em = emf.createEntityManager();
        try {
            Proveedor proveedor = (Proveedor) em.createQuery("SELEC pro FROM Proveedor pro WHERE "
                    + "pro.id_proveedor=:id").setParameter("id", id).getSingleResult();
            return proveedor;
        } catch (Exception e) {
            throw e;
        }
    }
    
    
    //======================================
    //=============MODIFICACIONES================
    //======================================

}
