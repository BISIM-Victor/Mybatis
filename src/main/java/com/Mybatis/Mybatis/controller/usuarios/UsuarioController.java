package com.Mybatis.Mybatis.controller.usuarios;

import com.Mybatis.Mybatis.module.entities.Usuario;
import com.Mybatis.Mybatis.module.repository.RepositoryUsuario;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;


@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    // Inyectamos el repository
    private final RepositoryUsuario repositoryUsuario;

    @GetMapping("home")
   public String getapp() {
       return "app functional";
   }
    // Endpoint para obtener todos los usuarios
    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsuarios() {
        try {
            List<Usuario> usuarios = repositoryUsuario.getAllUsuarios();
            return ResponseEntity.ok(usuarios);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);  // Puedes manejar el error con el mensaje que necesites
        }
    }

    // Endpoint para obtener un usuario por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long id) {
        try {
            Usuario usuario = repositoryUsuario.getUsuarioById(id);
            if (usuario != null) {
                return ResponseEntity.ok(usuario);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // Endpoint para insertar un nuevo usuario
    @PostMapping
    public ResponseEntity<Usuario> insertUsuario(@RequestBody Usuario usuario) {
        try {
            repositoryUsuario.insertUsuario(usuario);
            return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);  // Puedes manejar el error con el mensaje que necesites
        }
    }

    // Endpoint para actualizar un usuario
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        try {
            usuario.setId(id);  // Asegurarse de que el ID del usuario es el que se quiere actualizar
            repositoryUsuario.updateUsuario(usuario);
            return ResponseEntity.status(HttpStatus.OK).body(usuario);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // Endpoint para eliminar un usuario
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
        try {
            repositoryUsuario.deleteUsuario(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
