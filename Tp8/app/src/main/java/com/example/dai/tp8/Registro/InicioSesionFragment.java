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
import com.example.dai.tp8.AsyncTask.AsyncTaskBase;
import com.example.dai.tp8.MainActivity;
import com.example.dai.tp8.Usuario;
import com.example.dai.tp8.R;
import com.example.dai.tp8.Utilidades.ApiHelper;
import com.example.dai.tp8.Utilidades.Session;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class InicioSesionFragment extends Fragment {

    View layoutRhoot;
    Button btnIn;
    EditText edtEmail;
    EditText edtPassword;
  /*  ProgressBar pgCargando2;
    ConstraintLayout clInicionSesion;*/

    public InicioSesionFragment() {
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
        layoutRhoot = inflater.inflate(R.layout.fragment_inicio_sesion, container, false);
        ObtenerReferencias();
        SetearListners();
        return layoutRhoot;
    }

    View.OnClickListener btnIn_Click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String mail = edtEmail.getText().toString().trim();
            String clave = edtPassword.getText().toString().trim();
            if(mail.equals("") || clave.equals("")){
                Toast.makeText(getContext(),"Por favor completa con mail y contraseña",Toast.LENGTH_SHORT).show();

            }
            else{
                /*clInicionSesion.setVisibility(View.GONE);
                pgCargando2.setVisibility(View.VISIBLE);*/
                Login login = new Login(mail,clave);
                login.execute();

            }


        }
    };


    public void SetearListners() {
        btnIn.setOnClickListener(btnIn_Click);

    }

    private void ObtenerReferencias() {
        btnIn = (Button) layoutRhoot.findViewById(R.id.btnIn);
        edtEmail = (EditText) layoutRhoot.findViewById(R.id.edtNombreUsuario);
        edtPassword = (EditText) layoutRhoot.findViewById(R.id.edtApellido);
        /*pgCargando2=(ProgressBar) layoutRhoot.findViewById(R.id.pgCargando2);
        clInicionSesion=(ConstraintLayout) layoutRhoot.findViewById(R.id.clInicioSesion);*/
    }




    public class Login extends AsyncTaskBase  {
        super(ApiHelper.devolverUrlParaGet("Prestamos","recomendados",String.valueOf(montoMax)));
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        toastes.msj(getContext(),"Cargando por favor espero...");
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if (s!=null){
            Gson miGson = new Gson();
            resultado = miGson.fromJson(s,PrestamoRecomendadoDTO[].class);
            ListaAdaptora nuevoAdapter = new ListaAdaptora(getActivity(),R.layout.my_list_item_listview, Arrays.asList(resultado.clone()));
            listView.setAdapter(nuevoAdapter);

        }

        pgCargando.setVisibility(View.GONE);
        clMenu.setVisibility(View.VISIBLE);


    }
}




public class Login extends AsyncTaskBase {

        public Login(){
            super(RequestMethods.POST,ApiHelper.devolverUrlParaGet("Usuarios","login"));
            this.mail = mail;
            this.password = password;
        }
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            this.setParams("Mail",mail);
            this.setParams("Password",password);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if(s.equals("")){/*pgCargando2.setVisibility(View.INVISIBLE) ;clInicionSesion.setVisibility(View.VISIBLE);*/ Toast.makeText(getContext(),"Usuario o contraseña incorrectas ",Toast.LENGTH_SHORT).show();
            } else {
                Gson miGson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                    .create();
                Session.currentUser = miGson.fromJson(s,Usuario.class);

                MainActivity actividadContenedora;
                actividadContenedora = (MainActivity) getActivity();
                actividadContenedora.cambioActivity();
            }


        }

    }
}

