package org.elis.dao;

import java.util.List;
import org.elis.model.Genere;
import org.elis.model.Offerta;

public interface GenereDAO {
    Genere addGenere(String nome);
    Genere getGenereByName(String nome);
    List<Genere> getAllGenere();
    Genere updateGenereNome(Genere genere, String nuovoNome);
    Genere updateGenereOfferta(Genere genere, Offerta nuovaOfferta);
    Genere deleteByName(String nome);
}
