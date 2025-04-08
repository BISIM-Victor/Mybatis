package com.Mybatis.Mybatis.module.repository;

import com.Mybatis.Mybatis.module.entities.Usuario;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RepositoryUsuario {

    List<Usuario> getAllUsuarios();

    Usuario getUsuarioById(int id);

    void insertUsuario(Usuario usuario);

    void updateUsuario(Usuario usuario);

    void deleteUsuarioById(int id);

}
