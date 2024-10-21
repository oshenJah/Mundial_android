package com.example.mundial;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class VerMundial extends AppCompatActivity {
    int numero=0;

    String jugador1="";
    String jugador2="";
    String jugador3="";
    String jugador4="";
    String seleccion1="";
    String seleccion2="";
    String seleccion3="";
    String seleccion4="";
    String pts1="";
    String pts2="";
    String pts3="";
    String pts4="";
    String octavos_1="",octavos_2="",octavos_3="",octavos_4="";
    String marcador_octavos_1="",marcador_octavos_2="",marcador_octavos_3="",marcador_octavos_4="";





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ver_mundial);


        numero=MundialesGuardados.numero_2;


        mundiales_registrados_correccion(this,"datos_mundial.json");

        String x=leer_mundiales_registrados(this,"mundiales_registrados_correctamente.json");





        try {
            // Crear un JSONArray a partir del contenido del archivo corregido
            JSONArray jsonArray = new JSONArray(x);


            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);


                if (jsonObject.getInt("numero_mundial") == numero) {



                    TableLayout tableLayout = findViewById(R.id.tabla_vermundial_grupo);

                    TextView jug_1 = tableLayout.findViewById(R.id.jugadorvermundial1);
                    TextView jug_2 = tableLayout.findViewById(R.id.jugadorvermundial2);
                    TextView jug_3 = tableLayout.findViewById(R.id.jugadorvermundial3);
                    TextView jug_4 = tableLayout.findViewById(R.id.jugadorvermundial4);

                    TextView pt_1 = tableLayout.findViewById(R.id.ptsvermundial1);
                    TextView pt_2 = tableLayout.findViewById(R.id.ptsvermundial2);
                    TextView pt_3 = tableLayout.findViewById(R.id.ptsvermundial3);
                    TextView pt_4 = tableLayout.findViewById(R.id.ptsvermundial4);

                    TextView sele_1= tableLayout.findViewById(R.id.seleccionvermundial1);
                    TextView sele_2= tableLayout.findViewById(R.id.seleccionvermundial2);
                    TextView sele_3= tableLayout.findViewById(R.id.seleccionvermundial3);
                    TextView sele_4= tableLayout.findViewById(R.id.seleccionvermundial4);

                    TextView oct_1= findViewById(R.id.octavos_vermundial_1);
                    TextView oct_2= findViewById(R.id.octavos_vermundial_2);
                    TextView oct_3= findViewById(R.id.octavos_vermundial_3);
                    TextView oct_4= findViewById(R.id.octavos_vermundial_4);

                    TextView marc_oct_1= findViewById(R.id.marcador_octavos_vermundial_1);
                    TextView marc_oct_2= findViewById(R.id.marcador_octavos_vermundial_2);
                    TextView marc_oct_3= findViewById(R.id.marcador_octavos_vermundial_3);
                    TextView marc_oct_4= findViewById(R.id.marcador_octavos_vermundial_4);



                    jugador1 = jsonObject.getString("jugador1");
                    jug_1.setText(jugador1);
                    jugador2 = jsonObject.getString("jugador2");
                    jug_2.setText(jugador2);
                    jugador3 = jsonObject.getString("jugador3");
                    jug_3.setText(jugador3);
                    jugador4 = jsonObject.getString("jugador4");
                    jug_4.setText(jugador4);

                    seleccion1  = jsonObject.getString("seleccion1");
                    sele_1.setText(seleccion1);
                    seleccion2 = jsonObject.getString("seleccion2");
                    sele_2.setText(seleccion2);
                    seleccion3  = jsonObject.getString("seleccion3");
                    sele_3.setText(seleccion3);
                    seleccion4 = jsonObject.getString("seleccion4");
                    sele_4.setText(seleccion4);

                    pts1 = jsonObject.getString("pts1");
                    pt_1.setText(pts1);
                    pts2= jsonObject.getString("pts2");
                    pt_2.setText(pts2);
                    pts3 = jsonObject.getString("pts3");
                    pt_3.setText(pts3);
                    pts4 = jsonObject.getString("pts4");
                    pt_4.setText(pts4);



                    octavos_1=jsonObject.getString("octavos_1");
                    oct_1.setText(octavos_1);
                    octavos_2=jsonObject.getString("octavos_2");
                    oct_2.setText(octavos_2);
                    octavos_3=jsonObject.getString("octavos_3");
                    oct_3.setText(octavos_3);
                    octavos_4=jsonObject.getString("octavos_4");
                    oct_4.setText(octavos_4);

                    marcador_octavos_1=jsonObject.getString("marcador_octavos_1");
                    marc_oct_1.setText(marcador_octavos_1);
                    marcador_octavos_2=jsonObject.getString("marcador_octavos_2");
                    marc_oct_2.setText(marcador_octavos_2);
                    marcador_octavos_3=jsonObject.getString("marcador_octavos_3");
                    marc_oct_3.setText(marcador_octavos_3);
                    marcador_octavos_4=jsonObject.getString("marcador_octavos_4");
                    marc_oct_4.setText(marcador_octavos_4);


                    // Salir del bucle una vez que encontramos el año 2018
                    break;



                }





            }
        }catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Error al procesar el JSON", Toast.LENGTH_SHORT).show();
        }


        Button boton_siguiente_vermundial_1=findViewById(R.id.boton_siguiente_vermundial_1);
        boton_siguiente_vermundial_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent para abrir RegistroMundialActivity
                Intent intent = new Intent(VerMundial.this, VerEliminatoria.class);
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
                Intent intent = new Intent(VerMundial.this, MundialesGuardados.class);
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


    public void mundiales_registrados_correccion(Context context, String nombreArchivo) {
        // Leer el contenido del archivo JSON incorrecto
        String contenidoJson = leer_mundiales_registrados(context, nombreArchivo);

        try {
            // Paso 1: Corregir el formato agregando corchetes y separando los objetos con comas
            contenidoJson = contenidoJson.trim();
            contenidoJson = "[" + contenidoJson.replace("}{", "},{") + "]";

            // Paso 2: Validar el JSON corregido
            JSONArray jsonArray = new JSONArray(contenidoJson);

            // Paso 3: Guardar el nuevo contenido JSON en un archivo llamado 'mundiales_registrados_correctamente.json'
            File documentosDir = context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
            File archivoCorregido = new File(documentosDir, "mundiales_registrados_correctamente.json");

            FileOutputStream fos = new FileOutputStream(archivoCorregido);
            fos.write(contenidoJson.getBytes());
            fos.close();

            // Confirmar que el archivo se ha corregido y guardado


        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(context, "Error al corregir el JSON", Toast.LENGTH_SHORT).show();
        }
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