package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txtAct1;
    private Button btnAct1;
    private EditText editTextAct1;

    private SharedPreferences shared;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtAct1 = findViewById(R.id.TextViewAct1);
        btnAct1 = findViewById(R.id.btnCambiar);
        editTextAct1= findViewById(R.id.editTextAct1);

        shared=this.getPreferences(Context.MODE_PRIVATE);

        String value= shared.getString(getString(R.string.clave), getString(R.string.base));
        txtAct1.setText(value);

        btnAct1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //CAmbiar con un boton el valor de un TextView
                // tvHello.setText("Clicked");
                /*if (tvHello.getText().equals(getText(R.string.hello))){
                    tvHello.setText(R.string.agur);
                }else{
                    tvHello.setText(R.string.hello);
                }*/
                //Mandar datos y abrir otra pagina
                Intent intent= new Intent(MainActivity.this, MainActivity2.class);
                //CharSequence variable = editTextAct1.getText();

                intent.putExtra(Value.Content_Clave, editTextAct1.getText().toString());

                startActivityForResult(intent, Value.Intet_Cod_1);
            }
        });
    }

    @Override
    public void onActivityResult (int requestCode, int resultCode, Intent data ){
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK){
            if (requestCode == Value.Intet_Cod_1){

                Context context = getBaseContext();

                shared=this.getPreferences(Context.MODE_PRIVATE);
                editor=shared.edit();

                /*String value= shared.getString(getString(R.string.clave), getString(R.string.base));
                txtAct1.setText(value);*/


                editor.putString(getString(R.string.clave), data.getStringExtra(Value.Content_Clave));
                editor.apply();

                String value= shared.getString(getString(R.string.clave), getString(R.string.base));
                txtAct1.setText(value);


            }
        }
    }
}