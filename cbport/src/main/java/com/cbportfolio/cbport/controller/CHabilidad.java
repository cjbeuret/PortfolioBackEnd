package com.cbportfolio.cbport.controller;

import com.cbportfolio.cbport.entity.Habilidad;
import com.cbportfolio.cbport.service.SHabilidad;
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
@RequestMapping("/habilidad") //localhost:8080/habilidades
@CrossOrigin(origins = "http://localhost:4200")
public class CHabilidad {
    
    @Autowired
    private SHabilidad habServ;
       
    @GetMapping ("/lista")
    @ResponseBody
    public List<Habilidad> list (){
       // return listaHabilidades;
       return habServ.list();
    }   
    
    @GetMapping ("/detalle/{id}")
    @ResponseBody
    public Habilidad getById (@PathVariable Long id){
       return habServ.getById(id);
    }
    
    @PostMapping ("/alta")
    public String create (@RequestBody Habilidad habilidad){
        //listaHabilidades.add(hab);
        habServ.create(habilidad);
        return "La habilidad fue creada correctamente";
    }
    
    @DeleteMapping ("/baja/{id}")
    public String delete(@PathVariable Long id){
        habServ.delete(id);
        return "La habilidad fue borrada correctamente";
    }
    
    @PutMapping ("/edicion")
    public String edit(@RequestBody Habilidad habilidad){
        //listaHabilidades.add(hab);
        habServ.edit(habilidad);
        return "Los datos de la habilidad se modificaron correctamente";
    }
}
