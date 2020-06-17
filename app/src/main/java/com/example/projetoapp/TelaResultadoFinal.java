package com.example.projetoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class TelaResultadoFinal extends AppCompatActivity {

    private ImageView imgNota;
    int cifra;


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
                cifra= 1;
                imgNota.setImageResource(R.drawable.c);
            }else if(nota.toString().equals("d") || nota.toString().equals("re") || nota.toString().equals("re maior") || nota.toString().equals("ré maior")  || nota.toString().equals("ré")){
                imgNota.setImageResource(R.drawable.d);
                cifra= 2;
            }else if(nota.toString().equals("e") || nota.toString().equals("mi") || nota.toString().equals("mi maior") || nota.toString().equals("mí maior")  || nota.toString().equals("mí")){
                imgNota.setImageResource(R.drawable.e);
                cifra= 3;
            }else if(nota.toString().equals("f") || nota.toString().equals("fa") || nota.toString().equals("fa maior") || nota.toString().equals("fá maior")  || nota.toString().equals("fá")){
                imgNota.setImageResource(R.drawable.f);
                cifra= 4;
            }else if(nota.toString().equals("g") || nota.toString().equals("sol") || nota.toString().equals("sol maior")){
                imgNota.setImageResource(R.drawable.g);
                cifra= 5;
            }else if(nota.toString().equals("a") || nota.toString().equals("la") || nota.toString().equals("la maior") || nota.toString().equals("lá maior")  || nota.toString().equals("lá")){
                imgNota.setImageResource(R.drawable.a);
                cifra= 6;
            }else if(nota.toString().equals("b") || nota.toString().equals("si") || nota.toString().equals("si maior") || nota.toString().equals("sí maior")  || nota.toString().equals("sí")){
                imgNota.setImageResource(R.drawable.b);
                cifra= 7;
            }else{
                imgNota.setImageResource(R.drawable.erro);
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

    public void play(View view){
        if(cifra == 1){
            final MediaPlayer mp = MediaPlayer.create(this, R.raw.c);
            mp.start();
        }else if(cifra == 2){
            final MediaPlayer mp = MediaPlayer.create(this, R.raw.d);
            mp.start();
        }else if(cifra == 3){
            final MediaPlayer mp = MediaPlayer.create(this, R.raw.e);
            mp.start();
        }else if(cifra == 4){
            final MediaPlayer mp = MediaPlayer.create(this, R.raw.f);
            mp.start();
        }else if(cifra == 5){
            final MediaPlayer mp = MediaPlayer.create(this, R.raw.g);
            mp.start();
        }else if(cifra == 6){
            final MediaPlayer mp = MediaPlayer.create(this, R.raw.a);
            mp.start();
        }else if(cifra == 7){
            final MediaPlayer mp = MediaPlayer.create(this, R.raw.b);
            mp.start();
        }else{
            final MediaPlayer mp = MediaPlayer.create(this, R.raw.v);
            mp.start();
        }

    }
}
