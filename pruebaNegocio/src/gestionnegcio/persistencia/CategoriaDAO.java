/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionnegcio.persistencia;

import gestionnegcio.entidades.Categoria;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author brunopc
 */
public class CategoriaDAO {

    
    //=======================================
    //=============AGREGAR NUEVO=============
    //=======================================
    public void addCategoria(Categoria categoria) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("GNPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(categoria);
        em.getTransaction().commit();

    }
    //======================================
    //=============CONSULTAS================
    //======================================
    
    //BUSCAR POR ID
    public Categoria buscarPorId(String id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("UN");
        EntityManager em = emf.createEntityManager();
        try {
            Categoria categoria = (Categoria) em.createQuery("SELEC c FROM Categoria c WHERE "
                    + "c.id_categoria=:id").setParameter("id", id).getSingleResult();
            return categoria;
        } catch (Exception e) {
            throw e;
        }
    }
    
    //VER LISTA DE CATEGORIAS
    public List<Categoria> obtenerCategorias(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("UN");
        EntityManager em = emf.createEntityManager();
        try {
            
            List<Categoria> categorias = em.createQuery("SELECT c  FROM "
                    + "Categoria c").getResultList();
            return categorias;
        } catch (Exception e) {
            throw e;
        }
        
        
    }
    
    
    
    
    
    
    
    

    public Categoria buscatarCategoriaPorNombre(String nombre) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("UN");
        EntityManager em = emf.createEntityManager();
        try {
            Categoria categoria = (Categoria) em.createQuery("SELECT c FROM Categoria c WHERE c.nombre=:nombre"
                    + "").setParameter("nombre", nombre).getSingleResult();
            return categoria;
        } catch (Exception e) {
            throw e;
        }

    }
    
    
    //======================================
    //=============MODIFICACIONES================
    //======================================

}
