
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
    private String imagen;
    private String nombreHab;
    private Double porcentaje;
    //private Persona pers;
    private Long idPersona; //esto no sé si va
    
    
    
    
}
