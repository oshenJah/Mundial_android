package com.example.mundial;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
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

public class VerEliminatoria extends AppCompatActivity {
    int numero=0;

    String cuartos_1="";
    String cuartos_2="";
    String cuartos_3="";
    String cuartos_4="";

    String marcador_cuartos_1="";
    String marcador_cuartos_2="";
    String marcador_cuartos_3="";
    String marcador_cuartos_4="";

    String semis_1="";
    String semis_2="";
    String semis_3="";
    String semis_4="";

    String marcador_semis_1="";
    String marcador_semis_2="";
    String marcador_semis_3="";
    String marcador_semis_4="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ver_eliminatoria);



         numero=MundialesGuardados.numero_2;
         String x=leer_mundiales_registrados(this,"mundiales_registrados_correctamente.json");


        try {
            // Crear un JSONArray a partir del contenido del archivo corregido
            JSONArray jsonArray = new JSONArray(x);


            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);


                if (jsonObject.getInt("numero_mundial") == numero) {



                    TextView cua_1 = findViewById(R.id.cuartos_vereliminatoria_1);
                    TextView cua_2 = findViewById(R.id.cuartos_vereliminatoria_2);
                    TextView cua_3 = findViewById(R.id.cuartos_vereliminatoria_3);
                    TextView cua_4 = findViewById(R.id.cuartos_vereliminatoria_4);


                    TextView sem_1 = findViewById(R.id.semis_vereliminatoria_1);
                    TextView sem_2 = findViewById(R.id.semis_vereliminatoria_2);
                    TextView sem_3 = findViewById(R.id.semis_vereliminatoria_3);
                    TextView sem_4 = findViewById(R.id.semis_vereliminatoria_4);

                    TextView marc_sem_1 = findViewById(R.id.marcador_semis_vereliminatoria_1);
                    TextView marc_sem_2 = findViewById(R.id.marcador_semis_vereliminatoria_2);
                    TextView marc_sem_3 = findViewById(R.id.marcador_semis_vereliminatoria_3);
                    TextView marc_sem_4 = findViewById(R.id.marcador_semis_vereliminatoria_4);

                    TextView marc_cua_1 = findViewById(R.id.marcador_cuartos_vereliminatoria_1);
                    TextView marc_cua_2 = findViewById(R.id.marcador_cuartos_vereliminatoria_2);
                    TextView marc_cua_3 = findViewById(R.id.marcador_cuartos_vereliminatoria_3);
                    TextView marc_cua_4 = findViewById(R.id.marcador_cuartos_vereliminatoria_4);


                    cuartos_1 = jsonObject.getString("cuartos_1");
                    cua_1.setText(cuartos_1);
                    cuartos_2 = jsonObject.getString("cuartos_2");
                    cua_2.setText(cuartos_2);
                    cuartos_3 = jsonObject.getString("cuartos_3");
                    cua_3.setText(cuartos_3);
                    cuartos_4 = jsonObject.getString("cuartos_4");
                    cua_4.setText(cuartos_4);


                    semis_1 = jsonObject.getString("semis_1");
                    sem_1.setText(semis_1);
                    semis_2 = jsonObject.getString("semis_2");
                    sem_2.setText(semis_2);
                    semis_3 = jsonObject.getString("semis_3");
                    sem_3.setText(semis_3);
                    semis_4 = jsonObject.getString("semis_4");
                    sem_4.setText(semis_4);


                    marcador_semis_1 = jsonObject.getString("marcador_semis_1");
                    marc_sem_1.setText(marcador_semis_1);
                    marcador_semis_2 = jsonObject.getString("marcador_semis_2");
                    marc_sem_2.setText(marcador_semis_2);
                    marcador_semis_3 = jsonObject.getString("marcador_semis_3");
                    marc_sem_3.setText(marcador_semis_3);
                    marcador_semis_4 = jsonObject.getString("marcador_semis_4");
                    marc_sem_4.setText(marcador_semis_4);


                    marcador_cuartos_1 = jsonObject.getString("marcador_cuartos_1");
                    marc_cua_1.setText(marcador_cuartos_1);
                    marcador_cuartos_2 = jsonObject.getString("marcador_cuartos_2");
                    marc_cua_2.setText(marcador_cuartos_2);
                    marcador_cuartos_3 = jsonObject.getString("marcador_cuartos_3");
                    marc_cua_3.setText(marcador_cuartos_3);
                    marcador_cuartos_4 = jsonObject.getString("marcador_cuartos_4");
                    marc_cua_4.setText(marcador_cuartos_4);


                    // Salir del bucle una vez que encontramos el año 2018
                    break;


                }
            }
        }catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Error al procesar el JSON", Toast.LENGTH_SHORT).show();
        }

                Button boton_vereliminatoria_eliminatoria=findViewById(R.id.boton_vereliminatoria_eliminatoria);
                boton_vereliminatoria_eliminatoria.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Intent para abrir RegistroMundialActivity
                        Intent intent = new Intent(VerEliminatoria.this, VerFinal.class);
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
                Intent intent = new Intent(VerEliminatoria.this, VerMundial.class);
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