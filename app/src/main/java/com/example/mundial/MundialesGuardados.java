package com.example.mundial;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class MundialesGuardados extends AppCompatActivity {
    int numero=1;
    static int numero_2=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mundiales_guardados);




        String x= leer_numero_mundial(this,"numero_mundial.txt");
        TextView texto_mundiales_guardados1 = findViewById(R.id.texto_mundiales_guardados1);

        // Cambiar el texto del TextView
        texto_mundiales_guardados1.setText("Existen "+x+" mundiales registrados, ingrese abajo un numero menor o igual a este.");


        Button boton_ver_mundial = findViewById(R.id.boton_ver_mundial);
        boton_ver_mundial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent para abrir RegistroMundialActivity
                EditText m = findViewById(R.id.ingrese_numero_mundial);
                String k = m.getText().toString();
                String y= leer_numero_mundial(MundialesGuardados.this,"numero_mundial.txt").trim(); ;

                int numeroInt = Integer.parseInt(k);

                numero_2=numeroInt;
                try{

                    if (numeroInt<=Integer.parseInt(y)){
                        Intent intent = new Intent(MundialesGuardados.this, VerMundial.class);
                        startActivity(intent);


                        // Finalizar la actividad actual para cerrarla
                        finish();
                    }else{
                        Toast.makeText(getApplicationContext(), "ingrese un numero menor o igual a "+x, Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception ex){
                    Toast.makeText(getApplicationContext(), "ingrese un numero entero", Toast.LENGTH_SHORT).show();
                }


            }
        });

        OnBackPressedDispatcher onBackPressedDispatcher = getOnBackPressedDispatcher();
        onBackPressedDispatcher.addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                // Aquí defines lo que quieres que suceda al presionar el botón de retroceso
                Intent intent = new Intent(MundialesGuardados.this, MainActivity.class);
                startActivity(intent);
                finish();  // Opcionalmente termina la actividad actual
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }





    public String leer_numero_mundial(Context context, String nombreArchivo) {
        StringBuilder stringBuilder = new StringBuilder();

        try {
            File documentosDir = context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
            // Obtener referencia al archivo en almacenamiento interno
            File archivo = new File(documentosDir, nombreArchivo);

            // Verificar si el archivo existe
            if (archivo.exists()) {
                FileInputStream fis = new FileInputStream(archivo);
                InputStreamReader inputStreamReader = new InputStreamReader(fis);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String linea;

                // Leer el archivo línea por línea
                while ((linea = bufferedReader.readLine()) != null) {
                    stringBuilder.append(linea).append("\n");
                }

                bufferedReader.close();
            } else {
                // Manejar el caso en que el archivo no existe
                stringBuilder.append("El archivo no existe.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            stringBuilder.append("Error al leer el archivo.");
        }

        // Retornar el contenido leído
        return stringBuilder.toString();
    }





}