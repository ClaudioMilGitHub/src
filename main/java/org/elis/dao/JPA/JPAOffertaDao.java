package org.elis.dao.JPA;

import java.sql.Timestamp;
import java.util.List;

import org.elis.dao.OffertaDAO;
import org.elis.model.Offerta;
import org.elis.model.Ricorrenza;

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
	public Offerta addOfferta(Offerta offerta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Offerta getOffertaById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Offerta> getAllOfferta() {
		// TODO Auto-generated method stub
		return null;
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
