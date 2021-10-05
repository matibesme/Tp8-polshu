package com.example.dai.tp8.Registro;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dai.tp8.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InsertarFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InsertarFragment extends Fragment {


    public InsertarFragment() {
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
        return inflater.inflate(R.layout.fragment_insertar, container, false);
    }
}