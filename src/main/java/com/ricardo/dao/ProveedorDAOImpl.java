package com.ricardo.dao;

import com.ricardo.model.Proveedor;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author ricardo
 */
public class ProveedorDAOImpl implements ProveedorDAO{

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");

    public void save(Proveedor proveedor) {
        EntityManager em = null;
        EntityTransaction tx = null;
        try {
            em = emf.createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            em.persist(proveedor);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void delete(Proveedor proveedor) {
        EntityManager em = null;
        EntityTransaction tx = null;

        try {
            em = emf.createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            em.remove(proveedor);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public List<Proveedor> findAll() {
        EntityManager em = null;
        List<Proveedor> proveedores = new ArrayList<Proveedor>();
        try {
            em = emf.createEntityManager();
            TypedQuery<Proveedor> query = (TypedQuery<Proveedor>) em.createQuery("SELECT r FROM Proveeedor r");
            proveedores= query.getResultList();
            return proveedores;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return null;
    }

    public Proveedor findById(int id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Proveedor.class, id);
    }

    public void edit(Proveedor proveedor) {
        EntityManager em = null;
        EntityTransaction tx = null;

        try {
            em = emf.createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            em.merge(proveedor);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            em.close();
        }
    }
    
}
