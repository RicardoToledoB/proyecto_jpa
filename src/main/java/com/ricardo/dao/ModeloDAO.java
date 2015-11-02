package com.ricardo.dao;
import com.ricardo.model.Modelo;
import java.util.List;

/**
 *
 * @author ricardo
 */
public interface ModeloDAO {
      public void save(Modelo modelo);
    public void delete(Modelo modelo);
    public List<Modelo> findAll();
    public void edit(Modelo modelo);
}
