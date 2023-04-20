package com.cbportfolio.cbport.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Builder
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Basic
    private String email;
    @Basic
    private String password;
    
    //relacion con Persona
    @OneToOne
    @JoinColumn(name="persona_id")//anotation p ponerle otro nombre a la columna en la BD
    //creación de objeto   
    private Persona pers;

    public Usuario() {
    }

    public Usuario(Long id, String email, String password, Persona pers) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.pers = pers;
    }

    
}
