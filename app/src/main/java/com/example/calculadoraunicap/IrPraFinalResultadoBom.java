package com.example.calculadoraunicap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class IrPraFinalResultadoBom extends AppCompatActivity {

    private Button home, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ir_pra_final_resultado_bom);
        Intent intent = getIntent();

        if (intent != null) {
            Bundle paramentros = intent.getExtras();

            if (paramentros != null) {

                double nota = paramentros.getDouble("Nota");
                String str = Double.toString(nota);


                TextView NotaView = (TextView) findViewById(R.id.ApResultado);

                NotaView.setText(str.toString());


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
                        setContentView(R.layout.activity_media);
                    }
                });
            }
        }
    }




    private void home(){
        startActivity(new Intent(IrPraFinalResultadoBom.this, MainActivity.class));
        finish();

        }


        }
