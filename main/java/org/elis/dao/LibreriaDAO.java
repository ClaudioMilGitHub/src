package org.elis.dao;

import java.util.List;

import org.elis.model.Gioco;
import org.elis.model.Libreria;
import org.elis.model.Utente;

public interface LibreriaDAO {

	Libreria add(String nome, Utente utente, Gioco gioco);
	Libreria getByName(String nome);
	List<Libreria> getAll();
	Libreria update(String nome);
	Libreria deleteByNome(String nome);
}
