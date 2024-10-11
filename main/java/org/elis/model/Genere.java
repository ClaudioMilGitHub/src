package org.elis.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*; 

@Entity 
public class Genere {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private long id;
    
    @Column(name = "data_creazione", nullable = false) 
    private LocalDateTime dataCreazione;
    
    @Column(name = "data_ultima_modifica") 
    private LocalDateTime dataUltimaModifica;
    
    @Column(name = "nome", nullable = false, length = 100) 
    private String nome;
    
    @ManyToOne 
    @JoinColumn(name = "offerta_id") 
    private Offerta offerta;
    
    @OneToMany(mappedBy = "genere", cascade = CascadeType.ALL) 
    private List<Gioco> giochi = new ArrayList<>();
    
    // Getter e Setter

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
