package com.cbportfolio.cbport.service;

import com.cbportfolio.cbport.entity.Proyecto;
import com.cbportfolio.cbport.repository.RProyecto;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SProyecto implements IProyectoService{
    
    @Autowired
    public RProyecto proyRepo;
    
    @Override
    public List<Proyecto> verProyectos() {
        return proyRepo.findAll();
    }
    
    /*public List<Proyecto> verProyectos() {
        List<Proyecto> listaProyectos = proyRepo.findAll();
        return listaProyectos;  
    }  programa TK*/

    @Override
    public Proyecto buscarProyecto(Long id) {
        return proyRepo.findById(id).orElse(null);
    }
    
    /*public Proyecto buscarProyecto(Long id) {
        Proyecto proy = proyRepo.findById(id).orElse(null);
        return proy;
    } programa TK */
    
    @Override
    public void crearProyecto(Proyecto proy) {
        proyRepo.save(proy);
    }

    @Override
    public void borrarProyecto(Long id) {
        proyRepo.deleteById(id);
    }
    
    @Override
    public void editarProyecto(Proyecto proy) {
        proyRepo.save(proy);
    }

   
}
