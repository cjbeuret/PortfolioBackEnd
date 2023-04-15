package com.cbportfolio.cbport.controller;

import com.cbportfolio.cbport.dto.DtoHabilidad;
import com.cbportfolio.cbport.entity.Habilidad;
import com.cbportfolio.cbport.service.SHabilidad;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/habilidad") //localhost:8080/habilidades
@CrossOrigin(origins = "http://localhost:4200")
public class CHabilidad {
    
    @Autowired
    private SHabilidad habServ;
       
    @GetMapping ("/lista/habilidades")
    @ResponseBody
    public List<Habilidad> verHabilidades (){
       // return listaHabilidades;
       return habServ.verHabilidades();
    }
    
    /*@GetMapping("/lista/dtohabilidades")
    @ResponseBody
    public List<DtoHabilidad> verDtoHabilidades(){

        // Lista de DTOS
        List<DtoHabilidad> listahabdto = new ArrayList<>();

        // Lista de Entidades
        List<Habilidad> listahab = habServ.verHabilidades();
        
        for (Habilidad hab : listahab) {
            DtoHabilidad dto = 
                    DtoHabilidad.builder()
                            .imagen(hab.getImagen())
                            .nombreHab(hab.getNombreHab())
                            .porcentaje(hab.getPorcentaje())
                            .pers(hab.getPers())
                            .build();
            
            listahabdto.add(dto);
        }
        return listahabdto;
    }*/

    
    
    @GetMapping ("/buscar/{id}")
    @ResponseBody
    public Habilidad buscarHabilidad (@PathVariable Long id){
       return habServ.buscarHabilidad(id);
    }
    
    @PostMapping ("/crear/habilidad")
    public String crearHabilidad (@RequestBody Habilidad hab){
        //listaHabilidades.add(hab);
        habServ.crearHabilidad(hab);
        return "La habilidad fue creada correctamente";
    }
    
    @DeleteMapping ("/borrar/{id}")
    public String borrarHabilidad(@PathVariable Long id){
        habServ.borrarHabilidad(id);
        return "La habilidad fue borrada correctamente";
    }
    
    @PostMapping ("/editar/habilidad")
    public String editarHabilidad (@RequestBody Habilidad hab){
        //listaHabilidades.add(hab);
        habServ.editarHabilidad(hab);
        return "Los datos de la habilidad se modificaron correctamente";
    }
}
