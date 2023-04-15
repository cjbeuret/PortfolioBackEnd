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
public class Educacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Basic
    private String institucion;
    @Column (length=1000)
    private String logo;
    @Basic
    private String altLogo; //esto va?
    @Column (length=1000)
    private String url;
    @Basic
    private String titulo;
    @Column (length=1000)
    private String alcanceTitulo;
    @Basic
    private String comentario;
    
    //relacion con Persona
    @ManyToOne()
    @JoinColumn(name="persona_id") //anotation p ponerle otro nombre a la columna en la BD
    //@Column(name = "persona_id")esta debe cumplir misma funcion
    //para que se borre si borra persona
    //@OnDelete(action = OnDeleteAction.CASCADE)
    //creación de objeto 
    private Persona pers;

    public Educacion() {
    }

    public Educacion(String institucion, String logo, String altLogo, String url, String titulo, String alcanceTitulo, String comentario, Persona pers) {
        // en constructor lleno no va el id porque es autogenerado /identity
        this.institucion = institucion;
        this.logo = logo;
        this.altLogo = altLogo;
        this.url = url;
        this.titulo = titulo;
        this.alcanceTitulo = alcanceTitulo;
        this.comentario = comentario;
        this.pers = pers;
    }
   
    
    

    
}
