package org.elis.dao;

import java.util.List;
import org.elis.model.Genere;
import org.elis.model.Offerta;

public interface GenereDAO {
    Genere add(String nome) throws Exception;
    Genere getByName(String nome) throws Exception;
    List<Genere> getAllGeneri();
    Genere updateGenereNome(String nome, String nuovoNome);
    Genere updateGenereOfferta(String nome, Offerta nuovaOfferta);
    Genere deleteByName(String nome);
}
