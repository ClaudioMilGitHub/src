package org.elis.dao;

import java.sql.Timestamp;
import java.util.List;


import org.elis.model.Offerta;


public interface OffertaDAO {
    Offerta add(Offerta offerta) throws Exception;
    Offerta getOffertaById(long id);
    List<Offerta> getAll() throws Exception;
    void deleteById(int id) throws Exception;
    Offerta updateOffertaNome(Offerta offerta, String nome) throws Exception;
	Offerta updateOffertaDataInizio(Offerta offerta, Timestamp dataInizio);
	Offerta updateOffertaDataFine(Offerta offerta, Timestamp dataFine);
	Offerta updateOffertaSconto(Offerta offerta, double sconto);
}
