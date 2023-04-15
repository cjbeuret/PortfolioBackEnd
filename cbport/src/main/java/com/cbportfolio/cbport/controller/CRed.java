package com.cbportfolio.cbport.controller;

import com.cbportfolio.cbport.entity.Red;
import com.cbportfolio.cbport.service.SRed;
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
@RequestMapping("/red") //localhost:8080/redes
//@CrossOrigin(origins = "http://localhost:4200")
public class CRed {
    
    @Autowired
    private SRed redServ;
       
    @GetMapping ("/lista/redes")
    @ResponseBody
    public List<Red> verRedes (){
       // return listaRedes;
       return redServ.verRedes();
    }
    
    @GetMapping ("/buscar/{id}")
    @ResponseBody
    public Red buscarRed (@PathVariable Long id){
       return redServ.buscarRed(id);
    }
    
    @PostMapping ("/crear/red")
    public String crearRed (@RequestBody Red net){
        //listaRedes.add(net);
        redServ.crearRed(net);
        return "La red fue creada correctamente";
    }
    
    @DeleteMapping ("/borrar/{id}")
    public String borrarRed(@PathVariable Long id){
        redServ.borrarRed(id);
        return "La red fue borrada correctamente";
    }
    
    @PostMapping ("/editar/red")
    public String editarRed (@RequestBody Red net){
        //listaRedes.add(net);
        redServ.editarRed(net);
        return "Los datos de la red se modificaron correctamente";
    }
}
