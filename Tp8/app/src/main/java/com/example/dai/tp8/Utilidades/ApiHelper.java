package com.example.dai.tp8.Utilidades;

public class ApiHelper {
    public static String urlBase = String.format("http://api.polshu.com.ar/api/v1/usuarios/login/");


    public static String devolverUrlParaGet(String userName, String clave){
        String urlFinal = urlBase;

        urlFinal += String.format("%s/%s",userName,clave);

        return urlFinal;



    }

    public static String devolverUrlMarcas(String tokenKey){
        String urlFinal = String.format("http://api.polshu.com.ar/api/v1/tablas/marcas/");;


        urlFinal += String.format("%s",tokenKey);

        return urlFinal;



    }



    }

