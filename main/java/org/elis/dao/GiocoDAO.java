package org.elis.dao;

import java.time.LocalDate;
import java.util.List;

import org.elis.model.Gioco;
import org.elis.model.Offerta;
import org.elis.model.Utente;

public interface GiocoDAO {
	
	Gioco addGioco(String nome, LocalDate dataRilascio, String descrizione, String imagePath, double prezzo, Offerta idOfferta,
			Utente utente);
	Gioco getGiocoByName(String nome);
	Gioco getGiocoById(long id);
	List<Gioco> getAllGiochi();
	List<Gioco> getAllGiochiByGenere(long genere);
	Gioco updateGiocoNome(Gioco gioco, String nome);
	Gioco updateGiocoImmagine(Gioco gioco, String path);
	Gioco updateGiocoDataRilascio(Gioco gioco, LocalDate dataRilascio);
	Gioco updateGiocoDescrizione(Gioco gioco, String descrizione);
	Gioco updateGiocoPrezzo(Gioco gioco, double prezzo);
	Gioco updateGiocoOfferta(Gioco gioco, Offerta offerta);
	void deleteGiocoByNome(String nome);
	List<Gioco> getGiochiByUtente(Utente utente);
	void deleteGiocoById(long id);
	List<Gioco> getAllGiochiByIdUtente(long idUtente);
}
