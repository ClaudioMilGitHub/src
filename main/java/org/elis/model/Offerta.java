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

import java.sql.Timestamp;

public class Offerta {
    private long id;
    private String nome;
    private double sconto;
    private Timestamp dataInizio;
    private Timestamp dataFine;
    private long giocoId; 
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

    public long getGiocoId() {
        return giocoId;
    }

    public void setGiocoId(long giocoId) {
        this.giocoId = giocoId;
    }

    public Ricorrenza getRicorrenza() {
        return ricorrenza;
    }

    public void setRicorrenza(Ricorrenza ricorrenza) {
        this.ricorrenza = ricorrenza;
    }
}

