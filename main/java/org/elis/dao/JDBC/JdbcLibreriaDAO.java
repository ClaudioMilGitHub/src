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

public class JdbcLibreriaDAO implements LibreriaDAO {

    private JdbcLibreriaDAO() {}
    private static JdbcLibreriaDAO instance;

    public static JdbcLibreriaDAO getInstance() {
        if (instance == null) {
            instance = new JdbcLibreriaDAO();
        }
        return instance;
    }

    @Override
    public Libreria addLibreria(String nome, Utente utente, Gioco gioco) throws Exception {
        String query = "INSERT INTO libreria (nome, utente, gioco) VALUES (?, ?, ?)";
        
        Libreria libreria = new Libreria();
        List<Gioco> giochi = new ArrayList<>();
        libreria.setNome(nome);
        libreria.setUtente(utente);
        libreria.setGiochi(giochi);

        try (Connection c = JdbcDAOfactory.getConnection();
             PreparedStatement ps = c.prepareStatement(query)) {

            ps.setString(1, nome);
            ps.setLong(2, utente.getId());
            ps.setLong(3, gioco.getId());
            ps.executeUpdate();

            return libreria;

        } catch (SQLException e) {
            System.err.println("Errore durante l'aggiunta della libreria: " + e.getMessage());
            throw e; // Propaga l'eccezione
        }
    }

    @Override
    public Libreria getLibreriaByName(String nome) throws Exception {
        String query = "SELECT * FROM libreria JOIN libreria_gioco ON libreria.id = id_libreria JOIN gioco ON gioco.id = id_gioco WHERE libreria.nome = ?";
        
        Libreria libreria = null; // Inizializza come null
        List<Gioco> giochi = new ArrayList<>();

        try (Connection c = JdbcDAOfactory.getConnection();
             PreparedStatement ps = c.prepareStatement(query)) {

            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                libreria = new Libreria(); // Crea un nuovo oggetto Libreria
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
            }

        } catch (SQLException e) {
            System.err.println("Errore durante il recupero della libreria: " + e.getMessage());
            throw e; // Propaga l'eccezione
        }
        return libreria; // Restituisce null se non trovata
    }

    @Override
    public Libreria getLibreriaById(long id) throws Exception {
        String query = "SELECT * FROM libreria WHERE id = ?";
        
        Libreria libreria = null; // Inizializza come null

        try (Connection c = JdbcDAOfactory.getConnection();
             PreparedStatement ps = c.prepareStatement(query)) {

            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                libreria = new Libreria(); // Crea un nuovo oggetto Libreria
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
                // Non gestiamo i giochi in questa funzione, ma potresti aggiungerli se necessario
            }

        } catch (SQLException e) {
            System.err.println("Errore durante il recupero della libreria per ID: " + e.getMessage());
            throw e; // Propaga l'eccezione
        }
        return libreria; // Restituisce null se non trovata
    }

    @Override
    public List<Libreria> getAllLibrerie() throws Exception {
        List<Libreria> librerie = new ArrayList<>();
        String query = "SELECT * FROM libreria JOIN libreria_gioco ON libreria.id = id_libreria";

        try (Connection c = JdbcDAOfactory.getConnection();
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
            }

        } catch (SQLException e) {
            System.err.println("Errore durante il recupero delle librerie: " + e.getMessage());
            throw e; // Propaga l'eccezione
        }
        return librerie; // Restituisce una lista vuota se non trovate
    }

    @Override
    public Libreria updateLibreria(long id, String nuovoNome) throws Exception {
        String query = "UPDATE libreria SET nome = ? WHERE id = ?";
        Libreria libreria = null; // Inizializza come null

        try (Connection c = JdbcDAOfactory.getConnection();
             PreparedStatement ps = c.prepareStatement(query)) {

            ps.setString(1, nuovoNome); // Imposta il nuovo nome
            ps.setLong(2, id); // Imposta l'ID per la condizione

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                libreria = getLibreriaById(id); // Recupera la libreria aggiornata
            }

        } catch (SQLException e) {
            System.err.println("Errore durante l'aggiornamento della libreria: " + e.getMessage());
            throw e; // Propaga l'eccezione
        }
        return libreria; // Restituisce null se l'aggiornamento non ha avuto successo
    }

    @Override
    public Libreria deleteLibreriaByNome(String nome) throws Exception {
        String query = "DELETE FROM libreria WHERE nome = ?";

        try (Connection c = JdbcDAOfactory.getConnection();
             PreparedStatement ps = c.prepareStatement(query)) {
            ps.setString(1, nome);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Errore durante l'eliminazione della libreria: " + e.getMessage());
            throw e; // Propaga l'eccezione
        }
        return null; // Non restituisce nulla per l'eliminazione
    }

    @Override
    public Libreria updateLibreria(String nome) {
        // Implementazione del metodo non specificata. Se non è necessaria, puoi rimuoverlo dall'interfaccia.
        return null; // Restituisce null per ora
    }
}



