package org.elis.dao.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.elis.dao.UtenteDAO;
import org.elis.model.Ruolo;
import org.elis.model.Utente;
/*
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
	public Utente addUtente(int ruoloIntValue, String username, String email, String password, String nome, String cognome, String telefono, String indirizzo, String sitoWeb, String comuneResidenza, LocalDate dataNascita) {
		
		String query = "INSERT INTO utente (ruolo, username, email, password, nome, cognome, telefono, indirizzo, sito_web, comune_residenza, data_nascita) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		
		Utente u = new Utente();
		Ruolo[] ruoli = Ruolo.values();
		Ruolo ruolo = ruoli[ruoloIntValue];
		u.setRuolo(ruolo);
		u.setUsername(username);
		u.setEmail(email);
		u.setPassword(password);
		u.setNome(nome);
		u.setCognome(cognome);
		u.setTelefono(telefono);
		u.setIndirizzo(indirizzo);
		u.setSitoWeb(sitoWeb);
		u.setComuneResidenza(comuneResidenza);
		u.setDataNascita(dataNascita);
		
		try(
				Connection  c = JdbcDAOFactory.getConnection();
				PreparedStatement ps = c.prepareStatement(query);
				
				){
			
			ps.setInt(1, ruoloIntValue);
			ps.setString(2, username);
			ps.setString(3, email);
			ps.setString(4, password);
			ps.setString(5, nome);
			ps.setString(6, cognome);
			ps.setString(7, telefono);
			ps.setString(8, indirizzo);
			ps.setString(9, sitoWeb);
			ps.setString(10, comuneResidenza);
			ps.setDate(11, java.sql.Date.valueOf(dataNascita));
			
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
	public Utente getUtenteByName(String usernameSearch) {
		String query = "SELECT * FROM UTENTE WHERE USERNAME = ?";
		
		try(
				Connection c = JdbcDAOFactory.getConnection();
				PreparedStatement ps = c.prepareStatement(query);
				) {
			ps.setString(1, usernameSearch);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				Utente u = new Utente();
				
				long id = rs.getLong("id");
				String username = rs.getString("username");
				String email = rs.getString("email");
				String password = rs.getString("password");
				String nome = rs.getString("nome");
				String cognome = rs.getString("cognome");
				String telefono = rs.getString("telefono");
				String indirizzo = rs.getString("indirizzo");
				String sitoWeb = rs.getString("sito_web");
				String comuneResidenza = rs.getString("comune_residenza");
				
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
				u.setNome(nome);
				u.setCognome(cognome);
				u.setTelefono(telefono);
				u.setIndirizzo(indirizzo);
				u.setSitoWeb(sitoWeb);
				u.setComuneResidenza(comuneResidenza);
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
				Connection c = JdbcDAOFactory.getConnection();
				PreparedStatement ps = c.prepareStatement(query);
				) {
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				Utente u = new Utente();
				
				String username = rs.getString("username");
				String email = rs.getString("email");
				String password = rs.getString("password");
				String nome = rs.getString("nome");
				String cognome = rs.getString("cognome");
				String telefono = rs.getString("telefono");
				String indirizzo = rs.getString("indirizzo");
				String sitoWeb = rs.getString("sito_web");
				String comuneResidenza = rs.getString("comune_residenza");
				
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
				u.setNome(nome);
				u.setCognome(cognome);
				u.setTelefono(telefono);
				u.setIndirizzo(indirizzo);
				u.setSitoWeb(sitoWeb);
				u.setComuneResidenza(comuneResidenza);
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
				Connection  c = JdbcDAOFactory.getConnection();
				PreparedStatement ps = c.prepareStatement(query);
				){
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Utente u = new Utente();
				long id = rs.getLong("id");
				String username = rs.getString("username");
				String email = rs.getString("email");
				String password = rs.getString("password");
				String nome = rs.getString("nome");
				String cognome = rs.getString("cognome");
				String telefono = rs.getString("telefono");
				String indirizzo = rs.getString("indirizzo");
				String sitoWeb = rs.getString("sito_web");
				String comuneResidenza = rs.getString("comune_residenza");
				
				int roleIntValue = rs.getInt("ruolo");
				Ruolo[] ruoli = Ruolo.values();
				Ruolo ruolo = ruoli[roleIntValue];				
				Timestamp dataN = rs.getTimestamp("data_nascita");
				
				LocalDate dataNascita = dataN.toLocalDateTime().toLocalDate();
				
				u.setId(id);
				u.setUsername(username);
				u.setEmail(email);
				u.setPassword(password);
				u.setRuolo(ruolo);
				u.setNome(nome);
				u.setCognome(cognome);
				u.setTelefono(telefono);
				u.setIndirizzo(indirizzo);
				u.setSitoWeb(sitoWeb);
				u.setComuneResidenza(comuneResidenza);
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
	public Utente updateUtenteUsername(Utente utenteLoggato, String newUsername) {
		
		String query = "UPDATE utente SET username = ? WHERE ID = ?";
		
		try(
				Connection  c = JdbcDAOFactory.getConnection();
				PreparedStatement ps = c.prepareStatement(query);
				){
			
			ps.setString(1, newUsername);
			ps.setLong(2, utenteLoggato.getId());
			
			ps.executeUpdate();
			
			utenteLoggato.setUsername(newUsername);
			return utenteLoggato;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	public Utente updateUtentePassword(Utente utenteLoggato, String newPassword) {
		
		String query = "UPDATE utente SET password = ? WHERE ID = ?";
		
		try(
				Connection  c = JdbcDAOFactory.getConnection();
				PreparedStatement ps = c.prepareStatement(query);
				){
			
			ps.setString(1, newPassword);
			ps.setLong(2, utenteLoggato.getId());
			
			ps.executeUpdate();
			
			utenteLoggato.setPassword(newPassword);
			return utenteLoggato;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	public Utente updateUtenteDataNascita(Utente utenteLoggato, LocalDate newDataNascita) {
		
		String query = "UPDATE utente SET data_nascita = ? WHERE ID = ?";
		
		try(
				Connection  c = JdbcDAOFactory.getConnection();
				PreparedStatement ps = c.prepareStatement(query);
				){
			
			ps.setTimestamp(1, Timestamp.valueOf(newDataNascita.toString()));
			ps.setLong(2, utenteLoggato.getId());
			
			ps.executeUpdate();
			
			utenteLoggato.setDataNascita(newDataNascita);
			return utenteLoggato;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Utente deleteUtenteByNome(String nome) {
		
		String query = "DELETE FROM UTENTE WHERE USERNAME = ?";
		
		try(
				Connection  c = JdbcDAOFactory.getConnection();
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
}*/