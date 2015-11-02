package com.ricardo.dao;
import com.ricardo.model.Rechazo;
import java.util.List;

/**
 *
 * @author ricardo
 */
public interface RechazoDAO {
      public void save(Rechazo rechazo);
    public void delete(Rechazo rechazo);
    public List<Rechazo> findAll();
    public void edit(Rechazo rechazo);
}
