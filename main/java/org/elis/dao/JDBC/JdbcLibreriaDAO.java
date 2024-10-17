package org.elis.dao.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.elis.dao.LibreriaDAO;
import org.elis.model.Gioco;
import org.elis.model.Libreria;
import org.elis.model.Utente;
/*
public class JdbcLibreriaDAO implements LibreriaDAO {

    private JdbcLibreriaDAO() {}
    private static JdbcLibreriaDAO instance;

    public static JdbcLibreriaDAO getInstance() {
        if (instance == null) {
            instance = new JdbcLibreriaDAO();
        }
        return instance;
    }

    //@Override
    public Libreria addLibreria(String nome, Utente utente, Gioco gioco) {
    	String query = "INSERT INTO libreria (nome, id_utente, id_gioco) VALUES (?, ?, ?)";

    	//ho sostituito UTENTE e GIOCO con i loto ID per evitare fraintendimenti ed essere più specifici
        
        Libreria libreria = new Libreria();
        List<Gioco> giochi = new ArrayList<>();
       // libreria.setNome(nome);
        libreria.setUtente(utente);
      //  libreria.setGiochi(giochi);

        try (Connection c = JdbcDAOFactory.getConnection();
             PreparedStatement ps = c.prepareStatement(query)) {

            ps.setString(1, nome);
            ps.setLong(2, utente.getId());
            ps.setLong(3, gioco.getId());
            ps.executeUpdate();

            return libreria;

        } catch (Exception e) {
            System.err.println("Errore durante l'aggiunta della libreria: " + e.getMessage());
        }
		return null;
    }

    //@Override
    public Libreria getLibreriaByName(String nome) {
        String query = "SELECT * FROM libreria JOIN libreria_gioco ON libreria.id = id_libreria JOIN gioco ON gioco.id = id_gioco WHERE libreria.nome = ?";
        
        Libreria libreria = null;
        List<Gioco> giochi = new ArrayList<>();

        try (Connection c = JdbcDAOFactory.getConnection();
             PreparedStatement ps = c.prepareStatement(query)) {

            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                libreria = new Libreria();
                long id = rs.getLong("id");
                Timestamp dataCreazioneTimestamp = rs.getTimestamp("data_creazione");
                LocalDateTime dataCreazione = dataCreazioneTimestamp.toLocalDateTime();
                Timestamp dataUltimaModificaTimestamp = rs.getTimestamp("data_ultima_modifica");
                LocalDateTime dataUltimaModifica = dataUltimaModificaTimestamp.toLocalDateTime();
                long idUtente = rs.getLong("id_utente");
                long idGioco = rs.getLong("id_gioco");

                libreria.setId(id);
                libreria.setNome(nome);
                libreria.setDataCreazione(dataCreazione);
                libreria.setDataUltimaModifica(dataUltimaModifica);
                libreria.setUtente(JdbcUtenteDAO.getInstance().getUtenteById(idUtente));
                giochi.add(JdbcGiocoDAO.getInstance().getGiocoById(idGioco));
                libreria.setGiochi(giochi);
                return libreria;
            }

        } catch (SQLException e) {
            System.err.println("Errore durante il recupero della libreria: " + e.getMessage());
        } catch (Exception e1) {
			e1.printStackTrace();
		}
		return null;
        
    }

    @Override
    public Libreria getLibreriaById(long id) {
        String query = "SELECT * FROM libreria WHERE id = ?";
        
        Libreria libreria = null;

        try (Connection c = JdbcDAOFactory.getConnection();
             PreparedStatement ps = c.prepareStatement(query)) {

            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                libreria = new Libreria();
                long libreriaId = rs.getLong("id");
                String nome = rs.getString("nome");
                Timestamp dataCreazioneTimestamp = rs.getTimestamp("data_creazione");
                LocalDateTime dataCreazione = dataCreazioneTimestamp.toLocalDateTime();
                Timestamp dataUltimaModificaTimestamp = rs.getTimestamp("data_ultima_modifica");
                LocalDateTime dataUltimaModifica = dataUltimaModificaTimestamp.toLocalDateTime();
                long idUtente = rs.getLong("id_utente");

                libreria.setId(libreriaId);
                libreria.setNome(nome);
                libreria.setDataCreazione(dataCreazione);
                libreria.setDataUltimaModifica(dataUltimaModifica);
                libreria.setUtente(JdbcUtenteDAO.getInstance().getUtenteById(idUtente));
                return libreria;
            }

        } catch (SQLException e) {
            System.err.println("Errore durante il recupero della libreria per ID: " + e.getMessage());
        } catch (Exception e1) {
			e1.printStackTrace();
		}
        return null;
    }

    @Override
    public List<Libreria> getAllLibrerie() {
        List<Libreria> librerie = new ArrayList<>();
        String query = "SELECT * FROM libreria JOIN libreria_gioco ON libreria.id = id_libreria";

        try (Connection c = JdbcDAOFactory.getConnection();
             PreparedStatement ps = c.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Libreria libreria = new Libreria();
                long id = rs.getLong("id");
                Timestamp dataCreazioneTimestamp = rs.getTimestamp("data_creazione");
                LocalDateTime dataCreazione = dataCreazioneTimestamp.toLocalDateTime();
                Timestamp dataUltimaModificaTimestamp = rs.getTimestamp("data_ultima_modifica");
                LocalDateTime dataUltimaModifica = dataUltimaModificaTimestamp.toLocalDateTime();
                String nome = rs.getString("nome");
                long idUtente = rs.getLong("id_utente");
                long idGioco = rs.getLong("id_gioco");
                List<Gioco> giochi = new ArrayList<>();

                libreria.setId(id);
                libreria.setNome(nome);
                libreria.setDataCreazione(dataCreazione);
                libreria.setDataUltimaModifica(dataUltimaModifica);
                libreria.setUtente(JdbcUtenteDAO.getInstance().getUtenteById(idUtente));
                giochi.add(JdbcGiocoDAO.getInstance().getGiocoById(idGioco));
                libreria.setGiochi(giochi);

                librerie.add(libreria);
                
                return librerie;
            }

        } catch (SQLException e) {
            System.err.println("Errore durante il recupero delle librerie: " + e.getMessage());
        } catch (Exception e1) {
			e1.printStackTrace();
		}
        return null;
    }

    @Override
    public Libreria updateLibreriaById(long id, String nuovoNome) {
    	String query = "UPDATE libreria SET nome = ?, data_ultima_modifica = NOW() WHERE id = ?";
    	//ho aggiunto la data di ultima modifica applicando il now() per cambiarla simultaneamente alla modifica, 
    	//su W3 School ho trovato questa definizione:
    	//"The NOW() function returns the current date and time."
        Libreria libreria = null;

        try (Connection c = JdbcDAOFactory.getConnection();
             PreparedStatement ps = c.prepareStatement(query)) {

            ps.setString(1, nuovoNome);
            ps.setLong(2, id);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                libreria = getLibreriaById(id);
            }
            
            return libreria;

        } catch (SQLException e) {
            System.err.println("Errore durante l'aggiornamento della libreria: " + e.getMessage());
        } catch (Exception e1) {
			e1.printStackTrace();
		}
        return null;
    }

    @Override
    public Libreria deleteLibreriaByNome(String nome) {
        String query = "DELETE FROM libreria WHERE nome = ?";

        try (Connection c = JdbcDAOFactory.getConnection();
             PreparedStatement ps = c.prepareStatement(query)) {
            ps.setString(1, nome);
            ps.executeUpdate();
            
        } catch (SQLException e) {
            System.err.println("Errore durante l'eliminazione della libreria: " + e.getMessage());
        } catch (Exception e1) {
			e1.printStackTrace();
		}
        return null;
    }

	@Override
	public Libreria aggiungiGiocoALibreria(Utente utente, Gioco gioco) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Libreria deleteLibreriaById(long id) {
		// TODO Auto-generated method stub
		return null;
	}
}*/