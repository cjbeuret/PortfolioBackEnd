
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/domicilio") //localhost:8080/domicilio
//@CrossOrigin(origins = "http://localhost:4200")
public class CDomicilio {
    
    @Autowired
    private SDomicilio domicServ;
    //inyección de dependencia de la controladora con el service
    
    @GetMapping ("/lista/domicilios")
    @ResponseBody
    public List<Domicilio> verDomicilios (){
       // return listaDomicilios;
       return domicServ.verDomicilios();
    }
    
    @GetMapping ("/buscar/{id}")
    @ResponseBody
    public Domicilio buscarDomicilio (@PathVariable Long id){
       return domicServ.buscarDomicilio(id);
    }
    
    @PostMapping ("/crear/domicilio")
    public String crearDomicilio (@RequestBody Domicilio domic){
        //listaDomicilios.add(domic);
        domicServ.crearDomicilio(domic);
        return "El domicilio fue creado correctamente";
    }
    
    @DeleteMapping ("/borrar/{id}")
    public String borrarDomicilio(@PathVariable Long id){
        domicServ.borrarDomicilio(id);
        return "El domicilio fue borrado correctamente";
    }
    
    @PostMapping ("/editar/domicilio")
    public String editarDomicilio (@RequestBody Domicilio domic){
        //listaDomicilio.add(domic);
        domicServ.editarDomicilio(domic);
        return "Los datos del domicilio se modificaron correctamente";
    }
    
}
