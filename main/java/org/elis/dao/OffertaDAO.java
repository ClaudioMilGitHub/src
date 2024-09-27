package org.elis.dao;

import java.util.List;
import org.elis.model.Offerta;

public interface OffertaDAO {
    Offerta add(Offerta offerta) throws Exception;
    Offerta getOffertaById(long id);
    List<Offerta> getAll() throws Exception;
    Offerta update(Offerta offerta);
    void deleteById(int id) throws Exception;
	
}
