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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Gioco getGiocoById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Gioco> getAllGiochi() {
		EntityManager em = JPADaoFactory.getEntityManager();
		Query q = em.createQuery("Select g FROM Gioco g");
		return q.getResultList();
	}

	@Override
	public List<Gioco> getAllGiochiByGenere(long genere) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Gioco updateGiocoNome(Gioco gioco, String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Gioco updateGiocoImmagine(Gioco gioco, String path) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Gioco updateGiocoDataRilascio(Gioco gioco, LocalDate dataRilascio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Gioco updateGiocoDescrizione(Gioco gioco, String descrizione) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Gioco updateGiocoPrezzo(Gioco gioco, double prezzo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Gioco deleteGiocoByNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
