package com.example.calculadoraunicap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class IrPraFinalActivity extends AppCompatActivity {

    private EditText notaAp;
    private Button botão;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ir_pra_final);

        botão= (Button) findViewById(R.id.button_irprafinal);
        notaAp= (EditText)findViewById(R.id.editText_nota1gqs);


        botão.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isEmpty(notaAp)==true){

                    Toast.makeText(IrPraFinalActivity.this, "Informe a nota", Toast.LENGTH_LONG).show();
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

        if(n1>=7){
            Intent intent = new Intent(this, IrParaFinalResultadoAprovado.class);
            intent.putExtras(paramentros);
            startActivity(intent);

        }else if (resultado >=6 ) {
            Intent intent = new Intent(this, IrPraFinalResultadoRuim.class);
            intent.putExtras(paramentros);
            startActivity(intent);


        } else {

            Intent intent = new Intent(this, IrPraFinalResultadoBom.class);
            intent.putExtras(paramentros);
            intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
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

        m1= (15-(nota*2))/3;



        return m1;


    }
}



