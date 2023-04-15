
package com.cbportfolio.cbport.service;

import com.cbportfolio.cbport.entity.Persona;
import java.util.List;


public interface IPersonaService {
    
    public List<Persona> verPersonas();
    public Persona buscarPersona(Long id);
    public void crearPersona(Persona per);
    public void borrarPersona(Long id);
    public void editarPersona(Persona per);
       

}
