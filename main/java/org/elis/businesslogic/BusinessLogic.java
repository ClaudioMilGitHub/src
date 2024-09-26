package org.elis.businesslogic;

import java.time.LocalDateTime;
import java.util.List;
import org.elis.dao.DAOfactory;
import org.elis.model.Gioco;
import org.elis.model.Libreria;
import org.elis.model.Utente;

public class BusinessLogic {
	
	public static Utente getUtenteByName(String nome) {
		return DAOfactory.getDaoFactory().getUtenteDAO().getUtenteByName(nome);
	}
	
	public static List<Utente> getAllUtenti() {
		return DAOfactory.getDaoFactory().getUtenteDAO().getAllUtenti();
	}
	
	public static Utente addUtente(int ruolo, String username, String email, String password) {
		return DAOfactory.getDaoFactory().getUtenteDAO().addUtente(ruolo, username, email, password);
	}
	
	public static Gioco addGioco(String nome, LocalDateTime dataRilascio, String descrizione, double prezzo, Integer idOfferta, Integer idCasaEditrice) {
		return DAOfactory.getDaoFactory().getGiocoDAO().addGioco(nome, dataRilascio, descrizione, prezzo, idOfferta, idCasaEditrice);
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
}