
package com.cbportfolio.cbport.dto;

import com.cbportfolio.cbport.entity.Persona;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class DtoRed {
    private String nombreRed;   
    private String imagen; 
    private String url; 
    private Persona pers;

    public DtoRed() {
    }

    public DtoRed(String nombreRed, String imagen, String url, Persona pers) {
        this.nombreRed = nombreRed;
        this.imagen = imagen;
        this.url = url;
        this.pers = pers;
    }
    
    
}
