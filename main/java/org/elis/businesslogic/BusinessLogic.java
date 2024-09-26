package org.elis.businesslogic;

import java.util.List;

import org.elis.dao.DAOfactory;
import org.elis.model.Utente;

public class BusinessLogic {
	
	public static Utente getByName(String nome) {
		return DAOfactory.getDaoFactory().getUtenteDAO().getByName(nome);
	}
	
	public static List<Utente> getAllUser() {
		return DAOfactory.getDaoFactory().getUtenteDAO().getAll();
	}
	
	public static Utente add(int ruolo, String username, String email, String password) {
		return DAOfactory.getDaoFactory().getUtenteDAO().add(ruolo, username, email, password);
	}
}