package org.elis.dao.JPA;

import java.time.LocalDate;
import java.util.List;

import org.elis.dao.UtenteDAO;
import org.elis.model.Ruolo;
import org.elis.model.Utente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

public class JPAUtenteDao implements UtenteDAO{

	private JPAUtenteDao() {}
	
	private static JPAUtenteDao instance;
	public static JPAUtenteDao getInstance() {
		if(instance == null) {
			
			instance = new JPAUtenteDao();
		}
		
		return instance;
	}
	@Override
	public Utente addUtente(int ruoloIntValue, String username, String email, String password, String nome,
			String cognome, String telefono, String indirizzo, String sitoWeb, String comuneResidenza,
			LocalDate dataNascita) {
		
		Utente u = new Utente();
		Ruolo[] ruoli = Ruolo.values();
		Ruolo ruolo = ruoli[ruoloIntValue];
		u.setRuolo(ruolo);
		u.setUsername(username);
		u.setEmail(email);
		u.setPassword(password);
		u.setNome(nome);
		u.setCognome(cognome);
		u.setTelefono(telefono);
		u.setIndirizzo(indirizzo);
		u.setSitoWeb(sitoWeb);
		u.setComuneResidenza(comuneResidenza);
		u.setDataNascita(dataNascita);
		
		EntityManager em = JPADaoFactory.getEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(u);
		t.commit();
		
		return u;
	}
	@Override
	public Utente getUtenteByName(String usernameSearch) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Utente getUtenteById(long id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Utente> getAllUtenti() {
		EntityManager em = JPADaoFactory.getEntityManager();
		Query q = em.createQuery("Select u from Utente u");
		return q.getResultList();

	}
	@Override
	public Utente deleteUtenteByNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Utente updateUtenteUsername(Utente utenteLoggato, String newUsername) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Utente updateUtentePassword(Utente utenteLoggato, String newPassword) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Utente updateUtenteDataNascita(Utente utenteLoggato, LocalDate newDataNascita) {
		// TODO Auto-generated method stub
		return null;
	}
}