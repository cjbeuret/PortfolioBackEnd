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

@Getter @Setter
@Entity
public class Habilidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (length=1000)
    private String imagen;
    /*@Basic
    private String altImage; esto va? */
    @Column (name="habilidad", length=255)
    private String nombreHab;
    @Basic
    private Double porcentaje;
    
     //relacion con Persona
    @ManyToOne()
    @JoinColumn(name="persona_id")//anotation p ponerle otro nombre a la columna en la BD
    //creación de objeto    
    private Persona pers;

    public Habilidad() {
    }

    public Habilidad(String imagen, String altImage, String nombreHab, Double porcentaje, Persona pers) {
        // en constructor lleno no va el id porque es autogenerado /identity
        this.imagen = imagen;
        //this.altImage = altImage;
        this.nombreHab = nombreHab;
        this.porcentaje = porcentaje;
        this.pers = pers;
    }

   
 
    
}
