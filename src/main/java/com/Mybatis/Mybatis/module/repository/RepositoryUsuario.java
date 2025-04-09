package com.Mybatis.Mybatis.module.repository;

import com.Mybatis.Mybatis.module.entities.Usuario;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface RepositoryUsuario {

    // Obtener todos los usuarios
    List<Usuario> getAllUsuarios();

    // Insertar un nuevo usuario
    void insertUsuario(Usuario usuario);

    // Actualizar un usuario existente
    void updateUsuario(Usuario usuario);

    // Eliminar un usuario por ID
    void deleteUsuario(Long id);

    // Buscar un usuario por ID
    Usuario getUsuarioById(Long id);
}

