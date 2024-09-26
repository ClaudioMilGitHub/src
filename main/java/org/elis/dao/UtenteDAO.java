package org.elis.dao;

import java.util.List;

import org.elis.model.Utente;

public interface UtenteDAO {

	Utente add(int ruolo, String username, String email, String password);
	Utente getByName(String nome);
	List<Utente> getAll();
	Utente update(String nome);
	Utente deleteByNome(String nome);
}