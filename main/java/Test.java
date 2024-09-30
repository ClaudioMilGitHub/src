import java.util.List;

import org.elis.businesslogic.BusinessLogic;
import org.elis.model.Utente;

public class Test {
	public static void main(String[] args) {
		
		List<Utente> utenti;
		
			//BusinessLogic.add(1, "Rino", "rino@gmail.com", "rano1234!");
			
			utenti = BusinessLogic.getAllUtenti();
			
			for (Utente utente : utenti) {
				System.out.println(utente.getUsername());
				System.out.println(utente.getRuolo());
				System.out.println(utente.getDataNascita());
			}
	}
}