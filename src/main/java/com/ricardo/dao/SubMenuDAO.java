package com.ricardo.dao;
import com.ricardo.model.SubMenu;
import java.util.List;

/**
 *
 * @author ricardo
 */
public interface SubMenuDAO {
      public void save(SubMenu submenu);
    public void delete(SubMenu submenu);
    public List<SubMenu> findAll();
    public void edit(SubMenu submenu);
}
