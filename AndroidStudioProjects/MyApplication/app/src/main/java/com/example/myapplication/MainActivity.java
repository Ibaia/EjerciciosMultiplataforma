package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tvHello;
    private Button butCambiar;
    private Button butSendInput;
    private EditText textInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvHello=findViewById(R.id.tvHello);
        butSendInput=findViewById(R.id.butSendInput);
        textInput=findViewById(R.id.textInput);

        butSendInput.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(!textInput.getText().toString().equals("")){
                    Intent intent = new Intent(MainActivity.this,pantalla2.class);

                    intent.putExtra(Values.SENT_USER,textInput.getText().toString());

                    //send information
                    //startActivity(intent);
                    //send and wait for information
                    //the second parameter is a random number to refer to this activity sent
                    //at the end of the code is the function that refers to this line
                    startActivityForResult(intent, Values.REQ_ACT_2);
                }


            }
        });


        butCambiar=findViewById(R.id.butCambiar);
        butCambiar.setVisibility(View.GONE);
//        butCambiar.setOnClickListener(new View.OnClickListener(){
//            public void onClick(View v){
//                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
//
//                intent.putExtra(Values.CLAVE_INTENT,getText(R.string.tvHello));
//
//                startActivity(intent);
//
//            }
//        });
        }

    @Override
    public void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode, data);
        textInput.setText("");

        switch(requestCode){
            case Values.REQ_ACT_2:
                if (resultCode == RESULT_OK) {
                        String requiredText=data.getStringExtra(Values.CLAVE_INTENT);
                        tvHello.setText(requiredText);

                }
        }






    }


}