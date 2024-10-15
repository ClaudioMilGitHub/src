import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.io.InputStream;
import java.time.LocalDate;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.elis.businesslogic.BusinessLogic;
import org.elis.dao.JPA.JPADaoFactory;
import org.elis.model.*;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class Test {
	public static void main(String[] args) {
		
//		BusinessLogic.addUtente(0, "username", "email@gmail.com", "passord", "Claudio", "Milano", "1111111", "Via San Bernardino", null, null, LocalDate.of(1996, 8, 31));
//		BusinessLogic.addGioco("Gioco", LocalDate.of(2024, 1, 1), "Bello", "path", 29.99, null, null);
		
//		Genere genere = BusinessLogic.getGenereByName("Avventura");
//		Gioco gioco = BusinessLogic.getGiocoById(1);
//		
//		BusinessLogic.aggiungiGiocoaGenere(genere, gioco);
		
//		Genere genere = BusinessLogic.addGenere("Avventura");
//		Offerta offerta = BusinessLogic.addOfferta(Ricorrenza.BLACK_FRIDAY, 0.5, LocalDate.of(2024, 11, 27), LocalDate.of(2024, 12, 1), "black friday");
//		Utente u = BusinessLogic.getUtenteById(1);
//		Gioco g = BusinessLogic.getGiocoById(5);
//		
//		BusinessLogic.aggiungiGiocoALibreria(u, g);
		
//		
//		
		EntityManager em = JPADaoFactory.getEntityManager();
//		EntityTransaction t = em.getTransaction();
//		
//		
//		t.begin();
//		Genere genere = em.find(Genere.class, 1);
		Gioco g = em.find(Gioco.class, 1);
		Set<Genere> setGenere = new HashSet<>();
		setGenere = g.getGeneri();
		
		Genere[] generiArray = setGenere.toArray(new Genere[setGenere.size()]);
		
		System.out.println(generiArray[0].getNome());
		
//		
//		genere.getGiochi().add(g);
//		
//		em.persist(g);
//		t.commit();
//		em.close();
		
		
		

		
	}
}
