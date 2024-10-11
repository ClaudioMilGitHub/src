import java.util.List;
import java.io.InputStream;
import java.time.LocalDate;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.elis.businesslogic.BusinessLogic;
import org.elis.model.Genere;
import org.elis.model.Gioco;
import org.elis.model.Utente;

public class Test {
	public static void main(String[] args) {
			
		
//		Utente utenteNuovo = BusinessLogic.addUtente(0, "username1", "email@gmail.com1", "password", "Claudio", "Milano", "11111111", "via pippo", "www.pippo.com", "Roma", LocalDate.of(1996, 8, 31));
//		Utente utenteNuovo1 = BusinessLogic.addUtente(0, "username2", "asdemail@gmail.com2", "password", "Claudio", "Milano", "11111111", "via pippo", "www.pippo.com", "Roma", LocalDate.of(1996, 8, 31));
//		Utente utenteNuovo2 = BusinessLogic.addUtente(0, "username3", "email@gmail.com3", "password", "Claudio", "Milano", "11111111", "via pippo", "www.pippo.com", "Roma", LocalDate.of(1996, 8, 31));
		
		
//		Utente utenteTrovato = BusinessLogic.getUtenteByName("username3");
//		System.out.println(utenteTrovato.getNome());
		
//		BusinessLogic.deleteUtenteByNome("username3");
		
		
		Utente utenteDaAggiornare = BusinessLogic.getUtenteByName("usernameNuovo");
		Utente utenteAggiornato = BusinessLogic.updateUtenteDataNascita(utenteDaAggiornare, LocalDate.of(1993, 1, 1));

		System.out.println(utenteAggiornato.getUsername());

		
	}
}
