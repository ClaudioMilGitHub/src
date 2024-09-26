package org.elis.model;

import java.sql.Timestamp;
import java.util.List;
import java.util.ArrayList;

public class Utente {

	private long id;

	private Ruolo ruolo;
	
	private String username;
	private String email;
	private String password;
	
	private List<Recensione> recensioni = new ArrayList<>();
	private List<Libreria> librerie = new ArrayList<>();
	
	private Timestamp dataCreazione;
	private Timestamp dataUltimaModifica;
	
	public Utente(long id, Ruolo ruolo, String username, String email, String password) {
		this.id = id;
		this.ruolo = ruolo;
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public Utente() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Ruolo getRuolo() {
		return ruolo;
	}

	public void setRuolo(Ruolo ruolo) {
		this.ruolo = ruolo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Recensione> getRecensioni() {
		return recensioni;
	}

	public void setRecensioni(List<Recensione> recensioni) {
		this.recensioni = recensioni;
	}

	public List<Libreria> getLibrerie() {
		return librerie;
	}

	public void setLibrerie(List<Libreria> librerie) {
		this.librerie = librerie;
	}

	public Timestamp getDataCreazione() {
		return dataCreazione;
	}

	public void setDataCreazione(Timestamp dataCreazione) {
		this.dataCreazione = dataCreazione;
	}

	public Timestamp getDataUltimaModifica() {
		return dataUltimaModifica;
	}

	public void setDataUltimaModifica(Timestamp dataUltimaModifica) {
		this.dataUltimaModifica = dataUltimaModifica;
	}
}