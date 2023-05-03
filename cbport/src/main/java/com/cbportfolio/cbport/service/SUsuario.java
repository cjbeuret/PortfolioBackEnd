
package com.cbportfolio.cbport.service;

import com.cbportfolio.cbport.dto.DtoUsuario;
import com.cbportfolio.cbport.entity.Usuario;
import com.cbportfolio.cbport.repository.RUsuario;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SUsuario implements IUsuarioService{
    
    @Autowired
    public RUsuario usuarioRepo; 
    //inyecta la dependencia del repo con el q vamos a trabajar
     
    @Autowired
    public SPersona persoServ;
    
    @Override
    public Usuario loginUsuario(String username, String password) {
        List<Usuario> listaUsuarios = usuarioRepo.findByUsernameAndPassword(username, password);
        if(!listaUsuarios.isEmpty())
        {
            return listaUsuarios.get(0);
        }
        return null;
     
    }

    @Override
    public List<Usuario> list() {
        return usuarioRepo.findAll();
    } 
    
    /*public List<Persona> verPersonas() {
        List<Persona> listaPersonas = persoRepo.findAll();
        return listaPersonas;  
    }*/
    
    @Override
    public Usuario getById(Long id) {
        return usuarioRepo.findById(id).orElse(null);
    } //Luisina
    
    
    /*public Persona buscarPersona(Long id) {
        Persona per = persoRepo.findById(id).orElse(null);
        return per;
    } programa TK */
    
    @Override
    public void create(Usuario usernew) {
        usuarioRepo.save(usernew);
    }

    @Override
    public void delete(Long id) {
        usuarioRepo.deleteById(id);
    }
    
    @Override
    public void edit(Usuario user) {
        usuarioRepo.save(user);
    }
    
     //DTOs
    
    @Override
    public List<DtoUsuario> listDto(){
    // Lista Persona dsd DTO
        List<DtoUsuario> listauserdto = new ArrayList<>();
        
        // Lista Experiencias dsd Entidad
        List<Usuario> listausers= this.list();
        
        // Asigno valores de Entidad a DTO
        for (Usuario user: listausers){
            
            DtoUsuario userdto =
            
            DtoUsuario.builder()
                    .id_usuario(user.getId())
                    .username(user.getUsername())
                    .email(user.getEmail())
                    .password(user.getPassword())          
                    .id_persona(user.getPers().getId())
                    .build();
            listauserdto.add(userdto); 
        }
    return listauserdto;
    }

          
    @Override
    public void createDto(DtoUsuario userdtonew){
    
        Usuario usernew=
                
        Usuario.builder()
                //.id(userdtonew.getId_usuario())               
                .username(userdtonew.getUsername())               
                .email(userdtonew.getEmail())
                .password(userdtonew.getPassword())
                .pers(persoServ.getById(userdtonew.getId_persona()))                
                .build();
        this.create(usernew);
    }
    
    
    @Override
    public void editDto(DtoUsuario userdto){
    
        //Busco la experiencia y la guardo en un objeto
        Usuario usermod=this.getById(userdto.getId_usuario());               
        //Cargo los datos desde el DTO
        usermod.setUsername(userdto.getUsername());        
        usermod.setEmail(userdto.getEmail());
        usermod.setPassword(userdto.getPassword());              
        // Lo cargo a BD
        this.edit(usermod);
    }
    
    @Override
    public DtoUsuario getByIdDto(Long id){
    
    //Busco la experiencia y la guardo en un objeto
        Usuario userBuscado=this.getById(id);
        
     // Mapeo la experiencia a DtoExperiencia
        DtoUsuario userBuscadoDTO =
             
             DtoUsuario.builder()
                     .id_usuario(userBuscado.getId())
                     .username( userBuscado.getUsername())                     
                     .email( userBuscado.getEmail())
                     .password( userBuscado.getPassword())                     
                  .build();
    
             return userBuscadoDTO;   
     
    }
            
    @Override
    public void deleteDto(Long id){
    this.delete(id);
    }
    
   /*
    @Override
    public DtoUsuario loginUsuarioDto(String username, String password) {
        List<Usuario> listaUsuariosDto = usuarioRepo.findByUsernameAndPassword(username, password);
        if(!listaUsuariosDto.isEmpty())
        {
            return listUsuariosDto.get(0);
        }
        return null;
     
    }
    */
    
    
    
    
}
