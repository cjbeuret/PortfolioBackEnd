package com.cbportfolio.cbport.controller;

import com.cbportfolio.cbport.entity.Persona;
import com.cbportfolio.cbport.service.SPersona;
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
@RequestMapping("/personas") //localhost:8080/personas
//@CrossOrigin(origins = "http://localhost:4200")
//@CrossOrigin(origins = ("https://cjbfrontend.web.app", "http://localhost:4200")) estas se pueden poner juntas
public class CPersona {
    
    @Autowired
    private SPersona persoServ;
    //inyección de dependencia de la controladora con el service
    
    @GetMapping ("/lista/personas")
    @ResponseBody
    public List<Persona> verPersonas (){
       // return listaPersonas;
       return persoServ.verPersonas();
    }
    
    @GetMapping ("/buscar/{id}")
    @ResponseBody
    public Persona buscarPersona (@PathVariable Long id){
       return persoServ.buscarPersona(id);
    }
    
    @PostMapping ("/nueva/persona")
    public String crearPersona (@RequestBody Persona per){
        //listaPersonas.add(pers);
        persoServ.crearPersona(per);
        return "La persona fue creada correctamente";
    }
    
    @DeleteMapping ("/borrar/{id}")
    public String borrarPersona(@PathVariable Long id){
        persoServ.borrarPersona(id);
        return "La persona fue borrada correctamente";
    }
    
    @PostMapping ("/editar/persona")
    public String editarPersona (@RequestBody Persona per){
        //listaPersonas.add(pers);
        persoServ.editarPersona(per);
        return "Los datos de la persona se modificaron correctamente";
    }
   
}
