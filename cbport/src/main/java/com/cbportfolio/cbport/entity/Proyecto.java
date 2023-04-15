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
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Basic
    private String tituloProyecto;
    @Column (length=1000)
    private String imagen;
    //@Basic
    //private String altImage; //esto va?
    @Column (length=1000)
    private String url;
    @Basic
    private String destinatario;
    @Column (length=1000)
    private String descProyecto;
    @Basic
    private String periodoDesarrollo;
    
    //relacion con Persona
    @ManyToOne()
    @JoinColumn(name="persona_id")//anotation p ponerle otro nombre a la columna en la BD
    //creación de objeto    
    private Persona pers;

    public Proyecto() {
    }

    public Proyecto(String tituloProyecto, String imagen, String altImage, String url, String destinatario, String descProyecto, String periodoDesarrollo, Persona pers) {
        // en constructor lleno no va el id porque es autogenerado /identity
        this.tituloProyecto = tituloProyecto;
        this.imagen = imagen;
        //this.altImage = altImage;
        this.url = url;
        this.destinatario = destinatario;
        this.descProyecto = descProyecto;
        this.periodoDesarrollo = periodoDesarrollo;
        this.pers = pers;
    }

    
   

    
}
