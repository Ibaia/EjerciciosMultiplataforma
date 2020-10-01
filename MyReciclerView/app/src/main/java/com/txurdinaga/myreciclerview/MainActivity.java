package com.txurdinaga.myreciclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getBaseContext());
        rv.setLayoutManager(mLayoutManager);
        rv.setItemAnimator(new DefaultItemAnimator());
        rv.addItemDecoration(new DividerItemDecoration(getBaseContext(), LinearLayoutManager.VERTICAL));
        PersonaAdapter pAdapter= new PersonaAdapter();
        rv.setAdapter(pAdapter);

    }
    public class Persona {
        String nombre, apellidos;

        public Persona(String nomb, String ape) {
            this.nombre = nomb;
            this.apellidos = ape;
        }

        public String getNombre() {
            return nombre;
        }

        public String getApellidos() {
            return apellidos;
        }
    }
        public static final List<Persona> ciudadanos = new ArrayList<>();
        {
            Persona p1 = new Persona("Jose Manuel","Nuñez Bilbao");
            Persona p2 = new Persona("Luis","Areeta Sabado");
            Persona p3 = new Persona("Sabrina","Domingo Garcia");
            Persona p4 = new Persona("Laura","Matamoros Prieto");


            ciudadanos.add(p1);
            ciudadanos.add(p2);
            ciudadanos.add(p3);
            ciudadanos.add(p4);

        }

}