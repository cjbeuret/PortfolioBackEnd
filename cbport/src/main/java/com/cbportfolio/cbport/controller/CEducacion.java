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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/educacion") //localhost:8080/educaciones
@CrossOrigin(origins = "http://localhost:4200")
public class CEducacion {
    
    @Autowired
    private SEducacion educServ;
    //inyección de dependencia de la controladora con el service
       
    @GetMapping ("/lista")
    @ResponseBody
    public List<Educacion> list(){
       // return listaPersonas;
       return educServ.list();
    }
    
    @GetMapping ("/detalle/{id}")
    @ResponseBody
    public Educacion getById(@PathVariable Long id){
       return educServ.getById(id);
    }
    
    @PostMapping ("/alta")
    public String create (@RequestBody Educacion educ){
        //listaPersonas.add(pers);
        educServ.create(educ);
        return "La educacion fue creada correctamente";
    }
    
    @DeleteMapping ("/baja/{id}")
    public String delete(@PathVariable Long id){
        educServ.delete(id);
        return "La educacion fue borrada correctamente";
    }
    
    @PutMapping ("/edicion")
    public String edit (@RequestBody Educacion educ){
        //listaPersonas.add(pers);
        educServ.edit(educ);
        return "Los datos de la educacion se modificaron correctamente";
    }
}
