package com.example.examenibairecycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Declaracion de Arraylist Animal y RecyclerView
    ArrayList<Animal> ar_animales;
    RecyclerView recycler;
    private int valoracion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Cogemos el recycler para hacer con el la carga de datos
        recycler= findViewById(R.id.recyclerView);

        //Decidimos la direccion del recycler que tipo de layaout va a tener
        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));


        //iniciamos el arraylist
        ar_animales= new ArrayList<>();

        Animal animal1 = new Animal("Araña",R.drawable.aranya);
        Animal animal2 = new Animal("Ardilla",R.drawable.ardilla);
        Animal animal3 = new Animal("Hormiga",R.drawable.hormiga);
        Animal animal4 = new Animal("Loro",R.drawable.loro);
        Animal animal5 = new Animal("Rata",R.drawable.rata);

        //Añadimos los animales al arraylist
        ar_animales.add(animal1);
        ar_animales.add(animal2);
        ar_animales.add(animal3);
        ar_animales.add(animal4);
        ar_animales.add(animal5);

        //creamos un objeto de tipo AdapterItems y le pasamos por parametro el arraylist
        AdapterAnimales adapter = new AdapterAnimales(ar_animales);

        //Onclick manda los datos a datosanimal.java del animal en cuestion
        adapter.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                Intent intent = new Intent(MainActivity.this,datosanimal.class);
                intent.putExtra("nombre",ar_animales.get(recycler.getChildAdapterPosition(v)).getNombre());
                intent.putExtra("img",ar_animales.get(recycler.getChildAdapterPosition(v)).getImg());
                startActivityForResult(intent, 1);

            }
        });

        //metemos el adapter creado al recyclerView
        recycler.setAdapter(adapter);
    }
}