/*package org.elis.dao.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
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
    public Offerta addOfferta(Offerta offerta) {
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
			e.printStackTrace();
		}
        return null;
    }

    @Override
    public Offerta getOffertaById(long id) {
        String query = "SELECT * FROM OFFERTA WHERE ID = ?";
        
        try (
        		Connection c = JdbcDAOfactory.getConnection();
        		PreparedStatement ps = c.prepareStatement(query)
        				
        		) {
        	
            ps.setLong(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) 
            {
                Offerta offerta = new Offerta();
                offerta.setId(id);
                offerta.setNome(rs.getString("nome"));
                offerta.setSconto(rs.getDouble("sconto"));
                offerta.setDataInizio(rs.getTimestamp("data_inizio"));
                offerta.setDataFine(rs.getTimestamp("data_fine"));
                return offerta;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Offerta> getAllOfferta() {
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
        } catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        return offerte;
    }

 

    @Override
    public Offerta deleteOffertaById(long id) {
        String query = "DELETE FROM OFFERTA WHERE ID = ?";
        
        try (Connection c = JdbcDAOfactory.getConnection();
             PreparedStatement ps = c.prepareStatement(query)
            		 
        	){
        	
            ps.setLong(1, id);
            ps.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        return null;
    }

	@Override
	public Offerta updateOffertaNome(Offerta offerta, String nome) {
		 String query = "UPDATE offerta SET nome = ? WHERE id = ?";
		    try (
		    		Connection c = JdbcDAOfactory.getConnection();
		         PreparedStatement ps = c.prepareStatement(query)
		        		 ) {
		        
		        ps.setString(1, nome);
		        ps.setLong(2, offerta.getId());

		        int rowsUpdated = ps.executeUpdate();
		        if (rowsUpdated > 0) {
		            offerta.setNome(nome);
		            return offerta;
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    } catch (Exception e1) {
				e1.printStackTrace();
			}
		    return null;
		}

	@Override
	public Offerta updateOffertaDataInizio(Offerta offerta, Timestamp dataInizio) {
	    String query = "UPDATE offerta SET dataInizio = ? WHERE id = ?";
	    try (
	    		Connection c = JdbcDAOfactory.getConnection();
	         PreparedStatement ps = c.prepareStatement(query)
	        		 ) {
	        
	        ps.setTimestamp(1, dataInizio);
	        ps.setLong(2, offerta.getId());

	        int rowsUpdated = ps.executeUpdate();
	        if (rowsUpdated > 0) {
	            offerta.setDataInizio(dataInizio);
	            return offerta;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } catch (Exception e) {
			e.printStackTrace();
	    }
	    return null;
	}
	@Override
	public Offerta updateOffertaDataFine(Offerta offerta, Timestamp dataFine) {
	    String query = "UPDATE offerta SET dataFine = ? WHERE id = ?";
	    try (
	    		Connection c = JdbcDAOfactory.getConnection();
	         PreparedStatement ps = c.prepareStatement(query)
	        		 ) {
	        
	        ps.setTimestamp(1, dataFine);
	        ps.setLong(2, offerta.getId());

	        int rowsUpdated = ps.executeUpdate();
	        if (rowsUpdated > 0) {
	            offerta.setDataFine(dataFine); 
	            return offerta;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } catch (Exception e) {
			e.printStackTrace();
	    }
	    return null;
	}
	@Override
	public Offerta updateOffertaSconto(Offerta offerta, double sconto) {
	    String query = "UPDATE offerta SET sconto = ? WHERE id = ?";
	    try (
	    		
	    		Connection c = JdbcDAOfactory.getConnection();
	    		PreparedStatement ps = c.prepareStatement(query)
	    				) {
	        
	        ps.setDouble(1, sconto);
	        ps.setLong(2, offerta.getId());

	        int rowsUpdated = ps.executeUpdate();
	        if (rowsUpdated > 0) {
	            offerta.setSconto(sconto); 
	            return offerta;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } catch (Exception e) {
			e.printStackTrace();
	    }
	    return null;
	}
} */



