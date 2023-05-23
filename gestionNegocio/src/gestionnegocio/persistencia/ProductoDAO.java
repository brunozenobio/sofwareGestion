/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionnegocio.persistencia;

import gestionnegocio.entidades.Categoria;
import gestionnegocio.entidades.Producto;
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

    public void addProducto(Producto producto) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("GNPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(producto);
        em.getTransaction().commit();
    }

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

}
