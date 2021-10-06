package com.example.dai.tp8.Registro;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dai.tp8.AsyncTask.AsyncPostBase;
import com.example.dai.tp8.MainActivity;
import com.example.dai.tp8.Marcas;
import com.example.dai.tp8.R;
import com.example.dai.tp8.Usuario;
import com.example.dai.tp8.Utilidades.ApiHelper;
import com.example.dai.tp8.Utilidades.Session;
import com.google.gson.Gson;


public class InsertarFragment extends Fragment {

    Button btnInsertar;
    EditText edtNombreNuevaMarca;
    String marca;
    View layoutRhoot;


    public InsertarFragment() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        layoutRhoot = inflater.inflate(R.layout.fragment_insertar, container, false);
        ObtenerReferencias();
        SetearListners();
        return layoutRhoot;


    }



    private void ObtenerReferencias() {
        btnInsertar = (Button) layoutRhoot.findViewById(R.id.btnInsertar);
        edtNombreNuevaMarca = (EditText) layoutRhoot.findViewById(R.id.edtNombreNuevaMarca);

        /*pgCargando2=(ProgressBar) layoutRhoot.findViewById(R.id.pgCargando2);
        clInicionSesion=(ConstraintLayout) layoutRhoot.findViewById(R.id.clInicioSesion);*/
    }


    public void SetearListners() {
        btnInsertar.setOnClickListener(btnInsertar_Click);

    }


    View.OnClickListener btnInsertar_Click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
             marca = edtNombreNuevaMarca.getText().toString().trim();
            if(marca.equals("") ){
                Toast.makeText(getContext(),"Por favor completa el campo",Toast.LENGTH_SHORT).show();

            }
            else{
                /*clInicionSesion.setVisibility(View.GONE);
                pgCargando2.setVisibility(View.VISIBLE);*/
                insertar insertar = new insertar(marca);
                insertar.execute();



            }


        }
    };


    private class insertar extends AsyncPostBase{
        public  insertar(String marca){
            super(RequestMethods.POST,"http://api.polshu.com.ar/api/v1/tablas/marcas/");


        }
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            setParams(marca);

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);


            //Gson miGson = new Gson();

            //Session.currentUser = miGson.fromJson(s, Usuario.class);

            //CustomLog.logObject(Session.currentUser);

                MainActivity actividadContenedora;
                actividadContenedora = (MainActivity) getActivity();

                actividadContenedora.setFragmentMenu();






        }
    }
}

