package com.Mybatis.Mybatis.module.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
@Data
@NoArgsConstructor
public class Usuario {

    @JsonProperty("id")
    private long id;

    private String usuario;
    private long idPerfil;
    private String nomUsuario;
    private String apUsuario;
    private String amUsuario;
    private String extension;
    private String oficina;
    private String secret;
    private Integer estatus;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ")
    private Timestamp lastCon;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ")
    private Timestamp lastSecretChange;
    private Integer secretChange;
    private Integer secretPolicy;
}

