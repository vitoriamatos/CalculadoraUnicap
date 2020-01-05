package com.example.calculadoraunicap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    private Button media, aprovado, irFinal, naoReprovar, botao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        media = (Button) findViewById(R.id.Média);
        aprovado = (Button) findViewById(R.id.passarpormedia);
        irFinal =(Button) findViewById(R.id.irFinal);
        naoReprovar = (Button) findViewById(R.id.naoreprovar) ;



        media.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaActvity();

            }
        });

        aprovado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aprovado();



            }
        });

        irFinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irFinal();


            }
        });

        naoReprovar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NaoReprovar();

            }
        });

    }

    private void irFinal(){
        startActivity(new Intent(MainActivity.this, IrPraFinalActivity.class));



    }


    private void NaoReprovar(){
        startActivity(new Intent(MainActivity.this, NaoReprovarActivity.class));


    }

    private  void mediaActvity(){
        startActivity(new Intent(MainActivity.this, MediaActivity.class));

    }

    private  void aprovado(){
        startActivity(new Intent(MainActivity.this, AprovadoPorMediaActivity.class));

    }

    }

