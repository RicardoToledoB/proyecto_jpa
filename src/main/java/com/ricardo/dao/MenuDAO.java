package com.ricardo.dao;
import com.ricardo.model.Menu;
import java.util.List;

/**
 *
 * @author ricardo
 */
public interface MenuDAO {
      public void save(Menu menu);
    public void delete(Menu menu);
    public List<Menu> findAll();
    public void edit(Menu menu);
}
