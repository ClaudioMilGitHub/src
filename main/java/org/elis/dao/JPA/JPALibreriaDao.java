package org.elis.dao.JPA;


import java.util.List;


import org.elis.dao.LibreriaDAO;
import org.elis.model.Gioco;
import org.elis.model.Libreria;
import org.elis.model.Utente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

public class JPALibreriaDao implements LibreriaDAO{

	
private JPALibreriaDao() {}
	
	private static JPALibreriaDao instance;
	public static JPALibreriaDao getInstance() {
		if(instance == null) {
			
			instance = new JPALibreriaDao();
		}
		
		return instance;
	}
	
	
	@Override
	public Libreria aggiungiGiocoALibreria(Utente utente, Gioco gioco) {
		
		Libreria l = new Libreria();
		l.setGioco(gioco);
		l.setUtente(utente);
		
		
		EntityManager em = JPADaoFactory.getEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(l);
		t.commit();

		return l;
				
	}

	@Override
	public Libreria getLibreriaByName(String nome) {
		EntityManager em = JPADaoFactory.getEntityManager();
		Query q = em.createQuery("SELECT l FROM Libreria l JOIN l.utente u WHERE u.username = :username");
		q.setParameter("username", nome);
		return (Libreria) q.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Libreria> getAllLibrerie() {
		EntityManager em = JPADaoFactory.getEntityManager();
		Query q = em.createQuery("Select l from Libreria l");
		return q.getResultList();
	}

	@Override
	public Libreria updateLibreriaById(long id, String nuovoNome) {
		  EntityManager em = JPADaoFactory.getEntityManager();
		  EntityTransaction t = em.getTransaction();
		  t.begin();
	      Libreria l = em.find(Libreria.class, id);
	      if (l != null) {
	            l.getUtente().setUsername(nuovoNome);
	            em.merge(l);
	            t.commit();
	      } else {
	            System.out.println("Impossibile trovare la libreria con l'ID specificato.");
	        }
		return null;
	}

	@Override
	public void deleteLibreriaByNome(String nome) {
		EntityManager em = JPADaoFactory.getEntityManager();
		Query q = em.createQuery("SELECT l FROM Libreria l JOIN l.utente u WHERE u.username = :username");
		q.setParameter("username", nome);
		Libreria l = (Libreria) q.getSingleResult();
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.remove(l);
		t.commit();
	}

	@Override
	public Libreria getLibreriaById(long id) {
		EntityManager em = JPADaoFactory.getEntityManager();
		return em.find(Libreria.class, id);
	}

}