package com.example.calculadoraunicap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;


public class MediaResultadoFinal extends AppCompatActivity {
private Button home, back, go;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_resultado_final);
        Intent intent = getIntent();

        if (intent != null) {
            Bundle paramentros = intent.getExtras();

            if (paramentros != null) {

                final double nota = paramentros.getDouble("Nota");
                String str = Double.toString(nota);


                TextView NotaView = (TextView) findViewById(R.id.ApResultadoF);

                NotaView.setText(str.toString());


                home= (Button) findViewById(R.id.home);
                back =(Button) findViewById(R.id.back);
                go = (Button) findViewById(R.id.go);


                home.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        home();


                    }
                });



                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setContentView(R.layout.activity_media);
                    }
                });


                go.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        go(nota);

                    }
                });
            }
        }
    }


    private void home(){
        startActivity(new Intent(MediaResultadoFinal.this, MainActivity.class));
        finish();

    }



    private void go(double nota) {

        double resultado = media(nota);

        Bundle paramentros = new Bundle();
        paramentros.putDouble("Nota",resultado);

        Intent intent = new Intent(this, MediaResultadoFinalResultado.class);
        intent.putExtras(paramentros);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);

        }




    public boolean isEmpty(EditText ed) {
        if (ed.getText().toString().trim().equals("")) {
            return true;
        }else{
            return false;
        }

    }

    public double media(double m){

        double media;
        double a;
        media = 10-m;

        return media;


    }


}

