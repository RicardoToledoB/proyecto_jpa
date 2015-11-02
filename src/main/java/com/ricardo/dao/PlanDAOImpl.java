package com.ricardo.dao;

import com.ricardo.model.Plan;
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
public class PlanDAOImpl implements PlanDAO {

     EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");

    public void save(Plan plan) {
        EntityManager em = null;
        EntityTransaction tx = null;
        try {
            em = emf.createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            em.persist(plan);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void delete(Plan plan) {
        EntityManager em = null;
        EntityTransaction tx = null;

        try {
            em = emf.createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            em.remove(plan);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public List<Plan> findAll() {
        EntityManager em = null;
        List<Plan> planes = new ArrayList<Plan>();
        try {
            em = emf.createEntityManager();
            TypedQuery<Plan> query = (TypedQuery<Plan>) em.createQuery("SELECT r FROM Plan r");
            planes = query.getResultList();
            return planes;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return null;
    }

    public Plan findById(int id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Plan.class, id);
    }

    public void edit(Plan plan) {
        EntityManager em = null;
        EntityTransaction tx = null;

        try {
            em = emf.createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            em.merge(plan);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            em.close();
        }
    }
    
}
