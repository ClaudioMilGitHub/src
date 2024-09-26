package org.elis.dao;

import org.elis.dao.JDBC.*;

public abstract class DAOfactory {
	
	public abstract UtenteDAO getUtenteDAO();

	public static JdbcDAOfactory getDaoFactory() {
		return new JdbcDAOfactory();
	}
}