package com.Mybatis.Mybatis.module.repository;

import com.Mybatis.Mybatis.module.entities.Usuario;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RepositoryUsuario {

    List<Usuario> getAllUsuarios();

    Usuario getUsuarioById(long id);  // Cambiado a long

    void insertUsuario(Usuario usuario);

    void updateUsuario(Usuario usuario);

    void deleteUsuarioById(long id);  // Cambiado a long
}

