package org.elis.dao.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.elis.dao.OffertaDAO;
import org.elis.model.Offerta;

public class JdbcOffertaDAO implements OffertaDAO {
    private JdbcOffertaDAO() {}
    private static JdbcOffertaDAO instance;

    public static JdbcOffertaDAO getInstance() {
        if (instance == null) {
            instance = new JdbcOffertaDAO();
        }
        return instance;
    }

    @Override
    public Offerta add(Offerta offerta) throws Exception {
        String query = "INSERT INTO offerta (nome, sconto, dataInizio, dataFine) VALUES (?, ?, ?, ?)";
        try {
			try (Connection c = JdbcDAOfactory.getConnection();
			     PreparedStatement ps = c.prepareStatement(query)) {
			    ps.setString(1, offerta.getNome());
			    ps.setDouble(2, offerta.getSconto());
			    ps.setTimestamp(3, offerta.getDataInizio());
			    ps.setTimestamp(4, offerta.getDataFine());
			    ps.executeUpdate();
			    return offerta;
			} catch (SQLException e) {
			    e.printStackTrace();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }

    @Override
    public Offerta getById(int id) throws Exception {
        String query = "SELECT * FROM OFFERTA WHERE ID = ?";
        try (Connection c = JdbcDAOfactory.getConnection();
             PreparedStatement ps = c.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Offerta offerta = new Offerta();
                offerta.setNome(rs.getString("nome"));
                offerta.setSconto(rs.getDouble("sconto"));
                offerta.setDataInizio(rs.getTimestamp("dataInizio"));
                offerta.setDataFine(rs.getTimestamp("dataFine"));
                return offerta;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Offerta> getAll() throws Exception {
        List<Offerta> offerte = new ArrayList<>();
        String query = "SELECT * FROM OFFERTA";
        try (Connection c = JdbcDAOfactory.getConnection();
             PreparedStatement ps = c.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Offerta offerta = new Offerta();
                offerta.setNome(rs.getString("nome"));
                offerta.setSconto(rs.getDouble("sconto"));
                offerta.setDataInizio(rs.getTimestamp("dataInizio"));
                offerta.setDataFine(rs.getTimestamp("dataFine"));
                offerte.add(offerta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return offerte;
    }

    @Override
    public Offerta update(Offerta offerta) {
        // Implementa la logica di aggiornamento se necessario
        return null;
    }

    @Override
    public void deleteById(int id) throws Exception {
        String query = "DELETE FROM OFFERTA WHERE ID = ?";
        try (Connection c = JdbcDAOfactory.getConnection();
             PreparedStatement ps = c.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
