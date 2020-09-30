package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class pantalla2 extends AppCompatActivity {

    private TextView Input;
    private Button butPantalla2;
    private EditText textoPantalla2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);

        Input=findViewById(R.id.Input);
        butPantalla2=findViewById(R.id.butPantalla2);
        textoPantalla2=findViewById(R.id.textoPantalla2);
        Input.setText(getIntent().getStringExtra(Values.SENT_USER));

        textoPantalla2.setText("");

        butPantalla2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //we won't send (origin or destination) on Intent, just data
                    Intent intent = new Intent();

                    //we use the random number that we used in MainActivity for us, to send and
                    //receive information from Main to second screen
                    intent.putExtra(Values.CLAVE_INTENT,textoPantalla2.getText().toString());

                    setResult(RESULT_OK,intent);
                    finish();
                }
            }

        );

    }
}