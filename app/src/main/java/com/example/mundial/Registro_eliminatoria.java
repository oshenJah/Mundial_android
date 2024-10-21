package com.example.mundial;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Registro_eliminatoria extends AppCompatActivity {

    static String cuartos_1,cuartos_2,cuartos_3,cuartos_4="";
    static String marcador_cuartos_1,marcador_cuartos_2,marcador_cuartos_3,marcador_cuartos_4="0";

    static String semis_1,semis_2,semis_3, semis_4="";
    static String marcador_semis_1,marcador_semis_2,marcador_semis_3,marcador_semis_4="0";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registro_eliminatoria);



        Button boton_registro_eliminatoria = findViewById(R.id.boton_registro_eliminatoria); // Asegúrate de que el ID del botón es correcto
        boton_registro_eliminatoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                captura_datos_eliminatoria();
                Intent intent = new Intent(Registro_eliminatoria.this, registro_final.class);
                startActivity(intent);
            }
        });

        OnBackPressedDispatcher onBackPressedDispatcher = getOnBackPressedDispatcher();
        onBackPressedDispatcher.addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                // Aquí defines lo que quieres que suceda al presionar el botón de retroceso
                Intent intent = new Intent(Registro_eliminatoria.this, registro_mundial.class);
                startActivity(intent);
                finish();  // Opcionalmente termina la actividad actual
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.texto_cuartos), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void captura_datos_eliminatoria(){

        EditText cuartos_1=findViewById(R.id.cuartos_1);
        EditText cuartos_2=findViewById(R.id.cuartos_2);
        EditText cuartos_3=findViewById(R.id.cuartos_3);
        EditText cuartos_4=findViewById(R.id.cuartos_4);

        EditText marcador_cuartos_1=findViewById(R.id.marcador_cuartos_1);
        EditText marcador_cuartos_2=findViewById(R.id.marcador_cuartos_2);
        EditText marcador_cuartos_3=findViewById(R.id.marcador_cuartos_3);
        EditText marcador_cuartos_4=findViewById(R.id.marcador_cuartos_4);

        EditText semis_1=findViewById(R.id.semis_1);
        EditText semis_2=findViewById(R.id.semis_2);
        EditText semis_3=findViewById(R.id.semis_3);
        EditText semis_4=findViewById(R.id.semis_4);

        EditText marcador_semis_1=findViewById(R.id.marcador_semis_1);
        EditText marcador_semis_2=findViewById(R.id.marcador_semis_2);
        EditText marcador_semis_3=findViewById(R.id.marcador_semis_3);
        EditText marcador_semis_4=findViewById(R.id.marcador_semis_4);


        Registro_eliminatoria.cuartos_1=cuartos_1.getText().toString();
        Registro_eliminatoria.cuartos_2=cuartos_2.getText().toString();
        Registro_eliminatoria.cuartos_3=cuartos_3.getText().toString();
        Registro_eliminatoria.cuartos_4=cuartos_4.getText().toString();

        Registro_eliminatoria.marcador_cuartos_1=marcador_cuartos_1.getText().toString();
        Registro_eliminatoria.marcador_cuartos_2=marcador_cuartos_2.getText().toString();
        Registro_eliminatoria.marcador_cuartos_3=marcador_cuartos_3.getText().toString();
        Registro_eliminatoria.marcador_cuartos_4=marcador_cuartos_4.getText().toString();

        Registro_eliminatoria.semis_1=semis_1.getText().toString();
        Registro_eliminatoria.semis_2=semis_2.getText().toString();
        Registro_eliminatoria.semis_3=semis_3.getText().toString();
        Registro_eliminatoria.semis_4=semis_4.getText().toString();

        Registro_eliminatoria.marcador_semis_1=marcador_semis_1.getText().toString();
        Registro_eliminatoria.marcador_semis_2=marcador_semis_2.getText().toString();
        Registro_eliminatoria.marcador_semis_3=marcador_semis_3.getText().toString();
        Registro_eliminatoria.marcador_semis_4=marcador_semis_4.getText().toString();

    }


    public static void reseteo_eliminatoria(){
        Registro_eliminatoria.semis_1="";
        Registro_eliminatoria.semis_2="";
        Registro_eliminatoria.semis_3="";
        Registro_eliminatoria.semis_4="";

        Registro_eliminatoria.marcador_semis_1="0";
        Registro_eliminatoria.marcador_semis_2="0";
        Registro_eliminatoria.marcador_semis_3="0";
        Registro_eliminatoria.marcador_semis_4="0";


        Registro_eliminatoria.marcador_cuartos_1="0";
        Registro_eliminatoria.marcador_cuartos_2="0";
        Registro_eliminatoria.marcador_cuartos_3="0";
        Registro_eliminatoria.marcador_cuartos_4="0";


        Registro_eliminatoria.cuartos_1="";
        Registro_eliminatoria.cuartos_2="";
        Registro_eliminatoria.cuartos_3="";
        Registro_eliminatoria.cuartos_4="";


    }




}