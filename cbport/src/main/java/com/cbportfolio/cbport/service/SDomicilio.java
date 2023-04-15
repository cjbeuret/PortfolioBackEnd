
package com.cbportfolio.cbport.service;

import com.cbportfolio.cbport.entity.Domicilio;
import com.cbportfolio.cbport.repository.RDomicilio;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SDomicilio implements IDomicilioService {
    @Autowired
    public RDomicilio domicRepo;
    //inyecta la dependencia del repo con el q vamos a trabajar
    
    @Override
    public List<Domicilio> verDomicilios() {
        return domicRepo.findAll();
    }
    
    /*public List<Educacion> verEducaciones() {
        List<Educacion> listaEducaciones = educRepo.findAll();
        return listaEducaciones;  
    }  programa TK*/

    @Override
    public Domicilio buscarDomicilio(Long id) {
        return domicRepo.findById(id).orElse(null);
    }
    
    /*public Educacion buscarEducacion(Long id) {
        Educacion educ = educRepo.findById(id).orElse(null);
        return educ;
    } programa TK */
    
    @Override
    public void crearDomicilio(Domicilio domic) {
        domicRepo.save(domic);
    }

    @Override
    public void borrarDomicilio(Long id) {
        domicRepo.deleteById(id);
    }
    
    @Override
    public void editarDomicilio(Domicilio domic) {
        domicRepo.save(domic);
    }
}
