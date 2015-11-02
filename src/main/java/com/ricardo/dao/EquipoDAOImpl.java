package com.ricardo.dao;

import com.ricardo.model.Equipo;
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
public class EquipoDAOImpl implements EquipoDAO{

     EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");

    public void save(Equipo equipo) {
        EntityManager em = null;
        EntityTransaction tx = null;
        try {
            em = emf.createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            em.persist(equipo);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void delete(Equipo equipo) {
        EntityManager em = null;
        EntityTransaction tx = null;

        try {
            em = emf.createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            em.remove(equipo);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public List<Equipo> findAll() {
        EntityManager em = null;
        List<Equipo> equipos = new ArrayList<Equipo>();
        try {
            em = emf.createEntityManager();
            TypedQuery<Equipo> query = (TypedQuery<Equipo>) em.createQuery("SELECT r FROM Equipo r");
            equipos = query.getResultList();
            return equipos;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return null;
    }

    public Equipo findById(int id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Equipo.class, id);
    }

    public void edit(Equipo equipo) {
        EntityManager em = null;
        EntityTransaction tx = null;

        try {
            em = emf.createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            em.merge(equipo);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            em.close();
        }
    }
    
}
