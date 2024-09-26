package org.elis.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Gioco {
	
	private Timestamp dataCreazione;
	private Timestamp dataUltimaModifica;
	private Timestamp dataRilascio;
	
	private String nome;
	private String descrizione;
	private double prezzo;
	
	private Integer idOffera;
	private Integer idCasaEditrice;
	
	private List<Genere> generi = new ArrayList<>();
	private List<Libreria> librerie = new ArrayList<>();
	
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
	public Timestamp getDataRilascio() {
		return dataRilascio;
	}
	public void setDataRilascio(Timestamp dataRilascio) {
		this.dataRilascio = dataRilascio;
	}
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
	public Integer getIdOffera() {
		return idOffera;
	}
	public void setIdOffera(Integer idOffera) {
		this.idOffera = idOffera;
	}
	public Integer getIdCasaEditrice() {
		return idCasaEditrice;
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
}