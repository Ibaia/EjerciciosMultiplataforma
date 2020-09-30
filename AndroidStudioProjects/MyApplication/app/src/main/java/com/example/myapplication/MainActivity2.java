package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private TextView tvHello2;
    private Button butCambiar2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tvHello2 = findViewById(R.id.tvHello2);
        butCambiar2 = findViewById(R.id.butCambiar2);

        tvHello2.setText(getIntent().getStringExtra("mytext"));
        tvHello2.setText(getIntent().getStringExtra(Values.CLAVE_INTENT));

        butCambiar2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (tvHello2.getText().equals(getText(R.string.tvHello))) {
                    tvHello2.setText(getText(R.string.tvHello2));

                } else {
                    tvHello2.setText(getText(R.string.tvHello));

                }
            }
        });
    }
}