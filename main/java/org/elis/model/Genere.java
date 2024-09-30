package org.elis.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Genere {
	
	private long id;
	private LocalDateTime  dataCreazione;
	private LocalDateTime  dataUltimaModifica;
	
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
}