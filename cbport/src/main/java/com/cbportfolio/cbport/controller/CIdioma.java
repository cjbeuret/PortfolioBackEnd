package com.cbportfolio.cbport.controller;

import com.cbportfolio.cbport.entity.Idioma;
import com.cbportfolio.cbport.service.SIdioma;
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
@RequestMapping("/idioma") //localhost:8080/idiomas
@CrossOrigin(origins = "http://localhost:4200")
public class CIdioma {
    
    @Autowired
    private SIdioma idiomaServ;
       
    @GetMapping ("/lista")
    @ResponseBody
    public List<Idioma> list (){
       // return listaIdiomas;
       return idiomaServ.list();
    }
    
    @GetMapping ("/detalle/{id}")
    @ResponseBody
    public Idioma getById (@PathVariable Long id){
       return idiomaServ.getById(id);
    }
    
    @PostMapping ("/alta")
    public String create (@RequestBody Idioma idiom){
        //listaIdiomas.add(idiom);
        idiomaServ.create(idiom);
        return "El idioma fue creado correctamente";
    }
    
    @DeleteMapping ("/baja/{id}")
    public String delete(@PathVariable Long id){
        idiomaServ.delete(id);
        return "El idioma fue borrado correctamente";
    }
    
    @PutMapping ("/edicion")
    public String edit (@RequestBody Idioma idiom){
        //listaIdiomas.add(idiom);
        idiomaServ.edit(idiom);
        return "Los datos del idioma se modificaron correctamente";
    }
}
