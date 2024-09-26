package org.elis.model;

import java.util.ArrayList;
import java.util.List;

public class Genere {
	
	private String nome;
	private Offerta offerta;
	private List<Gioco> giochi = new ArrayList<>();
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Offerta getOfferta() {
		return offerta;
	}
	public void setOfferta(Offerta offerta) {
		this.offerta = offerta;
	}
	public List<Gioco> getGiochi() {
		return giochi;
	}
	public void setGiochi(List<Gioco> giochi) {
		this.giochi = giochi;
	}
}