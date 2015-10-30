package com.ricardo.model;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
/**
 *
 * @author ricardo
 */
@Entity
@Table(name = "Roles")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "rol_id")
    private int id;
    private String tipo;
    private String estado;

    public Rol() {
    }

    public Rol(int id, String tipo, String estado) {
        this.id = id;
        this.tipo = tipo;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    @ManyToMany(mappedBy = "roles")
    public List<Usuario> usuarios = new ArrayList<Usuario>();

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    //////////////////////////////////////////////////
    
    // UN ROL PUEDE TENER MUCHOS MENUS Y ESE MENU TIENE MUCHOS ROLES
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "Roles_Menus",
            joinColumns = {
                @JoinColumn(name = "rol_id")
            },
            inverseJoinColumns = {
                @JoinColumn(name = "menu_id")
            })
    private List<Menu> menus = new ArrayList<Menu>();
    public List<Menu> getMenus() {
        return menus;
    }
    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }
    
    

}
