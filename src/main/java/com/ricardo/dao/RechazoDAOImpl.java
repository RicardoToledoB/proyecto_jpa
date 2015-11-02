/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ricardo.dao;

import com.ricardo.model.Rechazo;
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
public class RechazoDAOImpl implements RechazoDAO {
     EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");

    public void save(Rechazo rechazo) {
        EntityManager em = null;
        EntityTransaction tx = null;
        try {
            em = emf.createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            em.persist(rechazo);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void delete(Rechazo rechazo) {
        EntityManager em = null;
        EntityTransaction tx = null;

        try {
            em = emf.createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            em.remove(rechazo);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public List<Rechazo> findAll() {
        EntityManager em = null;
        List<Rechazo> rechazos = new ArrayList<Rechazo>();
        try {
            em = emf.createEntityManager();
            TypedQuery<Rechazo> query = (TypedQuery<Rechazo>) em.createQuery("SELECT r FROM Rechazo r");
            rechazos = query.getResultList();
            return rechazos;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return null;
    }

    public Rechazo findById(int id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Rechazo.class, id);
    }

    public void edit(Rechazo rechazo) {
        EntityManager em = null;
        EntityTransaction tx = null;

        try {
            em = emf.createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            em.merge(rechazo);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            em.close();
        }
    }
    
}
