package com.ricardo.dao;
import com.ricardo.model.Cliente;
import java.util.List;

/**
 *
 * @author ricardo
 */
public interface ClienteDAO {
      public void save(Cliente cliente);
    public void delete(Cliente cliente);
    public List<Cliente> findAll();
    public void edit(Cliente cliente);
}
