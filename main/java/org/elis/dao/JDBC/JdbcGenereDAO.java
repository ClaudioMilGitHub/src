package org.elis.dao.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.elis.businesslogic.BusinessLogic;
import org.elis.dao.GenereDAO;
import org.elis.model.Genere;
import org.elis.model.Offerta;
import org.elis.model.Ruolo;
import org.elis.model.Utente;

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
    public List<Genere> getAllGeneri() {
        List<Genere> generi = new ArrayList<>();
        String query = "SELECT * FROM genere";
        
        try(
				Connection  c = JdbcDAOfactory.getConnection();
				PreparedStatement ps = c.prepareStatement(query);
				){
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Genere g = new Genere();
				long id = rs.getLong("id");
				String nome = rs.getString("nome");
				long id_offerta = rs.getLong("id_offerta");
				Offerta offerta = BusinessLogic.getOffertaById(id_offerta);
				g.setId(id);
				g.setNome(nome);
				g.setOfferta(offerta);
				
				generi.add(g);
			}
			
			if(!generi.isEmpty()) {
				return generi;
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
    }

    @Override
    public Genere updateGenereNome(Genere genere, String nuovoNome) {
    	String query = "UPDATE genere SET nome = ? WHERE ID = ?";
    	
		
		try(
				Connection  c = JdbcDAOfactory.getConnection();
				PreparedStatement ps = c.prepareStatement(query);
				){
			
			ps.setString(1, nuovoNome);
			ps.setLong(2, genere.getId());
			
			ps.executeUpdate();
			
			genere.setNome(nuovoNome);
			return genere;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
    }
    
    @Override
    public Genere updateGenereOfferta(Genere genere, Offerta nuovaOfferta) {
    	String query = "UPDATE genere SET id_offerta = ? WHERE ID = ?";
    	
		
		try(
				Connection  c = JdbcDAOfactory.getConnection();
				PreparedStatement ps = c.prepareStatement(query);
				){
			
			ps.setLong(1, nuovaOfferta.getId());
			ps.setLong(2, genere.getId());
			
			ps.executeUpdate();
			
			genere.setOfferta(nuovaOfferta);
			return genere;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
    }

    @Override
    public Genere deleteByName(String nome) {
    	String query = "DELETE FROM genere WHERE nome = ?";
		
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
