package com.Mybatis.Mybatis.module.entities;

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
    private Timestamp lastCon;
    private Timestamp lastSecretChange;
    private Integer secretChange;
    private Integer secretPolicy;
}

