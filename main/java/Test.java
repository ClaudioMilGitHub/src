import java.util.List;
import java.io.InputStream;
import java.time.LocalDate;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.elis.businesslogic.BusinessLogic;
import org.elis.model.*;

public class Test {
	public static void main(String[] args) {
			
		
//		Utente utente = BusinessLogic.addUtente(0, "username1", "email@gmail.com1", "password", "Claudio", "Milano", "11111111", "via pippo", "www.pippo.com", "Roma", LocalDate.of(1996, 8, 31));
//		Utente utenteNuovo1 = BusinessLogic.addUtente(0, "username2", "asdemail@gmail.com2", "password", "Claudio", "Milano", "11111111", "via pippo", "www.pippo.com", "Roma", LocalDate.of(1996, 8, 31));
//		Utente utenteNuovo2 = BusinessLogic.addUtente(0, "username3", "email@gmail.com3", "password", "Claudio", "Milano", "11111111", "via pippo", "www.pippo.com", "Roma", LocalDate.of(1996, 8, 31));
		
		Utente u = BusinessLogic.getUtenteById(1);
		System.out.println(u.getUsername());
		Gioco g = BusinessLogic.getGiocoById(1);
		Libreria l = BusinessLogic.getLibreriaByName("username1");
		
//		Gioco gioco = BusinessLogic.addGioco("Gioco", LocalDate.of(2022, 1, 10), "Gioco appena aggiunto", "path", 29.99, o, u);
			
//		Utente utenteTrovato = BusinessLogic.getUtenteByName("username3");
//		System.out.println(utenteTrovato.getNome());
		
//		BusinessLogic.deleteUtenteByNome("username3");
		
//		Offerta offerta = BusinessLogic.getOffertaById(1);
//		Libreria libreria = BusinessLogic.addLibreria(u, g);

		
		System.out.println("Libreria di " + u.getUsername() + ": " + l.getId());
//		System.out.println(g.getId());
//		System.out.println(u.getNome());
//		System.out.println("Libreria { utenteId: " + libreria.getUtente().getId() + " giocoId: " + libreria.getGioco().getId() + " }"); 

		
//		Utente utenteDaAggiornare = BusinessLogic.getUtenteByName("usernameNuovo");
//		Utente utenteAggiornato = BusinessLogic.updateUtenteDataNascita(utenteDaAggiornare, LocalDate.of(1993, 1, 1));
//
//		System.out.println(utenteAggiornato.getUsername());

		
	}
}
