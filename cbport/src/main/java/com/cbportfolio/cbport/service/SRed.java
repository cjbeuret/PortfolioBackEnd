package com.cbportfolio.cbport.service;

import com.cbportfolio.cbport.entity.Red;
import com.cbportfolio.cbport.repository.RRed;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SRed implements IRedService{
    
    @Autowired
    public RRed redRepo;
    
    @Override
    public List<Red> verRedes() {
        return redRepo.findAll();
    }
    
    /*public List<Red> verRedes() {
        List<Red> listaRedes = redRepo.findAll();
        return listaRedes;  
    }  programa TK*/
    
    @Override
    public Red buscarRed(Long id) {
        return redRepo.findById(id).orElse(null);
    }
    
    /*public Red buscarRed(Long id) {
        Red net = redRepo.findById(id).orElse(null);
        return net;
    } programa TK */

    @Override
    public void crearRed(Red net) {
        redRepo.save(net);
    }

    @Override
    public void borrarRed(Long id) {
        redRepo.deleteById(id);
    }
    
    @Override
    public void editarRed(Red net) {
        redRepo.save(net);
    }

    
}
