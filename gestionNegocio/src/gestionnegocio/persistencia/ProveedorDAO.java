/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionnegocio.persistencia;

import gestionnegocio.entidades.Proveedor;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author brunopc
 */
public class ProveedorDAO {

    public void agregarProvedor(Proveedor proveedor) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("GNPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(proveedor);
        em.getTransaction().commit();

    }

    public Proveedor buscarProvedor(String nombre) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("GNPU");
        EntityManager em = emf.createEntityManager();
        try {
            Proveedor proveedor = (Proveedor) em.createQuery("SELECT p FROM Proveedor p WHERE p.nombre=:nombre").setParameter("nombre", nombre).getSingleResult();
            return proveedor;
        } catch (Exception e) {
            throw e;
        }
    }

}
