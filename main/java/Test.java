import java.util.List;
import java.io.InputStream;
import java.time.LocalDate;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.elis.businesslogic.BusinessLogic;
import org.elis.model.*;

public class Test {
	public static void main(String[] args) {
			
		
//		Utente utenteNuovo = BusinessLogic.addUtente(0, "username1", "email@gmail.com1", "password", "Claudio", "Milano", "11111111", "via pippo", "www.pippo.com", "Roma", LocalDate.of(1996, 8, 31));
//		Utente utenteNuovo1 = BusinessLogic.addUtente(0, "username2", "asdemail@gmail.com2", "password", "Claudio", "Milano", "11111111", "via pippo", "www.pippo.com", "Roma", LocalDate.of(1996, 8, 31));
//		Utente utenteNuovo2 = BusinessLogic.addUtente(0, "username3", "email@gmail.com3", "password", "Claudio", "Milano", "11111111", "via pippo", "www.pippo.com", "Roma", LocalDate.of(1996, 8, 31));
		
		
//		Utente utenteTrovato = BusinessLogic.getUtenteByName("username3");
//		System.out.println(utenteTrovato.getNome());
		
//		BusinessLogic.deleteUtenteByNome("username3");
		
		Offerta offerta = BusinessLogic.getOffertaById(1);
		Utente utente = BusinessLogic.getUtenteById(3);
		Gioco gioco = BusinessLogic.getAllGiochi().getFirst();
		Libreria libreria = BusinessLogic.addLibreria(utente, gioco);
//		Gioco gioco = BusinessLogic.addGioco("Gioco", LocalDate.of(2022, 1, 10), "Gioco appena aggiunto", "path", 29.99, offerta, utente);
		
//		System.out.println(gioco.getId());
		System.out.println(offerta.getNome());
		System.out.println(utente.getNome());
		System.out.println("Libreria{ utenteId: " + libreria.getUtente().getId() + " giocoId: " + libreria.getGioco().getId() + " }"); 

		
//		Utente utenteDaAggiornare = BusinessLogic.getUtenteByName("usernameNuovo");
//		Utente utenteAggiornato = BusinessLogic.updateUtenteDataNascita(utenteDaAggiornare, LocalDate.of(1993, 1, 1));
//
//		System.out.println(utenteAggiornato.getUsername());

		
	}
}
