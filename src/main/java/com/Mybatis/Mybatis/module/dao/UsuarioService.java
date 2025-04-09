package com.Mybatis.Mybatis.module.dao;

import com.Mybatis.Mybatis.module.entities.Usuario;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Mapper
public interface UsuarioService {

        String getAllUsuarios = "SELECT " +
                "ID, USUARIO, id_perfil, nom_usuario, ap_usuario, am_usuario, extencion, oficina, secret, estatus, " +
                "LAST_CON, LAST_SECRET_CHANGE, secret_change, secret_policy " +
                "FROM usuarios";

        String insertUsuario = "INSERT INTO usuarios (USUARIO, id_perfil, nom_usuario, ap_usuario, am_usuario, extencion, oficina, secret, estatus, LAST_CON, LAST_SECRET_CHANGE, secret_change, secret_policy) " +
                "VALUES (#{usuario.usuario}, #{usuario.idPerfil}, #{usuario.nomUsuario}, #{usuario.apUsuario}, #{usuario.amUsuario}, #{usuario.extencion}, #{usuario.oficina}, " +
                "#{usuario.secret}, #{usuario.estatus}, #{usuario.lastCon}, #{usuario.lastSecretChange}, #{usuario.secretChange}, #{usuario.secretPolicy})";

        String updateUsuario = "UPDATE usuarios SET " +
                "USUARIO = #{usuario.usuario}, id_perfil = #{usuario.idPerfil}, nom_usuario = #{usuario.nomUsuario}, " +
                "ap_usuario = #{usuario.apUsuario}, am_usuario = #{usuario.amUsuario}, extencion = #{usuario.extencion}, " +
                "oficina = #{usuario.oficina}, secret = #{usuario.secret}, estatus = #{usuario.estatus}, " +
                "LAST_CON = #{usuario.lastCon}, LAST_SECRET_CHANGE = #{usuario.lastSecretChange}, " +
                "secret_change = #{usuario.secretChange}, secret_policy = #{usuario.secretPolicy} " +
                "WHERE ID = #{usuario.id}";

        String deleteUsuario = "DELETE FROM usuarios WHERE ID = #{id}";

        String getUsuarioById = "SELECT " +
                "ID, USUARIO, id_perfil, nom_usuario, ap_usuario, am_usuario, extencion, oficina, secret, estatus, " +
                "LAST_CON, LAST_SECRET_CHANGE, secret_change, secret_policy " +
                "FROM usuarios WHERE ID = #{id}";

        // RESULT MAP GLOBAL
        @Select(getAllUsuarios)
        @Results({
                @Result(property = "id", column = "ID", id = true),
                @Result(property = "usuario", column = "USUARIO"),
                @Result(property = "idPerfil", column = "id_perfil"),
                @Result(property = "nomUsuario", column = "nom_usuario"),
                @Result(property = "apUsuario", column = "ap_usuario"),
                @Result(property = "amUsuario", column = "am_usuario"),
                @Result(property = "extencion", column = "extencion"),
                @Result(property = "oficina", column = "oficina"),
                @Result(property = "secret", column = "secret"),
                @Result(property = "estatus", column = "estatus"),
                @Result(property = "lastCon", column = "LAST_CON"),
                @Result(property = "lastSecretChange", column = "LAST_SECRET_CHANGE"),
                @Result(property = "secretChange", column = "secret_change"),
                @Result(property = "secretPolicy", column = "secret_policy")
        })
        List<Usuario> getAllUsuarios();

