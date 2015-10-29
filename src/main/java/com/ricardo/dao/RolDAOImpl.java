/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ricardo.dao;

import com.ricardo.model.Rol;
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
public class RolDAOImpl implements RolDAO{
    
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("JPA-PU");
	
	public void save(Rol rol) {
		EntityManager em=null;
		EntityTransaction tx=null;
		
		try {
			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			em.persist(rol);
			tx.commit();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	
	public void delete(Rol rol) {
		EntityManager em=null;
		EntityTransaction tx=null;
		
		try {
			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			em.remove(rol);
			tx.commit();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	
	public List<Rol> findAll() {
		EntityManager em=null;
		List<Rol> roles = new ArrayList<Rol>();
		
		try {
			em = emf.createEntityManager();
			TypedQuery<Rol> query = (TypedQuery<Rol>) em.createQuery("SELECT r FROM Rol r");
			roles = query.getResultList();
                        return roles;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
                return null;
	}

	
	public void edit(Rol rol) {
		EntityManager em=null;
		EntityTransaction tx=null;
		
		try {
			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			em.merge(rol);
			tx.commit();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
                   
                    em.close();
		}
	}
}
