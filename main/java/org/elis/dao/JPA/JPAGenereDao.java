package org.elis.dao.JPA;

import java.util.List;

import org.elis.dao.GenereDAO;
import org.elis.model.*;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

public class JPAGenereDao implements GenereDAO{

private JPAGenereDao() {}
	
	private static JPAGenereDao instance;
	public static JPAGenereDao getInstance() {
		if(instance == null) {
			
			instance = new JPAGenereDao();
		}
		
		return instance;
	}
	
	@Override
	public Genere addGenere(String nome) {
		
		Genere genere = new Genere();
		genere.setNome(nome);
		
		EntityManager em = JPADaoFactory.getEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(genere);
		t.commit();
		
		return genere;
		
	}
	
	public Genere aggiungiGiocoaGenere (long genereId, long giocoId) {

		EntityManager em = JPADaoFactory.getEntityManager();
		EntityTransaction t = em.getTransaction();

		t.begin();
		Genere genere = em.find(Genere.class, genereId);
		Gioco g = em.find(Gioco.class, giocoId);
		
		genere.getGiochi().add(g);
		
		em.persist(g);
		t.commit();
		em.close();
		
		return genere;
	}

	@Override
	public Genere getGenereByName(String nome) {
		EntityManager em = JPADaoFactory.getEntityManager();
		Query q = em.createQuery("SELECT g FROM Genere g WHERE g.nome = :nome");
		q.setParameter("nome", nome);
		return (Genere) q.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Genere> getAllGenere() {
		EntityManager em = JPADaoFactory.getEntityManager();
		Query q = em.createQuery("SELECT g FROM genere g");
		return q.getResultList();
	}

	@Override
	public Genere updateGenereNome(Genere genere, String nuovoNome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Genere updateGenereOfferta(Genere genere, Offerta nuovaOfferta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Genere deleteByName(String nome) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
