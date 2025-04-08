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

    // Inyectar el UsuarioMapper para ejecutar las consultas de MyBatis
    @Resource
    private RepositoryUsuario  usuarioMapper;

    @Override
    public List<Usuario> getAllUsuarios() {
        // Llamar al método de MyBatis para obtener todos los usuarios
        return usuarioMapper.getAllUsuarios();
    }

    @Override
    public Usuario getUsuarioById(long id) {
        // Llamar al método de MyBatis para obtener un usuario por ID
        return usuarioMapper.getUsuarioById(id);
    }

    @Override
    public void insertUsuario(Usuario usuario) {
        // Llamar al método de MyBatis para insertar un nuevo usuario
        usuarioMapper.insertUsuario(usuario);
    }

    @Override
    public void updateUsuario(Usuario usuario) {
        // Llamar al método de MyBatis para actualizar un usuario
        usuarioMapper.updateUsuario(usuario);
    }

    @Override
    public void deleteUsuarioById(long id) {
        // Llamar al método de MyBatis para eliminar un usuario por ID
        usuarioMapper.deleteUsuarioById(id);
    }
}





