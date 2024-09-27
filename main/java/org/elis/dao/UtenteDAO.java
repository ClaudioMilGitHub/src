package org.elis.dao;

import java.time.LocalDate;
import java.util.List;

import org.elis.model.Utente;

public interface UtenteDAO {

	Utente addUtente(int ruolo, String username, String email, String password, LocalDate dataNascita);
	Utente getUtenteByName(String nome);
	Utente getUtenteById(long id);
	List<Utente> getAllUtenti();
	Utente deleteUtenteByNome(String nome);
	Utente updateUtenteUsername(Utente utenteLoggato, String newUsername);
	Utente updateUtentePassword(Utente utenteLoggato, String newPassword);
	Utente updateUtenteDataNascita(Utente utenteLoggato, LocalDate newDataNascita);
}