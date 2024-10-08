package org.elis.dao;

import java.time.LocalDate;
import java.util.List;

import org.elis.businesslogic.BusinessLogic;
import org.elis.model.Utente;

public interface UtenteDAO {

	Utente addUtente(int ruoloIntValue, String username, String email, String password, String nome, String cognome, String telefono, String indirizzo, String sitoWeb, String comuneResidenza, LocalDate dataNascita);
	Utente getUtenteByName(String usernameSearch);
	Utente getUtenteById(long id);
	List<Utente> getAllUtenti();
	Utente deleteUtenteByNome(String nome);
	Utente updateUtenteUsername(Utente utenteLoggato, String newUsername);
	Utente updateUtentePassword(Utente utenteLoggato, String newPassword);
	Utente updateUtenteDataNascita(Utente utenteLoggato, LocalDate newDataNascita);
}