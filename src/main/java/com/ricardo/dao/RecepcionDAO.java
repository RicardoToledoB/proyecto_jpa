package com.ricardo.dao;
import com.ricardo.model.Recepcion;
import java.util.List;

/**
 *
 * @author ricardo
 */
public interface RecepcionDAO {
     public void save(Recepcion recepcion);
    public void delete(Recepcion recepcion);
    public List<Recepcion> findAll();
    public void edit(Recepcion recepcion); 
}
