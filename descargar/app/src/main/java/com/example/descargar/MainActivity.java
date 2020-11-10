package com.example.descargar;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.ed_image);

        String EDteamImage = "https://ed.team/sites/default/files/styles/16_9_medium/public/2018-04/guia-de-estilos.jpg?itok=73JysFzx";
        Glide.with(getApplicationContext()).load(EDteamImage).into(imageView);
    }

}
//public class ThreadDescarga extends Thread {


//}