package com.example.dai.tp8.Registro;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

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
import com.example.dai.tp8.Utilidades.Session;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;


public class MenuFragment extends Fragment {


    ListView listView;
    View layoutRhoot;
    ArrayList<Marcas> prestamoList;
    ArrayList<Marcas> prestamoListApi=new ArrayList<>();
    Marcas[] resultado;

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
        return layoutRhoot;
    }

    public void SetearListners() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Marcas pestamoSolici = resultado[position] ;


                MainActivity actividadContenedora;
                actividadContenedora = (MainActivity) getActivity();



            }
        });

        class MarcasAsinc extends AsyncTaskBase {


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
                if (s!=null){
                    Gson miGson = new Gson();
                    resultado = miGson.fromJson(s,Marcas[].class);
                    ListAdapter nuevoAdapter = new ArrayAdapter<Marcas>(getActivity(),android.R.layout.simple_list_item_1, Arrays.asList(resultado.clone()));
                    listView.setAdapter(nuevoAdapter);

                }




            }
        }


        private void ObtenerReferencia() {
        listView = (ListView) layoutRhoot.findViewById(R.id.listView);
        }

    }
}