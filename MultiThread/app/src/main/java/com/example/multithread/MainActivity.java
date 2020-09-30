package com.example.multithread;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText inputNumber;
    private TextView ascend;
    private TextView descend;
    private TextView ambos;
    private Button btTriger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Declare the input text
        inputNumber = findViewById(R.id.dataIn);
        ascend= findViewById(R.id.txAscendente);
        descend= findViewById(R.id.txDescendente);
        ambos= findViewById(R.id.txRandom);

        //Declare the trigger
        btTriger= findViewById(R.id.btTrigger);



        btTriger.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Access to the content of the input text
                int inNumber= Integer.parseInt(inputNumber.getText().toString());

                ascend.setText("Ascendente: ");
                descend.setText("Descendente: ");
                ambos.setText("Ambos: ");

                MiThreadAsc miThreadAsc = new MiThreadAsc(inNumber);
                miThreadAsc.start();

                MiThreadDesc miThreadDesc = new MiThreadDesc(inNumber);
                miThreadDesc.start();
            }
        }));


    }


    //Thread Ascendent
    public class MiThreadAsc extends Thread {
    private int n;
    private String res;

    public MiThreadAsc(int n) {this.n = n;}
    @Override
    public void run() {
        //res = ascendente(n);

        //necesario para poder usar los view y modificar
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                for (int i=1; i<=n; i++){
                    ascend.append(" "  + i);
                    ambos.append(" " + i);
                    //SystemClock.sleep(1500);
                }
            }
        });
        }
    }
    //Ascendent Method
    /*public final String ascendente(int n){
        String asc = "";

        for (int i=1; i<=n; i++){
            asc +=""+i;

            ambos.append(asc + "\n");
        }
        return asc;
    }*/

    //Numero descendente
    public class MiThreadDesc extends Thread {
        private int num;
        private String result;

        public MiThreadDesc(int num) {
            this.num = num;
        }
        @Override
        public void run() {
            //result = descendente(num);
            //necesario para poder usar el view y modificar
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    for(int i=num;1<=i;i--){
                        ambos.append(" "  + i);
                        descend.append(" " + i);
                    }
                }
            });
        }
    }
    //Method Descendent
    /*private void descendente(int num) {
        //String result="";
        for(int i=num;1<=i;i--){
            //result+=" "+i;
            ambos.append(", " + i); // + "\n");
        }
        //return result;
    }*/
}