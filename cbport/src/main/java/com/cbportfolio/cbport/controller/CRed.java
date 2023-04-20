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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/red") //localhost:8080/redes
@CrossOrigin(origins = "http://localhost:4200")
public class CRed {
    
    @Autowired
    private SRed redServ;
       
    @GetMapping ("/lista")
    @ResponseBody
    public List<Red> list (){
       // return listaRedes;
       return redServ.list();
    }
    
    @GetMapping ("/detalle/{id}")
    @ResponseBody
    public Red getById (@PathVariable Long id){
       return redServ.getById(id);
    }
    
    @PostMapping ("/alta")
    public String create (@RequestBody Red red){
        //listaRedes.add(net);
        redServ.create(red);
        return "La red fue creada correctamente";
    }
    
    @DeleteMapping ("/baja/{id}")
    public String delete(@PathVariable Long id){
        redServ.delete(id);
        return "La red fue borrada correctamente";
    }
    
    @PutMapping ("/edicion")
    public String edit (@RequestBody Red red){
        //listaRedes.add(net);
        redServ.edit(red);
        return "Los datos de la red se modificaron correctamente";
    }
}
