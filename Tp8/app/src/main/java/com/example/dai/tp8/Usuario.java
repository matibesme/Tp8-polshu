package com.example.dai.tp8;

import androidx.annotation.NonNull;

import java.sql.Date;

public class Usuario {


    private String TokenExpiresDate, Nombre, Apellido,TokenKey;
    private int id;


    public Usuario(String tokenExpiresDate, int id, String nombre, String apellido, String tokenKey) {
        TokenExpiresDate = tokenExpiresDate;
        TokenKey = tokenKey;
        Nombre = nombre;
        Apellido = apellido;




    }


    public String getNombre() {
        return Nombre;
    }
    public String getApellido() {
        return Apellido;
    }

    public String getTokenKey() {
        return TokenKey;
    }


}
