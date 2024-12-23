package org.elis.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import java.util.List;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;

@Entity(name="Utente")
@Table(name="utente")
public class Utente {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@Column(name="ruolo")
	private Ruolo ruolo;
	
	@Column(name="username", unique = true, nullable = false)
	private String username;
	@Column(name="email", unique = true, nullable = false)
	private String email;
	@Column(name="password", nullable = false)
	private String password;
	@Column(name="nome", nullable = true)
	private String nome;
	@Column(name="cognome", nullable = true)
	private String cognome;
	@Column(name="telefono")
	private String telefono;
	@Column(name="indirizzo")
	private String indirizzo;
	@Column(name="sito_web")
	private String sitoWeb;
	@Column(name="comune_residenza")
	private String comuneResidenza;
	@Column(name="isSuspended")
	private boolean isSuspended;
	
	@Column(name="data_nascita", nullable = false)
	private LocalDate dataNascita; 
	
	@OneToMany(mappedBy = "utente")
	private List<Recensione> recensioni;
	
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
        name = "Libreria",
        joinColumns = @JoinColumn(name = "utente_id"),
        inverseJoinColumns = @JoinColumn(name = "gioco_id")
    )
    private List<Gioco> giochi = new ArrayList<>();
	
	@CreationTimestamp
	@Column(name="data_creazione", nullable = false)
	private LocalDateTime dataCreazione;
	
	@UpdateTimestamp
	@Column(name="data_ultima_modifica", nullable = false)
	private LocalDateTime dataUltimaModifica;
	
	public Utente(long id, Ruolo ruolo, String username, String email, String password, LocalDate dataNascita) {
		this.id = id;
		this.ruolo = ruolo;
		this.username = username;
		this.email = email;
		this.password = password;
		this.dataNascita = dataNascita;
	}

	public Utente() {}
	
	public boolean isSuspended() {
		return isSuspended;
	}

	public void setSuspended(boolean isSuspended) {
		this.isSuspended = isSuspended;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Ruolo getRuolo() {
		return ruolo;
	}

	public void setRuolo(Ruolo ruolo) {
		this.ruolo = ruolo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getSitoWeb() {
		return sitoWeb;
	}

	public void setSitoWeb(String sitoWeb) {
		this.sitoWeb = sitoWeb;
	}

	public String getComuneResidenza() {
		return comuneResidenza;
	}

	public void setComuneResidenza(String comuneResidenza) {
		this.comuneResidenza = comuneResidenza;
	}

	public LocalDate getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(LocalDate dataNascita) {
		this.dataNascita = dataNascita;
	}

	public List<Recensione> getRecensioni() {
		return recensioni;
	}

	public void setRecensioni(List<Recensione> recensioni) {
		this.recensioni = recensioni;
	}

	public List<Gioco> getGiochi() {
		return giochi;
	}

	public void setGiochi(List<Gioco> giochi) {
		this.giochi = giochi;
	}
	
	public void aggiungiGioco(Gioco gioco) {
        giochi.add(gioco);
        gioco.getUtenti().add(this);
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