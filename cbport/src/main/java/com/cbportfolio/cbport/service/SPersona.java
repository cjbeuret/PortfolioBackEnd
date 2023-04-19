package com.cbportfolio.cbport.service;

import com.cbportfolio.cbport.dto.DtoPersona;
import com.cbportfolio.cbport.entity.Persona;
import com.cbportfolio.cbport.repository.RPersona;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
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
    public List<Persona> list() {
        return persoRepo.findAll();
    } 
    
    /*public List<Persona> verPersonas() {
        List<Persona> listaPersonas = persoRepo.findAll();
        return listaPersonas;  
    }*/
    
    @Override
    public Persona getById(Long id) {
        return persoRepo.findById(id).orElse(null);
    } //Luisina
    
    
    /*public Persona buscarPersona(Long id) {
        Persona per = persoRepo.findById(id).orElse(null);
        return per;
    } programa TK */
    
    @Override
    public void create(Persona pernew) {
        persoRepo.save(pernew);
    }

    @Override
    public void delete(Long id) {
        persoRepo.deleteById(id);
    }
    
    @Override
    public void edit(Persona per) {
        persoRepo.save(per);
    }

     //DTOs
    
    @Override
    public List<DtoPersona> listDto(){
    // Lista Persona dsd DTO
        List<DtoPersona> listaperdto = new ArrayList<>();
        
        // Lista Experiencias dsd Entidad
        List<Persona> listaper= this.list();
        
        // Asigno valores de Entidad a DTO
        for (Persona per: listaper){
            
            DtoPersona perdto =
            
            DtoPersona.builder()
                    .idPersona(per.getId())
                    .nombre(per.getNombre())
                    .apellido(per.getApellido())
                    .especialidad1(per.getEspecialidad1())
                    .especialidad2(per.getEspecialidad2())
                    .sobreMi(per.getSobreMi())
                    .banner(per.getBanner())
                    .imagen(per.getImagen())
                    .telefono(per.getTelefono())
                    .email(per.getEmail())
                    .fechaNac(per.getFechaNac())
                    .build();
            listaperdto.add(perdto); 
        }
    return listaperdto;
    }
    
          
    @Override
    public void createDto(DtoPersona perdtonew){
    
        Persona pernew=
                
        Persona.builder()
                .id(perdtonew.getIdPersona())               
                .nombre(perdtonew.getNombre())
                .apellido(perdtonew.getApellido())
                .especialidad1(perdtonew.getEspecialidad1())
                .especialidad2(perdtonew.getEspecialidad2())
                .sobreMi(perdtonew.getSobreMi())
                .banner(perdtonew.getBanner())
                .imagen(perdtonew.getImagen())
                .telefono(perdtonew.getTelefono())
                .email(perdtonew.getEmail())
                .fechaNac(perdtonew.getFechaNac())
                .build();
        this.create(pernew);
    }
    
    
    @Override
    public void editDto(DtoPersona perdto){
    
        //Busco la experiencia y la guardo en un objeto
        Persona permod=this.getById(perdto.getIdPersona());
                
        //Cargo los datos desde el DTO
        permod.setNombre(perdto.getNombre());
        permod.setApellido(perdto.getApellido());
        permod.setEspecialidad1(perdto.getEspecialidad1());
        permod.setEspecialidad2(perdto.getEspecialidad2());
        permod.setSobreMi(perdto.getSobreMi());
        permod.setBanner(perdto.getBanner());
        permod.setImagen(perdto.getImagen());
        permod.setTelefono(perdto.getTelefono());
        permod.setEmail(perdto.getEmail());
        permod.setFechaNac(perdto.getFechaNac());
                     
        // Lo cargo a BD
        this.edit(permod);
    }
    
    
    @Override
    public void deleteDto(Long id){
    this.delete(id);
    }

}
