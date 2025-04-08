package com.Mybatis.Mybatis.module.dao;

import com.Mybatis.Mybatis.module.entities.Usuario;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface UsuarioService {

    // Definimos el SQL para insertar un nuevo usuario
    final String insertUsuario = "INSERT INTO USUARIOS (NOMBRE, CORREO, TELEFONO, USUARIO, CONTRASENA, ESTATUS) " +
            "VALUES (#{nombre}, #{correo}, #{telefono}, #{usuario}, #{contrasena}, #{estatus})";

    // Definimos el SQL para obtener todos los usuarios
    final String selectAllUsuariosQ = "SELECT id, nombre, correo, telefono, usuario, contrasena, estatus FROM USUARIOS";

    // Definimos el SQL para obtener un usuario por ID
    final String selectUsuarioByIdQ = "SELECT id, nombre, correo, telefono, usuario, contrasena, estatus FROM USUARIOS WHERE id = #{id}";

    // Definimos el SQL para actualizar un usuario
    final String updateUsuarioQ = "UPDATE USUARIOS SET nombre = #{nombre}, correo = #{correo}, telefono = #{telefono}, " +
            "usuario = #{usuario}, contrasena = #{contrasena}, estatus = #{estatus} WHERE id = #{id}";

    // Definimos el SQL para eliminar un usuario por ID
    final String deleteUsuarioByIdQ = "DELETE FROM USUARIOS WHERE id = #{id}";

    // Mapeamos el resultado para los usuarios
    @Results(id = "UsuarioMap", value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "nombre", column = "nombre"),
            @Result(property = "correo", column = "correo"),
            @Result(property = "telefono", column = "telefono"),
            @Result(property = "usuario", column = "usuario"),
            @Result(property = "contrasena", column = "contrasena"),
            @Result(property = "estatus", column = "estatus")
    })

    // Obtener todos los usuarios
    @Select(selectAllUsuariosQ)
    List<Usuario> getAllUsuarios();

    // Obtener un usuario por su ID
    @ResultMap("UsuarioMap")
    @Select(selectUsuarioByIdQ)
    Usuario getUsuarioById(@Param("id") int id);

    // Insertar un nuevo usuario
    @Insert(insertUsuario)
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void insertUsuario(Usuario usuario);

    // Actualizar un usuario
    @Update(updateUsuarioQ)
    void updateUsuario(Usuario usuario);

    // Eliminar un usuario por ID
    @Delete(deleteUsuarioByIdQ)
    void deleteUsuarioById(@Param("id") int id);
}
