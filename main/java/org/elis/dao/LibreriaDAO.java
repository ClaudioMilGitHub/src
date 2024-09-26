package org.elis.dao;

import java.util.List;

import org.elis.model.Gioco;
import org.elis.model.Libreria;
import org.elis.model.Utente;

public interface LibreriaDAO {

	Libreria addLibreria(String nome, Utente utente, Gioco gioco);
	Libreria getLibreriaByName(String nome);
	List<Libreria> getAllLibrerie();
	Libreria updateLibreria(String nome);
	Libreria deleteLibreriaByNome(String nome);
}
