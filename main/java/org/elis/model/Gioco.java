package org.elis.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;

@Entity(name="Gioco")
public class Gioco {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@CreationTimestamp
	@Column(name="data_creazione", nullable = false)
	private LocalDateTime dataCreazione;
	
	@UpdateTimestamp
	@Column(name="data_ultima_modifica", nullable = false)
	private LocalDateTime dataUltimaModifica;
	
	@Column(name="data_rilascio", nullable = false)
	private LocalDate dataRilascio;
	
	@Column(name="nome", nullable = false)
	private String nome;
	@Column(name="descrizione", nullable = false)
	private String descrizione;
	@Column(name="image_path", nullable = false)
	private String imagePath;
	
	@Column(name="prezzo", nullable = false)
	private double prezzo;
	
	@ManyToMany
	private List<Genere> generi; 
	
	@ManyToMany(mappedBy = "giochi")
	private Set<Utente> utenti = new HashSet<>();
	
	public Gioco() {}

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

	public LocalDate getDataRilascio() {
		return dataRilascio;
	}

	public void setDataRilascio(LocalDate dataRilascio) {
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

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public List<Genere> getGeneri() {
		return generi;
	}

	public void setGeneri(List<Genere> generi) {
		this.generi = generi;
	}

	public Set<Utente> getUtenti() {
		return utenti;
	}

	public void setUtenti(Set<Utente> utenti) {
		this.utenti = utenti;
	}

}