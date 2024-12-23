package org.elis.dao.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;

import org.elis.dao.DAOFactory;
import org.elis.dao.GenereDAO;
import org.elis.dao.GiocoDAO;
import org.elis.dao.LibreriaDAO;
import org.elis.dao.OffertaDAO;
import org.elis.dao.UtenteDAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class JdbcDAOFactory extends DAOFactory{

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
		return null;//JdbcUtenteDAO.getInstance();
	}
	
	@Override
	public GiocoDAO getGiocoDAO() {
		return JdbcGiocoDAO.getInstance();
	}
	
	@Override
	public LibreriaDAO getLibreriaDAO() {
		return null;// JdbcLibreriaDAO.getInstance();
	}

	@Override
	public OffertaDAO getOffertaDAO() {
		return null;//JdbcOffertaDAO.getInstance();
	}
	
	@Override
	public GenereDAO getGenereDAO() {
		return JdbcGenereDAO.getInstance();
	}
}