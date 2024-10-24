package org.elis.dao.JPA;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

import org.elis.dao.OffertaDAO;
import org.elis.model.Offerta;
import org.elis.model.Ricorrenza;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

public class JPAOffertaDao implements OffertaDAO {

    private JPAOffertaDao() {}

    private static JPAOffertaDao instance;

    public static JPAOffertaDao getInstance() {
        if (instance == null) {
            instance = new JPAOffertaDao();
        }
        return instance;
    }

    @Override
    public Offerta addOfferta(Ricorrenza ricorrenza, double sconto, LocalDate dataInizio, LocalDate dataFine, String nome) {
        Offerta o = new Offerta();
        o.setRicorrenza(ricorrenza);
        o.setSconto(sconto);
        o.setDataInizio(dataInizio);
        o.setDataFine(dataFine);
        o.setNome(nome);

        EntityManager em = JPADaoFactory.getEntityManager();
        EntityTransaction t = em.getTransaction();
        try {
            t.begin();
            em.persist(o);
            t.commit();
        } catch (Exception e) {
            if (t.isActive()) t.rollback();
            throw e;
        } finally {
            em.close();
        }

        return o;
    }

    @Override
    public Offerta getOffertaById(long id) {
        EntityManager em = JPADaoFactory.getEntityManager();
        try {
            return em.find(Offerta.class, id);  // Sicuro poiché non coinvolge query dinamiche
        } finally {
            em.close();
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Offerta> getAllOfferta() {
        EntityManager em = JPADaoFactory.getEntityManager();
        try {
            Query q = em.createQuery("SELECT o FROM Offerta o");
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Offerta> getOfferteByRicorrenza(Ricorrenza ricorrenza) {
        EntityManager em = JPADaoFactory.getEntityManager();
        try {
            Query q = em.createQuery("SELECT o FROM Offerta o WHERE o.ricorrenza = :ricorrenza");
            q.setParameter("ricorrenza", ricorrenza);  // Parametrizzazione per protezione SQL injection
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Offerta> getOfferteByGiocoId(long giocoId) {
        EntityManager em = JPADaoFactory.getEntityManager();
        try {
            Query q = em.createQuery("SELECT o FROM Offerta o JOIN o.giochi g WHERE g.id = :giocoId");
            q.setParameter("giocoId", giocoId);  // Parametrizzazione per protezione SQL injection
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public Offerta deleteOffertaById(long id) {
        EntityManager em = JPADaoFactory.getEntityManager();
        EntityTransaction t = em.getTransaction();
        try {
            Query q = em.createQuery("SELECT o FROM Offerta o WHERE o.id = :id");
            q.setParameter("id", id);  // Parametrizzazione per protezione SQL injection
            Offerta o = (Offerta) q.getSingleResult();
            t.begin();
            em.remove(o);
            t.commit();
            return o;
        } catch (Exception e) {
            if (t.isActive()) t.rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public Offerta updateOffertaNome(Offerta offerta, String nome) {
        EntityManager em = JPADaoFactory.getEntityManager();
        EntityTransaction t = em.getTransaction();
        try {
            t.begin();
            offerta.setNome(nome);
            offerta = em.merge(offerta);
            t.commit();
        } catch (Exception e) {
            if (t.isActive()) t.rollback();
            throw e;
        } finally {
            em.close();
        }
        return offerta;
    }

    @Override
    public Offerta updateOffertaDataInizio(Offerta offerta, Timestamp dataInizio) {
        EntityManager em = JPADaoFactory.getEntityManager();
        EntityTransaction t = em.getTransaction();
        try {
            t.begin();
            offerta.setDataInizio(dataInizio.toLocalDateTime().toLocalDate());
            offerta = em.merge(offerta);
            t.commit();
        } catch (Exception e) {
            if (t.isActive()) t.rollback();
            throw e;
        } finally {
            em.close();
        }
        return offerta;
    }

    @Override
    public Offerta updateOffertaDataFine(Offerta offerta, Timestamp dataFine) {
        EntityManager em = JPADaoFactory.getEntityManager();
        EntityTransaction t = em.getTransaction();
        try {
            t.begin();
            offerta.setDataFine(dataFine.toLocalDateTime().toLocalDate());
            offerta = em.merge(offerta);
            t.commit();
        } catch (Exception e) {
            if (t.isActive()) t.rollback();
            throw e;
        } finally {
            em.close();
        }
        return offerta;
    }

    @Override
    public Offerta updateOffertaSconto(Offerta offerta, double sconto) {
        EntityManager em = JPADaoFactory.getEntityManager();
        EntityTransaction t = em.getTransaction();
        try {
            t.begin();
            offerta.setSconto(sconto);
            offerta = em.merge(offerta);
            t.commit();
        } catch (Exception e) {
            if (t.isActive()) t.rollback();
            throw e;
        } finally {
            em.close();
        }
        return offerta;
    }
}


/*package org.elis.dao.JPA;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

import org.elis.dao.OffertaDAO;
import org.elis.model.Offerta;
import org.elis.model.Ricorrenza;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

public class JPAOffertaDao implements OffertaDAO{

	
private JPAOffertaDao() {}
	
	private static JPAOffertaDao instance;
	public static JPAOffertaDao getInstance() {
		if(instance == null) {
			
			instance = new JPAOffertaDao();
		}
		
		return instance;
	}
	
	
	@Override
	public Offerta addOfferta(Ricorrenza ricorrenza, double sconto, LocalDate dataInizio, LocalDate dataFine, String nome) {
		
		Offerta o = new Offerta();
		o.setRicorrenza(ricorrenza);
		o.setSconto(sconto);
		o.setDataInizio(dataInizio);
		o.setDataFine(dataFine);
		o.setNome(nome);
		
		EntityManager em = JPADaoFactory.getEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(o);
		t.commit();
		
		return o;
		
	}

	@Override
	public Offerta getOffertaById(long id) {
		EntityManager em = JPADaoFactory.getEntityManager();
		return em.find(Offerta.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Offerta> getAllOfferta() {
		EntityManager em = JPADaoFactory.getEntityManager();
		Query q = em.createQuery("Select o FROM Offerta o");
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Offerta> getOfferteByRicorrenza(Ricorrenza ricorrenza) {
		EntityManager em = JPADaoFactory.getEntityManager();
	    Query q = em.createQuery("SELECT o FROM Offerta o WHERE o.ricorrenza = :ricorrenza");
	    q.setParameter("ricorrenza", ricorrenza);
	    return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Offerta> getOfferteByGiocoId(long giocoId) {
		 EntityManager em = JPADaoFactory.getEntityManager();
		    Query q = em.createQuery("SELECT o FROM Offerta o JOIN o.giochi g WHERE g.id = :giocoId");
		    q.setParameter("giocoId", giocoId);
		    return q.getResultList();
	}

	@Override
	public Offerta deleteOffertaById(long id) {
		EntityManager em = JPADaoFactory.getEntityManager();
		Query q = em.createQuery("SELECT o FROM Offerta u WHERE o.id = :id");
		q.setParameter("id", id);
		Offerta o = (Offerta) q.getSingleResult();
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.remove(o);
		t.commit();
		return o;
	}

	@Override
	public Offerta updateOffertaNome(Offerta offerta, String nome) {
		EntityManager em = JPADaoFactory.getEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		offerta.setNome(nome);
		offerta = em.merge(offerta);
		t.commit();
	  return offerta;
	}

	@Override
	public Offerta updateOffertaDataInizio(Offerta offerta, Timestamp dataInizio) {
		 EntityManager em = JPADaoFactory.getEntityManager();
		 EntityTransaction t = em.getTransaction();
		 t.begin();
	     offerta.setDataInizio(dataInizio.toLocalDateTime().toLocalDate());
	     offerta = em.merge(offerta);
	     t.commit();
		return offerta;
	}

	@Override
	public Offerta updateOffertaDataFine(Offerta offerta, Timestamp dataFine) {
		 EntityManager em = JPADaoFactory.getEntityManager();
		 EntityTransaction t = em.getTransaction();
		 t.begin();
	     offerta.setDataFine(dataFine.toLocalDateTime().toLocalDate());
	     offerta = em.merge(offerta);
	     t.commit();
	    return offerta;
	}

	@Override
	public Offerta updateOffertaSconto(Offerta offerta, double sconto) {
		 EntityManager em = JPADaoFactory.getEntityManager();
		 EntityTransaction t = em.getTransaction();
		 t.begin();
	     offerta.setSconto(sconto);
	     offerta = em.merge(offerta);
	     t.commit();
	    return offerta;
	}
} */