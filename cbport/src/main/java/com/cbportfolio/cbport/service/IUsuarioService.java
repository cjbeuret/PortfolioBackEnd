package com.cbportfolio.cbport.service;

import com.cbportfolio.cbport.dto.DtoUsuario;
import com.cbportfolio.cbport.entity.Usuario;
import java.util.List;


public interface IUsuarioService {
    //entidades
    public List<Usuario> list();
    public Usuario getById(Long id);
    public void create(Usuario usuarionew);
    public void delete(Long id);
    public void edit(Usuario usuario);
    
    // DTOs
    public List<DtoUsuario> listDto();
    public void createDto(DtoUsuario usuariodtonew);
    public void deleteDto(Long id);
    public void editDto(DtoUsuario usuariodto);
    
}
