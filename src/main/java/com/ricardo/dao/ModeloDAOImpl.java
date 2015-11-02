/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ricardo.dao;

import com.ricardo.model.Modelo;
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
public class ModeloDAOImpl implements ModeloDAO{

     EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");

    public void save(Modelo modelo) {
        EntityManager em = null;
        EntityTransaction tx = null;
        try {
            em = emf.createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            em.persist(modelo);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void delete(Modelo modelo) {
        EntityManager em = null;
        EntityTransaction tx = null;

        try {
            em = emf.createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            em.remove(modelo);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public List<Modelo> findAll() {
        EntityManager em = null;
        List<Modelo> modelos = new ArrayList<Modelo>();
        try {
            em = emf.createEntityManager();
            TypedQuery<Modelo> query = (TypedQuery<Modelo>) em.createQuery("SELECT r FROM Modelo r");
            modelos = query.getResultList();
            return modelos;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return null;
    }

    public Modelo findById(int id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Modelo.class, id);
    }

    public void edit(Modelo modelo) {
        EntityManager em = null;
        EntityTransaction tx = null;

        try {
            em = emf.createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            em.merge(modelo);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            em.close();
        }
    }
    
}
