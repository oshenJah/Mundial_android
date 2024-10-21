package com.example.mundial;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.gson.Gson;


import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.BufferedReader;
import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.HashMap;

import java.util.Map;


import java.io.FileReader;



public class registro_final extends AppCompatActivity {

    static String final_1,final_2="";
    static String marcador_final_1,marcador_final_2="0";

    static int numero_mundial=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registro_final);



        Button boton_volver_final = findViewById(R.id.boton_volver_final); // Asegúrate de que el ID del botón es correcto
        boton_volver_final.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(registro_final.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Button boton_guardartodo = findViewById(R.id.boton_guardartodo); // Asegúrate de que el ID del botón es correcto
        boton_guardartodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean x= verifica_existe_archivo_numero_mundial(registro_final.this);

                if (x==false){
                    crea_archivo_numero_mundial(registro_final.this);
                }else{

                    //sobreescribimos el archivo txt sumandole 1 al valor que contiene, es un string ojo
                   
                    File documentosDir = getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
                    File archivo = new File(documentosDir, "numero_mundial.txt");

                    FileReader fileReader = null;
                    try {
                        fileReader = new FileReader(archivo);
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    BufferedReader bufferedReader = new BufferedReader(fileReader);

                    // Leer la única línea del archivo que contiene el número
                    String linea = null;
                    try {
                        linea = bufferedReader.readLine();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    // Convertir la línea a un número entero
                    int numero = Integer.parseInt(linea.trim());
                    numero_mundial=numero+1;

                    crea_archivo_numero_mundial(registro_final.this);





                }


                captura_datos_final();



                guardarDatosEnDocumentos(registro_final.this);

                registro_final.reseteo_final();
                registro_mundial.reseteo_mundial();
                Registro_eliminatoria.reseteo_eliminatoria();


                Toast.makeText(registro_final.this, "Mundial registrado", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(registro_final.this, MainActivity.class);
                startActivity(intent);
            }
        });


        OnBackPressedDispatcher onBackPressedDispatcher = getOnBackPressedDispatcher();
        onBackPressedDispatcher.addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                // Aquí defines lo que quieres que suceda al presionar el botón de retroceso
                Intent intent = new Intent(registro_final.this, Registro_eliminatoria.class);
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

    public void captura_datos_final(){
        EditText final_1=findViewById(R.id.final_1);
        EditText final_2=findViewById(R.id.final_2);

        EditText marcador_final_1=findViewById(R.id.marcador_final_1);
        EditText marcador_final_2=findViewById(R.id.marcador_final_2);

        registro_final.final_1=final_1.getText().toString();
        registro_final.final_2=final_2.getText().toString();

        registro_final.marcador_final_1=marcador_final_1.getText().toString();
        registro_final.marcador_final_2=marcador_final_2.getText().toString();

    }


    public static void reseteo_final(){
        registro_final.final_1="";
        registro_final.final_2="";

        registro_final.marcador_final_1="0";
        registro_final.marcador_final_2="0";

    }






     // se guarda en \Almacenamiento interno\Android\data\com.example.mundial\files\Documents
    public void guardarDatosEnDocumentos(Context context) {
        // Crear el objeto Gson
        Gson gson = new Gson();

        // Crear los nuevos datos (puedes cambiarlo según lo que quieras guardar)
        Map<String, Object> datos = new HashMap<>();

        datos.put("jugador1",registro_mundial.jugador1);
        datos.put("jugador2",registro_mundial.jugador2);
        datos.put("jugador3",registro_mundial.jugador3);
        datos.put("jugador4",registro_mundial.jugador4);

        datos.put("seleccion1",registro_mundial.seleccion1);
        datos.put("seleccion2",registro_mundial.seleccion2);
        datos.put("seleccion3",registro_mundial.seleccion3);
        datos.put("seleccion4",registro_mundial.seleccion4);

        datos.put("pts1",registro_mundial.pts1);
        datos.put("pts2",registro_mundial.pts2);
        datos.put("pts3",registro_mundial.pts3);
        datos.put("pts4",registro_mundial.pts4);




        datos.put("octavos_1",registro_mundial.octavos_1);
        datos.put("octavos_2",registro_mundial.octavos_2);
        datos.put("octavos_3",registro_mundial.octavos_3);
        datos.put("octavos_4",registro_mundial.octavos_4);

        datos.put("marcador_octavos_1",registro_mundial.marcador_octavos_1);
        datos.put("marcador_octavos_2",registro_mundial.marcador_octavos_2);
        datos.put("marcador_octavos_3",registro_mundial.marcador_octavos_3);
        datos.put("marcador_octavos_4",registro_mundial.marcador_octavos_4);

        datos.put("cuartos_1",Registro_eliminatoria.cuartos_1);
        datos.put("cuartos_2",Registro_eliminatoria.cuartos_2);
        datos.put("cuartos_3",Registro_eliminatoria.cuartos_3);
        datos.put("cuartos_4",Registro_eliminatoria.cuartos_4);

        datos.put("marcador_cuartos_1",Registro_eliminatoria.marcador_cuartos_1);
        datos.put("marcador_cuartos_2",Registro_eliminatoria.marcador_cuartos_2);
        datos.put("marcador_cuartos_3",Registro_eliminatoria.marcador_cuartos_3);
        datos.put("marcador_cuartos_4",Registro_eliminatoria.marcador_cuartos_4);

        datos.put("semis_1",Registro_eliminatoria.semis_1);
        datos.put("semis_2",Registro_eliminatoria.semis_2);
        datos.put("semis_3",Registro_eliminatoria.semis_3);
        datos.put("semis_4",Registro_eliminatoria.semis_4);

        datos.put("marcador_semis_1",Registro_eliminatoria.marcador_semis_1);
        datos.put("marcador_semis_2",Registro_eliminatoria.marcador_semis_2);
        datos.put("marcador_semis_3",Registro_eliminatoria.marcador_semis_3);
        datos.put("marcador_semis_4",Registro_eliminatoria.marcador_semis_4);



        datos.put("final_1", final_1);
        datos.put("final_2", final_2);

        datos.put("marcador_final_1", marcador_final_1);
        datos.put("marcador_final_2", marcador_final_2);
        datos.put("numero_mundial", numero_mundial);

        // Convertir a JSON
        String json = gson.toJson(datos);

        // Obtener la carpeta Documents
        File documentosDir = context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);

        // Crear el archivo en esa ubicación
        File archivo = new File(documentosDir, "datos_mundial.json");

        FileOutputStream fos = null;
        try {
            // Abrir el archivo para escribir
            fos = new FileOutputStream(archivo, true); // true para agregar datos sin sobrescribir
            fos.write(json.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();  // Cerrar el archivo al terminar
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }



    public void crea_archivo_numero_mundial(Context context) {
        // Obtiene el directorio de almacenamiento interno para la app
        File documentosDir = context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);

        // Crear el archivo en esa ubicación
        File archivo = new File(documentosDir, "numero_mundial.txt");




        try (FileOutputStream fos = new FileOutputStream(archivo)) {
            fos.write(String.valueOf(numero_mundial).getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public boolean verifica_existe_archivo_numero_mundial(Context context){
        File documentosDir = context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
        File archivo = new File(documentosDir, "numero_mundial.txt");

        // Verificar si el archivo ya existe
        if (archivo.exists()) {

            return true ;
        }else{
            return false;
        }



    }














}