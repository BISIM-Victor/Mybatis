package com.Mybatis.Mybatis.module.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
@Data
@NoArgsConstructor
public class Usuario {

    private Long id;
    private String usuario;
    private Long idPerfil;
    private String nomUsuario;
    private String apUsuario;
    private String amUsuario;
    private String extencion;
    private String oficina;
    private String secret;
    private Integer estatus;
    private Timestamp lastCon;
    private Timestamp lastSecretChange;
    private Integer secretChange;
    private Integer secretPolicy;

}

