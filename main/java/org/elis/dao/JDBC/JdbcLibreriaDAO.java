package org.elis.dao.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.elis.businesslogic.BusinessLogic;
import org.elis.dao.LibreriaDAO;
import org.elis.model.Gioco;
import org.elis.model.Libreria;
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
	public Libreria addLibreria(String nome, Utente utente, Gioco gioco) {
		String query = "INSERT INTO libreria (nome,utente,gioco) VALUES (?,?,?)";
		
		Libreria l = new Libreria();
		List<Gioco> giochi = new ArrayList<>();
		
		l.setNome(nome);
		l.setUtente(utente);
		l.setGiochi(giochi);
		
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
	public Libreria getLibreriaByName(String nome) {
		String query = "SELECT * FROM libreria JOIN libreria_gioco ON libreria.id = id_libreria JOIN gioco ON gioco.id = id_gioco WHERE libreria.nome = ?";
		
		List<Gioco> giochi = new ArrayList<>();
		Libreria l = new Libreria();
		
		try(
				Connection c = JdbcDAOfactory.getConnection();
				PreparedStatement ps = c.prepareStatement(query);
				) {
			ps.setString(1, nome);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				
				
				long id = rs.getLong("id");
				Timestamp dataCreazioneTimestamp = rs.getTimestamp("data_creazione");
				LocalDateTime dataCreazione = dataCreazioneTimestamp.toLocalDateTime();
				Timestamp dataUltimaModificaTimestamp = rs.getTimestamp("data_ultima_modifica");
				LocalDateTime dataUltimaModifica = dataUltimaModificaTimestamp.toLocalDateTime();
				String nomeLibreria = rs.getString("nome");
				long idUtente = rs.getLong("id_utente");
				long idGioco = rs.getLong("id_gioco");
				
				
				
				l.setId(id);
				l.setNome(nomeLibreria);
				l.setDataCreazione(dataCreazione);
				l.setDataUltimaModifica(dataUltimaModifica);
				Utente u = BusinessLogic.getUtenteById(idUtente);
				l.setUtente(u);
				Gioco g = BusinessLogic.getGiocoById(idGioco);
				giochi.add(g);
				l.setGiochi(giochi);				
			}		
			return l;
		}catch(Exception e) {
				e.printStackTrace();
			}
		return null;
	}

	@Override
	public List<Libreria> getAllLibrerie() {
		List<Libreria> librerie = new ArrayList<>();
		String query = "select * from libreria JOIN libreria_gioco ON libreria.id = id_libreria;";
		
		try(
				Connection  c = JdbcDAOfactory.getConnection();
				PreparedStatement ps = c.prepareStatement(query);
				){
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Libreria l = new Libreria();
				long id = rs.getLong("id");
				Timestamp dataCreazioneTimestamp = rs.getTimestamp("data_creazione");
				LocalDateTime dataCreazione = dataCreazioneTimestamp.toLocalDateTime();
				Timestamp dataUltimaModificaTimestamp = rs.getTimestamp("data_ultima_modifica");
				LocalDateTime dataUltimaModifica = dataUltimaModificaTimestamp.toLocalDateTime();
				String nome = rs.getString("nome");
				long idUtente = rs.getLong("id_utente");
				long idGioco = rs.getLong("id_gioco");
				List<Gioco> giochi = new ArrayList<>();

				l.setId(id);
				l.setNome(nome);
				l.setDataCreazione(dataCreazione);
				l.setDataUltimaModifica(dataUltimaModifica);
				Utente u = JdbcUtenteDAO.getInstance().getUtenteById(idUtente);
				l.setUtente(u);
				Gioco g = JdbcGiocoDAO.getInstance().getGiocoById(idGioco);
				giochi.add(g);
				l.setGiochi(giochi);
				
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
	public Libreria updateLibreria(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Libreria deleteLibreriaByNome(String nome) {
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
