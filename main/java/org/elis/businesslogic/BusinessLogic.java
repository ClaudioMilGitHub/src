package org.elis.businesslogic;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

import org.elis.dao.DAOFactory;
import org.elis.model.*;

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
	
	public static boolean GameInLibreria(Utente user, Gioco game) {
		for(Gioco g : user.getGiochi()) {
			if(g.getNome().equalsIgnoreCase(game.getNome())) {
				return true;
			}
		}
		return false;
		
	}
	
	//Aggiungere stringa in getDaoFactory per metodo di gestione dati
	public static Utente getUtenteById(long id) {
		return DAOFactory.getDaoFactory(implementation).getUtenteDAO().getUtenteById(id);
	}	
	public static Utente getUtenteByName(String nome) {
		return DAOFactory.getDaoFactory(implementation).getUtenteDAO().getUtenteByName(nome);
	}
	public static List<Utente> getAllUtenti() {
		return DAOFactory.getDaoFactory(implementation).getUtenteDAO().getAllUtenti();
	}	
	public static Utente addUtente(int ruoloIntValue, String username, String email, String password, String nome, String cognome, String telefono, String indirizzo, String sitoWeb, String comuneResidenza, LocalDate dataNascita) {
		return DAOFactory.getDaoFactory(implementation).getUtenteDAO().addUtente(ruoloIntValue, username, email, password,nome, cognome, telefono, indirizzo, sitoWeb, comuneResidenza, dataNascita);
	}
	public static Utente updateUtenteUsername(Utente utenteLoggato, String newUsername) {
		return DAOFactory.getDaoFactory(implementation).getUtenteDAO().updateUtenteUsername(utenteLoggato, newUsername);
	}	
	public static Utente updateUtentePassword(Utente utenteLoggato, String newPassword) {
		return DAOFactory.getDaoFactory(implementation).getUtenteDAO().updateUtentePassword(utenteLoggato, newPassword);
	}	
	public static Utente updateUtenteDataNascita(Utente utenteLoggato, LocalDate newDataNascita) {
		return DAOFactory.getDaoFactory(implementation).getUtenteDAO().updateUtenteDataNascita(utenteLoggato, newDataNascita);
	}

	public static Utente updateUtenteSuspension(Utente utente, boolean suspension) {
		return DAOFactory.getDaoFactory(implementation).getUtenteDAO().updateUtenteSuspension(utente, suspension);
	}
	
	public static void deleteUtenteByNome(String nome) {
		DAOFactory.getDaoFactory(implementation).getUtenteDAO().deleteUtenteByNome(nome);
	}
	
	public static Gioco addGioco(String nome, LocalDate dataRilascio, String descrizione, String imagePath, double prezzo, Offerta offerta,
			Utente utente) {
		return DAOFactory.getDaoFactory(implementation).getGiocoDAO().addGioco(nome, dataRilascio, descrizione, imagePath, prezzo, offerta, utente);
	}
	public static Gioco getGiocoByName(String nome) {
		return DAOFactory.getDaoFactory(implementation).getGiocoDAO().getGiocoByName(nome);
	}
	public static Gioco getGiocoById(long id) {
		return DAOFactory.getDaoFactory(implementation).getGiocoDAO().getGiocoById(id);
		
	}
	
	public static List<Gioco> getGiochiByUtente(Utente utente){
		return DAOFactory.getDaoFactory(implementation).getGiocoDAO().getGiochiByUtente(utente);
	}
	
	public static List<Gioco> getAllGiochi(){
		return DAOFactory.getDaoFactory(implementation).getGiocoDAO().getAllGiochi();
	}
	public static List<Gioco> getAllGiochiByGenere(long genereId){
		return DAOFactory.getDaoFactory(implementation).getGiocoDAO().getAllGiochiByGenere(genereId);
	}
	
	public static List<Gioco> getAllGiochiByIdUtente(long idUtente){
		return DAOFactory.getDaoFactory(implementation).getGiocoDAO().getAllGiochiByIdUtente(idUtente);
	}

	public static Gioco updateGiocoNome(Gioco gioco, String nome) {
		return DAOFactory.getDaoFactory(implementation).getGiocoDAO().updateGiocoNome(gioco, nome);
	}
	public static Gioco updateGiocoImmagine(Gioco gioco, String path) {
		return DAOFactory.getDaoFactory(implementation).getGiocoDAO().updateGiocoImmagine(gioco, path);
	}
	public static Gioco updateGiocoDataRilascio(Gioco gioco, LocalDate dataRilascio) {
		return DAOFactory.getDaoFactory(implementation).getGiocoDAO().updateGiocoDataRilascio(gioco, dataRilascio);
	}
	public static Gioco updateGiocoDescrizione(Gioco gioco, String descrizione) {
		return DAOFactory.getDaoFactory(implementation).getGiocoDAO().updateGiocoDescrizione(gioco, descrizione);
	}
	public static Gioco updateGiocoPrezzo(Gioco gioco, double prezzo) {
		return DAOFactory.getDaoFactory(implementation).getGiocoDAO().updateGiocoPrezzo(gioco, prezzo);
	}
	public static void deleteGiocoById(long id) {
		DAOFactory.getDaoFactory(implementation).getGiocoDAO().deleteGiocoById(id);
	}
	
	public static void deleteGiocoByNome(String nome) {
		DAOFactory.getDaoFactory(implementation).getGiocoDAO().deleteGiocoByNome(nome);
	}
	

	
	public static Libreria aggiungiGiocoALibreria(Utente utente, Gioco gioco) {
		return DAOFactory.getDaoFactory(implementation).getLibreriaDAO().aggiungiGiocoALibreria(utente, gioco);
	}
	public static List<Libreria> getLibreriaByName(String nome) {
		return DAOFactory.getDaoFactory(implementation).getLibreriaDAO().getLibreriaByName(nome);
	}	
	public static List<Libreria> getAllLibrerie(){
		return DAOFactory.getDaoFactory(implementation).getLibreriaDAO().getAllLibrerie();
	}
	public static Libreria updateLibreriaById(long id, String nuovoNome) {
		return DAOFactory.getDaoFactory(implementation).getLibreriaDAO().updateLibreriaById(id, nuovoNome);
	}
	public static void deleteLibreriaByNome(String nome) {
		DAOFactory.getDaoFactory(implementation).getLibreriaDAO().deleteLibreriaByNome(nome);
	}
	
	
	public static Libreria deleteLibreriaById(long id) {
		return DAOFactory.getDaoFactory(implementation).getLibreriaDAO().deleteLibreriaById(id);
	}
	
	
	public static Genere addGenere(String nome) {
		return DAOFactory.getDaoFactory(implementation).getGenereDAO().addGenere(nome);
	}
	
	public static Genere aggiungiGiocoaGenere (long genereId, long giocoId) {
		return DAOFactory.getDaoFactory(implementation).getGenereDAO().aggiungiGiocoaGenere(genereId, giocoId);
	}
	public static Genere getGenereByName(String nome) {
		return DAOFactory.getDaoFactory(implementation).getGenereDAO().getGenereByName(nome);
	}
	public static List<Genere> getAllGenere() {

		return DAOFactory.getDaoFactory(implementation).getGenereDAO().getAllGenere();
	}
	public static Genere updateGenereNome(Genere genere, String nuovoNome) {
		return DAOFactory.getDaoFactory(implementation).getGenereDAO().updateGenereNome(genere, nuovoNome);
	}
	public static Genere updateGenereOfferta(Genere genere, Offerta nuovaOfferta) {
		return DAOFactory.getDaoFactory(implementation).getGenereDAO().updateGenereOfferta(genere, nuovaOfferta);
	}
	public static Genere deleteGenereByName(String nome) {
		return DAOFactory.getDaoFactory(implementation).getGenereDAO().deleteByName(nome);
	}
	
	public static Genere getGenereById(long id) {
		return DAOFactory.getDaoFactory(implementation).getGenereDAO().getGenereById(id);
	}
	
	public static Offerta addOfferta(Ricorrenza ricorrenza, double sconto, LocalDate dataInizio, LocalDate dataFine, String nome) {
		return DAOFactory.getDaoFactory(implementation).getOffertaDAO().addOfferta(ricorrenza, sconto, dataInizio, dataFine, nome);
	}
	public static Offerta getOffertaById(long id) {
		return DAOFactory.getDaoFactory(implementation).getOffertaDAO().getOffertaById(id);
	}
	public static List<Offerta> getAllOfferta() {
		return DAOFactory.getDaoFactory(implementation).getOffertaDAO().getAllOfferta();
	}
	public static Offerta updateOffertaNome(Offerta offerta, String nome) {
		return DAOFactory.getDaoFactory(implementation).getOffertaDAO().updateOffertaNome(offerta, nome);
	}
	public static Offerta updateOffertaDataInizio(Offerta offerta, Timestamp dataInizio) {
		return DAOFactory.getDaoFactory(implementation).getOffertaDAO().updateOffertaDataInizio(offerta, dataInizio);
	}
	public static Offerta updateOffertaDataFine(Offerta offerta, Timestamp dataFine) {
		return DAOFactory.getDaoFactory(implementation).getOffertaDAO().updateOffertaDataFine(offerta, dataFine);
	}
	public static Offerta updateOffertaSconto(Offerta offerta, double sconto) {
		return DAOFactory.getDaoFactory(implementation).getOffertaDAO().updateOffertaSconto(offerta, sconto);
	}
	public static Offerta deleteOffertaById(long id) {
		return DAOFactory.getDaoFactory(implementation).getOffertaDAO().deleteOffertaById(id);
	}
	
	public static Recensione addRecensione(String testo, long idUtente, long idGioco) {
		return DAOFactory.getDaoFactory(implementation).getRecensioneDAO().addRecensione(testo, idUtente, idGioco);
	}
	
	public static Recensione getRecensioneById(long idRecensione) {
		return DAOFactory.getDaoFactory(implementation).getRecensioneDAO().getRecensioneById(idRecensione);
	}
	
	public static Recensione updateTestoRecensione(Recensione recensione, String newTesto) {
		return DAOFactory.getDaoFactory(implementation).getRecensioneDAO().updateTestoRecensione(recensione, newTesto);
	}
	
	public static List<Recensione> getAllRecensioniByGame(long idGioco) {
		return DAOFactory.getDaoFactory(implementation).getRecensioneDAO().getAllRecensioniByGame(idGioco);
	}

	public static void deleteRecensioneById(long idRecensione) {
		DAOFactory.getDaoFactory(implementation).getRecensioneDAO().deleteRecensioneById(idRecensione);
		
	}
}