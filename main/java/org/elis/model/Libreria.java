package org.elis.model;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity(name = "Libreria")
@Table(name="libreria")
public class Libreria {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@ManyToOne
	@JoinColumn(name="utente_id", nullable = false)
	private Utente utente;
	
	@ManyToOne
	@JoinColumn(name="gioco_id", nullable = false)
	private Gioco gioco;
	
	@Column(name="data_acquisto")
	private LocalDate dataAcquisto;
	
	@Column(name="tempo_gioco")
	private int tempoGioco;				//in minuti
	
	public Libreria() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public LocalDate getDataAcquisto() {
		return dataAcquisto;
	}

	public void setDataAcquisto(LocalDate dataAcquisto) {
		this.dataAcquisto = dataAcquisto;
	}

	public int getTempoGioco() {
		return tempoGioco;
	}

	public void setTempoGioco(int tempoGioco) {
		this.tempoGioco = tempoGioco;
	}
}