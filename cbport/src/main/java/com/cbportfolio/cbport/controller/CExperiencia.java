package com.cbportfolio.cbport.controller;

import com.cbportfolio.cbport.entity.Experiencia;
import com.cbportfolio.cbport.service.SExperiencia;
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
@RequestMapping("/experiencia") //localhost:8080/experiencias
//@CrossOrigin(origins = "http://localhost:4200")
public class CExperiencia {
    
    @Autowired
    private SExperiencia expeServ;
       
    @GetMapping ("/lista/experiencias")
    @ResponseBody
    public List<Experiencia> verExperiencias (){
       // return listaExperiencias;
       return expeServ.verExperiencias();
    }
    
    @GetMapping ("/buscar/{id}")
    @ResponseBody
    public Experiencia buscarExperiencia (@PathVariable Long id){
       return expeServ.buscarExperiencia(id);
    }
    
    @PostMapping ("/crear/experiencia")
    public String crearExperiencia (@RequestBody Experiencia expe){
        //listaExperiencias.add(expe);
        expeServ.crearExperiencia(expe);
        return "La experiencia fue creada correctamente";
    }
    
    @DeleteMapping ("/borrar/{id}")
    public String borrarExperiencia(@PathVariable Long id){
        expeServ.borrarExperiencia(id);
        return "La experiencia fue borrada correctamente";
    }
    
    @PostMapping ("/editar/experiencia")
    public String editarExperiencia (@RequestBody Experiencia expe){
        //listaExperiencias.add(expe);
        expeServ.editarExperiencia(expe);
        return "Los datos de la experiencia se modificaron correctamente";
    }
}
