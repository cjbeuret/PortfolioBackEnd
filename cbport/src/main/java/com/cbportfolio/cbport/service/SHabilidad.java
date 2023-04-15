package com.cbportfolio.cbport.service;

import com.cbportfolio.cbport.entity.Habilidad;
import com.cbportfolio.cbport.dto.DtoHabilidad;
import com.cbportfolio.cbport.repository.RHabilidad;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SHabilidad implements IHabilidadService{
        
    @Autowired
    public RHabilidad habRepo;
    
    
    @Override
    public List<Habilidad> verHabilidades() {
        return habRepo.findAll();
    }
    
    /*public List<Habilidad> verHabilidades() {
        List<Habilidad> listaHabilidades = habRepo.findAll();
        return listaHabilidades;  
    }  programa */

    @Override
    public Habilidad buscarHabilidad(Long id) {
        return habRepo.findById(id).orElse(null);
    }
    
    /*public Habilidad buscarHabilidad(Long id) {
        Habilidad hab = habRepo.findById(id).orElse(null);
        return hab;
    } programa TK */
    
    @Override
    public void crearHabilidad(Habilidad hab) {
        habRepo.save(hab);
    }

    @Override
    public void borrarHabilidad(Long id) {
        habRepo.deleteById(id);
    }
    
    @Override
    public void editarHabilidad(Habilidad hab) {
        habRepo.save(hab);
    }

    //METODOS DTOs
    
    /*@Override
    public List<DtoHabilidad> verDtoHabilidades(){
    // Lista de DTOS
    List<DtoHabilidad> listahabdto = new ArrayList<>();
    // Lista de Entidades
    List<Habilidad> listahab = this.verHabilidades();
        
        for (Habilidad hab : listahab) {
            DtoHabilidad dto
                    = DtoHabilidad.builder()
                            .imagen(hab.getImagen())
                            .nombreHab(hab.getNombreHab())
                            .porcentaje(hab.getPorcentaje())
                            .pers(hab.getPers())
                            .build();

            listahabdto.add(dto);
        }
        return listahabdto;
    }*/

    @Override
    public DtoHabilidad buscarDtoHabilidad(Long id) {
             throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void crearDtoHabilidad(DtoHabilidad dtohab) {
              
        DtoHabilidad newhab=
                DtoHabilidad.builder()
                        .imagen(dtohab.getImagen())
                        .nombreHab(dtohab.getNombreHab())
                        .porcentaje(dtohab.getPorcentaje())
                        .pers(dtohab.getPers())         
                    .build();
        this.crearDtoHabilidad(newhab);
    }


    @Override
    public List<DtoHabilidad> verDtoHabilidades() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void borrarDtoHabilidad(Long id) {  
        habRepo.deleteById(id);
    }
    

    @Override
    public void editarDtoHabilidad(DtoHabilidad dtohab) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    /*public void modificarHabilidadDTO(HabilidadDTO habilidadDTO){
        
        //Busco la habilidad y la guardo en un objeto
        Habilidad habilidadaModificar=this.buscarHabilidad(habilidadDTO.getId_habilidad());
        
        //Cargo los datos desde el DTO
        habilidadaModificar.setNombre(habilidadDTO.getNombre());
        habilidadaModificar.setPorcentaje(habilidadDTO.getPorcentaje());
        
        //Lo guardo en la base de datos
        this.modificarHabilidad(habilidadaModificar);*/
    }
}
      

   
    

   


    
