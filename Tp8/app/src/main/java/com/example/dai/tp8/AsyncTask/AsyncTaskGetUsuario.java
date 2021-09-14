package com.example.dai.tp8.AsyncTask;

import com.example.ProyectoFinal.loangrounds.Model.Usuario;
import com.example.ProyectoFinal.loangrounds.Utilidades.ApiHelper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class AsyncTaskGetUsuario extends AsyncTaskBase{
    private static Usuario usuario;

    private AsyncTaskGetUsuario(int id) {
        super(ApiHelper.devolverUrlParaGet("Usuarios", "traerPorid",String.valueOf(id)));
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if(!s.equals("")){
            Gson migson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                    .create();
            usuario = migson.fromJson(s,Usuario.class);
        }
    }

    public static Usuario devolerUsuario(int id){
        AsyncTaskGetUsuario tarea = new AsyncTaskGetUsuario(id);
        tarea.execute();
        return usuario;
    }
}




