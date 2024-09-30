package org.elis.dao;

import java.sql.Timestamp;
import java.util.List;


import org.elis.model.Offerta;


public interface OffertaDAO {
    Offerta addOfferta(Offerta offerta);
    Offerta getOffertaById(long id);
    List<Offerta> getAllOfferta();
    Offerta deleteOffertaById(long id);
    Offerta updateOffertaNome(Offerta offerta, String nome);
	Offerta updateOffertaDataInizio(Offerta offerta, Timestamp dataInizio);
	Offerta updateOffertaDataFine(Offerta offerta, Timestamp dataFine);
	Offerta updateOffertaSconto(Offerta offerta, double sconto);
}
