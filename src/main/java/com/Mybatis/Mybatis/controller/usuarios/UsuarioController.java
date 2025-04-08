package com.Mybatis.Mybatis.controller.usuarios;

import com.Mybatis.Mybatis.module.entities.Usuario;
import com.Mybatis.Mybatis.module.repository.RepositoryUsuario;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    // Inyectamos el repository
    private final RepositoryUsuario repositoryUsuario;

    // Obtener todos los usuarios
    @GetMapping
    public List<Usuario> getAllUsuarios() {
        return repositoryUsuario.getAllUsuarios();
    }

    // Obtener usuario por ID
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable long id) {  // Cambiado a long
        Usuario usuario = repositoryUsuario.getUsuarioById(id);
        return usuario != null ? ResponseEntity.ok(usuario) : ResponseEntity.notFound().build();
    }

    // Insertar nuevo usuario
    @PostMapping
    public ResponseEntity<?> insertUsuario(@RequestBody Usuario usuario) {
        try {
            repositoryUsuario.insertUsuario(usuario);
            return ResponseEntity.ok(usuario);  // Retorna el usuario con ID actualizado
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al insertar el usuario: " + e.getMessage());
        }
    }

    // Actualizar usuario
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUsuario(@PathVariable long id, @RequestBody Usuario usuario) {
        try {
            usuario.setId(id);
            repositoryUsuario.updateUsuario(usuario);
            return ResponseEntity.ok(usuario);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar el usuario: " + e.getMessage());
        }
    }


    // Eliminar usuario
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUsuario(@PathVariable long id) {
        try {
            repositoryUsuario.deleteUsuarioById(id);
            return ResponseEntity.ok().body("Usuario eliminado exitosamente.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar el usuario: " + e.getMessage());
        }
    }
}

