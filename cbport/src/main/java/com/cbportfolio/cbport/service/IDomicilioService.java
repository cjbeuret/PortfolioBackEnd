
package com.cbportfolio.cbport.service;

import com.cbportfolio.cbport.entity.Domicilio;
import java.util.List;


public interface IDomicilioService {
    public List<Domicilio> verDomicilios();
    public Domicilio buscarDomicilio(Long id);
    public void crearDomicilio(Domicilio domic);
    public void borrarDomicilio(Long id);
    public void editarDomicilio(Domicilio domic);
}
