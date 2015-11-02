package com.ricardo.dao;

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
public class UsuarioDAOImpl implements UsuarioDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");

    public void save(Usuario user) {
        EntityManager em = null;
        EntityTransaction tx = null;
        try {
            em = emf.createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            em.persist(user);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void delete(Usuario user) {
        EntityManager em = null;
        EntityTransaction tx = null;

        try {
            em = emf.createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            em.remove(user);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public List<Usuario> findAll() {
        EntityManager em = null;
        List<Usuario> usuarios = new ArrayList<Usuario>();
        try {
            em = emf.createEntityManager();
            TypedQuery<Usuario> query = (TypedQuery<Usuario>) em.createQuery("SELECT r FROM Usuario r");
            usuarios = query.getResultList();
            return usuarios;
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

    public void edit(Usuario user) {
        EntityManager em = null;
        EntityTransaction tx = null;

        try {
            em = emf.createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            em.merge(user);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            em.close();
        }
    }
}
