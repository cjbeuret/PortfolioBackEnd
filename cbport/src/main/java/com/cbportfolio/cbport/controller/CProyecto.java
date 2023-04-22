package com.cbportfolio.cbport.controller;

import com.cbportfolio.cbport.dto.DtoProyecto;
import com.cbportfolio.cbport.entity.Proyecto;
import com.cbportfolio.cbport.service.SProyecto;
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
@RequestMapping("/proyecto") //localhost:8080/proyectos
@CrossOrigin(origins = "http://localhost:4200")
public class CProyecto {
    
    @Autowired
    private SProyecto proyServ;
       
    @GetMapping ("/lista")
    @ResponseBody
    public List<DtoProyecto> list(){
       // return listaProyectos;
       return proyServ.listDto();
    }
    
    @GetMapping ("/detalle/{id}")
    @ResponseBody
    public Proyecto getById (@PathVariable Long id){
       return proyServ.getById(id);
    }
    
    @PostMapping ("/alta")
    public String create (@RequestBody Proyecto proyecto){
        //listaProyecto.add(proy);
        proyServ.create(proyecto);
        return "El proyecto fue creado correctamente";
    }
    
    @DeleteMapping ("/baja/{id}")
    public String delete(@PathVariable Long id){
        proyServ.deleteDto(id);
        return "El proyecto fue borrado correctamente";
    }
    
    @PutMapping ("/edicion")
    public String edit (@RequestBody Proyecto proyecto){
        //listaProyectos.add(proy);
        proyServ.edit(proyecto);
        return "Los datos del proyecto se modificaron correctamente";
    }
    
}
