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
public class SUsuario implements IUsuarioService {
   
    @Autowired
    public RUsuario usuarioRepo;
    
    @Autowired
    public SPersona persoServ;
    
    
    //ENTIDADES
    
    @Override
    public List<Usuario> list() {
        return usuarioRepo.findAll();
    }
    
    /*public List<Usuario> list() {
        List<Usuario> listaUsuarios = usuarioRepo.findAll();
        return listaUsuarios;  
    }  */

    @Override
    public Usuario getById(Long id) {
        return usuarioRepo.findById(id).orElse(null);
    }
    
    /*public Usuario getById(Long id) {
        Usuario usuario = usuarioRepo.findById(id).orElse(null);
        return usuario;
    }  */
    
    @Override
    public void create(Usuario usuarionew) {
        usuarioRepo.save(usuarionew);
    }

    @Override
    public void delete(Long id) {
        usuarioRepo.deleteById(id);
    }
    
    @Override
    public void edit(Usuario usuario) {
        usuarioRepo.save(usuario);
    }

    //DTOs
    
    @Override
    public List<DtoUsuario> listDto(){
    // Lista Usuarios dsd DTO
        List<DtoUsuario> listausuariodto = new ArrayList<>();
        
        // Lista Usuarios dsd Entidad
        List<Usuario> listausuario= this.list();
        
        // Asigno valores de Entidad a DTO
        for (Usuario usuario: listausuario){
            
            DtoUsuario usuariodto =
            
            DtoUsuario.builder()
                    .idUsuario(usuario.getId())
                    .email(usuario.getEmail())
                    .password(usuario.getPassword())                    
                    .idPersona(usuario.getPers().getId())
                    .build();
            listausuariodto.add(usuariodto); 
        }
    return listausuariodto;
    }
          
    @Override
    public void createDto(DtoUsuario usuariodtonew){
    
        Usuario usuarionew=
                
        Usuario.builder()
                .id(usuariodtonew.getIdUsuario())
                .email(usuariodtonew.getEmail())
                .password(usuariodtonew.getPassword())
                .pers(persoServ.getById(usuariodtonew.getIdPersona()))
                /*.personaid(usuariodto.getPers().getId())*/
                .build();
        this.create(usuarionew);
    }
    
    
    @Override
    public void editDto(DtoUsuario usuariodto){
    
        //Busco el usuario y la guardo en un objeto
        Usuario usuariomod=this.getById(usuariodto.getIdUsuario());
                
        //Cargo los datos desde el DTO
        usuariomod.setEmail(usuariodto.getEmail());
        usuariomod.setPassword(usuariodto.getPassword());
                     
        // Lo cargo a BD
        this.edit(usuariomod);
        
    }
    
    @Override
    public void deleteDto(Long id){
    this.delete(id);
    }

}
