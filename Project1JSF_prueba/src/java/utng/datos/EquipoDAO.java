/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.datos;

/**
 *
 * @author gerardo
 */
import org.hibernate.HibernateException;
import utng.modelo.Equipo;


public class EquipoDAO extends DAO<Equipo> {
     public EquipoDAO() {
        super(new Equipo());
    }

    
    public Equipo getOneById(Equipo equipo) throws HibernateException {
        return super.getOneById(equipo.getIdEquipo()); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
