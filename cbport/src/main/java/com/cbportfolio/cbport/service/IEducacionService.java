
package com.cbportfolio.cbport.service;

import com.cbportfolio.cbport.entity.Educacion;
import java.util.List;


public interface IEducacionService {
    
    public List<Educacion> verEducaciones();
    public Educacion buscarEducacion(Long id);
    public void crearEducacion(Educacion educ);
    public void borrarEducacion(Long id);
    public void editarEducacion(Educacion educ);
    
}
