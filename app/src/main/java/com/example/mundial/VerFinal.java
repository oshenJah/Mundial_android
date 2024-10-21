package com.example.mundial;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class VerFinal extends AppCompatActivity {
    int numero=0;
    String final_1="";
    String final_2="";
    String marcador_final_1="";
    String marcador_final_2="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ver_final);


        numero=MundialesGuardados.numero_2;
        String x=leer_mundiales_registrados(this,"mundiales_registrados_correctamente.json");

        try {
            // Crear un JSONArray a partir del contenido del archivo corregido
            JSONArray jsonArray = new JSONArray(x);


            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);


                if (jsonObject.getInt("numero_mundial") == numero) {




                    TextView fin_1 = findViewById(R.id.final_verfinal_1);
                    TextView fin_2 = findViewById(R.id.final_verfinal_2);

                    TextView marc_fin_1 = findViewById(R.id.marcador_final_verfinal_1);
                    TextView marc_fin_2 = findViewById(R.id.marcador_final_verfinal_2);


                    final_1 = jsonObject.getString("final_1");
                    fin_1.setText(final_1);
                    final_2 = jsonObject.getString("final_2");
                    fin_2.setText(final_2);

                    marcador_final_1= jsonObject.getString("marcador_final_1");
                    marc_fin_1.setText(marcador_final_1);
                    marcador_final_2= jsonObject.getString("marcador_final_2");
                    marc_fin_2.setText(marcador_final_2);

                    // Salir del bucle una vez que encontramos el año 2018
                    break;


                }
            }
        }catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Error al procesar el JSON", Toast.LENGTH_SHORT).show();
        }


        Button boton_volver_final_verfinal=findViewById(R.id.boton_volver_final_verfinal);
        boton_volver_final_verfinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent para abrir RegistroMundialActivity
                Intent intent = new Intent(VerFinal.this, MainActivity.class);
                startActivity(intent);
                // Finalizar la actividad actual para cerrarla
                finish();
            }
        });

        OnBackPressedDispatcher onBackPressedDispatcher = getOnBackPressedDispatcher();
        onBackPressedDispatcher.addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                // Aquí defines lo que quieres que suceda al presionar el botón de retroceso
                Intent intent = new Intent(VerFinal.this, VerEliminatoria.class);
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


    public String leer_mundiales_registrados(Context context, String nombreArchivo) {
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