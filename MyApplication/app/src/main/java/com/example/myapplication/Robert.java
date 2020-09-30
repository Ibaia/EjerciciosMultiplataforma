package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;


public class Robert extends AppCompatActivity {

    private TextView txSum;
    private Button btnSum;
    private EditText EditValue1;
    private EditText EditValue2;
    private RadioButton RadioButton1;
    private RadioButton RadioButton2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_robert);

        btnSum= findViewById(R.id.btSum);


        btnSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txSum= findViewById(R.id.tvResult);

                EditValue1= findViewById(R.id.etValue1);
                EditValue2= findViewById(R.id.etValue2);

                RadioButton1= findViewById(R.id.radioButton);
                RadioButton2= findViewById(R.id.radioButton2);

                String value1String = EditValue1.getText().toString();
                String value2String = EditValue2.getText().toString();

                int value1= Integer.parseInt(value1String);
                int value2= Integer.parseInt(value2String);


                if (RadioButton1.isChecked()==true) {
                    int resta = value1 - value2;

                    txSum.setText(String.valueOf(resta));
                } else
                if (RadioButton2.isChecked()==true) {
                    int sum = value1 + value2;

                    txSum.setText(String.valueOf(sum));
                }
            }
        });

    }
}