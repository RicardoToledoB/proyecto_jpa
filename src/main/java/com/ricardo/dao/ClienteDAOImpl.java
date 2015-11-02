/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ricardo.dao;

import com.ricardo.model.Cliente;
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
public class ClienteDAOImpl implements ClienteDAO{

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");

    public void save(Cliente cliente) {
        EntityManager em = null;
        EntityTransaction tx = null;
        try {
            em = emf.createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            em.persist(cliente);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void delete(Cliente cliente) {
        EntityManager em = null;
        EntityTransaction tx = null;

        try {
            em = emf.createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            em.remove(cliente);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public List<Cliente> findAll() {
        EntityManager em = null;
        List<Cliente> clientes = new ArrayList<Cliente>();
        try {
            em = emf.createEntityManager();
            TypedQuery<Cliente> query = (TypedQuery<Cliente>) em.createQuery("SELECT r FROM Cliente r");
            clientes = query.getResultList();
            return clientes;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return null;
    }

    public Cliente findById(int id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Cliente.class, id);
    }

    public void edit(Cliente cliente) {
        EntityManager em = null;
        EntityTransaction tx = null;

        try {
            em = emf.createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            em.merge(cliente);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            em.close();
        }
    }
}
