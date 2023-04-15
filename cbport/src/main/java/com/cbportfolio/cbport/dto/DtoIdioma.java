
package com.cbportfolio.cbport.dto;

import com.cbportfolio.cbport.entity.Persona;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class DtoIdioma {
    private String idioma;
    private Double porcentaje;
    private String comentario;
    private Persona pers;

    public DtoIdioma() {
    }

    public DtoIdioma(String idioma, Double porcentaje, String comentario, Persona pers) {
        this.idioma = idioma;
        this.porcentaje = porcentaje;
        this.comentario = comentario;
        this.pers = pers;
    }
    
    
}
