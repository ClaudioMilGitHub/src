package org.elis.dao.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.elis.dao.GiocoDAO;
import org.elis.model.Gioco;
import org.elis.model.Ruolo;
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
	public Gioco addGioco(String nome, LocalDateTime dataRilascio, String descrizione, double prezzo, Integer idOfferta,
			Integer idCasaEditrice) {
		String query = "SELECT * FROM gioco WHERE nome = ?";
		
		Gioco g = new Gioco();
		g.setNome(nome);
		g.setDataRilascio(dataRilascio);
		g.setDescrizione(descrizione);
		g.setPrezzo(prezzo);
		g.setIdOfferta(idOfferta);
		g.setIdCasaEditrice(idCasaEditrice);
		
		
		try(
				Connection c = JdbcDAOfactory.getConnection();
				PreparedStatement ps = c.prepareStatement(query);
				){
			ps.setString(1, nome);
			ps.setTimestamp(2, Timestamp.valueOf(dataRilascio));
			ps.setString(3, descrizione);
			ps.setDouble(4, prezzo);
			ps.setObject(5, idOfferta, java.sql.Types.INTEGER);
			ps.setObject(6, idCasaEditrice, java.sql.Types.INTEGER);
			
			ps.executeUpdate();
			
			return g;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}

		return null;
		
	}
	
	public Gioco getById(long id) {
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
				Integer idOfferta = (Integer) rs.getObject("id_offerta");
				Integer idCasaEditrice = (Integer) rs.getObject("id_casa_editrice");
				
				g.setId(id);
				g.setDataRilascio(dataRilascio);
				g.setDescrizione(descrizione);
				g.setIdCasaEditrice(idCasaEditrice);
				g.setIdOfferta(idOfferta);
				g.setNome(nome);			
				return g;
			}
			
		}catch(Exception e) {
				e.printStackTrace();
			}
		
		
		return null;
	}

	@Override
	public Gioco getByName(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Gioco> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Gioco update(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Gioco deleteByNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
