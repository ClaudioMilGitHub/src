package org.elis.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Utente {

	private long id;

	private Ruolo ruolo;
	
	private String username;
	private String email;
	private String password;
	private LocalDate dataNascita; 
	
	private List<Recensione> recensioni;
	private List<Libreria> librerie;
	
	private LocalDateTime dataCreazione;
	private LocalDateTime dataUltimaModifica;
	
	public Utente(long id, Ruolo ruolo, String username, String email, String password, LocalDate dataNascita) {
		this.id = id;
		this.ruolo = ruolo;
		this.username = username;
		this.email = email;
		this.password = password;
		this.dataNascita = dataNascita;
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

	public LocalDateTime getDataCreazione() {
		return dataCreazione;
	}

	public void setDataCreazione(LocalDateTime dataCreazione) {
		this.dataCreazione = dataCreazione;
	}

	public LocalDateTime getDataUltimaModifica() {
		return dataUltimaModifica;
	}

	public void setDataUltimaModifica(LocalDateTime dataUltimaModifica) {
		this.dataUltimaModifica = dataUltimaModifica;
	}

	public LocalDate getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(LocalDate dataNascita) {
		this.dataNascita = dataNascita;
	}
}