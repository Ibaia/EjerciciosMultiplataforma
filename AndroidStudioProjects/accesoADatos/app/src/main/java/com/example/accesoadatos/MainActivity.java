package com.example.accesoadatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences sharedPref;
    private SharedPreferences.Editor editor;
    private Button butSave;
    private Button butRecover;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        butSave=findViewById(R.id.butSave);
        butRecover=findViewById(R.id.butRecover);

        Context context = getBaseContext();

        sharedPref=getPreferences(Context.MODE_PRIVATE);

        butSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor =sharedPref.edit();
                editor.putString(PARAM_GUARDADO,butSave.getText().toString());
                //editor.commit();
                editor.apply();
            }
        });

    }
}