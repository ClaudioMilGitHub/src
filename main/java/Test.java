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
		
		//Aggiungi utenti al database
		
//		public Utente addUtente(int ruoloIntValue, String username, String email, String password, String nome, String cognome, String telefono, String indirizzo, String sitoWeb, String comuneResidenza, LocalDate dataNascita)
		
		
//		BusinessLogic.addUtente(0, "theredcondor", "email01@gmail.com", "Password1234!", "Claudio", "Milano", "3755954849", "Via San Bernardino 27", null, "Trapani", LocalDate.of(1996, 8, 31));
//		BusinessLogic.addUtente(1, "therinoranos", "email02@gmail.com", "Password1234!?", "Rino", "Rano", "3755954848", "Via San Bernardino 26", null, "Roma", LocalDate.of(1997, 7, 30));
//		BusinessLogic.addUtente(1, "thegiannigiannos", "email03@gmail.com", "Password1235!?", "Gianno", "Gianni", "3755954847", "Via San Bernardino 25", null, "Roma", LocalDate.of(1998, 6, 29));
//		BusinessLogic.addUtente(1, "thepincopancos", "email04@gmail.com", "Password1236!?", "Pinco", "Panco", "3755954846", "Via San Bernardino 24", null, "Milano", LocalDate.of(1999, 5, 28));
//		BusinessLogic.addUtente(1, "thegiallogiallis", "email05@gmail.com", "Password1237!?", "Giallo", "Gialli", "3755954845", "Via San Bernardino 23", null, null, LocalDate.of(1995, 4, 27));
//		BusinessLogic.addUtente(2, "ubisoft", "ubisoft@ubisoft.com", "Password1238!?", "Ubisoft", null, "3755954844", null, "www.ubisoft.com/", "Saint-Mandé", LocalDate.of(1985, 3, 26));
//		BusinessLogic.addUtente(2, "505Games", "505@505games.com", "Password1239!?", "505Games", null, "3755954843", null, "https://505games.com/", "Milano", LocalDate.of(2006, 2, 25));
		
		//Aggiungi giochi al database
//		BusinessLogic.addGioco("Death Stranding", LocalDate.of(2019, 11, 8), "Dal leggendario Hideo Kojima arriva un’esperienza di gioco che definisce il genere", "path", 39.99, null, null);
//		BusinessLogic.addGioco("Elden Ring", LocalDate.of(2022, 2, 25), "UN NUOVO ACTION RPG FANTASY. Alzati, Senzaluce", "path", 59.99, null, null);
//		BusinessLogic.addGioco("Castlevania Dominus Collection", LocalDate.of(2024, 8, 27), "Per la prima volta, finalmente fanno il loro ritorno tre incredibili titoli action adventure della serie Castlevania!", "path", 24.99, null, null);
//		BusinessLogic.addGioco("Assassin's Creed Valhalla", LocalDate.of(2022, 12, 6), "Diventa una leggenda tra i vichinghi, scrivi il tuo nome nella Storia", "path", 14.99, null, null);
//		BusinessLogic.addGioco("Tom Clancy's Rainbow Six® Siege", LocalDate.of(2015, 12, 1), "Tom Clancy's Rainbow Six® Siege è uno sparatutto tattico d'élite a squadre", "path", 19.99, null, null);
//		BusinessLogic.addGioco("Prince of Persia The Lost Crown", LocalDate.of(2024, 8, 8), "Tuffati in un platform d'azione e avventura ambientato in una versione mitologica dell'antica Persia", "path", 39.99, null, null);
//		BusinessLogic.addGioco("Skull and Bones", LocalDate.of(2024, 8, 22), "Spiega le vele nell'emozionante mondo aperto di Skull and Bones", "path", 59.99, null, null);
//		BusinessLogic.addGioco("Avatar: Frontiers of Pandora™", LocalDate.of(2024, 6, 17), "Avatar: Frontiers of Pandora™ è un gioco d'azione-avventura in prima persona", "path", 69.99, null, null);
//		BusinessLogic.addGioco("Ghostrunner 2", LocalDate.of(2023, 10, 26), "Scopri Ghostrunner 2, lo slasher in prima persona ambientato in un futuro cyberpunk", "path", 39.99, null, null);
//		BusinessLogic.addGioco("Control Ultimate Edition", LocalDate.of(2020, 8, 27), "Vincitore di oltre 80 riconoscimenti, Control è uno spettacolare gioco d’azione e avventura", "path", 39.99, null, null);

		//Aggiungi genere al database
		BusinessLogic.addGenere("Avventura");
		BusinessLogic.addGenere("Azione");
		BusinessLogic.addGenere("Ruolo");
		BusinessLogic.addGenere("Strategia");
		BusinessLogic.addGenere("Metroidvania");
		
		//Aggiungi giochi al genere  id[Genere, Gioco]
		//Avventura
//		BusinessLogic.aggiungiGiocoaGenere(1, 4);
//		BusinessLogic.aggiungiGiocoaGenere(1, 8);
//		BusinessLogic.aggiungiGiocoaGenere(1, 2);
//		BusinessLogic.aggiungiGiocoaGenere(1, 9);
//
//		//Azione
//		BusinessLogic.aggiungiGiocoaGenere(2, 4);
//		BusinessLogic.aggiungiGiocoaGenere(2, 10);
//		BusinessLogic.aggiungiGiocoaGenere(2, 5);
//		BusinessLogic.aggiungiGiocoaGenere(2, 9);
//
//		//Ruolo
//		BusinessLogic.aggiungiGiocoaGenere(3, 2);
//		BusinessLogic.aggiungiGiocoaGenere(3, 1);
//		BusinessLogic.aggiungiGiocoaGenere(3, 4);
//
//		//Strategia
//		BusinessLogic.aggiungiGiocoaGenere(4, 5);
//
//		//MetroidVania
//		BusinessLogic.aggiungiGiocoaGenere(5, 3);
		
		
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
//		EntityManager em = JPADaoFactory.getEntityManager();
//		EntityTransaction t = em.getTransaction();
//		
//		
//		t.begin();
//		Genere genere = em.find(Genere.class, 1);
//		Gioco g = em.find(Gioco.class, 1);
//		Set<Genere> setGenere = new HashSet<>();
//		setGenere = g.getGeneri();
//		
//		Genere[] generiArray = setGenere.toArray(new Genere[setGenere.size()]);
//		
//		System.out.println(generiArray[0].getNome());
		
//		
//		genere.getGiochi().add(g);
//		
//		em.persist(g);
//		t.commit();
//		em.close();
		
		
		

		
	}
}
