package org.elis.dao;

import java.util.List;

import org.elis.model.Gioco;
import org.elis.model.Libreria;
import org.elis.model.Utente;

public interface LibreriaDAO {

	Libreria aggiungiGiocoALibreria(Utente utente, Gioco gioco);
    Libreria getLibreriaByName(String nome);
    List<Libreria> getAllLibrerie();
    Libreria updateLibreriaById(long id, String nuovoNome);
    Libreria deleteLibreriaByNome(String nome);
    Libreria getLibreriaById(long id);
	
    
}