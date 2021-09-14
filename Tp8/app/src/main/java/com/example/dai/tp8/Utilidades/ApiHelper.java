package com.example.dai.tp8.Utilidades;

public class ApiHelper {
    public static String host = "10.0.2.2";
    public static String port = "54035";
    public static String urlBase = String.format("http://%s:%s/",host,port);
    public static String devolverUrlParaGet(String controller, String clase, String accion,String params){
        String urlFinal = urlBase;
        if(params.equals("") && clase.equals("")){
              urlFinal += String.format("%s/%s",controller,accion);
        }
            else if(params.equals("")){
                urlFinal += String.format("%s/%s/%s",controller,clase,accion);
            }
        else if(clase.equals("")){
            urlFinal += String.format("%s/%s/%s",controller,accion,params);
        }
        else{
            urlFinal += String.format("%s/%s/%s/%s",controller,clase,accion,params);
        }
        return urlFinal;



    }
    public static String devolverUrlParaGet(String controller,String accion,String params){
        return devolverUrlParaGet(controller,"",accion,params);
    }
    public static String devolverUrlParaGet(String controller,String accion){
        return devolverUrlParaGet(controller,accion,"");
    }
    public static String devolverUrlParaGetconClase(String controller,String clase, String accion){
        return devolverUrlParaGet(controller,clase,accion,"");
    }

    }

