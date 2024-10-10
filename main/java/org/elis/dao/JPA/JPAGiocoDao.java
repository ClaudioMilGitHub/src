package org.elis.dao.JPA;

import java.time.LocalDate;
import java.util.List;

import org.elis.dao.GiocoDAO;
import org.elis.model.Gioco;
import org.elis.model.Offerta;
import org.elis.model.Utente;

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
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
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
