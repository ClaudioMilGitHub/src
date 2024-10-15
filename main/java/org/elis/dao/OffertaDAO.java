package org.elis.dao;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import org.elis.model.Offerta;
import org.elis.model.Ricorrenza;

public interface OffertaDAO {
	
	Offerta addOfferta(Ricorrenza ricorrenza, double sconto, LocalDate dataInizio, LocalDate dataFine, String nome);
    Offerta getOffertaById(long id);
    List<Offerta> getAllOfferta();
    List<Offerta> getOfferteByRicorrenza(Ricorrenza ricorrenza); 
    List<Offerta> getOfferteByGiocoId(long giocoId);
    Offerta deleteOffertaById(long id);
    Offerta updateOffertaNome(Offerta offerta, String nome);
    Offerta updateOffertaDataInizio(Offerta offerta, Timestamp dataInizio);
    Offerta updateOffertaDataFine(Offerta offerta, Timestamp dataFine);
    Offerta updateOffertaSconto(Offerta offerta, double sconto);
	
}
