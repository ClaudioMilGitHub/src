package org.elis.businesslogic;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.elis.dao.DAOfactory;
import org.elis.model.Gioco;
import org.elis.model.Libreria;
import org.elis.model.Offerta;
import org.elis.model.Utente;

public class BusinessLogic {
	
	public static Utente loginUtente(String email, String password) {
		
		for(Utente u : getAllUtenti()) {
			if(u.getEmail().equals(email) && u.getPassword().equals(password)) {
				System.out.println("Email e password corrette!");
				return u;
			}
		}
		return null;
	}
	
	public static Utente getUtenteById(long id) {
		return DAOfactory.getDaoFactory().getUtenteDAO().getUtenteById(id);
	}
	
	public static Utente getUtenteByName(String nome) {
		return DAOfactory.getDaoFactory().getUtenteDAO().getUtenteByName(nome);
	}
	
	public static List<Utente> getAllUtenti() {
		return DAOfactory.getDaoFactory().getUtenteDAO().getAllUtenti();
	}
	
	public static Utente addUtente(int ruolo, String username, String email, String password, LocalDate dataNascita) {
		return DAOfactory.getDaoFactory().getUtenteDAO().addUtente(ruolo, username, email, password, dataNascita);
	}
	
	public static Gioco addGioco(String nome, LocalDateTime dataRilascio, String descrizione, double prezzo, Offerta offerta, Utente utente) {
		return DAOfactory.getDaoFactory().getGiocoDAO().addGioco(nome, dataRilascio, descrizione, prezzo, offerta, utente);
	}
	
	public static Gioco getGiocoByName(String nome) {
		return DAOfactory.getDaoFactory().getGiocoDAO().getGiocoByName(nome);
	}
	
	public static Gioco getGiocoById(long id) {
		return DAOfactory.getDaoFactory().getGiocoDAO().getGiocoById(id);
	}
	
	public static Libreria getLibreriaByName(String nome) {
		return DAOfactory.getDaoFactory().getLibreriaDAO().getLibreriaByName(nome);
	}
	
	public static List<Libreria> getAllLibrerie(){
		return DAOfactory.getDaoFactory().getLibreriaDAO().getAllLibrerie();
	}
	
	public static Offerta getOffertaById(long id) {
		return DAOfactory.getDaoFactory().getOffertaDAO().getOffertaById(id);
	}
}