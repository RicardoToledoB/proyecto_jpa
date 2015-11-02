/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ricardo.dao;

import com.ricardo.model.Solicitud;
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
public class SolicitudDAOImpl implements SolicitudDAO {
 EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");

    public void save(Solicitud solicitud) {
        EntityManager em = null;
        EntityTransaction tx = null;
        try {
            em = emf.createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            em.persist(solicitud);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void delete(Solicitud solicitud) {
        EntityManager em = null;
        EntityTransaction tx = null;

        try {
            em = emf.createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            em.remove(solicitud);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public List<Solicitud> findAll() {
        EntityManager em = null;
        List<Solicitud> solicitudes = new ArrayList<Solicitud>();
        try {
            em = emf.createEntityManager();
            TypedQuery<Solicitud> query = (TypedQuery<Solicitud>) em.createQuery("SELECT r FROM Solicitud r");
            solicitudes = query.getResultList();
            return solicitudes;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return null;
    }

    public Solicitud findById(int id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Solicitud.class, id);
    }

    public void edit(Solicitud solicitud) {
        EntityManager em = null;
        EntityTransaction tx = null;

        try {
            em = emf.createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            em.merge(solicitud);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            em.close();
        }
    }
    
}
