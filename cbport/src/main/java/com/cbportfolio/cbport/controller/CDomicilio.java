
package com.cbportfolio.cbport.controller;

import com.cbportfolio.cbport.entity.Domicilio;
import com.cbportfolio.cbport.service.SDomicilio;
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
@RequestMapping("/domicilio") //localhost:8080/domicilio
@CrossOrigin(origins = "http://localhost:4200")
public class CDomicilio {
    
    @Autowired
    private SDomicilio domicServ;
    //inyección de dependencia de la controladora con el service
    
    @GetMapping ("/lista")
    @ResponseBody
    public List<Domicilio> list (){
       // return listaDomicilios;
       return domicServ.list();
    }
    
    @GetMapping ("/detalle/{id}")
    @ResponseBody
    public Domicilio getById (@PathVariable Long id){
       return domicServ.getById(id);
    }
    
    @PostMapping ("/alta")
    public String create (@RequestBody Domicilio domicilio){
        //listaDomicilios.add(domic);
        domicServ.create(domicilio);
        return "El domicilio fue creado correctamente";
    }
    
    @DeleteMapping ("/baja/{id}")
    public String delete(@PathVariable Long id){
        domicServ.delete(id);
        return "El domicilio fue borrado correctamente";
    }
    
    @PutMapping ("/edicion")
    public String edit (@RequestBody Domicilio domicilio){
        //listaDomicilio.add(domic);
        domicServ.edit(domicilio);
        return "Los datos del domicilio se modificaron correctamente";
    }
    
}
