package com.Mybatis.Mybatis.module.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Usuario {

    @JsonProperty("id")
    private int id;

    private String nombre;
    private String correo;
    private String telefono;
    private String usuario;
    private String contrasena;
    private String estatus;
}
