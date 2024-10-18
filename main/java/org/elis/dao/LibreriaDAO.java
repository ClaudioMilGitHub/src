package org.elis.dao;

import java.util.List;

import org.elis.model.Gioco;
import org.elis.model.Libreria;
import org.elis.model.Utente;

public interface LibreriaDAO {

	Libreria aggiungiGiocoALibreria(Utente utente, Gioco gioco);
    List<Libreria> getLibreriaByName(String nome);
    List<Libreria> getAllLibrerie();
    Libreria updateLibreriaById(long id, String nuovoNome);
    void deleteLibreriaByNome(String nome);
    Libreria getLibreriaById(long id);
	Libreria deleteLibreriaById(long id);
	
}