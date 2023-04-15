package com.cbportfolio.cbport.dto;

import com.cbportfolio.cbport.entity.Persona;
import lombok.Getter;
import lombok.Setter;


@Setter @Getter
public class DtoEducacion {
    
    private String institucion;
    private String logo;
    private String url;
    private String titulo;
    private String alcanceTitulo;
    private String comentario;
    private Persona pers;
    
    public DtoEducacion() {
    }

    public DtoEducacion(String institucion, String logo, String url, String titulo, String alcanceTitulo, String comentario, Persona pers) {
        this.institucion = institucion;
        this.logo = logo;
        this.url = url;
        this.titulo = titulo;
        this.alcanceTitulo = alcanceTitulo;
        this.comentario = comentario;
        this.pers = pers;
    }

   
    
    
}
