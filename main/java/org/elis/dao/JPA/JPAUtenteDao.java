package org.elis.dao.JPA;

import java.time.LocalDate;
import java.util.List;

import org.elis.dao.UtenteDAO;
import org.elis.model.Utente;

public class JPAUtenteDao implements UtenteDAO{

	private JPAUtenteDao() {}
	
	private static JPAUtenteDao instance;
	public static JPAUtenteDao getInstance() {
		if(instance == null) {
			
			instance = new JPAUtenteDao();
		}
		
		return instance;
	}
	@Override
	public Utente addUtente(Utente utente) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Utente getUtenteByName(String usernameSearch) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Utente getUtenteById(long id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Utente> getAllUtenti() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Utente deleteUtenteByNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Utente updateUtenteUsername(Utente utenteLoggato, String newUsername) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Utente updateUtentePassword(Utente utenteLoggato, String newPassword) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Utente updateUtenteDataNascita(Utente utenteLoggato, LocalDate newDataNascita) {
		// TODO Auto-generated method stub
		return null;
	}

}
