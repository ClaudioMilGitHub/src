package org.elis.model;

import java.time.LocalDateTime;
import java.util.List;

public class Libreria {
	
	private long id;
	private String nome;
	
	private LocalDateTime dataCreazione;
	private LocalDateTime dataUltimaModifica;
	
	private Utente utente;
	private List<Gioco> giochi;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public List<Gioco> getGiochi() {
		return giochi;
	}

	public void setGiochi(List<Gioco> giochi) {
		this.giochi = giochi;
	}
}