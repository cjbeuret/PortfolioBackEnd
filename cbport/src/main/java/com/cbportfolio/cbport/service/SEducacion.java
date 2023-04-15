package com.cbportfolio.cbport.service;

import com.cbportfolio.cbport.entity.Educacion;
import com.cbportfolio.cbport.repository.REducacion;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SEducacion implements IEducacionService {
    
    @Autowired
    public REducacion educRepo;
    //inyecta la dependencia del repo con el q vamos a trabajar
    
    @Override
    public List<Educacion> verEducaciones() {
        return educRepo.findAll();
    }
    
    /*public List<Educacion> verEducaciones() {
        List<Educacion> listaEducaciones = educRepo.findAll();
        return listaEducaciones;  
    }  programa TK*/

    @Override
    public Educacion buscarEducacion(Long id) {
        return educRepo.findById(id).orElse(null);
    }
    
    /*public Educacion buscarEducacion(Long id) {
        Educacion educ = educRepo.findById(id).orElse(null);
        return educ;
    } programa TK */
    
    @Override
    public void crearEducacion(Educacion educ) {
        educRepo.save(educ);
    }

    @Override
    public void borrarEducacion(Long id) {
        educRepo.deleteById(id);
    }
    
    @Override
    public void editarEducacion(Educacion educ) {
        educRepo.save(educ);
    }
 
    
}
