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
public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Basic
    private String empresa;
    @Column (length=1000)
    private String logo;
    //@Basic
    //private String altLogo; esto va?
    @Column (length=1000)
    private String url;
    @Basic
    private String cargo;
    @Column (length=1000)
    private String descPuesto;
    @Basic
    private String inicio;
    @Basic
    private String fin;
    
    //relacion con Persona
    @ManyToOne()
    @JoinColumn(name="persona_id")//anotation p ponerle otro nombre a la columna en la BD
    //creación de objeto    
    private Persona pers;
    
    //private Long personaid; esto no sé si va

    public Experiencia() {
    }

    public Experiencia(Long id, String empresa, String logo, String url, String cargo, String descPuesto, String inicio, String fin, Persona pers) {
        this.id = id;
        this.empresa = empresa;
        this.logo = logo;
        this.url = url;
        this.cargo = cargo;
        this.descPuesto = descPuesto;
        this.inicio = inicio;
        this.fin = fin;
        this.pers = pers;
    }

    
}
