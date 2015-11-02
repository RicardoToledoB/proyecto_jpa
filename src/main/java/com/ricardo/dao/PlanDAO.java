package com.ricardo.dao;
import com.ricardo.model.Plan;
import java.util.List;

/**
 *
 * @author ricardo
 */
public interface PlanDAO {
      public void save(Plan plan);
    public void delete(Plan plan);
    public List<Plan> findAll();
    public void edit(Plan plan);
}
