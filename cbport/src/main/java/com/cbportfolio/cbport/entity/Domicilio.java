
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

@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
    
    //private Long personaid; esto no sé si va

     
}
