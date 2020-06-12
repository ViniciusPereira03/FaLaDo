package com.example.projetoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class TelaResultadoFinal extends AppCompatActivity {

    private ImageView imgNota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultadofinal);

        Intent telaResult = getIntent();
        Bundle parametros = telaResult.getExtras();

        imgNota = (ImageView)findViewById(R.id.imgResultadoNota);

        if(parametros != null){
            String nota =  parametros.getString("chave_nota");

            nota = nota.toLowerCase();

            if(nota.toString().equals("c") || nota.toString().equals("do") || nota.toString().equals("do maior") || nota.toString().equals("dó maior")  || nota.toString().equals("dó")){
                imgNota.setImageResource(R.drawable.c);
            }else if(nota.toString().equals("d") || nota.toString().equals("re") || nota.toString().equals("re maior") || nota.toString().equals("ré maior")  || nota.toString().equals("ré")){
                imgNota.setImageResource(R.drawable.d);
            }else if(nota.toString().equals("e") || nota.toString().equals("mi") || nota.toString().equals("mi maior") || nota.toString().equals("mí maior")  || nota.toString().equals("mí")){
                imgNota.setImageResource(R.drawable.e);
            }else if(nota.toString().equals("f") || nota.toString().equals("fa") || nota.toString().equals("fa maior") || nota.toString().equals("fá maior")  || nota.toString().equals("fá")){
                imgNota.setImageResource(R.drawable.f);
            }else if(nota.toString().equals("g") || nota.toString().equals("sol") || nota.toString().equals("sol maior")){
                imgNota.setImageResource(R.drawable.g);
            }else if(nota.toString().equals("a") || nota.toString().equals("la") || nota.toString().equals("la maior") || nota.toString().equals("lá maior")  || nota.toString().equals("lá")){
                imgNota.setImageResource(R.drawable.a);
            }else if(nota.toString().equals("b") || nota.toString().equals("si") || nota.toString().equals("si maior") || nota.toString().equals("sí maior")  || nota.toString().equals("sí")){
                imgNota.setImageResource(R.drawable.b);
            }


        }

    }

    public void voltarTipoPesquisa(View view){
        Intent tela = new Intent(this, TelaTiposDePesquisa.class);
        startActivity(tela);

    }


    public void fecharApp(View view){
        this.finishAffinity();
    }
}
