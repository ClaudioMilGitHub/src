/*package org.elis.model;

import java.sql.Timestamp;

public class Offerta {
    
    private long id;
    private String nome;
    private double sconto;
    private Timestamp dataInizio;
    private Timestamp dataFine;
    private Ricorrenza ricorrenza;  
    public Offerta() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSconto() {
        return sconto;
    }

    public void setSconto(double sconto) {
        this.sconto = sconto;
    }

    public Timestamp getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(Timestamp dataInizio) {
        this.dataInizio = dataInizio;
    }

    public Timestamp getDataFine() {
        return dataFine;
    }

    public void setDataFine(Timestamp dataFine) {
        this.dataFine = dataFine;
    }

    public Ricorrenza getRicorrenza() {  
        return ricorrenza;
    }

    public void setRicorrenza(Ricorrenza ricorrenza) {  
        this.ricorrenza = ricorrenza;
    }
}*/


package org.elis.model;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name = "Offerta")
public class Offerta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	@Column(name = "nome")
    private String nome;
	
	@Column(name = "sconto", nullable=false)
    private double sconto;
	
	@Column(name = "data_inizio", nullable=false)
    private LocalDate dataInizio;
	
	@Column(name = "data_Fine", nullable=false)
    private LocalDate dataFine;
	
	@OneToMany(mappedBy = "offerta")
	private List<Gioco> giochi = new ArrayList<>();
	
	@Enumerated(EnumType.ORDINAL)
    private Ricorrenza ricorrenza; 

    public Offerta() {}

    // Getters e Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSconto() {
        return sconto;
    }

    public void setSconto(double sconto) {
        this.sconto = sconto;
    }

    public LocalDate getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(LocalDate dataInizio) {
		this.dataInizio = dataInizio;
	}

	public LocalDate getDataFine() {
		return dataFine;
	}

	public void setDataFine(LocalDate dataFine) {
		this.dataFine = dataFine;
	}

	public List<Gioco> getGiochi() {
		return giochi;
	}

	public void setGiochi(List<Gioco> giochi) {
		this.giochi = giochi;
	}

	public Ricorrenza getRicorrenza() {
        return ricorrenza;
    }

    public void setRicorrenza(Ricorrenza ricorrenza) {
        this.ricorrenza = ricorrenza;
    }
}