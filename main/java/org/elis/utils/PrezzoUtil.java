package org.elis.utils;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import org.elis.dao.OffertaDAO;
import org.elis.dao.JPA.JPAOffertaDao;
import org.elis.model.Offerta;
import org.elis.model.Ricorrenza;

public class PrezzoUtil {

    // Metodo per calcolare il prezzo finale con eventuali sconti
    public static double calcolaPrezzoFinale(double prezzoBase, long giocoId) {
        double scontoMassimo = 0;

        // Istanza di OffertaDAO (implementazione JPA)
        OffertaDAO offertaDao = JPAOffertaDao.getInstance();

        // Recupera le offerte valide per il gioco specifico
        List<Offerta> offerteGioco = offertaDao.getOfferteByGiocoId(giocoId);
        scontoMassimo = trovaScontoMassimo(offerteGioco, scontoMassimo);

        // Recupera le offerte valide per la ricorrenza attuale
        Ricorrenza ricorrenzaAttuale = determinaRicorrenzaAttuale();
        List<Offerta> offerteRicorrenza = offertaDao.getOfferteByRicorrenza(ricorrenzaAttuale);
        scontoMassimo = trovaScontoMassimo(offerteRicorrenza, scontoMassimo);

        // Applica lo sconto più alto disponibile
        return prezzoBase * (1 - scontoMassimo / 100);
    }

    // Metodo privato per trovare lo sconto massimo in una lista di offerte
    private static double trovaScontoMassimo(List<Offerta> offerte, double scontoCorrente) {
        double scontoMassimo = scontoCorrente;
        Timestamp now = new Timestamp(System.currentTimeMillis());

        for (Offerta offerta : offerte) {
            if (offerta.getDataInizio().isBefore(now.toLocalDateTime().toLocalDate()) &&
                offerta.getDataFine().isAfter(now.toLocalDateTime().toLocalDate())) {
                scontoMassimo = Math.max(scontoMassimo, offerta.getSconto());
            }
        }
        return scontoMassimo;
    }

    // Metodo per determinare la ricorrenza attuale basata sulla data odierna
    private static Ricorrenza determinaRicorrenzaAttuale() {
        LocalDate today = LocalDate.now();
        Month currentMonth = today.getMonth();
        int currentDay = today.getDayOfMonth();

        // Mappatura delle ricorrenze in base ai mesi e giorni
        if (currentMonth == Month.DECEMBER && currentDay >= 20) {
            return Ricorrenza.NATALE;
        } else if (currentMonth == Month.OCTOBER && currentDay >= 25) {
            return Ricorrenza.HALLOWEEN;
        } else if (currentMonth == Month.NOVEMBER && currentDay >= 20 && currentDay <= 30) {
            return Ricorrenza.BLACK_FRIDAY;
        } else if (currentMonth == Month.APRIL && currentDay >= 1 && currentDay <= 15) {
            return Ricorrenza.PASQUA;
        } else if (currentMonth == Month.JULY || currentMonth == Month.AUGUST) {
            return Ricorrenza.ESTATE;
        } else if (currentMonth == Month.JANUARY || currentMonth == Month.FEBRUARY) {
            return Ricorrenza.INVERNO;
        } else {
            return Ricorrenza.DEFAULT;
        }
    }
}






/*package org.elis.utils;

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
}*/
