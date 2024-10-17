package org.elis.dao;

import org.elis.dao.JDBC.*;
import org.elis.dao.JPA.JPADaoFactory;

public abstract class DAOFactory {
	
	private static DAOFactory instance;
	
	public abstract UtenteDAO getUtenteDAO();
	public abstract GiocoDAO getGiocoDAO();
	public abstract LibreriaDAO getLibreriaDAO();
	public abstract OffertaDAO getOffertaDAO();
	public abstract GenereDAO getGenereDAO();
	
	public static DAOFactory getDaoFactory(String s) {
		
		if(instance==null) {
			switch(s) {
			case "JDBC":
				instance = new JdbcDAOfactory();
				break;
			case "JPA":
				instance = new JPADaoFactory();
				break;
			}
		}	
		return instance;
	}
}