        @Insert(insertUsuario)
        @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "ID")
        void insertUsuario(@Param("usuario") Usuario usuario);

        @Update(updateUsuario)
        void updateUsuario(@Param("usuario") Usuario usuario);

        @Delete(deleteUsuario)
        void deleteUsuario(@Param("id") Long id);

        @Select(getUsuarioById)
        @Results({
                @Result(property = "id", column = "ID", id = true),
                @Result(property = "usuario", column = "USUARIO"),
                @Result(property = "idPerfil", column = "id_perfil"),
                @Result(property = "nomUsuario", column = "nom_usuario"),
                @Result(property = "apUsuario", column = "ap_usuario"),
                @Result(property = "amUsuario", column = "am_usuario"),
                @Result(property = "extencion", column = "extencion"),
                @Result(property = "oficina", column = "oficina"),
                @Result(property = "secret", column = "secret"),
                @Result(property = "estatus", column = "estatus"),
                @Result(property = "lastCon", column = "LAST_CON"),
                @Result(property = "lastSecretChange", column = "LAST_SECRET_CHANGE"),
                @Result(property = "secretChange", column = "secret_change"),
                @Result(property = "secretPolicy", column = "secret_policy")
        })
        Usuario getUsuarioById(@Param("id") Long id);
}
//@Component
//@Mapper
//public interface UsuarioService {
//
//        String getAllUsuarios = "SELECT " +
//                "ID, USUARIO, id_perfil, nom_usuario, ap_usuario, am_usuario, extencion, oficina, secret, estatus, " +
//                "LAST_CON, LAST_SECRET_CHANGE, secret_change, secret_policy " +
//                "FROM usuarios";
//
//        String insertUsuario = "INSERT INTO usuarios (USUARIO, id_perfil, nom_usuario, ap_usuario, am_usuario, extencion, oficina, secret, estatus, LAST_CON, LAST_SECRET_CHANGE, secret_change, secret_policy) " +
//                "VALUES (#{usuario.usuario}, #{usuario.idPerfil}, #{usuario.nomUsuario}, #{usuario.apUsuario}, #{usuario.amUsuario}, #{usuario.extencion}, #{usuario.oficina}, " +
//                "#{usuario.secret}, #{usuario.estatus}, #{usuario.lastCon}, #{usuario.lastSecretChange}, #{usuario.secretChange}, #{usuario.secretPolicy})";
//
//        String updateUsuario = "UPDATE usuarios SET " +
//                "USUARIO = #{usuario.usuario}, id_perfil = #{usuario.idPerfil}, nom_usuario = #{usuario.nomUsuario}, " +
//                "ap_usuario = #{usuario.apUsuario}, am_usuario = #{usuario.amUsuario}, extencion = #{usuario.extencion}, " +
//                "oficina = #{usuario.oficina}, secret = #{usuario.secret}, estatus = #{usuario.estatus}, " +
//                "LAST_CON = #{usuario.lastCon}, LAST_SECRET_CHANGE = #{usuario.lastSecretChange}, " +
//                "secret_change = #{usuario.secretChange}, secret_policy = #{usuario.secretPolicy} " +
//                "WHERE ID = #{usuario.id}";
//
//        String deleteUsuario = "DELETE FROM usuarios WHERE ID = #{id}";
//
//        // Buscar un usuario por ID
//        String getUsuarioById = "SELECT " +
//                "ID, USUARIO, id_perfil, nom_usuario, ap_usuario, am_usuario, extencion, oficina, secret, estatus, " +
//                "LAST_CON, LAST_SECRET_CHANGE, secret_change, secret_policy " +
//                "FROM usuarios WHERE ID = #{id}";
//
//        // Seleccionar todos los usuarios
//        @Results(id = "UserMapUnique", value = {
//                @Result(property = "id", column = "ID", id = true),
//                @Result(property = "usuario", column = "USUARIO"),
//                @Result(property = "idPerfil", column = "id_perfil"),
//                @Result(property = "nomUsuario", column = "nom_usuario"),
//                @Result(property = "apUsuario", column = "ap_usuario"),
//                @Result(property = "amUsuario", column = "am_usuario"),
//                @Result(property = "extencion", column = "extencion"),
//                @Result(property = "oficina", column = "oficina"),
//                @Result(property = "secret", column = "secret"),
//                @Result(property = "estatus", column = "estatus"),
//                @Result(property = "lastCon", column = "LAST_CON"),
//                @Result(property = "lastSecretChange", column = "LAST_SECRET_CHANGE"),
//                @Result(property = "secretChange", column = "secret_change"),
//                @Result(property = "secretPolicy", column = "secret_policy")
//        })
//
//        @Select(getAllUsuarios)
//        List<Usuario> getAllUsuarios();
//
//        // Insertar un nuevo usuario
//        @Insert(insertUsuario)
//        @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "ID")
//        void insertUsuario(@Param("usuario") Usuario usuario);
//
//        // Actualizar un usuario
//        @Update(updateUsuario)
//        void updateUsuario(@Param("usuario") Usuario usuario);
//
//        // Eliminar un usuario por ID
//        @Delete(deleteUsuario)
//        void deleteUsuario(@Param("id") Long id);
//
//        // Buscar un usuario por ID
//        @Results(id = "UserMap", value = {
//                @Result(property = "id", column = "ID", id = true),
//                @Result(property = "usuario", column = "USUARIO"),
//                @Result(property = "idPerfil", column = "id_perfil"),
//                @Result(property = "nomUsuario", column = "nom_usuario"),
//                @Result(property = "apUsuario", column = "ap_usuario"),
//                @Result(property = "amUsuario", column = "am_usuario"),
//                @Result(property = "extencion", column = "extencion"),
//                @Result(property = "oficina", column = "oficina"),
//                @Result(property = "secret", column = "secret"),
//                @Result(property = "estatus", column = "estatus"),
//                @Result(property = "lastCon", column = "LAST_CON"),
//                @Result(property = "lastSecretChange", column = "LAST_SECRET_CHANGE"),
//                @Result(property = "secretChange", column = "secret_change"),
//                @Result(property = "secretPolicy", column = "secret_policy")
//        })
//        @Select(getUsuarioById)
//        Usuario getUsuarioById(@Param("id") Long id);
//}

