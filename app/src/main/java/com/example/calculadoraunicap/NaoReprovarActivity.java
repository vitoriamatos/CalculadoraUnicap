package com.example.calculadoraunicap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NaoReprovarActivity extends AppCompatActivity {


    private EditText Media;
    private Button botão;
    private Double m;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nao_reprovar);


        Media = (EditText) findViewById(R.id.editText_nota1gqx);

        botão = (Button) findViewById(R.id.button_naoReprovar);



        botão.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if(isEmpty(Media)==true) {
                    Toast.makeText(NaoReprovarActivity.this, "Informe a nota", Toast.LENGTH_LONG).show();
                }else if(passarDouble(Media)>10){
                        Toast.makeText(NaoReprovarActivity.this, "Informe uma média válida (valores abaixo de 10)", Toast.LENGTH_LONG).show();


                }else{
                    aprovadoResultado(Media);
                }

            }
        });


    }






    private  void aprovadoResultado(EditText Media){

        double resultado, m;

        m = Double.parseDouble(Media.getText().toString());

        resultado = media(m);

        Bundle paramentros = new Bundle();
        paramentros.putDouble("Nota", resultado);


        if(m<3) {
            Intent intent = new Intent(this, NaoReprovarReprovado.class);
            intent.putExtras(paramentros);
            startActivity(intent);
        }else if(m>=7){
            Intent intent = new Intent(this, NaoReprovarAprovado.class);
            intent.putExtras(paramentros);
            startActivity(intent);


        }else{
            if(resultado>5) {
                Intent intent = new Intent(this, NaoReprovarResultadoRuim.class);
                intent.putExtras(paramentros);
                startActivity(intent);




            }else{
                Intent intent = new Intent(this, NaoReprovarResultadoBom.class);
                intent.putExtras(paramentros);
                startActivity(intent);

            }
        }


    }



    public double media(double m){

        double media;

        media = 10-m;

        return media;


    }



    public double passarDouble(EditText ed){
        Double m;
        m = Double.parseDouble(Media.getText().toString());
        return  m;

    }


    public boolean isEmpty(EditText ed) {
        if (ed.getText().toString().trim().equals("")) {
            return true;
        }else{
            return false;
        }

    }

}
