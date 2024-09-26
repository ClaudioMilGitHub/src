package org.elis.dao;

import java.util.List;
import org.elis.model.Genere;

public interface GenereDAO {
    Genere add(String nome) throws Exception;
    Genere getByName(String nome) throws Exception;
    List<Genere> getAll();
    Genere update(String nome, String nuovoNome);
    void deleteByName(String nome);
}
