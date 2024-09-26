package org.elis.dao.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.elis.dao.UtenteDAO;
import org.elis.model.Ruolo;
import org.elis.model.Utente;

public class JdbcUtenteDAO implements UtenteDAO{
	
	private JdbcUtenteDAO() {}
	private static JdbcUtenteDAO instance;
	public static JdbcUtenteDAO getInstance(){
		if(instance == null) {
			
			instance = new JdbcUtenteDAO();
		}
		
		return instance;
	}

	@Override
	public Utente add(int ruoloIntValue, String username, String email, String password) {
		
		String query = "INSERT INTO utente (ruolo, username, email, password) VALUES (?,?,?,?)";
		
		Utente u = new Utente();
		Ruolo[] ruoli = Ruolo.values();
		Ruolo ruolo = ruoli[ruoloIntValue];
		u.setRuolo(ruolo);
		u.setUsername(username);
		u.setEmail(email);
		u.setPassword(password);
		
		try(
				Connection  c = JdbcDAOfactory.getConnection();
				PreparedStatement ps = c.prepareStatement(query);
				){
			
			ps.setInt(1, ruoloIntValue);
			ps.setString(2, username);
			ps.setString(3, email);
			ps.setString(4, password);
			
			ps.executeUpdate();
			
			return u;			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Utente getByName(String nome) {
		String query = "SELECT * FROM UTENTE WHERE USERNAME = ?";
		
		try(
				Connection c = JdbcDAOfactory.getConnection();
				PreparedStatement ps = c.prepareStatement(query);
				) {
			ps.setString(1, nome);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				Utente u = new Utente();
				long id = rs.getLong("id");
				String username = rs.getString("username");
				String email = rs.getString("email");
				String password = rs.getString("password");
				int indiceRuolo = rs.getInt("ruolo");
				Ruolo[] ruoli = Ruolo.values();
				Ruolo ruolo = ruoli[indiceRuolo];
				u.setId(id);
				u.setUsername(username);
				u.setEmail(email);
				u.setPassword(password);
				u.setRuolo(ruolo);
				return u;
			}
			
		}catch(Exception e) {
				e.printStackTrace();
			}
		
		
		return null;
	}

	@Override
	public List<Utente> getAll() {
		
		List<Utente> utenti = new ArrayList<>();
		String query = "SELECT * FROM UTENTE";
		
		try(
				Connection  c = JdbcDAOfactory.getConnection();
				PreparedStatement ps = c.prepareStatement(query);
				){
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Utente u = new Utente();
				String email = rs.getString("email");
				String username = rs.getString("username");
				String password = rs.getString("password");
				int roleIntValue = rs.getInt("ruolo");
				Ruolo[] ruoli = Ruolo.values();
				Ruolo ruolo = ruoli[roleIntValue];
				u.setEmail(email);
				u.setUsername(username);
				u.setPassword(password);
				u.setRuolo(ruolo);
				utenti.add(u);
			}
			
			if(!utenti.isEmpty()) {
				return utenti;
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Utente update(String nome) {
		return null;
	}

	@Override
	public Utente deleteByNome(String nome) {
		
		String query = "DELETE FROM UTENTE WHERE USERNAME = ?";
		
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