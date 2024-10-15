package org.elis.businesslogic;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.elis.dao.DaoFactory;
import org.elis.model.Genere;
import org.elis.model.Gioco;
import org.elis.model.Libreria;
import org.elis.model.Offerta;
import org.elis.model.Ricorrenza;
import org.elis.model.Utente;

public class BusinessLogic {
	
	private static String implementation = "JPA";
	
	public static Utente loginUtente(String email, String password) {
		
		for(Utente u : getAllUtenti()) {
			if(u.getEmail().equals(email) && u.getPassword().equals(password)) {	
				return u;
			}
		}
		return null;
	}
	
	//Aggiungere stringa in getDaoFactory per metodo di gestione dati
	public static Utente getUtenteById(long id) {
		return DaoFactory.getDaoFactory(implementation).getUtenteDAO().getUtenteById(id);
	}	
	public static Utente getUtenteByName(String nome) {
		return DaoFactory.getDaoFactory(implementation).getUtenteDAO().getUtenteByName(nome);
	}
	public static List<Utente> getAllUtenti() {
		return DaoFactory.getDaoFactory(implementation).getUtenteDAO().getAllUtenti();
	}	
	public static Utente addUtente(int ruoloIntValue, String username, String email, String password, String nome, String cognome, String telefono, String indirizzo, String sitoWeb, String comuneResidenza, LocalDate dataNascita) {
		return DaoFactory.getDaoFactory(implementation).getUtenteDAO().addUtente(ruoloIntValue, username, email, password,nome, cognome, telefono, indirizzo, sitoWeb, comuneResidenza, dataNascita);
	}
	public static Utente updateUtenteUsername(Utente utenteLoggato, String newUsername) {
		return DaoFactory.getDaoFactory(implementation).getUtenteDAO().updateUtenteUsername(utenteLoggato, newUsername);
	}	
	public static Utente updateUtentePassword(Utente utenteLoggato, String newPassword) {
		return DaoFactory.getDaoFactory(implementation).getUtenteDAO().updateUtentePassword(utenteLoggato, newPassword);
	}	
	public static Utente updateUtenteDataNascita(Utente utenteLoggato, LocalDate newDataNascita) {
		return DaoFactory.getDaoFactory(implementation).getUtenteDAO().updateUtenteDataNascita(utenteLoggato, newDataNascita);
	}
	public static void deleteUtenteByNome(String nome) {
		DaoFactory.getDaoFactory(implementation).getUtenteDAO().deleteUtenteByNome(nome);
	}
	
	public static Gioco addGioco(String nome, LocalDate dataRilascio, String descrizione, String imagePath, double prezzo, Offerta offerta,
			Utente utente) {
		return DaoFactory.getDaoFactory(implementation).getGiocoDAO().addGioco(nome, dataRilascio, descrizione, imagePath, prezzo, offerta, utente);
	}
	public static Gioco getGiocoByName(String nome) {
		return DaoFactory.getDaoFactory(implementation).getGiocoDAO().getGiocoByName(nome);
	}
	public static Gioco getGiocoById(long id) {
		return DaoFactory.getDaoFactory(implementation).getGiocoDAO().getGiocoById(id);
		
	}
	
	public static List<Gioco> getGiochiByUtente(Utente utente){
		return DaoFactory.getDaoFactory(implementation).getGiocoDAO().getGiochiByUtente(utente);
	}
	
	public static List<Gioco> getAllGiochi(){
		return DaoFactory.getDaoFactory(implementation).getGiocoDAO().getAllGiochi();
	}
	public static List<Gioco> getAllGiochiByGenere(long genereId){
		return DaoFactory.getDaoFactory(implementation).getGiocoDAO().getAllGiochiByGenere(genereId);
	}
	public static Gioco updateGiocoNome(Gioco gioco, String nome) {
		return DaoFactory.getDaoFactory(implementation).getGiocoDAO().updateGiocoNome(gioco, nome);
	}
	public static Gioco updateGiocoImmagine(Gioco gioco, String path) {
		return DaoFactory.getDaoFactory(implementation).getGiocoDAO().updateGiocoImmagine(gioco, path);
	}
	public static Gioco updateGiocoDataRilascio(Gioco gioco, LocalDate dataRilascio) {
		return DaoFactory.getDaoFactory(implementation).getGiocoDAO().updateGiocoDataRilascio(gioco, dataRilascio);
	}
	public static Gioco updateGiocoDescrizione(Gioco gioco, String descrizione) {
		return DaoFactory.getDaoFactory(implementation).getGiocoDAO().updateGiocoDescrizione(gioco, descrizione);
	}
	public static Gioco updateGiocoPrezzo(Gioco gioco, double prezzo) {
		return DaoFactory.getDaoFactory(implementation).getGiocoDAO().updateGiocoPrezzo(gioco, prezzo);
	}
	public static void deleteGiocoById(long id) {
		DaoFactory.getDaoFactory(implementation).getGiocoDAO().deleteGiocoById(id);
	}
	
