package org.elis.dao.JPA;

import org.elis.dao.DaoFactory;
import org.elis.dao.GenereDAO;
import org.elis.dao.GiocoDAO;
import org.elis.dao.LibreriaDAO;
import org.elis.dao.OffertaDAO;
import org.elis.dao.UtenteDAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class JPADaoFactory extends DaoFactory{
	
	protected static EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("SteamProject").createEntityManager();
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

}
