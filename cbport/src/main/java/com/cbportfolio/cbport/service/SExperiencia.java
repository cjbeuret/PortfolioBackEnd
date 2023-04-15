package com.cbportfolio.cbport.service;

import com.cbportfolio.cbport.entity.Experiencia;
import com.cbportfolio.cbport.repository.RExperiencia;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SExperiencia implements IExperienciaService {
    
    @Autowired
    public RExperiencia expeRepo;
    
    @Override
    public List<Experiencia> verExperiencias() {
        return expeRepo.findAll();
    }
    
    /*public List<Experiencia> verExperiencias() {
        List<Experiencia> listaExperiencias = expeRepo.findAll();
        return listaExperiencias;  
    }  programa TK*/

    @Override
    public Experiencia buscarExperiencia(Long id) {
        return expeRepo.findById(id).orElse(null);
    }
    
    /*public Experiencia buscarExperiencia(Long id) {
        Experiencia expe = expeRepo.findById(id).orElse(null);
        return expe;
    } programa TK */
    
    @Override
    public void crearExperiencia(Experiencia expe) {
        expeRepo.save(expe);
    }

    @Override
    public void borrarExperiencia(Long id) {
        expeRepo.deleteById(id);
    }
    
    @Override
    public void editarExperiencia(Experiencia expe) {
        expeRepo.save(expe);
    }

    
}
