package com.cbportfolio.cbport.service;

import com.cbportfolio.cbport.dto.DtoDomicilio;
import com.cbportfolio.cbport.entity.Domicilio;
import com.cbportfolio.cbport.repository.RDomicilio;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SDomicilio implements IDomicilioService {
    
    @Autowired
    public RDomicilio domicRepo;
    //inyecta la dependencia del repo con el q vamos a trabajar
    @Autowired
    public SPersona persoServ;
    
    //ENTIDADES
    
    @Override
    public List<Domicilio> list() {
        return domicRepo.findAll();
    }
    
    /*public List<Educacion> verEducaciones() {
        List<Educacion> listaEducaciones = educRepo.findAll();
        return listaEducaciones;  
    }  */

    @Override
    public Domicilio getById(Long id) {
        return domicRepo.findById(id).orElse(null);
    }
    
    /*public Educacion buscarEducacion(Long id) {
        Educacion educ = educRepo.findById(id).orElse(null);
        return educ;
    } */
    
    @Override
    public void create(Domicilio domicnew) {
        domicRepo.save(domicnew);
    }

    @Override
    public void delete(Long id) {
        domicRepo.deleteById(id);
    }
    
    @Override
    public void edit(Domicilio domic) {
        domicRepo.save(domic);
    }
    
     //DTOs
    
    @Override
    public List<DtoDomicilio> listDto(){
    // Lista Experiencias dsd DTO
        List<DtoDomicilio> listadomicdto = new ArrayList<>();
        
        // Lista Experiencias dsd Entidad
        List<Domicilio> listadomic= this.list();
        
        // Asigno valores de Entidad a DTO
        for (Domicilio domic: listadomic){
            
            DtoDomicilio domicdto =
            
            DtoDomicilio.builder()
                    .idDomicilio(domic.getId())
                    .calle(domic.getCalle())
                    .altura(domic.getAltura())
                    .piso(domic.getPiso())
                    .localidad(domic.getLocalidad())
                    .provincia(domic.getProvincia())
                    .mapa(domic.getMapa())
                    //.idPersona(domic.getPers().getId())
                    .build();
            listadomicdto.add(domicdto); 
        }
    return listadomicdto;
    }
          
    @Override
    public void createDto(DtoDomicilio domicdtonew){
    
        Domicilio domicnew=
                
        Domicilio.builder()
                .id(domicdtonew.getIdDomicilio())
                .calle(domicdtonew.getCalle())
                .altura(domicdtonew.getAltura())
                .piso(domicdtonew.getPiso())
                .localidad(domicdtonew.getLocalidad())
                .provincia(domicdtonew.getProvincia())
                .mapa(domicdtonew.getMapa())
                .pers(persoServ.getById(domicdtonew.getIdPersona()))
                /*.personaid(expedto.getPers().getId())*/
                .build();
        this.create(domicnew);
    }         
    
    @Override
    public void editDto(DtoDomicilio domicdto){
    
        //Busco la experiencia y la guardo en un objeto
        Domicilio domicmod=this.getById(domicdto.getIdDomicilio());
                
        //Cargo los datos desde el DTO
        domicmod.setCalle(domicdto.getCalle());
        domicmod.setAltura(domicdto.getAltura());
        domicmod.setPiso(domicdto.getPiso());
        domicmod.setLocalidad(domicdto.getLocalidad());
        domicmod.setProvincia(domicdto.getProvincia());
        domicmod.setMapa(domicdto.getMapa());
              
        // Lo cargo a BD
        this.edit(domicmod);
        
    }
    
    @Override
    public void deleteDto(Long id){
    this.delete(id);
    }
    
}
