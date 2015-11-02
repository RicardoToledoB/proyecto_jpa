package com.ricardo.bean;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author ricardo
 */
@Named(value = "equipoBean")
@SessionScoped
public class EquipoBean implements Serializable {

    /**
     * Creates a new instance of EquipoBean
     */
    public EquipoBean() {
    }
    
}
