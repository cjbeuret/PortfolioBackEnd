
package com.cbportfolio.cbport.dto;

import com.cbportfolio.cbport.entity.Persona;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class DtoDomicilio {
    private String calle; 
    private String altura; 
    private String piso;
    private String localidad;
    private String provincia;
    private String mapa;
    private Persona pers;

    public DtoDomicilio() {
    }

    public DtoDomicilio(String calle, String altura, String piso, String localidad, String provincia, String mapa, Persona pers) {
        this.calle = calle;
        this.altura = altura;
        this.piso = piso;
        this.localidad = localidad;
        this.provincia = provincia;
        this.mapa = mapa;
        this.pers = pers;
    }
    
    
}
