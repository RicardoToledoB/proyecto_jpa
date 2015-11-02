package com.ricardo.dao;

import com.ricardo.model.Recepcion;
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
public class RecepcionDAOImpl implements RecepcionDAO{
     EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");

    public void save(Recepcion recepcion) {
        EntityManager em = null;
        EntityTransaction tx = null;
        try {
            em = emf.createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            em.persist(recepcion);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void delete(Recepcion recepcion) {
        EntityManager em = null;
        EntityTransaction tx = null;

        try {
            em = emf.createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            em.remove(recepcion);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public List<Recepcion> findAll() {
        EntityManager em = null;
        List<Recepcion> recepciones = new ArrayList<Recepcion>();
        try {
            em = emf.createEntityManager();
            TypedQuery<Recepcion> query = (TypedQuery<Recepcion>) em.createQuery("SELECT r FROM Recepcion r");
            recepciones = query.getResultList();
            return recepciones;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return null;
    }

    public Recepcion findById(int id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Recepcion.class, id);
    }

    public void edit(Recepcion recepcion) {
        EntityManager em = null;
        EntityTransaction tx = null;

        try {
            em = emf.createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            em.merge(recepcion);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            em.close();
        }
    }
    
}
