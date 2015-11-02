package com.ricardo.dao;
import com.ricardo.model.Proveedor;
import java.util.List;

/**
 *
 * @author ricardo
 */
public interface ProveedorDAO {
      public void save(Proveedor proveedor);
    public void delete(Proveedor proveedor);
    public List<Proveedor> findAll();
    public void edit(Proveedor proveedor);
}
