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
	private String nome;
	private String cognome;
	private String telefono;
	private String indirizzo;
	private String sitoWeb;
	private String comuneResidenza;
	
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getSitoWeb() {
		return sitoWeb;
	}

	public void setSitoWeb(String sitoWeb) {
		this.sitoWeb = sitoWeb;
	}

	public String getComuneResidenza() {
		return comuneResidenza;
	}

	public void setComuneResidenza(String comuneResidenza) {
		this.comuneResidenza = comuneResidenza;
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