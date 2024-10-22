package org.elis.dao;

import java.util.List;

import org.elis.model.Recensione;
import org.elis.model.Utente;

public interface RecensioneDAO {
	
	Recensione addRecensione(String testo, long idUtente, long idGioco);
	Recensione getRecensioneByUtente(Utente utente);
	List<Recensione> getAllRecensioniByGame(long idGioco);
	Recensione updateRecensione();
	void deleteRecensione();
	Recensione getRecensioneById(long idRecensione);
	Recensione updateTestoRecensione(Recensione recensione, String newTesto);
	void deleteRecensioneById(long idRecensione);

}