package org.elis.dao.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import org.elis.dao.OffertaDAO;
import org.elis.model.Offerta;
import org.elis.model.Ricorrenza;

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
    public Offerta addOfferta(Offerta offerta) {
        String query = "INSERT INTO offerta (nome, sconto, dataInizio, dataFine, giocoId, ricorrenza) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection c = JdbcDAOfactory.getConnection();
             PreparedStatement ps = c.prepareStatement(query)) {
            ps.setString(1, offerta.getNome());
            ps.setDouble(2, offerta.getSconto());
            ps.setTimestamp(3, offerta.getDataInizio());
            ps.setTimestamp(4, offerta.getDataFine());
            ps.setLong(5, offerta.getGiocoId()); // Associa l'ID del gioco
            ps.setString(6, offerta.getRicorrenza() != null ? offerta.getRicorrenza().name() : null); // Associa la ricorrenza
            ps.executeUpdate();
            return offerta;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        return null;
    }

    @Override
    public Offerta getOffertaById(long id) {
        String query = "SELECT * FROM OFFERTA WHERE ID = ?";
        try (Connection c = JdbcDAOfactory.getConnection();
             PreparedStatement ps = c.prepareStatement(query)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Offerta offerta = new Offerta();
                offerta.setId(rs.getLong("id"));
                offerta.setNome(rs.getString("nome"));
                offerta.setSconto(rs.getDouble("sconto"));
                offerta.setDataInizio(rs.getTimestamp("dataInizio"));
                offerta.setDataFine(rs.getTimestamp("dataFine"));
                offerta.setGiocoId(rs.getLong("giocoId")); // Imposta l'ID del gioco
                offerta.setRicorrenza(Ricorrenza.valueOf(rs.getString("ricorrenza"))); // Imposta la ricorrenza
                return offerta;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        return null;
    }

    @Override
    public List<Offerta> getAllOfferta() {
        List<Offerta> offerte = new ArrayList<>();
        String query = "SELECT * FROM OFFERTA";
        try (Connection c = JdbcDAOfactory.getConnection();
             PreparedStatement ps = c.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Offerta offerta = new Offerta();
                offerta.setId(rs.getLong("id"));
                offerta.setNome(rs.getString("nome"));
                offerta.setSconto(rs.getDouble("sconto"));
                offerta.setDataInizio(rs.getTimestamp("dataInizio"));
                offerta.setDataFine(rs.getTimestamp("dataFine"));
                offerta.setGiocoId(rs.getLong("giocoId")); // Imposta l'ID del gioco
                offerta.setRicorrenza(Ricorrenza.valueOf(rs.getString("ricorrenza"))); // Imposta la ricorrenza
                offerte.add(offerta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        return offerte;
    }

    @Override
    public List<Offerta> getOfferteByRicorrenza(Ricorrenza ricorrenza) {
        List<Offerta> offerte = new ArrayList<>();
        String query = "SELECT * FROM OFFERTA WHERE ricorrenza = ?";
        try (Connection c = JdbcDAOfactory.getConnection();
             PreparedStatement ps = c.prepareStatement(query)) {
            ps.setString(1, ricorrenza.name());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Offerta offerta = new Offerta();
                offerta.setId(rs.getLong("id"));
                offerta.setNome(rs.getString("nome"));
                offerta.setSconto(rs.getDouble("sconto"));
                offerta.setDataInizio(rs.getTimestamp("dataInizio"));
                offerta.setDataFine(rs.getTimestamp("dataFine"));
                offerta.setGiocoId(rs.getLong("giocoId")); // Imposta l'ID del gioco
                offerta.setRicorrenza(ricorrenza); // Imposta la ricorrenza
                offerte.add(offerta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        return offerte;
    }

    @Override
    public List<Offerta> getOfferteByGiocoId(long giocoId) {
        List<Offerta> offerte = new ArrayList<>();
        String query = "SELECT * FROM OFFERTA WHERE giocoId = ?";
        try (Connection c = JdbcDAOfactory.getConnection();
             PreparedStatement ps = c.prepareStatement(query)) {
            ps.setLong(1, giocoId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Offerta offerta = new Offerta();
                offerta.setId(rs.getLong("id"));
                offerta.setNome(rs.getString("nome"));
                offerta.setSconto(rs.getDouble("sconto"));
                offerta.setDataInizio(rs.getTimestamp("dataInizio"));
                offerta.setDataFine(rs.getTimestamp("dataFine"));
                offerta.setGiocoId(giocoId); // Imposta l'ID del gioco
                offerta.setRicorrenza(Ricorrenza.valueOf(rs.getString("ricorrenza"))); // Imposta la ricorrenza
                offerte.add(offerta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        return offerte;
    }

    @Override
    public Offerta deleteOffertaById(long id) {
        Offerta offerta = getOffertaById(id);
        String query = "DELETE FROM OFFERTA WHERE ID = ?";
        try (Connection c = JdbcDAOfactory.getConnection();
             PreparedStatement ps = c.prepareStatement(query)) {
            ps.setLong(1, id);
            ps.executeUpdate();
            return offerta;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        return null;
    }

    @Override
    public Offerta updateOffertaNome(Offerta offerta, String nome) {
        String query = "UPDATE OFFERTA SET nome = ? WHERE id = ?";
        try (Connection c = JdbcDAOfactory.getConnection();
             PreparedStatement ps = c.prepareStatement(query)) {
            ps.setString(1, nome);
            ps.setLong(2, offerta.getId());
            ps.executeUpdate();
            offerta.setNome(nome);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        return offerta;
    }

    @Override
    public Offerta updateOffertaDataInizio(Offerta offerta, Timestamp dataInizio) {
        String query = "UPDATE OFFERTA SET dataInizio = ? WHERE id = ?";
        try (Connection c = JdbcDAOfactory.getConnection();
             PreparedStatement ps = c.prepareStatement(query)) {
            ps.setTimestamp(1, dataInizio);
            ps.setLong(2, offerta.getId());
            ps.executeUpdate();
            offerta.setDataInizio(dataInizio);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        return offerta;
    }

    @Override
    public Offerta updateOffertaDataFine(Offerta offerta, Timestamp dataFine) {
        String query = "UPDATE OFFERTA SET dataFine = ? WHERE id = ?";
        try (Connection c = JdbcDAOfactory.getConnection();
             PreparedStatement ps = c.prepareStatement(query)) {
            ps.setTimestamp(1, dataFine);
            ps.setLong(2, offerta.getId());
            ps.executeUpdate();
            offerta.setDataFine(dataFine);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        return offerta;
    }

    @Override
    public Offerta updateOffertaSconto(Offerta offerta, double sconto) {
        String query = "UPDATE OFFERTA SET sconto = ? WHERE id = ?";
        try (Connection c = JdbcDAOfactory.getConnection();
             PreparedStatement ps = c.prepareStatement(query)) {
            ps.setDouble(1, sconto);
            ps.setLong(2, offerta.getId());
            ps.executeUpdate();
            offerta.setSconto(sconto);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        return offerta;
    }
}
