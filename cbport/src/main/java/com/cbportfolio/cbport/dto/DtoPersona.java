package com.cbportfolio.cbport.dto;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class DtoPersona {
    
    private String nombre;
    private String apellido;
    private String especialidad1;
    private String especialidad2; 
    private String sobreMi;
    private String banner;
    private String imagen;
    private String telefono;
    private String email;

    public DtoPersona() {
    }

    public DtoPersona(String nombre, String apellido, String especialidad1, String especialidad2, String sobreMi, String banner, String imagen, String telefono, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidad1 = especialidad1;
        this.especialidad2 = especialidad2;
        this.sobreMi = sobreMi;
        this.banner = banner;
        this.imagen = imagen;
        this.telefono = telefono;
        this.email = email;
    }

    
    
    
}
