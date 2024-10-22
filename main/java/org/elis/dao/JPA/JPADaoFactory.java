package org.elis.dao.JPA;

import org.elis.dao.DAOFactory;
import org.elis.dao.GenereDAO;
import org.elis.dao.GiocoDAO;
import org.elis.dao.LibreriaDAO;
import org.elis.dao.OffertaDAO;
import org.elis.dao.RecensioneDAO;
import org.elis.dao.UtenteDAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPADaoFactory extends DAOFactory{
	
	private static EntityManagerFactory emf;
	
	public static EntityManager getEntityManager() {
		if(emf==null) {
			emf=Persistence.createEntityManagerFactory("SteamProject");
		}
		return emf.createEntityManager();
	}

	@Override
	public UtenteDAO getUtenteDAO() {
		return JPAUtenteDao.getInstance();
	}

	@Override
	public GiocoDAO getGiocoDAO() {
		return JPAGiocoDao.getInstance();
	}

	@Override
	public LibreriaDAO getLibreriaDAO() {
		return JPALibreriaDao.getInstance();
	}

	@Override
	public OffertaDAO getOffertaDAO() {
		return JPAOffertaDao.getInstance();
	}

	@Override
	public GenereDAO getGenereDAO() {
		return JPAGenereDao.getInstance();
	}

	@Override
	public RecensioneDAO getRecensioneDAO() {
		return JPARecensioneDao.getInstance();
	}

}
