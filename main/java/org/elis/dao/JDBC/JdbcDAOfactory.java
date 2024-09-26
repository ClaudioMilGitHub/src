package org.elis.dao.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;

import org.elis.dao.DAOfactory;
import org.elis.dao.UtenteDAO;

public class JdbcDAOfactory extends DAOfactory{

	protected static Connection getConnection() throws Exception{
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/steamdb","root","root");
	}

	@Override
	public UtenteDAO getUtenteDAO() {
		return JdbcUtenteDAO.getInstance();
	}
}