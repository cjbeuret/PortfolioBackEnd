package com.cbportfolio.cbport.service;

import com.cbportfolio.cbport.dto.DtoRed;
import com.cbportfolio.cbport.entity.Red;
import com.cbportfolio.cbport.repository.RRed;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SRed implements IRedService{
    
    @Autowired
    public RRed redRepo;
    
    @Autowired
    public SPersona persoServ;
    
    //ENTIDADES
    
    @Override
    public List<Red> list() {
        return redRepo.findAll();
    }
    
    /*public List<Red> verRedes() {
        List<Red> listaRedes = redRepo.findAll();
        return listaRedes;  
    }  */
    
    @Override
    public Red getById(Long id) {
        return redRepo.findById(id).orElse(null);
    }
    
    /*public Red buscarRed(Long id) {
        Red net = redRepo.findById(id).orElse(null);
        return net;
    }  */

    @Override
    public void create(Red netnew) {
        redRepo.save(netnew);
    }

    @Override
    public void delete(Long id) {
        redRepo.deleteById(id);
    }
    
    @Override
    public void edit(Red net) {
        redRepo.save(net);
    }

     //DTOs
    
    @Override
    public List<DtoRed> listDto(){
    // Lista Redes dsd DTO
        List<DtoRed> listareddto = new ArrayList<>();
        
        // Lista Redes dsd Entidad
        List<Red> listared= this.list();
        
        // Asigno valores de Entidad a DTO
        for (Red red: listared){
            
            DtoRed reddto =
            
            DtoRed.builder()
                    .idRed(red.getId())
                    .nombreRed(red.getNombreRed())
                    .imagen(red.getImagen())
                    .url(red.getUrl())
                    .idPersona(red.getPers().getId())
                    .build();
            listareddto.add(reddto); 
        }
    return listareddto;
    }
                   
    
    @Override
    public void createDto(DtoRed reddtonew){
    
        Red rednew=
                
        Red.builder()
                .id(reddtonew.getIdRed())
                .nombreRed(reddtonew.getNombreRed())
                .imagen(reddtonew.getImagen())
                .url(reddtonew.getUrl())
                .pers(persoServ.getById(reddtonew.getIdPersona()))
                /*.personaid(expedto.getPers().getId())*/
                .build();
        this.create(rednew);
    }
    
    @Override
    public void editDto(DtoRed reddto){
    
        //Busco la experiencia y la guardo en un objeto
        Red redmod=this.getById(reddto.getIdRed());
                
        //Cargo los datos desde el DTO
        redmod.setNombreRed(reddto.getNombreRed());
        redmod.setImagen(reddto.getImagen());
        redmod.setUrl(reddto.getUrl());
                    
        // Lo cargo a BD
        this.edit(redmod); 
    }
    
    
    @Override
    public void deleteDto(Long id){
    this.delete(id);
    }
}
