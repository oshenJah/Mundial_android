package com.example.mundial;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
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

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class Palmares extends AppCompatActivity {


    static int alejandro_campeon,alejandro_subcampeon=0;
    static int aldo_campeon,aldo_subcampeon=0;
    static int jefrey_campeon,jefrey_subcampeon=0;
    static int gabriel_campeon,gabriel_subcampeon=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_palmares);



        String fileName = "tabla_palmares.json";


        if (!doesFileExist(this, fileName)) {
            // Si no existe, llama al método crea_archivo_palmares
            crea_archivo_palmares();


        }


        String jsonString = readJsonFileFromStorage("tabla_palmares.json");
        JSONObject jsonObject = null;

        try {
            jsonObject = new JSONObject(jsonString);
            alejandro_campeon = jsonObject.getInt("alejandro_campeon");
            alejandro_subcampeon = jsonObject.getInt("alejandro_subcampeon");
            aldo_campeon = jsonObject.getInt("aldo_campeon");
            aldo_subcampeon = jsonObject.getInt("aldo_subcampeon");
            jefrey_campeon = jsonObject.getInt("jefrey_campeon");
            jefrey_subcampeon = jsonObject.getInt("jefrey_subcampeon");
            gabriel_campeon = jsonObject.getInt("gabriel_campeon");
            gabriel_subcampeon = jsonObject.getInt("gabriel_subcampeon");


            TextView z1 = findViewById(R.id.alejandro_campeon); // Usa el ID de tu TextView
            z1.setText(String.valueOf(alejandro_campeon));
            TextView z2 = findViewById(R.id.alejandro_subcampeon); // Usa el ID de tu TextView
            z2.setText(String.valueOf(alejandro_subcampeon));

            TextView z3 = findViewById(R.id.aldo_campeon); // Usa el ID de tu TextView
            z3.setText(String.valueOf(aldo_campeon));
            TextView z4 = findViewById(R.id.aldo_subcampeon); // Usa el ID de tu TextView
            z4.setText(String.valueOf(aldo_subcampeon));

            TextView z5 = findViewById(R.id.jefrey_campeon); // Usa el ID de tu TextView
            z5.setText(String.valueOf(jefrey_campeon));
            TextView z6 = findViewById(R.id.jefrey_subcampeon); // Usa el ID de tu TextView
            z6.setText(String.valueOf(jefrey_subcampeon));

            TextView z7 = findViewById(R.id.gabriel_campeon); // Usa el ID de tu TextView
            z7.setText(String.valueOf(gabriel_campeon));

            TextView z8 = findViewById(R.id.gabriel_subcampeon); // Usa el ID de tu TextView
            z8.setText(String.valueOf(gabriel_subcampeon));




        } catch (JSONException e) {
            Toast.makeText(Palmares.this, "Hubo un problema al leer el archivo JSON", Toast.LENGTH_SHORT).show();
            throw new RuntimeException(e);
        }





        Button boton_agregar_palm=findViewById(R.id.boton_agregar_palm);
        boton_agregar_palm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               EditText editTextCampeon = findViewById(R.id.campeon);
               EditText editTextSubcampeon=findViewById(R.id.subcampeon);

                // Extrae el texto del EditText como String
                String campeon = editTextCampeon.getText().toString();
                String subcampeon = editTextSubcampeon.getText().toString();


                if (campeon.equalsIgnoreCase("alejandro")){

                    try {
                        String jsonString = readJsonFileFromStorage("tabla_palmares.json");
                        JSONObject jsonObject = null;
                        try {

                            jsonObject = new JSONObject(jsonString);
                        } catch (JSONException e) {
                            Toast.makeText(Palmares.this, "Hubo un problema al leer el archivo JSON", Toast.LENGTH_SHORT).show();
                            throw new RuntimeException(e);
                        }
                        alejandro_campeon = jsonObject.getInt("alejandro_campeon")+1;
                        TextView z = findViewById(R.id.alejandro_campeon); // Usa el ID de tu TextView
                        z.setText(String.valueOf(alejandro_campeon));
                        crea_archivo_palmares();
                    } catch (JSONException e) {
                        Toast.makeText(Palmares.this, "Hubo un problema al asignar el numero alejandro_campeon", Toast.LENGTH_SHORT).show();
                        throw new RuntimeException(e);
                    }

                }


                if (subcampeon.equalsIgnoreCase("alejandro")){

                    try {
                        String jsonString = readJsonFileFromStorage("tabla_palmares.json");
                        JSONObject jsonObject = null;
                        try {

                            jsonObject = new JSONObject(jsonString);
                        } catch (JSONException e) {
                            Toast.makeText(Palmares.this, "Hubo un problema al leer el archivo JSON", Toast.LENGTH_SHORT).show();
                            throw new RuntimeException(e);
                        }
                        alejandro_subcampeon = jsonObject.getInt("alejandro_subcampeon")+1;
                        TextView z = findViewById(R.id.alejandro_subcampeon); // Usa el ID de tu TextView
                        z.setText(String.valueOf(alejandro_subcampeon));
                        crea_archivo_palmares();
                    } catch (JSONException e) {
                        Toast.makeText(Palmares.this, "Hubo un problema al asignar el numero alejandro_subcampeon", Toast.LENGTH_SHORT).show();
                        throw new RuntimeException(e);
                    }

                }

                if (campeon.equalsIgnoreCase("aldo")){

                    try {
                        String jsonString = readJsonFileFromStorage("tabla_palmares.json");
                        JSONObject jsonObject = null;
                        try {

                            jsonObject = new JSONObject(jsonString);
                        } catch (JSONException e) {
                            Toast.makeText(Palmares.this, "Hubo un problema al leer el archivo JSON", Toast.LENGTH_SHORT).show();
                            throw new RuntimeException(e);
                        }
                        aldo_campeon = jsonObject.getInt("aldo_campeon")+1;
                        TextView z = findViewById(R.id.aldo_campeon); // Usa el ID de tu TextView
                        z.setText(String.valueOf(aldo_campeon));
                        crea_archivo_palmares();
                    } catch (JSONException e) {
                        Toast.makeText(Palmares.this, "Hubo un problema al asignar el numero aldo_campeon", Toast.LENGTH_SHORT).show();
                        throw new RuntimeException(e);
                    }

                }

                if (subcampeon.equalsIgnoreCase("aldo")){

                    try {
                        String jsonString = readJsonFileFromStorage("tabla_palmares.json");
                        JSONObject jsonObject = null;
                        try {

                            jsonObject = new JSONObject(jsonString);
                        } catch (JSONException e) {
                            Toast.makeText(Palmares.this, "Hubo un problema al leer el archivo JSON", Toast.LENGTH_SHORT).show();
                            throw new RuntimeException(e);
                        }
                        aldo_subcampeon = jsonObject.getInt("aldo_subcampeon")+1;
                        TextView z = findViewById(R.id.aldo_subcampeon); // Usa el ID de tu TextView
                        z.setText(String.valueOf(aldo_subcampeon));
                        crea_archivo_palmares();
                    } catch (JSONException e) {
                        Toast.makeText(Palmares.this, "Hubo un problema al asignar el numero aldo_subcampeon", Toast.LENGTH_SHORT).show();
                        throw new RuntimeException(e);
                    }

                }

                if (campeon.equalsIgnoreCase("jefrey")){

                    try {
                        String jsonString = readJsonFileFromStorage("tabla_palmares.json");
                        JSONObject jsonObject = null;
                        try {

                            jsonObject = new JSONObject(jsonString);
                        } catch (JSONException e) {
                            Toast.makeText(Palmares.this, "Hubo un problema al leer el archivo JSON", Toast.LENGTH_SHORT).show();
                            throw new RuntimeException(e);
                        }
                        jefrey_campeon = jsonObject.getInt("jefrey_campeon")+1;
                        TextView z = findViewById(R.id.jefrey_campeon); // Usa el ID de tu TextView
                        z.setText(String.valueOf(jefrey_campeon));
                        crea_archivo_palmares();
                    } catch (JSONException e) {
                        Toast.makeText(Palmares.this, "Hubo un problema al asignar el numero jefrey_campeon", Toast.LENGTH_SHORT).show();
                        throw new RuntimeException(e);
                    }

                }

                if (subcampeon.equalsIgnoreCase("jefrey")){

                    try {
                        String jsonString = readJsonFileFromStorage("tabla_palmares.json");
                        JSONObject jsonObject = null;
                        try {

                            jsonObject = new JSONObject(jsonString);
                        } catch (JSONException e) {
                            Toast.makeText(Palmares.this, "Hubo un problema al leer el archivo JSON", Toast.LENGTH_SHORT).show();
                            throw new RuntimeException(e);
                        }
                        jefrey_subcampeon = jsonObject.getInt("jefrey_subcampeon")+1;
                        TextView z = findViewById(R.id.jefrey_subcampeon); // Usa el ID de tu TextView
                        z.setText(String.valueOf(jefrey_subcampeon));
                        crea_archivo_palmares();
                    } catch (JSONException e) {
                        Toast.makeText(Palmares.this, "Hubo un problema al asignar el numero jefrey_subcampeon", Toast.LENGTH_SHORT).show();
                        throw new RuntimeException(e);
                    }

                }

                if (campeon.equalsIgnoreCase("gabriel")){

                    try {
                        String jsonString = readJsonFileFromStorage("tabla_palmares.json");
                        JSONObject jsonObject = null;
                        try {

                            jsonObject = new JSONObject(jsonString);
                        } catch (JSONException e) {
                            Toast.makeText(Palmares.this, "Hubo un problema al leer el archivo JSON", Toast.LENGTH_SHORT).show();
                            throw new RuntimeException(e);
                        }
                        gabriel_campeon = jsonObject.getInt("gabriel_campeon")+1;
                        TextView z = findViewById(R.id.gabriel_campeon); // Usa el ID de tu TextView
                        z.setText(String.valueOf(gabriel_campeon));
                        crea_archivo_palmares();
                    } catch (JSONException e) {
                        Toast.makeText(Palmares.this, "Hubo un problema al asignar el numero gabriel_campeon", Toast.LENGTH_SHORT).show();
                        throw new RuntimeException(e);
                    }

                }


                if (subcampeon.equalsIgnoreCase("gabriel")){

                    try {
                        String jsonString = readJsonFileFromStorage("tabla_palmares.json");
                        JSONObject jsonObject = null;
                        try {

                            jsonObject = new JSONObject(jsonString);
                        } catch (JSONException e) {
                            Toast.makeText(Palmares.this, "Hubo un problema al leer el archivo JSON", Toast.LENGTH_SHORT).show();
                            throw new RuntimeException(e);
                        }
                        gabriel_subcampeon = jsonObject.getInt("gabriel_subcampeon")+1;
                        TextView z = findViewById(R.id.gabriel_subcampeon); // Usa el ID de tu TextView
                        z.setText(String.valueOf(gabriel_subcampeon));
                        crea_archivo_palmares();
                    } catch (JSONException e) {
                        Toast.makeText(Palmares.this, "Hubo un problema al asignar el numero gabriel_subcampeon", Toast.LENGTH_SHORT).show();
                        throw new RuntimeException(e);
                    }

                }


            }




        });


        OnBackPressedDispatcher onBackPressedDispatcher = getOnBackPressedDispatcher();
        onBackPressedDispatcher.addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                // Aquí defines lo que quieres que suceda al presionar el botón de retroceso
                Intent intent = new Intent(Palmares.this, MainActivity.class);
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




    public String readJsonFileFromStorage(String fileName) {
        String json = null;
        try {
            // Crear la ruta completa del archivo
            File file = new File(getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS), fileName);

            // Verificar si el archivo existe
            if (file.exists()) {
                FileInputStream inputStream = new FileInputStream(file);

                int tamaño = inputStream.available();
                byte[] buffer = new byte[tamaño];
                inputStream.read(buffer);
                inputStream.close();

                json = new String(buffer, StandardCharsets.UTF_8);
            } else {
                Log.e("JSON_FILE_ERROR", "El archivo no existe: " + fileName);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return json;
    }





    //private boolean doesFileExist(Context context, String fileName) {
      //  File file = context.getFileStreamPath(fileName);
        //return file.exists();
    //}


    private boolean doesFileExist(Context context, String fileName) {
        File documentosDir = context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
        File file = new File(documentosDir, fileName);
        return file.exists();
    }



    public void crea_archivo_palmares(){

        Gson gson=new Gson();
        Map<String, Object> datos = new HashMap<>();

        String ale_c=String.valueOf(alejandro_campeon);
        String ale_sub=String.valueOf(alejandro_subcampeon);
        String aldo_c=String.valueOf(aldo_campeon);
        String aldo_sub=String.valueOf(aldo_subcampeon);
        String jef_c=String.valueOf(jefrey_campeon);
        String jef_sub=String.valueOf(jefrey_subcampeon);
        String gab_c=String.valueOf(gabriel_campeon);
        String gab_sub=String.valueOf(gabriel_subcampeon);



        datos.put("alejandro_campeon",ale_c);
        datos.put("alejandro_subcampeon",ale_sub);

        datos.put("aldo_campeon",aldo_c);
        datos.put("aldo_subcampeon",aldo_sub);

        datos.put("jefrey_campeon",jef_c);
        datos.put("jefrey_subcampeon",jef_sub);

        datos.put("gabriel_campeon",gab_c);
        datos.put("gabriel_subcampeon",gab_sub);

        String json = gson.toJson(datos);

        File documentosDir = getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);

        // Crear el archivo en esa ubicación
        File archivo = new File(documentosDir, "tabla_palmares.json");

        FileOutputStream fos = null;

        try {

            fos = new FileOutputStream(archivo, false); // true para agregar datos sin sobrescribir
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



}