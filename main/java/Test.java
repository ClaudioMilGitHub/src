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
			
		
		Utente utenteNuovo = BusinessLogic.addUtente(0, "username", "email@gmail.com", "password", "Claudio", "Milano", "11111111", "via pippo", "www.pippo.com", "Roma", LocalDate.of(1996, 8, 31));
		
		System.out.println(utenteNuovo.getCognome());
		

	}
}