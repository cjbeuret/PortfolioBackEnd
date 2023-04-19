
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
public class DtoIdioma {
    
    private Long idIdioma;
    private String idioma;
    private Double porcentaje;
    private String comentario;
   //private Persona pers;
    private Long idPersona; //esto no sé si va
   
    
}