	public static void deleteGiocoByNome(String nome) {
		DaoFactory.getDaoFactory(implementation).getGiocoDAO().deleteGiocoByNome(nome);
	}
	

	
	public static Libreria aggiungiGiocoALibreria(Utente utente, Gioco gioco) {
		return DaoFactory.getDaoFactory(implementation).getLibreriaDAO().aggiungiGiocoALibreria(utente, gioco);
	}
	public static Libreria getLibreriaByName(String nome) {
		return DaoFactory.getDaoFactory(implementation).getLibreriaDAO().getLibreriaByName(nome);
	}	
	public static List<Libreria> getAllLibrerie(){
		return DaoFactory.getDaoFactory(implementation).getLibreriaDAO().getAllLibrerie();
	}
	public static Libreria updateLibreriaById(long id, String nuovoNome) {
		return DaoFactory.getDaoFactory(implementation).getLibreriaDAO().updateLibreriaById(id, nuovoNome);
	}
	public static Libreria deleteLibreriaByNome(String nome) {
		return DaoFactory.getDaoFactory(implementation).getLibreriaDAO().deleteLibreriaByNome(nome);
	}
	
	public static Genere addGenere(String nome) {
		return DaoFactory.getDaoFactory(implementation).getGenereDAO().addGenere(nome);
	}
	
	public static Genere aggiungiGiocoaGenere (long genereId, long giocoId) {
		return DaoFactory.getDaoFactory(implementation).getGenereDAO().aggiungiGiocoaGenere(genereId, giocoId);
	}
	public static Genere getGenereByName(String nome) {
		return DaoFactory.getDaoFactory(implementation).getGenereDAO().getGenereByName(nome);
	}
	public static List<Genere> getAllGenere() {

		return DaoFactory.getDaoFactory(implementation).getGenereDAO().getAllGenere();
	}
	public static Genere updateGenereNome(Genere genere, String nuovoNome) {
		return DaoFactory.getDaoFactory(implementation).getGenereDAO().updateGenereNome(genere, nuovoNome);
	}
	public static Genere updateGenereOfferta(Genere genere, Offerta nuovaOfferta) {
		return DaoFactory.getDaoFactory(implementation).getGenereDAO().updateGenereOfferta(genere, nuovaOfferta);
	}
	public static Genere deleteGenereByName(String nome) {
		return DaoFactory.getDaoFactory(implementation).getGenereDAO().deleteByName(nome);
	}
	
	public static Offerta addOfferta(Ricorrenza ricorrenza, double sconto, LocalDate dataInizio, LocalDate dataFine, String nome) {
		return DaoFactory.getDaoFactory(implementation).getOffertaDAO().addOfferta(ricorrenza, sconto, dataInizio, dataFine, nome);
	}
	public static Offerta getOffertaById(long id) {
		return DaoFactory.getDaoFactory(implementation).getOffertaDAO().getOffertaById(id);
	}
	public static List<Offerta> getAllOfferta() {
		return DaoFactory.getDaoFactory(implementation).getOffertaDAO().getAllOfferta();
	}
	public static Offerta updateOffertaNome(Offerta offerta, String nome) {
		return DaoFactory.getDaoFactory(implementation).getOffertaDAO().updateOffertaNome(offerta, nome);
	}
	public static Offerta updateOffertaDataInizio(Offerta offerta, Timestamp dataInizio) {
		return DaoFactory.getDaoFactory(implementation).getOffertaDAO().updateOffertaDataInizio(offerta, dataInizio);
	}
	public static Offerta updateOffertaDataFine(Offerta offerta, Timestamp dataFine) {
		return DaoFactory.getDaoFactory(implementation).getOffertaDAO().updateOffertaDataFine(offerta, dataFine);
	}
	public static Offerta updateOffertaSconto(Offerta offerta, double sconto) {
		return DaoFactory.getDaoFactory(implementation).getOffertaDAO().updateOffertaSconto(offerta, sconto);
	}
	public static Offerta deleteOffertaById(long id) {
		return DaoFactory.getDaoFactory(implementation).getOffertaDAO().deleteOffertaById(id);
	}
}