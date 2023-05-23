/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionnegocio.persistencia;

import gestionnegocio.entidades.Categoria;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author brunopc
 */
public class CategoriaDAO {

    public void addCategoria(Categoria categoria) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("GNPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(categoria);
        em.getTransaction().commit();

    }

    public Categoria buscatarCategoriaPorNombre(String nombre) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("GNPU");
        EntityManager em = emf.createEntityManager();
        try {
            Categoria categoria = (Categoria) em.createQuery("SELECT c FROM Categoria c WHERE c.nombre=:nombre"
                    + "").setParameter("nombre", nombre).getSingleResult();
            return categoria;
        } catch (Exception e) {
            throw e;
        }

    }

}
