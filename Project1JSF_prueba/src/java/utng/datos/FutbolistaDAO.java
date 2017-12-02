/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.datos;


import org.hibernate.HibernateException;
import utng.modelo.Futbolista;

/**
 *
 * @author gerardo
 */
public class FutbolistaDAO  extends DAO<Futbolista>{

    public FutbolistaDAO() {
        super(new Futbolista());
    }
    public Futbolista getOneById(Futbolista futbolista) throws HibernateException {
        return super.getOneById(futbolista.getIdFutbolista()); 
    }
    
    
}
