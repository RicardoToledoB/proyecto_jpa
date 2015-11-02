package com.ricardo.dao;
import com.ricardo.model.Devolucion;
import java.util.List;

/**
 *
 * @author ricardo
 */
public interface DevolucionDAO {
      public void save(Devolucion devolucion);
    public void delete(Devolucion devolucion);
    public List<Devolucion> findAll();
    public void edit(Devolucion devolucion);
}
