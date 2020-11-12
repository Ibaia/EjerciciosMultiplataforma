package com.example.examenibairecycler;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

//Clase para controlar la segunda pantalla de la app
public class datosanimal extends AppCompatActivity {

    //Declaramos los elementos que necesitamos
    private TextView tvNombre;
    private EditText edValoracion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datos_animal);

        //Declarar o engachar los elemntos en los que se quiere mostrar datos
        tvNombre = findViewById(R.id.tvNombre);
        edValoracion = findViewById(R.id.valoracion);
        ImageView img = findViewById(R.id.imgAnimal);
        Button btnValoracion = findViewById(R.id.btnInicio);

        tvNombre.setText(getIntent().getStringExtra("nombre"));
        img.setImageResource(getIntent().getIntExtra("img",0));

        btnValoracion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int valoracion = Integer.parseInt(String.valueOf(edValoracion.getText()));

                //En caso de que la valoracion sea inferior a 10 aparecera un toast Advirtiendo de ello en caso contrario te mandara a Adapter para cargar la valoracion
                if (valoracion <= 10)
                {
                    //Se recogen el nombr ey valoracion del animal selecionado y se manda al adapterAnimales.java para mostrarlos mas tarde
                    String nombre = tvNombre.getText().toString();
                    AdapterAnimales.anyadirValoracion(nombre, valoracion);

                    //Creamos una intent para volver a la pagina principal
                    Intent intent= new Intent(datosanimal.this, MainActivity.class);
                    startActivityForResult(intent, 1);
                }else
                    {
                        Toast toast = Toast.makeText(getApplicationContext(), "El numero tiene que ser 10 o menos", Toast.LENGTH_LONG);
                        toast.show();
                    }


            }
        });

    }
}
