package com.ricardo.dao;

import com.ricardo.model.Menu;
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
public class MenuDAOImpl implements MenuDAO{

     EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");

    public void save(Menu menu) {
        EntityManager em = null;
        EntityTransaction tx = null;
        try {
            em = emf.createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            em.persist(menu);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void delete(Menu menu) {
        EntityManager em = null;
        EntityTransaction tx = null;

        try {
            em = emf.createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            em.remove(menu);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public List<Menu> findAll() {
        EntityManager em = null;
        List<Menu> menus= new ArrayList<Menu>();
        try {
            em = emf.createEntityManager();
            TypedQuery<Menu> query = (TypedQuery<Menu>) em.createQuery("SELECT r FROM Menu r");
            menus = query.getResultList();
            return menus;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return null;
    }

    public Menu findById(int id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Menu.class, id);
    }

    public void edit(Menu menu) {
        EntityManager em = null;
        EntityTransaction tx = null;

        try {
            em = emf.createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            em.merge(menu);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            em.close();
        }
    }
    
}
