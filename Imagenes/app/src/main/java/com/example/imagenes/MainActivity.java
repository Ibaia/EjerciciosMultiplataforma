package com.example.imagenes;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    public static final String URL = "https://ia601407.us.archive.org/12/items/AyasHome/BA%C3%91O.jpg";
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);

        Picasso.get().load(URL).into(imageView);
    }
}