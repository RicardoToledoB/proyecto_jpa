package com.ricardo.dao;
import com.ricardo.model.Aprobado;
import java.util.List;

/**
 *
 * @author ricardo
 */
public interface AprobadoDAO {
    public void save(Aprobado aprobado);
    public void delete(Aprobado aprobado);
    public List<Aprobado> findAll();
    public void edit(Aprobado aprobado);
}
