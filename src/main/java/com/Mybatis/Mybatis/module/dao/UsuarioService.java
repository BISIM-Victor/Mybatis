package com.Mybatis.Mybatis.module.dao;

import com.Mybatis.Mybatis.module.entities.Usuario;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@Mapper
public interface UsuarioService {

    // SQL para insertar un nuevo usuario
    final String insertUsuario = "INSERT INTO USUARIOS (USUARIO, id_perfil, nom_usuario, ap_usuario, am_usuario, extencion, oficina, secret, estatus, LAST_CON, LAST_SECRET_CHANGE, secret_change, secret_policy) " +
            "VALUES (#{usuario}, #{idPerfil}, #{nomUsuario}, #{apUsuario}, #{amUsuario}, #{extencion}, #{oficina}, #{secret}, #{estatus}, #{lastCon}, #{lastSecretChange}, #{secretChange}, #{secretPolicy})";

    // SQL para obtener todos los usuarios
    final String selectAllUsuariosQ = "SELECT id, usuario, id_perfil, nom_usuario, ap_usuario, am_usuario, extencion, oficina, secret, estatus, LAST_CON, LAST_SECRET_CHANGE, secret_change, secret_policy FROM USUARIOS";

    // Mapeo del resultado
    @Results(id = "UsuarioMap", value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "usuario", column = "usuario"),
            @Result(property = "idPerfil", column = "id_perfil"),
            @Result(property = "nomUsuario", column = "nom_usuario"),
            @Result(property = "apUsuario", column = "ap_usuario"),
            @Result(property = "amUsuario", column = "am_usuario"),
            @Result(property = "extencion", column = "extencion"),
            @Result(property = "oficina", column = "oficina"),
            @Result(property = "secret", column = "secret"),
            @Result(property = "estatus", column = "estatus"),
            @Result(property = "lastCon", column = "last_con"),
            @Result(property = "lastSecretChange", column = "last_secret_change"),
            @Result(property = "secretChange", column = "secret_change"),
            @Result(property = "secretPolicy", column = "secret_policy")
    })

    // Métodos del Mapper
    @Select(selectAllUsuariosQ)
    List<Usuario> getAllUsuarios();

    @Select("SELECT id, usuario, id_perfil, nom_usuario, ap_usuario, am_usuario, extencion, oficina, secret, estatus, LAST_CON, LAST_SECRET_CHANGE, secret_change, secret_policy FROM USUARIOS WHERE id = #{id}")
    Usuario getUsuarioById(@Param("id") long id);

    @Insert(insertUsuario)
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id") // Generar el id automáticamente
    void insertUsuario(Usuario usuario);

    @Update("UPDATE USUARIOS SET usuario = #{usuario}, id_perfil = #{idPerfil}, nom_usuario = #{nomUsuario}, ap_usuario = #{apUsuario}, am_usuario = #{amUsuario}, extencion = #{extencion}, oficina = #{oficina}, secret = #{secret}, estatus = #{estatus}, LAST_CON = #{lastCon}, LAST_SECRET_CHANGE = #{lastSecretChange}, secret_change = #{secretChange}, secret_policy = #{secretPolicy} WHERE id = #{id}")
    void updateUsuario(Usuario usuario);

    @Delete("DELETE FROM USUARIOS WHERE id = #{id}")
    void deleteUsuarioById(@Param("id") long id);
}

