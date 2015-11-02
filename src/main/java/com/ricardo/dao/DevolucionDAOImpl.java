/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ricardo.dao;

import com.ricardo.model.Devolucion;
import com.ricardo.model.Usuario;
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
public class DevolucionDAOImpl implements DevolucionDAO{

     EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");

    public void save(Devolucion devolucion) {
        EntityManager em = null;
        EntityTransaction tx = null;
        try {
            em = emf.createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            em.persist(devolucion);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void delete(Devolucion devolucion) {
        EntityManager em = null;
        EntityTransaction tx = null;

        try {
            em = emf.createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            em.remove(devolucion);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public List<Devolucion> findAll() {
        EntityManager em = null;
        List<Devolucion> devoluciones = new ArrayList<Devolucion>();
        try {
            em = emf.createEntityManager();
            TypedQuery<Devolucion> query = (TypedQuery<Devolucion>) em.createQuery("SELECT r FROM Devolucion r");
            devoluciones = query.getResultList();
            return devoluciones;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return null;
    }

    public Usuario findById(int id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Usuario.class, id);
    }

    public void edit(Devolucion devolucion) {
        EntityManager em = null;
        EntityTransaction tx = null;

        try {
            em = emf.createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            em.merge(devolucion);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            em.close();
        }
    }
    
}
