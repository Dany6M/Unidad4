/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.modelo;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author gerardo
 */
@Entity
@Table(name="futbolista")
public class Futbolista implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_futbolista")
    private Long idFutbolista;
    
    @Column(name="nombre_futbolista", length=10)
    private String nombreFutbolista;
    
    @Column(name="epellido_futbolista", length=30)
    private String apellidoFutbolista;
    
    @Column(name="nacionalidad_futbolista", length=10)
    private String nacionalidadFutbolista;
    
    @ManyToOne()
    @JoinColumn(name="id_equipo")
    private Equipo equipo;

    public Futbolista(Long idFutbolista, String nombreFutbolista, Equipo equipo,String apellidoFutbolista, String nacionalidadFutbolista) {
        super();
        this.idFutbolista = idFutbolista;
        this.nombreFutbolista = nombreFutbolista;
        this.nacionalidadFutbolista = nacionalidadFutbolista;
        this.apellidoFutbolista = apellidoFutbolista;
        this.equipo = equipo;
    }

    public Futbolista() {
        this.idFutbolista=0L;
    }
    public Long getIdFutbolista() {
        return idFutbolista;
    }
    public void setIdFutbolista(Long idFutbolista) {
        this.idFutbolista = idFutbolista;
    }
    public String getNombreFutbolista() {
        return nombreFutbolista;
    }
    public void setNombreFutbolista(String nombreFutbolista) {
        this.nombreFutbolista = nombreFutbolista;
    }
   
    public Equipo getEquipo() {
        return equipo;
    }
    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public void setApellidoFutbolista(String apellidoFutbolista) {
        this.apellidoFutbolista = apellidoFutbolista;
    }

    public String getApellidoFutbolista() {
        return apellidoFutbolista;
    }

    public void setNacionalidadFutbolista(String nacionalidadFutbolista) {
        this.nacionalidadFutbolista = nacionalidadFutbolista;
    }

    public String getNacionalidadFutbolista() {
        return nacionalidadFutbolista;
    }
   
}
