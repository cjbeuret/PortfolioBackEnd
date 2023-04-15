
package com.cbportfolio.cbport.service;

import com.cbportfolio.cbport.entity.Experiencia;
import java.util.List;


public interface IExperienciaService {
    
    public List<Experiencia> verExperiencias();
    public Experiencia buscarExperiencia(Long id);
    public void crearExperiencia(Experiencia expe);
    public void borrarExperiencia(Long id);
    public void editarExperiencia(Experiencia expe);
}
