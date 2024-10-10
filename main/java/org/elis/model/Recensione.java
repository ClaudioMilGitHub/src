package org.elis.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


import jakarta.persistence.ManyToOne;


public class Recensione {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "is_recommended")
	private boolean isRecommended;
	@Column(name = "testo")
	private String testo;
	
	
	@ManyToOne
	private Utente utente;
	@ManyToOne
	private Gioco gioco;
	
	
	
	public Recensione(Long id, Boolean isRecommended, String testo) {
		this.id= id;
		this.isRecommended = isRecommended;
		this.testo = testo;
	}

	public boolean isRecommended() {
		return isRecommended;
	}

	public void setRecommended(boolean isRecommended) {
		this.isRecommended = isRecommended;
	}

	public String getTesto() {
		return testo;
	}

	public void setTesto(String testo) {
		this.testo = testo;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public Gioco getGioco() {
		return gioco;
	}

	public void setGioco(Gioco gioco) {
		this.gioco = gioco;
	}
}