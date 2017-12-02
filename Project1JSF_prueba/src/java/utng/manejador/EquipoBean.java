/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.manejador;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import utng.datos.EquipoDAO;
import utng.modelo.Equipo;

@ManagedBean
@SessionScoped
public class EquipoBean implements Serializable{
    private List<Equipo>equipos;
    private Equipo equipo;
    public EquipoBean(){}

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(List<Equipo> equipos) {
        this.equipos = equipos;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
    
    
    public String listar(){
        EquipoDAO dao = new EquipoDAO();
        try {
            equipos=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Equipos";
    }
    
    public String eliminar(){
         EquipoDAO dao = new EquipoDAO();
        try {
            dao.delete(equipo);
            equipos=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Eliminar";
    }
    
    public String iniciar(){
        equipo= new Equipo();
        return "Iniciar";
    }
    
    public String guardar(){
        EquipoDAO dao = new EquipoDAO();
        try {
            if(equipo.getIdEquipo()!= 0){
                dao.update(equipo);
            }else {
                dao.insert(equipo);
            }
            equipos=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Guardar";
    }
    
    public String cancelar(){
    return "Cancelar";
    }
    
    public String editar(Equipo equipo){
        this.equipo=equipo;
        return "Editar";
    }
    
}
