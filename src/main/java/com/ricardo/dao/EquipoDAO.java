package com.ricardo.dao;
import com.ricardo.model.Equipo;
import java.util.List;

/**
 *
 * @author ricardo
 */
public interface EquipoDAO {
      public void save(Equipo equipo);
    public void delete(Equipo equipo);
    public List<Equipo> findAll();
    public void edit(Equipo equipo);
}
