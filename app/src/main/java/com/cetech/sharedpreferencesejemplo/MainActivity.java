package com.cetech.sharedpreferencesejemplo;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnColorAzul,btnColorRojo,btnColorVerde,BtnColorNaranja,btnReset,btnContador;
    TextView Midisplay;
    SharedPreferences preferences;
    String colorDisplay;
    int contador=0;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnColorAzul=findViewById(R.id.btnColorAzul);
        btnColorAzul.setOnClickListener(this);

        btnColorRojo=findViewById(R.id.btnColorRojo);
        btnColorRojo.setOnClickListener(this);

        btnColorVerde=findViewById(R.id.btnColorVerde);
        btnColorVerde.setOnClickListener(this);

        BtnColorNaranja=findViewById(R.id.btnColorNaranja);
        BtnColorNaranja.setOnClickListener(this);


        btnReset=findViewById(R.id.btnResetear);
        btnReset.setOnClickListener(this);

        btnContador=findViewById(R.id.btnContador);
        btnContador.setOnClickListener(this);


        Midisplay=findViewById(R.id.display);

        preferences=getSharedPreferences("MisPreferencias",MODE_PRIVATE);

        colorDisplay=preferences.getString("color","#dedcdc");
        Midisplay.setBackgroundColor(Color.parseColor(colorDisplay));

        contador=preferences.getInt("contador",0);
        Midisplay.setText(String.valueOf(contador));




    }

    @Override
    public void onClick (View view) {
        switch (view.getId()){

            case R.id.btnColorAzul:


                Midisplay.setBackgroundColor(Color.parseColor("#49d3f5"));

                //Almacenando valores con sharedpeferences

                SharedPreferences.Editor insertarAzul=preferences.edit();
                insertarAzul.putString("color","#49d3f5");
                insertarAzul.commit();


                break;
            case R.id.btnColorRojo:
                Midisplay.setBackgroundColor(Color.parseColor("#ef3759"));
                SharedPreferences.Editor insertarRojo=preferences.edit();
                insertarRojo.putString("color","#ef3759");
                insertarRojo.commit();


                break;

            case R.id.btnColorVerde:
                Midisplay.setBackgroundColor(Color.parseColor("#79e44b"));
                SharedPreferences.Editor insertarVerde=preferences.edit();
                insertarVerde.putString("color","#79e44b");
                insertarVerde.commit();


                break;

            case R.id.btnColorNaranja:
                Midisplay.setBackgroundColor(Color.parseColor("#f58b49"));
                SharedPreferences.Editor insertarNaanja=preferences.edit();
                insertarNaanja.putString("color","#f58b49");
                insertarNaanja.commit();


                break;

            case R.id.btnContador:

                contador++;
                Midisplay.setText(String.valueOf(contador));

                SharedPreferences.Editor insertarContador=preferences.edit();
                insertarContador.putInt("contador",contador);
                insertarContador.commit();
                break;

            case R.id.btnResetear:
                SharedPreferences.Editor resetear=preferences.edit();
                resetear.clear().commit();

                contador=0;
                Midisplay.setText(String.valueOf(contador));
                Midisplay.setBackgroundColor(Color.parseColor("#dedcdc"));
                break;

                default:
                    break;

        }


    }
}
