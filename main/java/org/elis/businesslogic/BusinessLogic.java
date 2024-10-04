package org.elis.businesslogic;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import org.elis.dao.DAOfactory;
import org.elis.model.Genere;
import org.elis.model.Gioco;
import org.elis.model.Libreria;
import org.elis.model.Offerta;
import org.elis.model.Utente;

public class BusinessLogic {
	
	public static Utente loginUtente(String email, String password) {
		
		for(Utente u : getAllUtenti()) {
			if(u.getEmail().equals(email) && u.getPassword().equals(password)) {	
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
	public static Utente updateUtenteUsername(Utente utenteLoggato, String newUsername) {
		return DAOfactory.getDaoFactory().getUtenteDAO().updateUtenteUsername(utenteLoggato, newUsername);
	}	
	public static Utente updateUtentePassword(Utente utenteLoggato, String newPassword) {
		return DAOfactory.getDaoFactory().getUtenteDAO().updateUtentePassword(utenteLoggato, newPassword);
	}	
	public static Utente updateUtenteDataNascita(Utente utenteLoggato, LocalDate newDataNascita) {
		return DAOfactory.getDaoFactory().getUtenteDAO().updateUtenteDataNascita(utenteLoggato, newDataNascita);
	}
	public static Utente deleteUtenteByNome(String nome) {
		return DAOfactory.getDaoFactory().getUtenteDAO().deleteUtenteByNome(nome);
	}
	
	public static Gioco addGioco(String nome, LocalDate dataRilascio, String descrizione, double prezzo, Offerta offerta, Utente utente) {
		return DAOfactory.getDaoFactory().getGiocoDAO().addGioco(nome, dataRilascio, descrizione, prezzo, offerta, utente);
	}
	public static Gioco getGiocoByName(String nome) {
		return DAOfactory.getDaoFactory().getGiocoDAO().getGiocoByName(nome);
	}
	public static Gioco getGiocoById(long id) {
		return DAOfactory.getDaoFactory().getGiocoDAO().getGiocoById(id);
	}
	public static List<Gioco> getAllGiochi(){
		return DAOfactory.getDaoFactory().getGiocoDAO().getAllGiochi();
	}
	public static Gioco updateGiocoNome(Gioco gioco, String nome) {
		return DAOfactory.getDaoFactory().getGiocoDAO().updateGiocoNome(gioco, nome);
	}
	public static Gioco updateGiocoImmagine(Gioco gioco, String path) {
		return DAOfactory.getDaoFactory().getGiocoDAO().updateGiocoImmagine(gioco, path);
	}
	public static Gioco updateGiocoDataRilascio(Gioco gioco, LocalDate dataRilascio) {
		return DAOfactory.getDaoFactory().getGiocoDAO().updateGiocoDataRilascio(gioco, dataRilascio);
	}
	public static Gioco updateGiocoDescrizione(Gioco gioco, String descrizione) {
		return DAOfactory.getDaoFactory().getGiocoDAO().updateGiocoDescrizione(gioco, descrizione);
	}
	public static Gioco updateGiocoPrezzo(Gioco gioco, double prezzo) {
		return DAOfactory.getDaoFactory().getGiocoDAO().updateGiocoPrezzo(gioco, prezzo);
	}
	public static Gioco deleteGiocoByNome(String nome) {
		return DAOfactory.getDaoFactory().getGiocoDAO().deleteGiocoByNome(nome);
	}
	
	public static Libreria addLibreria(String nome, Utente utente, Gioco gioco) {
		return DAOfactory.getDaoFactory().getLibreriaDAO().addLibreria(nome, utente, gioco);
	}
	public static Libreria getLibreriaByName(String nome) {
		return DAOfactory.getDaoFactory().getLibreriaDAO().getLibreriaByName(nome);
	}	
	public static List<Libreria> getAllLibrerie(){
		return DAOfactory.getDaoFactory().getLibreriaDAO().getAllLibrerie();
	}
	public static Libreria updateLibreriaById(long id, String nuovoNome) {
		return DAOfactory.getDaoFactory().getLibreriaDAO().updateLibreriaById(id, nuovoNome);
	}
	public static Libreria deleteLibreriaByNome(String nome) {
		return DAOfactory.getDaoFactory().getLibreriaDAO().deleteLibreriaByNome(nome);
	}
	
	public static Genere addGenere(String nome) {
		return DAOfactory.getDaoFactory().getGenereDAO().addGenere(nome);
	}
	public static Genere getGenereByName(String nome) {
		return DAOfactory.getDaoFactory().getGenereDAO().getGenereByName(nome);
	}
	public static List<Genere> getAllGenere() {

		return DAOfactory.getDaoFactory().getGenereDAO().getAllGenere();
	}
	public static Genere updateGenereNome(Genere genere, String nuovoNome) {
		return DAOfactory.getDaoFactory().getGenereDAO().updateGenereNome(genere, nuovoNome);
	}
	public static Genere updateGenereOfferta(Genere genere, Offerta nuovaOfferta) {
		return DAOfactory.getDaoFactory().getGenereDAO().updateGenereOfferta(genere, nuovaOfferta);
	}
	public static Genere deleteGenereByName(String nome) {
		return DAOfactory.getDaoFactory().getGenereDAO().deleteByName(nome);
	}
	
	public static Offerta addOfferta(Offerta offerta) {
		return DAOfactory.getDaoFactory().getOffertaDAO().addOfferta(offerta);
	}
	public static Offerta getOffertaById(long id) {
		return DAOfactory.getDaoFactory().getOffertaDAO().getOffertaById(id);
	}
	public static List<Offerta> getAllOfferta() {
		return DAOfactory.getDaoFactory().getOffertaDAO().getAllOfferta();
	}
	public static Offerta updateOffertaNome(Offerta offerta, String nome) {
		return DAOfactory.getDaoFactory().getOffertaDAO().updateOffertaNome(offerta, nome);
	}
	public static Offerta updateOffertaDataInizio(Offerta offerta, Timestamp dataInizio) {
		return DAOfactory.getDaoFactory().getOffertaDAO().updateOffertaDataInizio(offerta, dataInizio);
	}
	public static Offerta updateOffertaDataFine(Offerta offerta, Timestamp dataFine) {
		return DAOfactory.getDaoFactory().getOffertaDAO().updateOffertaDataFine(offerta, dataFine);
	}
	public static Offerta updateOffertaSconto(Offerta offerta, double sconto) {
		return DAOfactory.getDaoFactory().getOffertaDAO().updateOffertaSconto(offerta, sconto);
	}
	public static Offerta deleteOffertaById(long id) {
		return DAOfactory.getDaoFactory().getOffertaDAO().deleteOffertaById(id);
	}
}