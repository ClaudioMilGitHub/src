package org.elis.dao.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.time.LocalDate;
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
	public Gioco addGioco(String nome, LocalDate dataRilascio, String descrizione, String imagePath, double prezzo, Offerta offerta,
			Utente utente) {
		String query = "INSERT INTO gioco (nome, data_rilascio, descrizione, immagine, prezzo, id_offerta, id_casa_editrice)"
				+ "VALUES (?,?,?,?,?,?,?)";
		
		Gioco g = new Gioco();
		
		g.setNome(nome);
		g.setDataRilascio(dataRilascio);
		g.setDescrizione(descrizione);
		g.setImagePath(imagePath);
		g.setPrezzo(prezzo);
		
		if(offerta != null) {
			g.setOfferta(offerta);
		}
		if(utente != null) {
			g.getUtenti().add(utente);
		}
		
		
		
		try(
				Connection c = JdbcDAOFactory.getConnection();
				PreparedStatement ps = c.prepareStatement(query);
				){
			
			ps.setString(1, nome);
			ps.setDate(2, java.sql.Date.valueOf(dataRilascio));
			ps.setString(3, descrizione);
			ps.setString(4, imagePath);
			ps.setDouble(5, prezzo);
			
			if(offerta != null) {
				ps.setLong(6, offerta.getId());
			} else {
				ps.setNull(6, Types.INTEGER);
			}
				

			if(utente != null) {
				ps.setLong(7, utente.getId());
			} else {
				ps.setNull(7, Types.INTEGER);
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
		//ora la select è più specifica
		
		try(
				Connection c = JdbcDAOFactory.getConnection();
				PreparedStatement ps = c.prepareStatement(query);
				) {
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				Gioco g = new Gioco();
				
				String nome = rs.getString("nome");
				Timestamp dataR = rs.getTimestamp("data_rilascio");
				LocalDate dataRilascio = dataR.toLocalDateTime().toLocalDate();
				String descrizione = rs.getString("descrizione");
				String imagePath = rs.getString("immagine");
				long idOfferta = rs.getLong("id_offerta");
				long idCasaEditrice =  rs.getLong("id_casa_editrice");
				Timestamp dataC = rs.getTimestamp("data_creazione");
				LocalDateTime dataCreazione = dataC.toLocalDateTime();
				Timestamp dataM = rs.getTimestamp("data_ultima_modifica");
				LocalDateTime dataUltimaModifica = dataM.toLocalDateTime();
				
				g.setId(id);
				g.setDataRilascio(dataRilascio);
				g.setDescrizione(descrizione);
				//g.setIdCasaEditrice(idCasaEditrice);
				//g.setIdOfferta(idOfferta);
				g.setNome(nome);			
				g.setDataCreazione(dataCreazione);
				g.setDataUltimaModifica(dataUltimaModifica);
				g.setImagePath(imagePath);
				
				return g;
			}
			
		}catch(Exception e) {
				e.printStackTrace();
			}
		
		
		return null;
	}

	@Override
	public Gioco getGiocoByName(String nome) {
		String query = "SELECT id, nome, data_rilascio, descrizione, id_offerta, id_casa_editrice, data_creazione, data_ultima_modifica FROM gioco WHERE nome = ?";

		
		try(
				Connection c = JdbcDAOFactory.getConnection();
				PreparedStatement ps = c.prepareStatement(query);
				) {
			ps.setString(1, nome);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				Gioco g = new Gioco();
				
				long id = rs.getLong("id");
				Timestamp dataR = rs.getTimestamp("data_rilascio");
				LocalDate dataRilascio = dataR.toLocalDateTime().toLocalDate();
				String descrizione = rs.getString("descrizione");
				String imagePath = rs.getString("immagine");
				long idOfferta = rs.getLong("id_offerta");
				long idCasaEditrice =  rs.getLong("id_casa_editrice");
				Timestamp dataC = rs.getTimestamp("data_creazione");
				LocalDateTime dataCreazione = dataC.toLocalDateTime();
				Timestamp dataM = rs.getTimestamp("data_ultima_modifica");
				LocalDateTime dataUltimaModifica = dataM.toLocalDateTime();
				
				g.setId(id);
				g.setDataRilascio(dataRilascio);
				g.setDescrizione(descrizione);
				g.setImagePath(imagePath);
			//	g.setIdCasaEditrice(idCasaEditrice);
			//	g.setIdOfferta(idOfferta);
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
				Connection  c = JdbcDAOFactory.getConnection();
				PreparedStatement ps = c.prepareStatement(query);
				){
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Gioco g = new Gioco();
				
				
				long id = rs.getLong("id");
				String nome = rs.getString("nome");
				Timestamp dataR = rs.getTimestamp("data_rilascio");
				LocalDate dataRilascio = dataR.toLocalDateTime().toLocalDate();
				String descrizione = rs.getString("descrizione");
				String imagePath = rs.getString("immagine");
				long idOfferta = rs.getLong("id_offerta");
				long idCasaEditrice =  rs.getLong("id_casa_editrice");
				Timestamp dataC = rs.getTimestamp("data_creazione");
				LocalDateTime dataCreazione = dataC.toLocalDateTime();
				Timestamp dataM = rs.getTimestamp("data_ultima_modifica");
				LocalDateTime dataUltimaModifica = dataM.toLocalDateTime();
				
				g.setId(id);
				g.setDataRilascio(dataRilascio);
				g.setDescrizione(descrizione);
				g.setImagePath(imagePath);
			//	g.setIdCasaEditrice(idCasaEditrice);
				//g.setIdOfferta(idOfferta);
				g.setNome(nome);			
				g.setDataCreazione(dataCreazione);
				g.setDataUltimaModifica(dataUltimaModifica);
				
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
	public List<Gioco> getAllGiochiByGenere(long genere){
		List<Gioco> giochi = new ArrayList<>();
		String query = "SELECT * from gioco JOIN genere_gioco ON gioco.id = id_gioco WHERE id_genere = ?";
		try(
				Connection  c = JdbcDAOFactory.getConnection();
				PreparedStatement ps = c.prepareStatement(query);
				){
			ps.setLong(1, genere);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Gioco g = new Gioco();
				long id_gioco = rs.getLong("id_gioco");
				long id_casa_editrice = rs.getLong("id_casa_editrice");
				long id_offerta = rs.getLong("id_offerta");
				String nome = rs.getString("nome");
				String descrizione = rs.getString("descrizione");
				String imagePath = rs.getString("immagine");
				double prezzo = rs.getDouble("prezzo");
				Timestamp data_rilascio = rs.getTimestamp("data_rilascio");
				LocalDate dataRilascio = data_rilascio.toLocalDateTime().toLocalDate();
				
				g.setId(id_gioco);
				//g.setIdCasaEditrice(id_casa_editrice);
				//g.setIdOfferta(id_offerta);
				g.setNome(nome);
				g.setDescrizione(descrizione);
				g.setImagePath(imagePath);
				g.setPrezzo(prezzo);
				g.setDataRilascio(dataRilascio);
				
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
	public Gioco updateGiocoNome(Gioco gioco, String nome) {
		
		String query = "UPDATE gioco SET nome = ? WHERE ID = ?";
		
		try(
				Connection  c = JdbcDAOFactory.getConnection();
				PreparedStatement ps = c.prepareStatement(query);
				){
			
			ps.setString(1, nome);
			ps.setLong(2, gioco.getId());
			
			ps.executeUpdate();
			
			gioco.setNome(nome);
			
			return gioco;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Gioco updateGiocoImmagine(Gioco gioco, String path) {
		
		String query = "UPDATE gioco SET immagine = ? WHERE ID = ?";
		
		try(
				Connection  c = JdbcDAOFactory.getConnection();
				PreparedStatement ps = c.prepareStatement(query);
				){
			
			ps.setString(1, path);
			ps.setLong(2, gioco.getId());
			
			ps.executeUpdate();
			
			gioco.setNome(path);
			return gioco;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Gioco updateGiocoDataRilascio(Gioco gioco, LocalDate dataRilascio) {
		
		String query = "UPDATE gioco SET data_rilascio = ? WHERE ID = ?";
		
		try(
				Connection  c = JdbcDAOFactory.getConnection();
				PreparedStatement ps = c.prepareStatement(query);
				){
			
			ps.setTimestamp(1, Timestamp.valueOf(dataRilascio.toString()));
			ps.setLong(2, gioco.getId());
			
			ps.executeUpdate();
			
			gioco.setDataRilascio(dataRilascio);
			return gioco;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Gioco updateGiocoDescrizione(Gioco gioco, String descrizione) {
		
		String query = "UPDATE gioco SET descrizione = ? WHERE ID = ?";
		
		try(
				Connection  c = JdbcDAOFactory.getConnection();
				PreparedStatement ps = c.prepareStatement(query);
				){
			
			ps.setString(1, descrizione);
			ps.setLong(2, gioco.getId());
			
			ps.executeUpdate();
			
			gioco.setDescrizione(descrizione);
			return gioco;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Gioco updateGiocoPrezzo(Gioco gioco, double prezzo) {
		
		String query = "UPDATE gioco SET prezzo = ? WHERE ID = ?";
		
		try(
				Connection  c = JdbcDAOFactory.getConnection();
				PreparedStatement ps = c.prepareStatement(query);
				){
			
			ps.setDouble(1, prezzo);
			ps.setLong(2, gioco.getId());
			
			ps.executeUpdate();
			
			gioco.setPrezzo(prezzo);
			return gioco;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Gioco deleteGiocoByNome(String nome) {
		String query = "DELETE FROM gioco WHERE nome = ? LIMIT 1";

		
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

	@Override
	public List<Gioco> getGiochiByUtente(Utente utente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteGiocoById(long id) {
		// TODO Auto-generated method stub
		
	}
}