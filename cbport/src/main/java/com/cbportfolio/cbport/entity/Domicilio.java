
package com.cbportfolio.cbport.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@Entity
public class Domicilio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Basic
    private String calle;
    @Basic
    private String altura;
    @Basic
    private String piso;
    @Basic
    private String localidad;
    @Basic
    private String provincia;
    @Column (length=1000)
    private String mapa;
    //relacion con Persona
    @ManyToOne()
    @JoinColumn(name="persona_id") //anotation p ponerle otro nombre a la columna en la BD
    //@Column(name = "persona_id")esta debe cumplir misma funcion
    //para que se borre si borra persona
    //@OnDelete(action = OnDeleteAction.CASCADE)
    //creación de objeto 
    private Persona pers;

    public Domicilio() {
    }

    public Domicilio(String calle, String altura, String piso, String localidad, String provincia, String mapa, Persona pers) {
        this.calle = calle;
        this.altura = altura;
        this.piso = piso;
        this.localidad = localidad;
        this.provincia = provincia;
        this.mapa = mapa;
        this.pers = pers;
    }
    
    
     
}
