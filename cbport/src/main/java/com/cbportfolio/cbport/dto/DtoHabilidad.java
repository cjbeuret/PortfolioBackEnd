
package com.cbportfolio.cbport.dto;

import com.cbportfolio.cbport.entity.Persona;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@Builder
public class DtoHabilidad {
    private Long id;
    private String imagen;
    private String nombreHab;
    private Double porcentaje;
    private Persona pers; //o persona_id?

    /*public DtoHabilidad() {
    }

    public DtoHabilidad(String imagen, String nombreHab, Double porcentaje, Persona pers) {
        this.imagen = imagen;
        this.nombreHab = nombreHab;
        this.porcentaje = porcentaje;
        this.pers = pers;
    }*/
    
    
}
