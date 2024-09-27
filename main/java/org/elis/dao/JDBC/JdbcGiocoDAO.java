package org.elis.dao.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.elis.dao.GiocoDAO;
import org.elis.model.Gioco;
import org.elis.model.Offerta;
import org.elis.model.Utente;

public class JdbcGiocoDAO implements GiocoDAO{
	
	private JdbcGiocoDAO() {}
	private static JdbcGiocoDAO instance;
	public static JdbcGiocoDAO getInstance() {
		
		if(instance == null) {
			
			instance = new JdbcGiocoDAO();
		}
		
		return instance;
	}
	
	@Override
	public Gioco addGioco(String nome, LocalDateTime dataRilascio, String descrizione, double prezzo, Offerta offerta,
			Utente utente) {
		String query = "INSERT INTO gioco (nome, data_rilascio, descrizione, prezzo, id_offerta, id_casa_editrice)"
				+ "VALUES (?,?,?,?,?,?)";
		
		Gioco g = new Gioco();
		
		g.setNome(nome);
		g.setDataRilascio(dataRilascio);
		g.setDescrizione(descrizione);
		g.setPrezzo(prezzo);
		
		if(offerta != null) {
			g.setIdOfferta(offerta.getId());
		}
		if(utente != null) {
			g.setIdCasaEditrice(utente.getId());
		}
		
		
		
		try(
				Connection c = JdbcDAOfactory.getConnection();
				PreparedStatement ps = c.prepareStatement(query);
				){
			
			ps.setString(1, nome);
			ps.setTimestamp(2, Timestamp.valueOf(dataRilascio));
			ps.setString(3, descrizione);
			ps.setDouble(4, prezzo);
			
			if(offerta != null) {
				ps.setLong(5, offerta.getId());
			} else {
				ps.setNull(5, Types.INTEGER);
			}
				

			if(utente != null) {
				ps.setLong(6, utente.getId());
			} else {
				ps.setNull(6, Types.INTEGER);
			}
	
			ps.executeUpdate();
			
			return g;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}

		return null;
		
	}
	
	public Gioco getGiocoById(long id) {
		String query = "SELECT * FROM gioco WHERE id = ?";
		
		try(
				Connection c = JdbcDAOfactory.getConnection();
				PreparedStatement ps = c.prepareStatement(query);
				) {
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				Gioco g = new Gioco();
				String nome = rs.getString("nome");
				Timestamp dataR = rs.getTimestamp("data_rilascio");
				LocalDateTime dataRilascio = dataR.toLocalDateTime();
				String descrizione = rs.getString("descrizione");
				long idOfferta = rs.getLong("id_offerta");
				long idCasaEditrice =  rs.getLong("id_casa_editrice");
				Timestamp dataC = rs.getTimestamp("data_creazione");
				LocalDateTime dataCreazione = dataC.toLocalDateTime();
				Timestamp dataM = rs.getTimestamp("data_ultima_modifica");
				LocalDateTime dataUltimaModifica = dataM.toLocalDateTime();
				
				g.setId(id);
				g.setDataRilascio(dataRilascio);
				g.setDescrizione(descrizione);
				g.setIdCasaEditrice(idCasaEditrice);
				g.setIdOfferta(idOfferta);
				g.setNome(nome);			
				g.setDataCreazione(dataCreazione);
				g.setDataUltimaModifica(dataUltimaModifica);
				return g;
			}
			
		}catch(Exception e) {
				e.printStackTrace();
			}
		
		
		return null;
	}

	@Override
	public Gioco getGiocoByName(String nome) {
		String query = "SELECT * FROM gioco WHERE nome = ?";
		
		try(
				Connection c = JdbcDAOfactory.getConnection();
				PreparedStatement ps = c.prepareStatement(query);
				) {
			ps.setString(1, nome);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				Gioco g = new Gioco();
				
				long id = rs.getLong("id");
				Timestamp dataR = rs.getTimestamp("data_rilascio");
				LocalDateTime dataRilascio = dataR.toLocalDateTime();
				String descrizione = rs.getString("descrizione");
				long idOfferta = rs.getLong("id_offerta");
				long idCasaEditrice =  rs.getLong("id_casa_editrice");
				Timestamp dataC = rs.getTimestamp("data_creazione");
				LocalDateTime dataCreazione = dataC.toLocalDateTime();
				Timestamp dataM = rs.getTimestamp("data_ultima_modifica");
				LocalDateTime dataUltimaModifica = dataM.toLocalDateTime();
				
				g.setId(id);
				g.setDataRilascio(dataRilascio);
				g.setDescrizione(descrizione);
				g.setIdCasaEditrice(idCasaEditrice);
				g.setIdOfferta(idOfferta);
				g.setNome(nome);			
				g.setDataCreazione(dataCreazione);
				g.setDataUltimaModifica(dataUltimaModifica);
				return g;
			}
			
		}catch(Exception e) {
				e.printStackTrace();
			}
		
		
		return null;
	}

	@Override
	public List<Gioco> getAllGiochi() {
		List<Gioco> giochi = new ArrayList<>();
		String query = "SELECT * FROM gioco";
		
		try(
				Connection  c = JdbcDAOfactory.getConnection();
				PreparedStatement ps = c.prepareStatement(query);
				){
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Gioco g = new Gioco();
				String nome = rs.getString("nome");
				
				g.setNome(nome);
				
				giochi.add(g);
			}
			
			if(!giochi.isEmpty()) {
				return giochi;
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Gioco updateGioco(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Gioco deleteGiocoByNome(String nome) {
		String query = "DELETE FROM gioco WHERE nome = ?";
		
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