package org.elis.dao.JPA;

import java.time.LocalDate;
import java.util.List;

import org.elis.dao.GiocoDAO;
import org.elis.model.Gioco;
import org.elis.model.Offerta;
import org.elis.model.Utente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

public class JPAGiocoDao implements GiocoDAO{

	
	private JPAGiocoDao() {}
	private static JPAGiocoDao instance;
	public static JPAGiocoDao getInstance() {
if(instance == null) {
			
			instance = new JPAGiocoDao();
		}
		
		return instance;
	}	
	
	@Override
	public Gioco addGioco(String nome, LocalDate dataRilascio, String descrizione, String imagePath, double prezzo,
			Offerta idOfferta, Utente utente) {
		
		Gioco g = new Gioco();
		g.setNome(nome);
		g.setDataRilascio(dataRilascio);
		g.setDescrizione(descrizione);
		g.setImagePath(imagePath);
		g.setPrezzo(prezzo);
		
		EntityManager em = JPADaoFactory.getEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(g);
		t.commit();
		
		return g;
	}

	@Override
	public Gioco getGiocoByName(String nome) {
		EntityManager em = JPADaoFactory.getEntityManager();
		Query q = em.createQuery("SELECT g FROM Gioco g WHERE g.nome = :nome");
		q.setParameter("nome", nome);
		return (Gioco) q.getSingleResult();
		
	}

	@Override
	public Gioco getGiocoById(long id) {
		EntityManager em = JPADaoFactory.getEntityManager();
		return em.find(Gioco.class, id);
	}
	
	@Override
	public List<Gioco> getGiochiByUtente(Utente utente) {
		EntityManager em = JPADaoFactory.getEntityManager();
		Query q = em.createQuery("SELECT g FROM Utente u JOIN u.giochi g WHERE u.id = :utenteId");
		q.setParameter("utenteId", utente.getId());
		return q.getResultList();
	}

	@Override
	public List<Gioco> getAllGiochi() {
		EntityManager em = JPADaoFactory.getEntityManager();
		Query q = em.createQuery("Select g FROM Gioco g");
		return q.getResultList();
	}

	@Override
	public List<Gioco> getAllGiochiByGenere(long genere) {
		EntityManager em = JPADaoFactory.getEntityManager();
		Query q = em.createQuery("Select g FROM Gioco g JOIN g.generi gen WHERE gen.id = idGenere");
		q.setParameter("genere", genere);
		return q.getResultList();
	}

	@Override
	public Gioco updateGiocoNome(Gioco gioco, String nome) {
		
		EntityManager em = JPADaoFactory.getEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		gioco.setNome(nome);
		gioco = em.merge(gioco);
		t.commit();
		return gioco;
	}

	@Override
	public Gioco updateGiocoImmagine(Gioco gioco, String path) {
		EntityManager em = JPADaoFactory.getEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		gioco.setImagePath(path);
		gioco = em.merge(gioco);
		t.commit();
		return gioco;
	}

	@Override
	public Gioco updateGiocoDataRilascio(Gioco gioco, LocalDate dataRilascio) {
		
		EntityManager em = JPADaoFactory.getEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		gioco.setDataRilascio(dataRilascio);
		gioco = em.merge(gioco);
		t.commit();
		return gioco;
	}

	@Override
	public Gioco updateGiocoDescrizione(Gioco gioco, String descrizione) {
		
		EntityManager em = JPADaoFactory.getEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		gioco.setDescrizione(descrizione);
		gioco = em.merge(gioco);
		t.commit();
		return gioco;
	}

	@Override
	public Gioco updateGiocoPrezzo(Gioco gioco, double prezzo) {
		EntityManager em = JPADaoFactory.getEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		gioco.setPrezzo(prezzo);
		gioco = em.merge(gioco);
		t.commit();
		return gioco;
	}

	@Override
	public void deleteGiocoById(long id) {
		EntityManager em = JPADaoFactory.getEntityManager();
		Gioco gioco = em.find(Gioco.class, id);
		EntityTransaction t = em.getTransaction();
		if (gioco != null) {
            gioco.rimuoviTuttiGliUtenti();
            t.begin();
            em.remove(gioco);
            t.commit();
        }
	}

	@Override
	public void deleteGiocoByNome(String nome) {
		
		EntityManager em = JPADaoFactory.getEntityManager();
		Query q = em.createQuery("SELECT g FROM Gioco g WHERE g.nome = :nome");
		q.setParameter("nome", nome);
		Gioco gioco = (Gioco) q.getSingleResult();
		EntityTransaction t = em.getTransaction();
		if (gioco != null) {
            gioco.rimuoviTuttiGliUtenti();
            t.begin();
            em.remove(gioco);
            t.commit();
		
		}
	}
}