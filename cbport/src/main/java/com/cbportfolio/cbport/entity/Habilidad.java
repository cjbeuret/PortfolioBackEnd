package com.cbportfolio.cbport.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Builder
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
    @JoinColumn(name="personaid")//anotation p ponerle otro nombre a la columna en la BD
    
    //creación de objeto    
    private Persona pers;
    
    private Long personaid; //esto no sé si va


    
}
