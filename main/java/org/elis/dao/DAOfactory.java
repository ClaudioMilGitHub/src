package org.elis.dao;

import org.elis.dao.JDBC.*;

public abstract class DAOfactory {
	
	public abstract UtenteDAO getUtenteDAO();
	public abstract GiocoDAO getGiocoDAO();
	public abstract LibreriaDAO getLibreriaDAO();
	public abstract OffertaDAO getOffertaDAO();

	public static JdbcDAOfactory getDaoFactory() {
		return new JdbcDAOfactory();
	}
}