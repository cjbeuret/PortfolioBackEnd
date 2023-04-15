package com.cbportfolio.cbport.controller;

import com.cbportfolio.cbport.entity.Educacion;
import com.cbportfolio.cbport.service.SEducacion;
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
@RequestMapping("/educacion") //localhost:8080/educaciones
//@CrossOrigin(origins = "http://localhost:4200")
public class CEducacion {
    
    @Autowired
    private SEducacion educServ;
    //inyección de dependencia de la controladora con el service
       
    @GetMapping ("/lista/educaciones")
    @ResponseBody
    public List<Educacion> verEducaciones (){
       // return listaPersonas;
       return educServ.verEducaciones();
    }
    
    @GetMapping ("/buscar/{id}")
    @ResponseBody
    public Educacion buscarEducacion (@PathVariable Long id){
       return educServ.buscarEducacion(id);
    }
    
    @PostMapping ("/crear/educacion")
    public String crearEducacion (@RequestBody Educacion educ){
        //listaPersonas.add(pers);
        educServ.crearEducacion(educ);
        return "La educacion fue creada correctamente";
    }
    
    @DeleteMapping ("/borrar/{id}")
    public String borrarEducacion(@PathVariable Long id){
        educServ.borrarEducacion(id);
        return "La educacion fue borrada correctamente";
    }
    
    @PostMapping ("/editar/educacion")
    public String editarEducacion (@RequestBody Educacion educ){
        //listaPersonas.add(pers);
        educServ.editarEducacion(educ);
        return "Los datos de la educacion se modificaron correctamente";
    }
}
