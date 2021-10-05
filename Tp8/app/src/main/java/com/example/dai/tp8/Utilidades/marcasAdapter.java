package com.example.dai.tp8.Utilidades;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.dai.tp8.Marcas;
import com.example.dai.tp8.R;


import java.util.ArrayList;
import java.util.List;


public class marcasAdapter extends ArrayAdapter<Marcas> {



        List<Marcas> listaMarcas;
        Context mCtx;
        private int resource;


        public marcasAdapter(Context mCtx, int resource, List<Marcas> listaMarcas){
            super(mCtx,resource,listaMarcas);
            this.mCtx=mCtx;
            this.resource=resource;
            this.listaMarcas=listaMarcas;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflater=LayoutInflater.from(mCtx) ;
            View view=inflater.inflate(resource,null);
            TextView tvNombreMarca=view.findViewById(R.id.tvNombreMarca);







            Marcas marcas=listaMarcas.get(position);
            tvNombreMarca.setText(marcas.getNombre());




            return view;
        }



    }


