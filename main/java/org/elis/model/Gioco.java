package org.elis.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Gioco {
	
	private long id;
	private LocalDateTime  dataCreazione;
	private LocalDateTime  dataUltimaModifica;
	private LocalDateTime  dataRilascio;
	
	private String nome;
	private String descrizione;
	private double prezzo;
	
	private long idOfferta;
	private long idCasaEditrice;
	
	private List<Genere> generi = new ArrayList<>();
	private List<Libreria> librerie = new ArrayList<>();
	

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public void setIdCasaEditrice(Integer idCasaEditrice) {
		this.idCasaEditrice = idCasaEditrice;
	}
	public List<Genere> getGeneri() {
		return generi;
	}
	public void setGeneri(List<Genere> generi) {
		this.generi = generi;
	}
	public List<Libreria> getLibrerie() {
		return librerie;
	}
	public void setLibrerie(List<Libreria> librerie) {
		this.librerie = librerie;
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
	public LocalDateTime getDataRilascio() {
		return dataRilascio;
	}
	public void setDataRilascio(LocalDateTime dataRilascio) {
		this.dataRilascio = dataRilascio;
	}
	public long getIdOfferta() {
		return idOfferta;
	}
	public void setIdOfferta(long idOfferta) {
		this.idOfferta = idOfferta;
	}
	public long getIdCasaEditrice() {
		return idCasaEditrice;
	}
	public void setIdCasaEditrice(long idCasaEditrice) {
		this.idCasaEditrice = idCasaEditrice;
	}
}