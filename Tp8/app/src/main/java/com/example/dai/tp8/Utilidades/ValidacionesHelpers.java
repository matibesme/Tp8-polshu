package com.example.dai.tp8.Utilidades;


import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.SeekBar;

import java.util.Random;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class ValidacionesHelpers {

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public  static final int maxCaracteres = 20000000;
    public static boolean esStringValido(String texto, int min, int max){
        boolean aux = false;
        if(texto.length()!=0 && texto.length()>=min && texto.length()<= max){
            aux = true;
        }
        return aux;
    }
    public static boolean esStringValido(String texto, int min){
        return esStringValido(texto,min,maxCaracteres);
    }

    public static boolean esNumeroValido(EditText e){
        return Integer.parseInt(e.getText().toString().trim()) > 0;
    }

    public static boolean esNumeroValido(SeekBar s){
        return s.getProgress() > 0;
    }

    public static boolean esStringValido(String texto){
        return esStringValido(texto,0);
    }

    public static boolean esStringValido(EditText edt_txt){
        String aux = edt_txt.getText().toString().trim();
        return esStringValido(aux);
    }

    public static int generarRandom(int min, int max){
        Random r = new Random();
        return r.nextInt(max-min) + min;
    }

    public static String convertMayus(EditText edt_txt){
        return edt_txt.getText().toString().trim().toUpperCase();
    }

    public static String convertMinus(EditText edt_txt){
        return edt_txt.getText().toString().trim().toLowerCase();
    }
    public static boolean validarMail(EditText mail) {
        String emailStr = mail.getText().toString().trim();
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }
    public static boolean esContraFuerte(EditText et){
        String contra = et.getText().toString().trim();
        if(!esStringValido(contra)) return false;
        return calculatePasswordStrength(contra) > 6; // abitrario
    }

    private static int calculatePasswordStrength(String password){

        //total score of password
        int iPasswordScore = 0;

        if( password.length() < 8 )
            return 0;
        else if( password.length() >= 10 )
            iPasswordScore += 2;
        else
            iPasswordScore += 1;

        //if it contains one digit, add 2 to total score
        if( password.matches("(?=.*[0-9]).*") )
            iPasswordScore += 2;

        //if it contains one lower case letter, add 2 to total score
        if( password.matches("(?=.*[a-z]).*") )
            iPasswordScore += 2;

        //if it contains one upper case letter, add 2 to total score
        if( password.matches("(?=.*[A-Z]).*") )
            iPasswordScore += 2;

        //if it contains one special character, add 2 to total score
        if( password.matches("(?=.*[~!@#$%^&*()_-]).*") )
            iPasswordScore += 2;

        return iPasswordScore;

    }

    public static boolean RG_check(RadioGroup rg){
        return rg.getCheckedRadioButtonId() != -1;
    }



}