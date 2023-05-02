
package com.cbportfolio.cbport.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class DtoHabilidad {
    
    private Long idHabilidad;
    private String span;
    private String nombreHab;
    private Double porcentaje;
    private String progreso;
    //private Persona pers;
    private Long personaId; //esto no sé si va
    
    
    
    
}
