package com.ricardo.dao;

import com.ricardo.model.Solicitud;
import java.util.List;

/**
 *
 * @author ricardo
 */
public interface SolicitudDAO {
      public void save(Solicitud solicitud);
    public void delete(Solicitud solicitud);
    public List<Solicitud> findAll();
    public void edit(Solicitud solicitud);
}
