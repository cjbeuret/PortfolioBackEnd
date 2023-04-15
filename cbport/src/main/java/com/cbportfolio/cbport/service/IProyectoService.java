
package com.cbportfolio.cbport.service;

import com.cbportfolio.cbport.entity.Proyecto;
import java.util.List;


public interface IProyectoService {
   
    public List<Proyecto> verProyectos();
    public Proyecto buscarProyecto(Long id);
    public void crearProyecto(Proyecto proy);
    public void borrarProyecto(Long id);
    public void editarProyecto(Proyecto proy);
}
