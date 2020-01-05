package com.example.calculadoraunicap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MediaActivity extends AppCompatActivity {

    private EditText Nota1, Nota2;
    private Button botão;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);

        Nota1 = (EditText) findViewById(R.id.Nota1GQ);
        Nota2 = (EditText) findViewById(R.id.Nota2GQ);
        botão = (Button) findViewById(R.id.Calcular);

        botão.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if(isEmpty(Nota1) == true || isEmpty(Nota2)==true){
                    Toast.makeText(MediaActivity.this, "Informe a nota", Toast.LENGTH_LONG).show();

                }else{
                    aprovadoResultado(Nota1, Nota2);
                }

            }
        });


    }






    private  void aprovadoResultado(EditText nota1, EditText nota2) {

        double resultado, n1, n2;

        n1 = Double.parseDouble(nota1.getText().toString());
        n2 = Double.parseDouble(nota2.getText().toString());

        resultado = media(n1, n2);

        Bundle paramentros = new Bundle();
        paramentros.putDouble("Nota", resultado);


        if (resultado < 3) {

            Intent intent = new Intent(this, MediaResultadoReprovado.class);
            intent.putExtras(paramentros);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);

        } else if(resultado >=7) {
            Intent intent = new Intent(this, MediaResultado.class);
            intent.putExtras(paramentros);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);

        }else{
            Intent intent = new Intent(this, MediaResultadoFinal.class);
            intent.putExtras(paramentros);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }


    public double media(double nota1, double nota2){

        double media;

        media = ((nota1*2)+(nota2*3))/5;

        return media;


    }




    public boolean isEmpty(EditText ed) {
        if (ed.getText().toString().trim().equals("")) {
            return true;
        }else{
            return false;
        }

    }

}
