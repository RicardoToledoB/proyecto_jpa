/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ricardo.dao;

import com.ricardo.model.Bodega;
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
public class BodegaDAOImpl implements BodegaDAO{

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");

    public void save(Bodega bodega) {
        EntityManager em = null;
        EntityTransaction tx = null;
        try {
            em = emf.createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            em.persist(bodega);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void delete(Bodega bodega) {
        EntityManager em = null;
        EntityTransaction tx = null;

        try {
            em = emf.createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            em.remove(bodega);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public List<Bodega> findAll() {
        EntityManager em = null;
        List<Bodega> bodegas = new ArrayList<Bodega>();
        try {
            em = emf.createEntityManager();
            TypedQuery<Bodega> query = (TypedQuery<Bodega>) em.createQuery("SELECT r FROM Bodega r");
            bodegas = query.getResultList();
            return bodegas;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return null;
    }

    public Bodega findById(int id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Bodega.class, id);
    }

    public void edit(Bodega bodega) {
        EntityManager em = null;
        EntityTransaction tx = null;

        try {
            em = emf.createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            em.merge(bodega);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            em.close();
        }
    }
    
}
