package com.Mybatis.Mybatis.controller.usuarios;

import com.Mybatis.Mybatis.module.entities.Usuario;
import com.Mybatis.Mybatis.module.repository.RepositoryUsuario;
import lombok.RequiredArgsConstructor;
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
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable int id) {
        Usuario usuario = repositoryUsuario.getUsuarioById(id);
        return usuario != null ? ResponseEntity.ok(usuario) : ResponseEntity.notFound().build();
    }

    // Insertar nuevo usuario
    @PostMapping
    public ResponseEntity<String> insertUsuario(@RequestBody Usuario usuario) {
        repositoryUsuario.insertUsuario(usuario);
        return ResponseEntity.ok("Usuario creado exitosamente.");
    }

    // Actualizar usuario
    @PutMapping("/{id}")
    public ResponseEntity<String> updateUsuario(@PathVariable int id, @RequestBody Usuario usuario) {
        usuario.setId(id); // Aseguramos que el ID sea el correcto
        repositoryUsuario.updateUsuario(usuario);
        return ResponseEntity.ok("Usuario actualizado exitosamente.");
    }

    // Eliminar usuario
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUsuario(@PathVariable int id) {
        repositoryUsuario.deleteUsuarioById(id);
        return ResponseEntity.ok("Usuario eliminado exitosamente.");
    }
}
