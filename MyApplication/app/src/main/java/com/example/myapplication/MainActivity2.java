package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private TextView textViewAct2;
    private Button buttonAct2, boton2;
    private EditText inputAct2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //Recibir datos
        //CharSequence string2=getIntent().getExtras().getString("stringAct1");

        buttonAct2= findViewById(R.id.buttonAct2);
        inputAct2= findViewById(R.id.editTextAct2);
        textViewAct2= findViewById(R.id.textViewAct2);
        boton2= findViewById(R.id.boton2);

        //Imprimir datos
        textViewAct2.setText(getIntent().getStringExtra("stringAct1"));


        buttonAct2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                    Intent intent= new Intent(MainActivity2.this, MainActivity.class);
                    intent.putExtra(Value.Content_Clave, inputAct2.getText().toString());
                    setResult(RESULT_OK, intent);
                    finish();
                }
        });

        boton2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity2.this, Robert.class);
                startActivity(intent);

            }
        });

    }
}