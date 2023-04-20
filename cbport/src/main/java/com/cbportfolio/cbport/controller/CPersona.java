package com.cbportfolio.cbport.controller;

import com.cbportfolio.cbport.dto.DtoPersona;
import com.cbportfolio.cbport.entity.Persona;
import com.cbportfolio.cbport.service.SPersona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persona") //localhost:8080/persona
@CrossOrigin(origins = "http://localhost:4200")
//@CrossOrigin(origins = ("https://cjbfrontend.web.app", "http://localhost:4200")) estas se pueden poner juntas
public class CPersona {
    
    @Autowired
    private SPersona persoServ;
    //inyección de dependencia de la controladora con el service
    
    @GetMapping ("/lista")
    @ResponseBody
    public List<DtoPersona> list (){
       // return listaPersonas;
       return persoServ.listDto();
    }
    
    @GetMapping ("/detalle/{id}")
    @ResponseBody
    public Persona getById (@PathVariable Long id){
       return persoServ.getById(id);
    }
    
    
    @PostMapping ("/alta")
    public String create (@RequestBody DtoPersona persona){
        //listaPersonas.add(pers);
        persoServ.createDto(persona);
        return "La persona fue creada correctamente";
    }
    
    @DeleteMapping ("/baja/{id}")
    public String delete(@PathVariable Long id){
        persoServ.deleteDto(id);
        return "La persona fue borrada correctamente";
    }
    
    @PutMapping ("/edicion")
    public String edit (@RequestBody DtoPersona persona){
        //listaPersonas.add(pers);
        persoServ.editDto(persona);
        return "Los datos de la persona se modificaron correctamente";
    }
   
}
