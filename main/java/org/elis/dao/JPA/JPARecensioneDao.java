package org.elis.dao.JPA;

import java.util.List;

import org.elis.dao.RecensioneDAO;
import org.elis.model.Gioco;
import org.elis.model.Recensione;
import org.elis.model.Utente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

public class JPARecensioneDao implements RecensioneDAO {
	
	private JPARecensioneDao() {}
	
	private static JPARecensioneDao instance;
	public static JPARecensioneDao getInstance() {
		if(instance == null) {
			instance = new JPARecensioneDao();
		}
		return instance;
	}

	@Override
	public Recensione addRecensione(String testo, long idUtente, long idGioco) {
		
		Recensione recensione = new Recensione();
		recensione.setTesto(testo);
		
		EntityManager em = JPADaoFactory.getEntityManager();
		EntityTransaction t = em.getTransaction();
		
		Utente utente = em.find(Utente.class, idUtente);
		Gioco gioco = em.find(Gioco.class, idGioco);
		
		recensione.setUtente(utente);
		recensione.setGioco(gioco);
		
		t.begin();
		em.persist(recensione);
		t.commit();
		
		return recensione;
	}

	@Override
	public Recensione getRecensioneByUtente(Utente utente) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Recensione> getAllRecensioniByGame(long idGioco) {
		
		EntityManager em = JPADaoFactory.getEntityManager();
		Query q = em.createQuery("Select r from Recensione r where r.gioco.id = :idGioco");
		q.setParameter("idGioco", idGioco);
		return q.getResultList();	
	
	}

	@Override
	public Recensione updateRecensione() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteRecensione() {
		// TODO Auto-generated method stub
		
	}

}
