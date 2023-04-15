
package com.cbportfolio.cbport.service;

import com.cbportfolio.cbport.dto.DtoHabilidad;
import com.cbportfolio.cbport.entity.Habilidad;
import java.util.List;


public interface IHabilidadService {
    
    //Entidades
    public List<Habilidad> verHabilidades();
    public Habilidad buscarHabilidad(Long id);
    public void crearHabilidad(Habilidad hab);
    public void borrarHabilidad(Long id);
    public void editarHabilidad(Habilidad hab);
    
    //DTOs
    public List<DtoHabilidad> verDtoHabilidades();
    public DtoHabilidad buscarDtoHabilidad(Long id);
    public void crearDtoHabilidad(DtoHabilidad dtohab);
    public void borrarDtoHabilidad(Long id);
    public void editarDtoHabilidad(DtoHabilidad dtohab);

}
