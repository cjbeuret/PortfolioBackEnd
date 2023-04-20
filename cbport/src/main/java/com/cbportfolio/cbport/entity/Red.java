package com.cbportfolio.cbport.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Red {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Basic
    private String nombreRed;
    @Column (length=1000)
    private String imagen;
    //@Basic
    //private String altImage; esto va?
    @Column (length=1000)
    private String url;
    
     //relacion con Persona
    @ManyToOne()
    @JoinColumn(name="persona_id")//anotation p ponerle otro nombre a la columna en la BD
    
    //creación de objeto    
    private Persona pers;

    //private Long personaid; esto no sé si va

   
    
}
