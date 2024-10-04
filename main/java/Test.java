import java.util.List;

import org.elis.businesslogic.BusinessLogic;
import org.elis.model.Genere;
import org.elis.model.Gioco;
import org.elis.model.Utente;

public class Test {
	public static void main(String[] args) {
		
		List<Utente> utenti;
		
			//BusinessLogic.add(1, "Rino", "rino@gmail.com", "rano1234!");
			
		Genere genere = BusinessLogic.getGenereByName("avventura");
		System.out.println(genere.getNome());
	}
}