/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ricardo.dao;

import com.ricardo.model.Marca;
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
public class MarcaDAOImpl implements MarcaDAO {
     EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");

    public void save(Marca marca) {
        EntityManager em = null;
        EntityTransaction tx = null;
        try {
            em = emf.createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            em.persist(marca);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void delete(Marca marca) {
        EntityManager em = null;
        EntityTransaction tx = null;

        try {
            em = emf.createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            em.remove(marca);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public List<Marca> findAll() {
        EntityManager em = null;
        List<Marca> marcas = new ArrayList<Marca>();
        try {
            em = emf.createEntityManager();
            TypedQuery<Marca> query = (TypedQuery<Marca>) em.createQuery("SELECT r FROM Marca r");
            marcas = query.getResultList();
            return marcas;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return null;
    }

    public Marca findById(int id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Marca.class, id);
    }

    public void edit(Marca marca) {
        EntityManager em = null;
        EntityTransaction tx = null;

        try {
            em = emf.createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            em.merge(marca);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            em.close();
        }
    }
    
}
