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

public class registro_mundial extends AppCompatActivity {

    static String octavos_1,octavos_2,octavos_3,octavos_4="";
    static String marcador_octavos_1,marcador_octavos_2,marcador_octavos_3,marcador_octavos_4="0";
    static String jugador1="";
    static String jugador2="";
    static String jugador3="";
    static String jugador4="";
    static String seleccion1="";
    static String seleccion2="";
    static String seleccion3="";
    static String seleccion4="";
    static String pts1="";
    static String pts2="";
    static String pts3="";
    static String pts4="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registro_mundial);



        Button boton_siguiente_1 = findViewById(R.id.boton_siguiente_1); // Asegúrate de que el ID del botón es correcto
        boton_siguiente_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                captura_datos_mundial();
                Intent intent = new Intent(registro_mundial.this, Registro_eliminatoria.class);
                startActivity(intent);
            }
        });


        OnBackPressedDispatcher onBackPressedDispatcher = getOnBackPressedDispatcher();
        onBackPressedDispatcher.addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                // Aquí defines lo que quieres que suceda al presionar el botón de retroceso
                Intent intent = new Intent(registro_mundial.this, MainActivity.class);
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


    public  void captura_datos_mundial(){

        EditText jugador1=findViewById(R.id.jugador1);
        EditText jugador2=findViewById(R.id.jugador2);
        EditText jugador3=findViewById(R.id.jugador3);
        EditText jugador4=findViewById(R.id.jugador4);

        EditText seleccion1=findViewById(R.id.seleccion1);
        EditText seleccion2=findViewById(R.id.seleccion2);
        EditText seleccion3=findViewById(R.id.seleccion3);
        EditText seleccion4=findViewById(R.id.seleccion4);

        EditText pts1=findViewById(R.id.pts1);
        EditText pts2=findViewById(R.id.pts2);
        EditText pts3=findViewById(R.id.pts3);
        EditText pts4=findViewById(R.id.pts4);


        EditText octavos_1=findViewById(R.id.octavos_1);
        EditText octavos_2=findViewById(R.id.octavos_2);
        EditText octavos_3=findViewById(R.id.octavos_3);
        EditText octavos_4=findViewById(R.id.octavos_4);

        EditText marcador_octavos_1=findViewById(R.id.marcador_octavos_1);
        EditText marcador_octavos_2=findViewById(R.id.marcador_octavos_2);
        EditText marcador_octavos_3=findViewById(R.id.marcador_octavos_3);
        EditText marcador_octavos_4=findViewById(R.id.marcador_octavos_4);

        registro_mundial.jugador1=jugador1.getText().toString();
        registro_mundial.jugador2=jugador2.getText().toString();
        registro_mundial.jugador3=jugador3.getText().toString();
        registro_mundial.jugador4=jugador4.getText().toString();

        registro_mundial.seleccion1=seleccion1.getText().toString();
        registro_mundial.seleccion2=seleccion2.getText().toString();
        registro_mundial.seleccion3=seleccion3.getText().toString();
        registro_mundial.seleccion4=seleccion4.getText().toString();

        registro_mundial.pts1=pts1.getText().toString();
        registro_mundial.pts2=pts2.getText().toString();
        registro_mundial.pts3=pts3.getText().toString();
        registro_mundial.pts4=pts4.getText().toString();





        registro_mundial.octavos_1=octavos_1.getText().toString();
        registro_mundial.octavos_2=octavos_2.getText().toString();
        registro_mundial.octavos_3=octavos_3.getText().toString();
        registro_mundial.octavos_4=octavos_4.getText().toString();

        registro_mundial.marcador_octavos_1=marcador_octavos_1.getText().toString();
        registro_mundial.marcador_octavos_2=marcador_octavos_2.getText().toString();
        registro_mundial.marcador_octavos_3=marcador_octavos_3.getText().toString();
        registro_mundial.marcador_octavos_4=marcador_octavos_4.getText().toString();




    }



    public static void reseteo_mundial(){

        registro_mundial.jugador1="";
        registro_mundial.jugador2="";
        registro_mundial.jugador3="";
        registro_mundial.jugador4="";


        registro_mundial.seleccion1="";
        registro_mundial.seleccion2="";
        registro_mundial.seleccion3="";
        registro_mundial.seleccion4="";

        registro_mundial.pts1="";
        registro_mundial.pts2="";
        registro_mundial.pts3="";
        registro_mundial.pts4="";



        registro_mundial.octavos_1="";
        registro_mundial.octavos_2="";
        registro_mundial.octavos_3="";
        registro_mundial.octavos_4="";


        registro_mundial.marcador_octavos_1="0";
        registro_mundial.marcador_octavos_2="0";
        registro_mundial.marcador_octavos_3="0";
        registro_mundial.marcador_octavos_4="0";



    }



}