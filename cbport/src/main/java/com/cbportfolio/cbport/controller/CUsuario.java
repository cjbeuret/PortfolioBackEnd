package com.cbportfolio.cbport.controller;

import com.cbportfolio.cbport.dto.DtoUsuario;
import com.cbportfolio.cbport.entity.Usuario;
import com.cbportfolio.cbport.service.IUsuarioService;
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
@RequestMapping("/usuario") //localhost:8080/experiencias
@CrossOrigin(origins = "http://localhost:4200")
public class CUsuario {
   
    @Autowired
    private IUsuarioService usuarioServ;
    
    @GetMapping ("/lista")
    @ResponseBody
    public List<DtoUsuario> list(){
       // return listaUsuarios;
       return usuarioServ.listDto();
    }
       
    @GetMapping ("/detalle/{id}") 
    @ResponseBody
    public Usuario getById(@PathVariable Long id){
       return usuarioServ.getById(id);
    }
    
    @PostMapping ("/alta")
    public String create(@RequestBody DtoUsuario usuario){
        //listaUsuarios.add(usuario);
        usuarioServ.createDto(usuario);
        return "El usuario fue creado correctamente";
    }
    
    @DeleteMapping ("/baja/{id}")
    public String delete(@PathVariable Long id){
        usuarioServ.deleteDto(id);
        return "El usuario fue borrada correctamente";
    }
    
    @PutMapping ("/edicion")
    public String edit(@RequestBody DtoUsuario usuario){
        //listaExperiencias.add(expe);
        usuarioServ.editDto(usuario);
        return "Los datos del usuario se modificaron correctamente";
    }
    
    /* este sería editar por id, pero no lo tenemos en el servicio ni su interfase, tampoco en FRONTEND

    @PutMapping ("/editar/{id}")
    public String editById (@PathVariable("id") Long id, Usuario usuario){
        //listaUsuarios.add(usuario);
        usuarioServ.editById(usuario);
        return "Los datos del usuario se modificaron correctamente";
      }*/
}
