package com.example.calculadoraunicap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NaoReprovarAprovado extends AppCompatActivity {

    private Button home, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nao_reprovar_aprovado);
        home= (Button) findViewById(R.id.home);
        back =(Button) findViewById(R.id.back);


        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                home();

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                voltar();
            }
        });

}


private void voltar(){
        startActivity(new Intent(NaoReprovarAprovado.this, NaoReprovarActivity.class));

        }

private void home(){
        startActivity(new Intent(NaoReprovarAprovado.this, MainActivity.class));

        }

        }