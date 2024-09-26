package org.elis.model;

public class Libreria {
	
	private String nome;
	private Utente utente;
	private Gioco gioco;

	public Libreria(String nome, Utente utente) {
		this.nome = nome;
		this.utente = utente;
	}

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

	public Gioco getGioco() {
		return gioco;
	}

	public void setGioco(Gioco gioco) {
		this.gioco = gioco;
	}
}