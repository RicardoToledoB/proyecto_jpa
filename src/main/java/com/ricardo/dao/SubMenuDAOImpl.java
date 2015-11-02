package com.ricardo.dao;

import com.ricardo.model.SubMenu;
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
public class SubMenuDAOImpl implements SubMenuDAO{
 EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");

    public void save(SubMenu submenu) {
        EntityManager em = null;
        EntityTransaction tx = null;
        try {
            em = emf.createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            em.persist(submenu);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void delete(SubMenu submenu) {
        EntityManager em = null;
        EntityTransaction tx = null;

        try {
            em = emf.createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            em.remove(submenu);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public List<SubMenu> findAll() {
        EntityManager em = null;
        List<SubMenu> submenu = new ArrayList<SubMenu>();
        try {
            em = emf.createEntityManager();
            TypedQuery<SubMenu> query = (TypedQuery<SubMenu>) em.createQuery("SELECT r FROM SubMenu r");
            submenu = query.getResultList();
            return submenu;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return null;
    }

    public SubMenu findById(int id) {
        EntityManager em = emf.createEntityManager();
        return em.find(SubMenu.class, id);
    }

    public void edit(SubMenu submenu) {
        EntityManager em = null;
        EntityTransaction tx = null;

        try {
            em = emf.createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            em.merge(submenu);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            em.close();
        }
    }
    
}
