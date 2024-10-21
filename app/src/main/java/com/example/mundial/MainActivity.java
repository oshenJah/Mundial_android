package com.example.mundial;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button boton_1 = findViewById(R.id.boton_1);
        boton_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent para abrir RegistroMundialActivity
                Intent intent = new Intent(MainActivity.this, registro_mundial.class);
                startActivity(intent);
                // Finalizar la actividad actual para cerrarla
                finish();
            }
        });

        Button boton_2 = findViewById(R.id.boton_2);
        boton_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent para abrir RegistroMundialActivity
                Intent intent = new Intent(MainActivity.this, MundialesGuardados.class);
                startActivity(intent);
                // Finalizar la actividad actual para cerrarla
                finish();
            }
        });



        Button boton_3 = findViewById(R.id.boton_3);
        boton_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent para abrir RegistroMundialActivity
                Intent intent = new Intent(MainActivity.this, Palmares.class);
                startActivity(intent);
                // Finalizar la actividad actual para cerrarla
                finish();
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.texto_cuartos), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}