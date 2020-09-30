package com.example.sumasyoperaciones;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    private EditText Input1Pantalla1;
    private EditText Input2Pantalla1;
    private TextView resultNum;
    private int resultado;
    private Button butResult;
    private TextView Aviso;
    private RadioButton rbutSumar;
    private RadioButton rbutRestar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        butResult=findViewById(R.id.butResult);
        rbutSumar=findViewById(R.id.rbutSumar);
        rbutRestar=findViewById(R.id.rbutRestar);
        Input1Pantalla1=findViewById(R.id.Input1Pantalla1);
        Input2Pantalla1=findViewById(R.id.Input2Pantalla1);
        resultNum=findViewById(R.id.resultNum);
        Aviso=findViewById(R.id.Aviso);

        Aviso.setText("");

        butResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultNum.setText("");
                String stringPrimerInput = Input1Pantalla1.getText().toString();
                String stringSegundoInput = Input2Pantalla1.getText().toString();

                if (stringPrimerInput.isEmpty() || stringSegundoInput.isEmpty()) {
                    Aviso.setText(R.string.Aviso);

                } else {
                    if (rbutSumar.isChecked()) {

                        int primerInput = Integer.parseInt(Input1Pantalla1.getText().toString());
                        int segundoInput = Integer.parseInt(Input2Pantalla1.getText().toString());
                        resultado = primerInput + segundoInput;
                        resultNum.setText(String.valueOf(resultado));
                        Aviso.setText("");
                        rbutSumar.setChecked(false);
                    } else if (rbutRestar.isChecked()) {
                        int primerInput = Integer.parseInt(Input1Pantalla1.getText().toString());
                        int segundoInput = Integer.parseInt(Input2Pantalla1.getText().toString());
                        resultado = primerInput - segundoInput;
                        resultNum.setText(String.valueOf(resultado));
                        Aviso.setText("");
                        rbutRestar.setChecked(false);
                        rbutRestar.setChecked(false);

                    } else {
                        Aviso.setText(R.string.AvisoRadioButton);

                    }
                }
            }
        });


    }
}