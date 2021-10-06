package com.example.dai.tp8.Registro;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.dai.tp8.AsyncTask.AsyncTaskBase;
import com.example.dai.tp8.MainActivity;
import com.example.dai.tp8.Marcas;
import com.example.dai.tp8.R;
import com.example.dai.tp8.Utilidades.ApiHelper;
import com.example.dai.tp8.Utilidades.CustomLog;
import com.example.dai.tp8.Utilidades.Session;
import com.example.dai.tp8.Utilidades.marcasAdapter;
import com.google.gson.Gson;

import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;


public class MenuFragment extends Fragment {


    ListView listView;
    View layoutRhoot;
    ArrayList<Marcas> prestamoList;
    ArrayList<Marcas> prestamoListApi=new ArrayList<>();
    Marcas[] resultado;
    ArrayAdapter<Marcas> adapter;

    public MenuFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        layoutRhoot= inflater.inflate(R.layout.fragment_menu, container, false);
        listView = (ListView) layoutRhoot.findViewById(R.id.listView);
        MarcasAsinc marcasAsinc=new MarcasAsinc();
        marcasAsinc.execute();
        SetearListners();
        return layoutRhoot;
    }

    public void SetearListners() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Marcas pestamoSolici = resultado[position] ;

                MainActivity actividadContenedora;
                actividadContenedora = (MainActivity) getActivity();

                actividadContenedora.setFragmentInsertar();




            }
        });


        }

   private class MarcasAsinc extends AsyncTaskBase {


        public MarcasAsinc() {
            super(ApiHelper.devolverUrlMarcas(Session.currentUser.getTokenKey()));
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);



                Gson miGson = new Gson();
                resultado = miGson.fromJson(s,Marcas[].class);


               adapter = new marcasAdapter(getActivity(),R.layout.my_list_item, Arrays.asList(resultado.clone()));
                listView.setAdapter(adapter);






        }

    }}
