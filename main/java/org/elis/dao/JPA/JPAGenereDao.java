package org.elis.dao.JPA;

import java.util.List;

import org.elis.dao.GenereDAO;
import org.elis.model.Genere;
import org.elis.model.Offerta;

public class JPAGenereDao implements GenereDAO{

private JPAGenereDao() {}
	
	private static JPAGenereDao instance;
	public static JPAGenereDao getInstance() {
		if(instance == null) {
			
			instance = new JPAGenereDao();
		}
		
		return instance;
	}
	
	@Override
	public Genere addGenere(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Genere getGenereByName(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Genere> getAllGenere() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Genere updateGenereNome(Genere genere, String nuovoNome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Genere updateGenereOfferta(Genere genere, Offerta nuovaOfferta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Genere deleteByName(String nome) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
