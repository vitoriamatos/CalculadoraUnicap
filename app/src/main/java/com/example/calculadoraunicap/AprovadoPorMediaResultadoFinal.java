package com.example.calculadoraunicap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AprovadoPorMediaResultadoFinal extends AppCompatActivity {
    private Button home, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aprovado_por_media_resultado_final);
        Intent intent = getIntent();

        if (intent != null) {
            Bundle paramentros = intent.getExtras();

            if (paramentros != null) {

                //String Nota = paramentros.getString("Nota");
                double nota = paramentros.getDouble("Nota"), n;
                String str = Double.toString(nota), m;

                TextView NotaView = (TextView) findViewById(R.id.textView_ApFinal);

                n= calcular(nota);
                m= Double.toString(n);


                NotaView.setText(m.toString());



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
        }
    }


    private void voltar(){
        startActivity(new Intent(AprovadoPorMediaResultadoFinal.this, AprovadoPorMediaActivity.class));
        finish();

    }

    private void home(){
        startActivity(new Intent(AprovadoPorMediaResultadoFinal.this, MainActivity.class));
        finish();

    }



    public double calcular(double nota){
        double m1, m2;

        m1= (15-(nota*2))/3;
        return m1;


    }
}

