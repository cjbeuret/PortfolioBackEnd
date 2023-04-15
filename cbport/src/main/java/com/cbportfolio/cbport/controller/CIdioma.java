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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/idioma") //localhost:8080/idiomas
//@CrossOrigin(origins = "http://localhost:4200")
public class CIdioma {
    
    @Autowired
    private SIdioma idiomaServ;
       
    @GetMapping ("/lista/idiomas")
    @ResponseBody
    public List<Idioma> verIdiomas (){
       // return listaIdiomas;
       return idiomaServ.verIdiomas();
    }
    
    @GetMapping ("/buscar/{id}")
    @ResponseBody
    public Idioma buscarIdioma (@PathVariable Long id){
       return idiomaServ.buscarIdioma(id);
    }
    
    @PostMapping ("/crear/idioma")
    public String crearIdioma (@RequestBody Idioma idiom){
        //listaIdiomas.add(idiom);
        idiomaServ.crearIdioma(idiom);
        return "El idioma fue creado correctamente";
    }
    
    @DeleteMapping ("/borrar/{id}")
    public String borrarIdioma(@PathVariable Long id){
        idiomaServ.borrarIdioma(id);
        return "El idioma fue borrado correctamente";
    }
    
    @PostMapping ("/editar/idioma")
    public String editarIdioma (@RequestBody Idioma idiom){
        //listaIdiomas.add(idiom);
        idiomaServ.editarIdioma(idiom);
        return "Los datos del idioma se modificaron correctamente";
    }
}
