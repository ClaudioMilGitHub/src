package org.elis.utils;

import java.sql.Timestamp;
import java.util.List;
import org.elis.dao.JDBC.JdbcOffertaDAO;
import org.elis.model.Offerta;
import org.elis.model.Ricorrenza;

public class PrezzoUtil {

    public static double calcolaPrezzoFinale(double prezzoBase, long giocoId) {
        double scontoGioco = 0;
        double scontoRicorrenza = 0;

        
        List<Offerta> offerteGioco = JdbcOffertaDAO.getInstance().getOfferteByGiocoId(giocoId);
        for (Offerta offerta : offerteGioco) {
            if (offerta.getDataInizio().before(new Timestamp(System.currentTimeMillis())) && 
                offerta.getDataFine().after(new Timestamp(System.currentTimeMillis()))) {
                scontoGioco = Math.max(scontoGioco, offerta.getSconto()); 
            }
        }

        
        Ricorrenza ricorrenzaAttuale = determinaRicorrenzaAttuale(); 
        List<Offerta> offerteRicorrenza = JdbcOffertaDAO.getInstance().getOfferteByRicorrenza(ricorrenzaAttuale);
        for (Offerta offerta : offerteRicorrenza) {
            if (offerta.getDataInizio().before(new Timestamp(System.currentTimeMillis())) && 
                offerta.getDataFine().after(new Timestamp(System.currentTimeMillis()))) {
                scontoRicorrenza = Math.max(scontoRicorrenza, offerta.getSconto()); 
            }
        }

   
        double scontoFinale = Math.max(scontoGioco, scontoRicorrenza);
        return prezzoBase * (1 - scontoFinale / 100);
    }

    private static Ricorrenza determinaRicorrenzaAttuale() {
       
        return Ricorrenza.DEFAULT; 
    }
}
