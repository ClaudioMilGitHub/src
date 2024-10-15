package org.elis.model;

import java.time.LocalDateTime;

import java.util.HashSet;

import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*; 

@Entity 
public class Genere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private long id;
    
    @CreationTimestamp
	@Column(name="data_creazione", nullable = false)
	private LocalDateTime dataCreazione;
	
	@UpdateTimestamp
	@Column(name="data_ultima_modifica", nullable = false)
	private LocalDateTime dataUltimaModifica;
    
    @Column(name = "nome", nullable = false, length = 100) 
    private String nome;
    
    @ManyToOne 
    @JoinColumn(name = "offerta_id") 
    private Offerta offerta;
    
    
    @ManyToMany
    private Set<Gioco> giochi = new HashSet<>();
    
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

	public Set<Gioco> getGiochi() {
		return giochi;
	}

	public void setGiochi(Set<Gioco> giochi) {
		this.giochi = giochi;
	}

    
}
