package com.Mybatis.Mybatis.module.repository.impl;

import com.Mybatis.Mybatis.module.dao.UsuarioService;
import com.Mybatis.Mybatis.module.entities.Usuario;
import com.Mybatis.Mybatis.module.repository.RepositoryUsuario;
import org.springframework.stereotype.Repository;
import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@Repository("repositoryUsuario")
public class RepositoryUsuarioimpl implements RepositoryUsuario {

    @Resource
    private UsuarioService usuarioService;

    @Override
    public List<Usuario> getAllUsuarios() {
        return usuarioService.getAllUsuarios();
    }

    @Override
    public void insertUsuario(Usuario usuario) {
        usuarioService.insertUsuario(usuario);
    }

    @Override
    public void updateUsuario(Usuario usuario) {
        // Llamada al servicio para actualizar el usuario
        usuarioService.updateUsuario(usuario);
    }

    @Override
    public void deleteUsuario(Long id) {
        // Llamada al servicio para eliminar el usuario por ID
        usuarioService.deleteUsuario(id);
    }

    @Override
    public Usuario getUsuarioById(Long id) {
        // Llamada al servicio para obtener el usuario por ID
        return usuarioService.getUsuarioById(id);
    }
}



