package org.elis.dao.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.elis.dao.LibreriaDAO;
import org.elis.model.Gioco;
import org.elis.model.Libreria;
import org.elis.model.Ruolo;
import org.elis.model.Utente;

public class JdbcLibreriaDAO implements LibreriaDAO{
	
	private JdbcLibreriaDAO() {}
	private static JdbcLibreriaDAO instance;
	public static JdbcLibreriaDAO getInstance(){
		if(instance == null) {
			
			instance = new JdbcLibreriaDAO();
		}
		
		return instance;
	}

	@Override
	public Libreria add(String nome, Utente utente, Gioco gioco) {
		String query = "INSERT INTO libreria (nome,utente,gioco) VALUES (?,?,?)";
		
		Libreria l = new Libreria();
		l.setNome(nome);
		l.setUtente(utente);
		l.setGioco(gioco);
		
		try(
				Connection  c = JdbcDAOfactory.getConnection();
				PreparedStatement ps = c.prepareStatement(query);
				){
			
			ps.setString(1, nome);
			ps.setLong(2, utente.getId());
			ps.setLong(3, gioco.getId());
			
			ps.executeUpdate();
			
			return l;			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Libreria getByName(String nome) {
		String query = "SELECT * FROM libreria WHERE nome = ?";
		
		try(
				Connection c = JdbcDAOfactory.getConnection();
				PreparedStatement ps = c.prepareStatement(query);
				) {
			ps.setString(1, nome);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				Libreria l = new Libreria();
				long id = rs.getLong("id");
				long idUtente = rs.getLong("id_utente");
				Utente u = JdbcUtenteDAO.getInstance().getById(idUtente);
				long idGioco = rs.getLong("id_gioco");
				Gioco g = JdbcGiocoDAO.getInstance().getById(idGioco);
				
				l.setNome(nome);
				l.setUtente(u);
				l.setGioco(g);
				return l;
			}
			
		}catch(Exception e) {
				e.printStackTrace();
			}
		
		
		return null;
	}

	@Override
	public List<Libreria> getAll() {
		List<Libreria> librerie = new ArrayList<>();
		String query = "SELECT * FROM libreria";
		
		try(
				Connection  c = JdbcDAOfactory.getConnection();
				PreparedStatement ps = c.prepareStatement(query);
				){
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Libreria l = new Libreria();
				String nome = rs.getString("nome");
				
				l.setNome(nome);
				
				librerie.add(l);
			}
			
			if(!librerie.isEmpty()) {
				return librerie;
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Libreria update(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Libreria deleteByNome(String nome) {
		String query = "DELETE FROM libreria WHERE nome = ?";
		
		try(
				Connection  c = JdbcDAOfactory.getConnection();
				PreparedStatement ps = c.prepareStatement(query);
				){
			ps.setString(1, nome);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return null;
	}

}
