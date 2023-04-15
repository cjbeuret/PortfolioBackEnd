package com.cbportfolio.cbport.service;

import com.cbportfolio.cbport.entity.Persona;
import com.cbportfolio.cbport.repository.RPersona;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SPersona implements IPersonaService{
    
    @Autowired
    public RPersona persoRepo; 
    //inyecta la dependencia del repo con el q vamos a trabajar
    
    @Override
    public List<Persona> verPersonas() {
        return persoRepo.findAll();
    } //Luisina
    
    /*public List<Persona> verPersonas() {
        List<Persona> listaPersonas = persoRepo.findAll();
        return listaPersonas;  
    }  programa TK*/
    
    @Override
    public Persona buscarPersona(Long id) {
        return persoRepo.findById(id).orElse(null);
    } //Luisina
    
    
    /*public Persona buscarPersona(Long id) {
        Persona per = persoRepo.findById(id).orElse(null);
        return per;
    } programa TK */
    
    @Override
    public void crearPersona(Persona per) {
        persoRepo.save(per);
    }

    @Override
    public void borrarPersona(Long id) {
        persoRepo.deleteById(id);
    }
    
    @Override
    public void editarPersona(Persona per) {
        persoRepo.save(per);
    }

    
}
