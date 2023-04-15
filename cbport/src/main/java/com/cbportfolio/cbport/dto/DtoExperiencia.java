
package com.cbportfolio.cbport.dto;

import com.cbportfolio.cbport.entity.Persona;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class DtoExperiencia {
    private String empresa;
    private String logo;
    private String url;
    private String cargo;
    private String descPuesto;
    private String inicio;
    private String fin;
    private Persona pers;

    public DtoExperiencia() {
    }

    public DtoExperiencia(String empresa, String logo, String url, String cargo, String descPuesto, String inicio, String fin, Persona pers) {
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
