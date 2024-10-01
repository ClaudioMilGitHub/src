package org.elis.dao;

import java.util.List;

import org.elis.model.Gioco;
import org.elis.model.Libreria;
import org.elis.model.Utente;

public interface LibreriaDAO {

    Libreria addLibreria(String nome, Utente utente, Gioco gioco) throws Exception;
    Libreria getLibreriaByName(String nome) throws Exception;
    List<Libreria> getAllLibrerie() throws Exception;
    Libreria updateLibreria(String nome);
    Libreria deleteLibreriaByNome(String nome) throws Exception;
    Libreria getLibreriaById(long id) throws Exception;
    Libreria updateLibreria(long id, String nuovoNome) throws Exception;
}