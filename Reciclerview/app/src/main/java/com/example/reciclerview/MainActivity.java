package com.example.reciclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

        private RecyclerView recyclerView;
        private RecyclerView.Adapter animeAdapter;
        private RecyclerView.LayoutManager layoutManager;



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            recyclerView = (RecyclerView) findViewById(R.id.reciclerView);

            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            recyclerView.setHasFixedSize(true);

            // use animeDetails linear layout manager
            layoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(layoutManager);

            // specify an adapter (see also next example)
            animeAdapter = new AnimeAdapter();
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getBaseContext());
            recyclerView.setAdapter(animeAdapter);
        }

    //Cambia el arraylist animeDetails RecyclerView
    //MyReciclerAdapter myReciclerAdapter= new MyRecyclerAdapter(listaAlumnos);
    //myRecycler.setAdapter(myRecyclerAdapter);
}