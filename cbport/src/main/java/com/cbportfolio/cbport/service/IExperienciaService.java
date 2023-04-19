
package com.cbportfolio.cbport.service;

import com.cbportfolio.cbport.dto.DtoExperiencia;
import com.cbportfolio.cbport.entity.Experiencia;
import java.util.List;


public interface IExperienciaService {
    
    //entidades
    public List<Experiencia> list();
    public Experiencia getById(Long id);
    public void create(Experiencia expenew);
    public void delete(Long id);
    public void edit(Experiencia expe);
    
    // DTOs
    public List<DtoExperiencia> listDto();
    public void createDto(DtoExperiencia expedtonew);
    public void deleteDto(Long id);
    public void editDto(DtoExperiencia expedto);
}
