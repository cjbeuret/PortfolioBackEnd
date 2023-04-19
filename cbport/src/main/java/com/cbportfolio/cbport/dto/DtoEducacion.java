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
public class DtoEducacion {
    
    private Long idEducacion;
    private String institucion;
    private String logo;
    private String url;
    private String titulo;
    private String alcanceTitulo;
    private String comentario;
    //private Persona pers;
    private Long idPersona; //esto no sé si va
    
    
}
