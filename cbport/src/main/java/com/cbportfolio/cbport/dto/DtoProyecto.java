
package com.cbportfolio.cbport.dto;

import com.cbportfolio.cbport.entity.Persona;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class DtoProyecto {
    private String tituloProyecto;
    private String imagen; 
    private String url;
    private String destinatario;
    private String descProyecto;
    private String periodoDesarrollo; 
    private Persona pers;

    public DtoProyecto() {
    }

    public DtoProyecto(String tituloProyecto, String imagen, String url, String destinatario, String descProyecto, String periodoDesarrollo, Persona pers) {
        this.tituloProyecto = tituloProyecto;
        this.imagen = imagen;
        this.url = url;
        this.destinatario = destinatario;
        this.descProyecto = descProyecto;
        this.periodoDesarrollo = periodoDesarrollo;
        this.pers = pers;
    }
    
    
    
}
