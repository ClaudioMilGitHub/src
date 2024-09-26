package org.elis.dao.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.elis.dao.GenereDAO;
import org.elis.model.Genere;

public class JdbcGenereDAO implements GenereDAO {
    private static JdbcGenereDAO instance;

    private JdbcGenereDAO() {}

    public static JdbcGenereDAO getInstance() {
        if (instance == null) {
            instance = new JdbcGenereDAO();
        }
        return instance;
    }

    @Override
    public Genere add(String nome) throws Exception {
        String query = "INSERT INTO genere (nome) VALUES (?)";
        try (Connection c = JdbcDAOfactory.getConnection();
             PreparedStatement ps = c.prepareStatement(query)) {
            ps.setString(1, nome);
            ps.executeUpdate();
            Genere genere = new Genere();
            genere.setNome(nome);
            return genere;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Genere getByName(String nome) throws Exception {
        String query = "SELECT * FROM GENERE WHERE NOME = ?";
        try (Connection c = JdbcDAOfactory.getConnection();
             PreparedStatement ps = c.prepareStatement(query)) {
            ps.setString(1, nome);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Genere genere = new Genere();
                    genere.setNome(rs.getString("nome"));
                    return genere;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Genere> getAll() {
        List<Genere> generi = new ArrayList<>();
        // Implementa la logica per recuperare tutti i generi
        return generi;
    }

    @Override
    public Genere update(String nome, String nuovoNome) {
        // Implementa la logica di aggiornamento se necessario
        return null;
    }

    @Override
    public void deleteByName(String nome) {
        // Implementa la logica di cancellazione se necessario
    }
}
