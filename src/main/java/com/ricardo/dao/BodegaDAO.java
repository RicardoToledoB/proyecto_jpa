package com.ricardo.dao;
import com.ricardo.model.Bodega;
import java.util.List;

/**
 *
 * @author ricardo
 */
public interface BodegaDAO {
    public void save(Bodega bodega);
    public void delete(Bodega bodega);
    public List<Bodega> findAll();
    public void edit(Bodega bodega);
}
