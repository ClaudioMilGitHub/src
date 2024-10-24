package org.elis.dao.JPA;

import java.time.LocalDate;
import java.util.List;

import org.elis.dao.UtenteDAO;
import org.elis.model.Ruolo;
import org.elis.model.Utente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

public class JPAUtenteDao implements UtenteDAO {

    private JPAUtenteDao() {}

    private static JPAUtenteDao instance;

    public static JPAUtenteDao getInstance() {
        if (instance == null) {
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
        try {
            t.begin();
            em.persist(u);
            t.commit();
        } catch (Exception e) {
            if (t.isActive()) t.rollback();
            throw e;
        } finally {
            em.close();
        }

        return u;
    }

    @Override
    public Utente getUtenteByName(String usernameSearch) {
        EntityManager em = JPADaoFactory.getEntityManager();
        try {
            Query q = em.createQuery("SELECT u FROM Utente u WHERE u.username = :username");
            q.setParameter("username", usernameSearch);  // Query parametrizzata per evitare SQL injection
            return (Utente) q.getSingleResult();
        } finally {
            em.close();
        }
    }

    @Override
    public Utente getUtenteById(long id) {
        EntityManager em = JPADaoFactory.getEntityManager();
        try {
            return em.find(Utente.class, id);  // Sicuro poiché non usa query dinamiche
        } finally {
            em.close();
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Utente> getAllUtenti() {
        EntityManager em = JPADaoFactory.getEntityManager();
        try {
            Query q = em.createQuery("SELECT u FROM Utente u");
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public void deleteUtenteByNome(String nome) {
        EntityManager em = JPADaoFactory.getEntityManager();
        EntityTransaction t = em.getTransaction();
        try {
            Query q = em.createQuery("SELECT u FROM Utente u WHERE u.username = :username");
            q.setParameter("username", nome);  // Parametrizzazione per evitare SQL injection
            Utente u = (Utente) q.getSingleResult();
            t.begin();
            em.remove(u);
            t.commit();
        } catch (Exception e) {
            if (t.isActive()) t.rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public Utente updateUtenteUsername(Utente utenteLoggato, String newUsername) {
        EntityManager em = JPADaoFactory.getEntityManager();
        EntityTransaction t = em.getTransaction();
        try {
            t.begin();
            utenteLoggato.setUsername(newUsername);
            utenteLoggato = em.merge(utenteLoggato);
            t.commit();
        } catch (Exception e) {
            if (t.isActive()) t.rollback();
            throw e;
        } finally {
            em.close();
        }
        return utenteLoggato;
    }

    @Override
    public Utente updateUtentePassword(Utente utenteLoggato, String newPassword) {
        EntityManager em = JPADaoFactory.getEntityManager();
        EntityTransaction t = em.getTransaction();
        try {
            t.begin();
            utenteLoggato.setPassword(newPassword);
            utenteLoggato = em.merge(utenteLoggato);
            t.commit();
        } catch (Exception e) {
            if (t.isActive()) t.rollback();
            throw e;
        } finally {
            em.close();
        }
        return utenteLoggato;
    }

    @Override
    public Utente updateUtenteDataNascita(Utente utenteLoggato, LocalDate newDataNascita) {
        EntityManager em = JPADaoFactory.getEntityManager();
        EntityTransaction t = em.getTransaction();
        try {
            t.begin();
            utenteLoggato.setDataNascita(newDataNascita);
            utenteLoggato = em.merge(utenteLoggato);
            t.commit();
        } catch (Exception e) {
            if (t.isActive()) t.rollback();
            throw e;
        } finally {
            em.close();
        }
        return utenteLoggato;
    }

    public Utente updateUtenteSuspension(Utente utente, boolean suspension) {
        EntityManager em = JPADaoFactory.getEntityManager();
        EntityTransaction t = em.getTransaction();
        try {
            t.begin();
            utente.setSuspended(suspension);
            utente = em.merge(utente);
            t.commit();
        } catch (Exception e) {
            if (t.isActive()) t.rollback();
            throw e;
        } finally {
            em.close();
        }
        return utente;
    }
}





/*package org.elis.dao.JPA;

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
		EntityManager em = JPADaoFactory.getEntityManager();
		Query q = em.createQuery("SELECT u FROM Utente u WHERE u.username = :username");
		q.setParameter("username", usernameSearch);
		return (Utente) q.getSingleResult();
	}
	
	@Override
	public Utente getUtenteById(long id) {
		EntityManager em = JPADaoFactory.getEntityManager();
		return em.find(Utente.class, id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Utente> getAllUtenti() {
		EntityManager em = JPADaoFactory.getEntityManager();
		Query q = em.createQuery("Select u from Utente u");
		return q.getResultList();

	}
	
	@Override
	public void deleteUtenteByNome(String nome) {
		EntityManager em = JPADaoFactory.getEntityManager();
		Query q = em.createQuery("SELECT u FROM Utente u WHERE u.username = :username");
		q.setParameter("username", nome);
		Utente u = (Utente) q.getSingleResult();
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.remove(u);
		t.commit();
	}
	
	@Override
	public Utente updateUtenteUsername(Utente utenteLoggato, String newUsername) {
		
		EntityManager em = JPADaoFactory.getEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		utenteLoggato.setUsername(newUsername);
		utenteLoggato = em.merge(utenteLoggato);
		t.commit();
		return utenteLoggato;
	}
	
	@Override
	public Utente updateUtentePassword(Utente utenteLoggato, String newPassword) {
		EntityManager em = JPADaoFactory.getEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		utenteLoggato.setPassword(newPassword);
		utenteLoggato = em.merge(utenteLoggato);
		t.commit();
		return utenteLoggato;
	}
	
	@Override
	public Utente updateUtenteDataNascita(Utente utenteLoggato, LocalDate newDataNascita) {
		EntityManager em = JPADaoFactory.getEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		utenteLoggato.setDataNascita(newDataNascita);
		utenteLoggato = em.merge(utenteLoggato);
		t.commit();
		return utenteLoggato;
	}
	
	public Utente updateUtenteSuspension(Utente utente, boolean suspension) {
		EntityManager em = JPADaoFactory.getEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		utente.setSuspended(suspension);
		utente = em.merge(utente);
		t.commit();
		return utente;
	}
} */