package org.elis.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.elis.model.Gioco;

public interface GiocoDAO {
	
	Gioco addGioco(String nome, LocalDateTime dataRilascio, String descrizione, double prezzo, Integer idOfferta, Integer idCasaEditrice);
	Gioco getByName(String nome);
	List<Gioco> getAll();
	Gioco update(String nome);
	Gioco deleteByNome(String nome);
}
