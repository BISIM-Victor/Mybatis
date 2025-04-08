package com.Mybatis.Mybatis.module.repository.impl;

import com.Mybatis.Mybatis.module.dao.UsuarioService;
import com.Mybatis.Mybatis.module.entities.Usuario;
import com.Mybatis.Mybatis.module.repository.RepositoryUsuario;
import org.springframework.stereotype.Repository;
import javax.annotation.Resource;
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
    public Usuario getUsuarioById(long id) {  // Cambiado a long
        return usuarioService.getUsuarioById(id);
    }

    @Override
    public void insertUsuario(Usuario usuario) {
        usuarioService.insertUsuario(usuario);
    }

    @Override
    public void updateUsuario(Usuario usuario) {
        usuarioService.updateUsuario(usuario);
    }

    @Override
    public void deleteUsuarioById(long id) {  // Cambiado a long
        usuarioService.deleteUsuarioById(id);
    }
}



