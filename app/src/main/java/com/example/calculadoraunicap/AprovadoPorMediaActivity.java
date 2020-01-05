package com.example.calculadoraunicap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AprovadoPorMediaActivity extends AppCompatActivity {
    private EditText notaAp, res;
    private Button botão;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_aprovado);




            botão= (Button) findViewById(R.id.calcularAp);
            notaAp= (EditText)findViewById(R.id.editText2);


            botão.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (isEmpty(notaAp)){
                        notaAp= (EditText)findViewById(R.id.editText2);
                        Toast.makeText(AprovadoPorMediaActivity.this, "Informe a nota", Toast.LENGTH_LONG).show();
                    }else{
                        aprovadoResultado();
                    }







                }
            });
        }

        private  void aprovadoResultado(){

            double n1, resultado;

            n1 = Double.parseDouble(notaAp.getText().toString());

            resultado = calcular(n1);

            Bundle paramentros = new Bundle();
            paramentros.putDouble("Nota", resultado);

            Bundle parametros2= new Bundle();
            parametros2.putDouble("Nota", n1);


            if (resultado > 10) {
                Intent intent = new Intent(this, AprovadoPorMediaResultadoFinal.class);
                intent.putExtras(parametros2);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

            } else {

                Intent intent = new Intent(this, AprovadoPorMediaResultado.class);
                intent.putExtras(paramentros);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        }






        public boolean isEmpty(EditText ed) {
            if (ed.getText().toString().trim().equals("")) {
                return true;
            }else{
                return false;
            }

        }


        public double calcular(double nota){
            double m1, m2;

            m1= (35-(nota*2))/3;
            return m1;


        }
    }






