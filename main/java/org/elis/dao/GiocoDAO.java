package org.elis.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.elis.model.Gioco;
import org.elis.model.Offerta;
import org.elis.model.Utente;

public interface GiocoDAO {
	
	Gioco addGioco(String nome, LocalDateTime dataRilascio, String descrizione, double prezzo, Offerta idOfferta,
			Utente utente);
	Gioco getGiocoByName(String nome);
	Gioco getGiocoById(long id);
	List<Gioco> getAllGiochi();
	Gioco updateGioco(String nome);
	Gioco deleteGiocoByNome(String nome);
}
