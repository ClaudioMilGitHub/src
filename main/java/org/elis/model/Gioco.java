package org.elis.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity(name="Gioco")
public class Gioco {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="data_creazione", columnDefinition="TIMESTAMP DEFAUL CURRENT_TIMESTAMP")
	private LocalDateTime  dataCreazione;
	@Column(name="data_ultima_modifica", columnDefinition="CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private LocalDateTime  dataUltimaModifica;
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
	
	@OneToMany(mappedBy="gioco")
	private Set<Libreria> librerie = new HashSet<>();
	
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

	public Set<Libreria> getLibrerie() {
		return librerie;
	}

	public void setLibrerie(Set<Libreria> librerie) {
		this.librerie = librerie;
	}
}