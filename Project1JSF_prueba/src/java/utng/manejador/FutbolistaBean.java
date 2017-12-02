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
import utng.datos.FutbolistaDAO;
import utng.modelo.Equipo;
import utng.modelo.Futbolista;

/**
 *
 * @author gerardo
 */
@ManagedBean(name="futbolistaBean") 
@SessionScoped
public class FutbolistaBean implements Serializable{
    private List<Futbolista> futbolistas;
    private Futbolista futbolista;
    private List<Equipo> equipos;
    
    public FutbolistaBean(){
        futbolista = new Futbolista();
        futbolista.setEquipo(new Equipo());
    }

    public List<Futbolista> getFutbolistas() {
        return futbolistas;
    }
    public void setFutbolistas(List<Futbolista> futbolistas) {
        this.futbolistas = futbolistas;
    }
    public Futbolista getFutbolista() {
        return futbolista;
    }
    public void setFutbolista(Futbolista futbolista) {
        this.futbolista = futbolista;
    }
    public List<Equipo> getEquipos() {
        return equipos;
    }
    public void setEquipos(List<Equipo> equipos) {
        this.equipos = equipos;
    }
    
     public String listar(){
        FutbolistaDAO dao = new FutbolistaDAO();
        try {
            futbolistas=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Futbolistas";
    }
    
    public String eliminar(){
         FutbolistaDAO dao = new FutbolistaDAO();
        try {
            dao.delete(futbolista);
            futbolistas=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Eliminar";
    }
    
    public String iniciar(){
        futbolista= new Futbolista();
        futbolista.setEquipo(new Equipo());
        try {
            equipos= new EquipoDAO().getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Iniciar";
    }
    
    public String guardar(){
        FutbolistaDAO dao = new FutbolistaDAO();
        try {
            if(futbolista.getIdFutbolista()!= 0){
                dao.update(futbolista);
            }else {
                dao.insert(futbolista);
            }
            futbolistas=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Guardar";
    }
    
    public String cancelar(){
    return "Cancelar";
    }
    
    public String editar(Futbolista futbolista){
        this.futbolista=futbolista;
        try {
            equipos = new EquipoDAO().getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Editar";
    }
    
  
    
    
}
