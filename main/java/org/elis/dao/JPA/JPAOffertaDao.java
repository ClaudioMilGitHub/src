package org.elis.dao.JPA;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

import org.elis.dao.OffertaDAO;
import org.elis.model.Offerta;
import org.elis.model.Ricorrenza;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

public class JPAOffertaDao implements OffertaDAO{

	
private JPAOffertaDao() {}
	
	private static JPAOffertaDao instance;
	public static JPAOffertaDao getInstance() {
		if(instance == null) {
			
			instance = new JPAOffertaDao();
		}
		
		return instance;
	}
	
	
	@Override
	public Offerta addOfferta(Ricorrenza ricorrenza, double sconto, LocalDate dataInizio, LocalDate dataFine, String nome) {
		
		Offerta o = new Offerta();
		o.setRicorrenza(ricorrenza);
		o.setSconto(sconto);
		o.setDataInizio(dataInizio);
		o.setDataFine(dataFine);
		o.setNome(nome);
		
		EntityManager em = JPADaoFactory.getEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(o);
		t.commit();
		
		return o;
		
	}

	@Override
	public Offerta getOffertaById(long id) {
		EntityManager em = JPADaoFactory.getEntityManager();
		return em.find(Offerta.class, id);
	}

	@Override
	public List<Offerta> getAllOfferta() {
		EntityManager em = JPADaoFactory.getEntityManager();
		Query q = em.createQuery("Select o FROM Offerta o");
		return q.getResultList();
	}

	@Override
	public List<Offerta> getOfferteByRicorrenza(Ricorrenza ricorrenza) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Offerta> getOfferteByGiocoId(long giocoId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Offerta deleteOffertaById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Offerta updateOffertaNome(Offerta offerta, String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Offerta updateOffertaDataInizio(Offerta offerta, Timestamp dataInizio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Offerta updateOffertaDataFine(Offerta offerta, Timestamp dataFine) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Offerta updateOffertaSconto(Offerta offerta, double sconto) {
		// TODO Auto-generated method stub
		return null;
	}
}