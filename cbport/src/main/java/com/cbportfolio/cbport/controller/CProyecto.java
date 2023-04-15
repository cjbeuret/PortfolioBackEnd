package com.cbportfolio.cbport.controller;

import com.cbportfolio.cbport.entity.Proyecto;
import com.cbportfolio.cbport.service.SProyecto;
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
@RequestMapping("/proyecto") //localhost:8080/proyectos
//@CrossOrigin(origins = "http://localhost:4200")
public class CProyecto {
    
    @Autowired
    private SProyecto proyServ;
       
    @GetMapping ("/lista/proyectos")
    @ResponseBody
    public List<Proyecto> verProyectos (){
       // return listaProyectos;
       return proyServ.verProyectos();
    }
    
    @GetMapping ("/buscar/{id}")
    @ResponseBody
    public Proyecto buscarProyecto (@PathVariable Long id){
       return proyServ.buscarProyecto(id);
    }
    
    @PostMapping ("/crear/proyecto")
    public String crearProyecto (@RequestBody Proyecto proy){
        //listaProyecto.add(proy);
        proyServ.crearProyecto(proy);
        return "El proyecto fue creado correctamente";
    }
    
    @DeleteMapping ("/borrar/{id}")
    public String borrarProyecto(@PathVariable Long id){
        proyServ.borrarProyecto(id);
        return "El proyecto fue borrado correctamente";
    }
    
    @PostMapping ("/editar/proyecto")
    public String editarProyecto (@RequestBody Proyecto proy){
        //listaProyectos.add(proy);
        proyServ.editarProyecto(proy);
        return "Los datos del proyecto se modificaron correctamente";
    }
    
}
