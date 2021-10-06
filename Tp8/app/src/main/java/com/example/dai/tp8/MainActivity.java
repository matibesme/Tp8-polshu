package com.example.dai.tp8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.dai.tp8.Registro.InicioSesionFragment;
import com.example.dai.tp8.Registro.InsertarFragment;
import com.example.dai.tp8.Registro.MenuFragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {



    InicioSesionFragment fragmentInicioSesion;
    MenuFragment fragmentMenu;
    InsertarFragment fragmentInsertar;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        crearFragments();
        reemplazarFragments(fragmentInicioSesion,false);

    }




    public void reemplazarFragments(Fragment fragmento){
        reemplazarFragments(fragmento,true);
    }

    public void reemplazarFragments(Fragment fragmento, Boolean blnAddToBackStack){
        FragmentManager manager= getSupportFragmentManager();
        FragmentTransaction transision = manager.beginTransaction();

        transision.replace(R.id.frameLayout1, fragmento, null );
        if(blnAddToBackStack){

            transision.addToBackStack(null);
        }
        transision.commit();

    }
    private void crearFragments() {
        fragmentInicioSesion = new InicioSesionFragment();
        fragmentMenu= new MenuFragment();
        fragmentInsertar= new InsertarFragment();


    }


    public  void setFragmentInicioSesion(){

        reemplazarFragments(fragmentInicioSesion);
    }


    public  void setFragmentMenu(){

        reemplazarFragments(fragmentMenu);
    }

    public  void setFragmentInsertar(){

        reemplazarFragments(fragmentInsertar);
    }






}