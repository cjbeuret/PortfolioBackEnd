package com.cbportfolio.cbport.service;

import com.cbportfolio.cbport.entity.Idioma;
import com.cbportfolio.cbport.repository.RIdioma;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SIdioma implements IIdiomaService{
    
    @Autowired
    public RIdioma idiomaRepo;
    
    @Override
    public List<Idioma> verIdiomas() {
        return idiomaRepo.findAll();
    }
    
    /*public List<Idioma> verIdiomas() {
        List<Idioma> listaIdiomas = idiomaRepo.findAll();
        return listaIdiomas;  
    }  programa TK*/

    @Override
    public Idioma buscarIdioma(Long id) {
        return idiomaRepo.findById(id).orElse(null);
    }
    
    /*public Idioma buscarIdioma(Long id) {
        Idioma idiom = idiomaRepo.findById(id).orElse(null);
        return idiom;
    } programa TK */
    
    @Override
    public void crearIdioma(Idioma idiom) {
        idiomaRepo.save(idiom);
    }

    @Override
    public void borrarIdioma(Long id) {
        idiomaRepo.deleteById(id);
    }
    
    @Override
    public void editarIdioma(Idioma idiom) {
        idiomaRepo.save(idiom);
    }

    
}
