package com.ricardo.dao;
import com.ricardo.model.Aprobado;
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
public class AprobadoDAOImpl implements AprobadoDAO{

     EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");

    public void save(Aprobado aprobado) {
        EntityManager em = null;
        EntityTransaction tx = null;
        try {
            em = emf.createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            em.persist(aprobado);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void delete(Aprobado aprobado) {
        EntityManager em = null;
        EntityTransaction tx = null;

        try {
            em = emf.createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            em.remove(aprobado);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public List<Aprobado> findAll() {
        EntityManager em = null;
        List<Aprobado> aprobados = new ArrayList<Aprobado>();
        try {
            em = emf.createEntityManager();
            TypedQuery<Aprobado> query = (TypedQuery<Aprobado>) em.createQuery("SELECT r FROM Aprobado r");
            aprobados = query.getResultList();
            return aprobados;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return null;
    }

    public Aprobado findById(int id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Aprobado.class, id);
    }

    public void edit(Aprobado aprobado) {
        EntityManager em = null;
        EntityTransaction tx = null;

        try {
            em = emf.createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            em.merge(aprobado);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            em.close();
        }
    }
    
}
