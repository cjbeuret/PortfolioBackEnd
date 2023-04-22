package com.cbportfolio.cbport.service;

import com.cbportfolio.cbport.dto.DtoIdioma;
import com.cbportfolio.cbport.entity.Idioma;
import com.cbportfolio.cbport.repository.RIdioma;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SIdioma implements IIdiomaService{
    
    @Autowired
    public RIdioma idiomaRepo;
    
    @Autowired
    public SPersona persoServ;
    
    
    @Override
    public List<Idioma> list() {
        return idiomaRepo.findAll();
    }
    
    /*public List<Idioma> verIdiomas() {
        List<Idioma> listaIdiomas = idiomaRepo.findAll();
        return listaIdiomas;  
    }  */

    @Override
    public Idioma getById(Long id) {
        return idiomaRepo.findById(id).orElse(null);
    }
    
    /*public Idioma buscarIdioma(Long id) {
        Idioma idioma = idiomaRepo.findById(id).orElse(null);
        return idioma;
    }  */
    
    @Override
    public void create(Idioma idiomanew) {
        idiomaRepo.save(idiomanew);
    }

    @Override
    public void delete(Long id) {
        idiomaRepo.deleteById(id);
    }
    
    @Override
    public void edit(Idioma idioma) {
        idiomaRepo.save(idioma);
    }

     //DTOs
    
    @Override
    public List<DtoIdioma> listDto(){
    // Lista Experiencias dsd DTO
        List<DtoIdioma> listaidiomadto = new ArrayList<>();
        
        // Lista Experiencias dsd Entidad
        List<Idioma> listaidioma= this.list();
        
        // Asigno valores de Entidad a DTO
        for (Idioma idioma: listaidioma){
            
            DtoIdioma idiomadto =
            
            DtoIdioma.builder()
                    .idIdioma(idioma.getId())
                    .idioma(idioma.getIdioma())
                    .porcentaje(idioma.getPorcentaje())
                    .comentario(idioma.getComentario())
                    //.idPersona(idioma.getPers().getId())
                    .build();
            listaidiomadto.add(idiomadto); 
        }
    return listaidiomadto;
    }
    
    @Override
    public void createDto(DtoIdioma idiomadtonew){
    
        Idioma idiomanew=
                
        Idioma.builder()
                .id(idiomadtonew.getIdIdioma())
                .idioma(idiomadtonew.getIdioma())
                .porcentaje(idiomadtonew.getPorcentaje())
                .comentario(idiomadtonew.getComentario())
                .pers(persoServ.getById(idiomadtonew.getIdPersona()))
                /*.personaid(expedto.getPers().getId())*/
                .build();
        this.create(idiomanew);
    }
    
    @Override
    public void editDto(DtoIdioma idiomadto){
    
        //Busco la experiencia y la guardo en un objeto
        Idioma idiomamod=this.getById(idiomadto.getIdIdioma());
                
        //Cargo los datos desde el DTO
        idiomamod.setIdioma(idiomadto.getIdioma());
        idiomamod.setPorcentaje(idiomadto.getPorcentaje());
        idiomamod.setComentario(idiomadto.getComentario());
                     
        // Lo cargo a BD
        this.edit(idiomamod);
        
    }
    
    @Override
    public void deleteDto(Long id){
    this.delete(id);
    }
    
}
