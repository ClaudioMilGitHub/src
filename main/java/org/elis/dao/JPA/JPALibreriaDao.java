package org.elis.dao.JPA;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

	@Override
	public List<Libreria> getAllLibrerie() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Libreria updateLibreriaById(long id, String nuovoNome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Libreria deleteLibreriaByNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Libreria getLibreriaById(long id) {
		// TODO Auto-generated method stub
		return null;
	}
}