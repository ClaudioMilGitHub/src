package org.elis.dao.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
	public Utente addUtente(int ruoloIntValue, String username, String email, String password, LocalDate dataNascita) {
		
		String query = "INSERT INTO utente (ruolo, username, email, password, data_nascita) VALUES (?,?,?,?,?)";
		
		Utente u = new Utente();
		Ruolo[] ruoli = Ruolo.values();
		Ruolo ruolo = ruoli[ruoloIntValue];
		u.setRuolo(ruolo);
		u.setUsername(username);
		u.setEmail(email);
		u.setPassword(password);
		u.setDataNascita(dataNascita);
		
		try(
				Connection  c = JdbcDAOfactory.getConnection();
				PreparedStatement ps = c.prepareStatement(query);
				){
			
			ps.setInt(1, ruoloIntValue);
			ps.setString(2, username);
			ps.setString(3, email);
			ps.setString(4, password);
			ps.setTimestamp(5, Timestamp.valueOf(dataNascita.toString()));
			
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
	public Utente getUtenteByName(String nome) {
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
				Timestamp dataN = rs.getTimestamp("data_nascita");
				LocalDate dataNascita = dataN.toLocalDateTime().toLocalDate();
				u.setId(id);
				u.setUsername(username);
				u.setEmail(email);
				u.setPassword(password);
				u.setRuolo(ruolo);
				u.setDataNascita(dataNascita);
				return u;
			}
			
		}catch(Exception e) {
				e.printStackTrace();
			}
		
		
		return null;
	}
	
	public Utente getUtenteById(long id) {
		String query = "SELECT * FROM UTENTE WHERE id = ?";
		
		try(
				Connection c = JdbcDAOfactory.getConnection();
				PreparedStatement ps = c.prepareStatement(query);
				) {
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				Utente u = new Utente();
				String username = rs.getString("username");
				String email = rs.getString("email");
				String password = rs.getString("password");
				int indiceRuolo = rs.getInt("ruolo");
				Ruolo[] ruoli = Ruolo.values();
				Ruolo ruolo = ruoli[indiceRuolo];
				Timestamp dataN = rs.getTimestamp("data_nascita");
				LocalDate dataNascita = dataN.toLocalDateTime().toLocalDate();
				u.setId(id);
				u.setUsername(username);
				u.setEmail(email);
				u.setPassword(password);
				u.setRuolo(ruolo);
				u.setDataNascita(dataNascita);
				return u;
			}
			
		}catch(Exception e) {
				e.printStackTrace();
			}
		
		
		return null;
	}

	@Override
	public List<Utente> getAllUtenti() {
		
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
				Timestamp dataN = rs.getTimestamp("data_nascita");
				LocalDate dataNascita = dataN.toLocalDateTime().toLocalDate();
				u.setEmail(email);
				u.setUsername(username);
				u.setPassword(password);
				u.setRuolo(ruolo);
				u.setDataNascita(dataNascita);
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
	public Utente updateUtente(String nome) {
		return null;
	}

	@Override
	public Utente deleteUtenteByNome(String nome) {
		
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