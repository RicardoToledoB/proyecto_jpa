package com.ricardo.dao;
import com.ricardo.model.Marca;
import java.util.List;

/**
 *
 * @author ricardo
 */
public interface MarcaDAO {
    public void save(Marca marca);
    public void delete(Marca marca);
    public List<Marca> findAll();
    public void edit(Marca marca);
}
