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
public class DtoUsuario {
    
    private Long idUsuario;
    private String email;
    private String password;
    //private Persona pers;
    private Long idPersona; //esto no sé si va

    
}
