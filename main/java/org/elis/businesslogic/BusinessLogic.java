package org.elis.businesslogic;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import org.elis.dao.DaoFactory;
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
	
	//Aggiungere stringa in getDaoFactory per metodo di persistenza dati
	public static Utente getUtenteById(long id) {
		return DaoFactory.getDaoFactory("JDBC").getUtenteDAO().getUtenteById(id);
	}	
	public static Utente getUtenteByName(String nome) {
		return DaoFactory.getDaoFactory("JDBC").getUtenteDAO().getUtenteByName(nome);
	}
	public static List<Utente> getAllUtenti() {
		return DaoFactory.getDaoFactory("JDBC").getUtenteDAO().getAllUtenti();
	}	
	public static Utente addUtente(int ruoloIntValue, String username, String email, String password, String nome, String cognome, String telefono, String indirizzo, String sitoWeb, String comuneResidenza, LocalDate dataNascita) {
		return DaoFactory.getDaoFactory("JDBC").getUtenteDAO().addUtente(ruoloIntValue, username, email, password,nome, cognome, telefono, indirizzo, sitoWeb, comuneResidenza, dataNascita);
	}
	public static Utente updateUtenteUsername(Utente utenteLoggato, String newUsername) {
		return DaoFactory.getDaoFactory("JDBC").getUtenteDAO().updateUtenteUsername(utenteLoggato, newUsername);
	}	
	public static Utente updateUtentePassword(Utente utenteLoggato, String newPassword) {
		return DaoFactory.getDaoFactory("JDBC").getUtenteDAO().updateUtentePassword(utenteLoggato, newPassword);
	}	
	public static Utente updateUtenteDataNascita(Utente utenteLoggato, LocalDate newDataNascita) {
		return DaoFactory.getDaoFactory("JDBC").getUtenteDAO().updateUtenteDataNascita(utenteLoggato, newDataNascita);
	}
	public static Utente deleteUtenteByNome(String nome) {
		return DaoFactory.getDaoFactory("JDBC").getUtenteDAO().deleteUtenteByNome(nome);
	}
	
	public static Gioco addGioco(String nome, LocalDate dataRilascio, String descrizione, String imagePath, double prezzo, Offerta offerta,
			Utente utente) {
		return DaoFactory.getDaoFactory("JDBC").getGiocoDAO().addGioco(nome, dataRilascio, descrizione, imagePath, prezzo, offerta, utente);
	}
	public static Gioco getGiocoByName(String nome) {
		return DaoFactory.getDaoFactory("JDBC").getGiocoDAO().getGiocoByName(nome);
	}
	public static Gioco getGiocoById(long id) {
		return DaoFactory.getDaoFactory("JDBC").getGiocoDAO().getGiocoById(id);
	}
	public static List<Gioco> getAllGiochi(){
		return DaoFactory.getDaoFactory("JDBC").getGiocoDAO().getAllGiochi();
	}
	public static List<Gioco> getAllGiochiByGenere(long genereId){
		return DaoFactory.getDaoFactory("JDBC").getGiocoDAO().getAllGiochiByGenere(genereId);
	}
	public static Gioco updateGiocoNome(Gioco gioco, String nome) {
		return DaoFactory.getDaoFactory("JDBC").getGiocoDAO().updateGiocoNome(gioco, nome);
	}
	public static Gioco updateGiocoImmagine(Gioco gioco, String path) {
		return DaoFactory.getDaoFactory("JDBC").getGiocoDAO().updateGiocoImmagine(gioco, path);
	}
	public static Gioco updateGiocoDataRilascio(Gioco gioco, LocalDate dataRilascio) {
		return DaoFactory.getDaoFactory("JDBC").getGiocoDAO().updateGiocoDataRilascio(gioco, dataRilascio);
	}
	public static Gioco updateGiocoDescrizione(Gioco gioco, String descrizione) {
		return DaoFactory.getDaoFactory("JDBC").getGiocoDAO().updateGiocoDescrizione(gioco, descrizione);
	}
	public static Gioco updateGiocoPrezzo(Gioco gioco, double prezzo) {
		return DaoFactory.getDaoFactory("JDBC").getGiocoDAO().updateGiocoPrezzo(gioco, prezzo);
	}
	public static Gioco deleteGiocoByNome(String nome) {
		return DaoFactory.getDaoFactory("JDBC").getGiocoDAO().deleteGiocoByNome(nome);
	}
	
	public static Libreria addLibreria(String nome, Utente utente, Gioco gioco) {
		return DaoFactory.getDaoFactory("JDBC").getLibreriaDAO().addLibreria(nome, utente, gioco);
	}
	public static Libreria getLibreriaByName(String nome) {
		return DaoFactory.getDaoFactory("JDBC").getLibreriaDAO().getLibreriaByName(nome);
	}	
	public static List<Libreria> getAllLibrerie(){
		return DaoFactory.getDaoFactory("JDBC").getLibreriaDAO().getAllLibrerie();
	}
	public static Libreria updateLibreriaById(long id, String nuovoNome) {
		return DaoFactory.getDaoFactory("JDBC").getLibreriaDAO().updateLibreriaById(id, nuovoNome);
	}
	public static Libreria deleteLibreriaByNome(String nome) {
		return DaoFactory.getDaoFactory("JDBC").getLibreriaDAO().deleteLibreriaByNome(nome);
	}
	
	public static Genere addGenere(String nome) {
		return DaoFactory.getDaoFactory("JDBC").getGenereDAO().addGenere(nome);
	}
	public static Genere getGenereByName(String nome) {
		return DaoFactory.getDaoFactory("JDBC").getGenereDAO().getGenereByName(nome);
	}
	public static List<Genere> getAllGenere() {

		return DaoFactory.getDaoFactory("JDBC").getGenereDAO().getAllGenere();
	}
	public static Genere updateGenereNome(Genere genere, String nuovoNome) {
		return DaoFactory.getDaoFactory("JDBC").getGenereDAO().updateGenereNome(genere, nuovoNome);
	}
	public static Genere updateGenereOfferta(Genere genere, Offerta nuovaOfferta) {
		return DaoFactory.getDaoFactory("JDBC").getGenereDAO().updateGenereOfferta(genere, nuovaOfferta);
	}
	public static Genere deleteGenereByName(String nome) {
		return DaoFactory.getDaoFactory("JDBC").getGenereDAO().deleteByName(nome);
	}
	
	public static Offerta addOfferta(Offerta offerta) {
		return DaoFactory.getDaoFactory("JDBC").getOffertaDAO().addOfferta(offerta);
	}
	public static Offerta getOffertaById(long id) {
		return DaoFactory.getDaoFactory("JDBC").getOffertaDAO().getOffertaById(id);
	}
	public static List<Offerta> getAllOfferta() {
		return DaoFactory.getDaoFactory("JDBC").getOffertaDAO().getAllOfferta();
	}
	public static Offerta updateOffertaNome(Offerta offerta, String nome) {
		return DaoFactory.getDaoFactory("JDBC").getOffertaDAO().updateOffertaNome(offerta, nome);
	}
	public static Offerta updateOffertaDataInizio(Offerta offerta, Timestamp dataInizio) {
		return DaoFactory.getDaoFactory("JDBC").getOffertaDAO().updateOffertaDataInizio(offerta, dataInizio);
	}
	public static Offerta updateOffertaDataFine(Offerta offerta, Timestamp dataFine) {
		return DaoFactory.getDaoFactory("JDBC").getOffertaDAO().updateOffertaDataFine(offerta, dataFine);
	}
	public static Offerta updateOffertaSconto(Offerta offerta, double sconto) {
		return DaoFactory.getDaoFactory("JDBC").getOffertaDAO().updateOffertaSconto(offerta, sconto);
	}
	public static Offerta deleteOffertaById(long id) {
		return DaoFactory.getDaoFactory("JDBC").getOffertaDAO().deleteOffertaById(id);
	}
}