package com.Mybatis.Mybatis.module.dao;

import com.Mybatis.Mybatis.module.entities.Usuario;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@Mapper
public interface UsuarioService {

    // Definir el SQL para insertar un nuevo usuario
    final String insertUsuario = "INSERT INTO USUARIOS (USUARIO, id_perfil, nom_usuario, ap_usuario, am_usuario, extencion, oficina, secret, estatus, last_con, last_secret_change, secret_change, secret_policy) " +
            "VALUES (#{usuario}, #{idPerfil}, #{nomUsuario}, #{apUsuario}, #{amUsuario}, #{extension}, #{oficina}, #{secret}, #{estatus}, #{lastCon}, #{lastSecretChange}, #{secretChange}, #{secretPolicy})";

    // Definir el SQL para obtener todos los usuarios
    final String selectAllUsuariosQ = "SELECT id, usuario, id_perfil, nom_usuario, ap_usuario, am_usuario, extencion, oficina, secret, estatus FROM USUARIOS";

    // Definir el SQL para obtener un usuario por ID
    final String selectUsuarioByIdQ = "SELECT id, usuario, id_perfil, nom_usuario, ap_usuario, am_usuario, extencion, oficina, secret, estatus FROM USUARIOS WHERE id = #{id}";

    // Definir el SQL para actualizar un usuario
    final String updateUsuarioQ = "UPDATE USUARIOS SET usuario = #{usuario}, id_perfil = #{idPerfil}, nom_usuario = #{nomUsuario}, " +
            "ap_usuario = #{apUsuario}, am_usuario = #{amUsuario}, extencion = #{extension}, oficina = #{oficina}, secret = #{secret}, " +
            "estatus = #{estatus}, last_con = #{lastCon}, last_secret_change = #{lastSecretChange}, secret_change = #{secretChange}, secret_policy = #{secretPolicy} WHERE id = #{id}";


    // Definir el SQL para eliminar un usuario por ID
    final String deleteUsuarioByIdQ = "DELETE FROM USUARIOS WHERE id = #{id}";

    // Mapeamos el resultado para los usuarios
    @Results(id = "UsuarioMap", value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "usuario", column = "usuario"),
            @Result(property = "idPerfil", column = "id_perfil"),
            @Result(property = "nomUsuario", column = "nom_usuario"),
            @Result(property = "apUsuario", column = "ap_usuario"),
            @Result(property = "amUsuario", column = "am_usuario"),
            @Result(property = "extension", column = "extension"),
            @Result(property = "oficina", column = "oficina"),
            @Result(property = "secret", column = "secret"),
            @Result(property = "estatus", column = "estatus"),
            @Result(property = "lastCon", column = "last_con"),
            @Result(property = "lastSecretChange", column = "last_secret_change"),
            @Result(property = "secretChange", column = "secret_change"),
            @Result(property = "secretPolicy", column = "secret_policy")
    })


    // Obtener todos los usuarios
    @Select(selectAllUsuariosQ)
    List<Usuario> getAllUsuarios();

    // Obtener un usuario por su ID
    @ResultMap("UsuarioMap")
    @Select(selectUsuarioByIdQ)
    Usuario getUsuarioById(@Param("id") long id);

    // Insertar un nuevo usuario
    @Insert(insertUsuario)
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void insertUsuario(Usuario usuario);

    // Actualizar un usuario
    @Update(updateUsuarioQ)
    void updateUsuario(Usuario usuario);

    // Eliminar un usuario por ID
    @Delete(deleteUsuarioByIdQ)
    void deleteUsuarioById(@Param("id") long id);
}
