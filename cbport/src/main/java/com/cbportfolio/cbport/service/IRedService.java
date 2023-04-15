
package com.cbportfolio.cbport.service;

import com.cbportfolio.cbport.entity.Red;
import java.util.List;


public interface IRedService {
    
    public List<Red> verRedes();
    public Red buscarRed(Long id);
    public void crearRed(Red net);
    public void borrarRed(Long id);
    public void editarRed(Red net);
}
