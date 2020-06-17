package com.example.projetoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TelaTiposDePesquisa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tiposdepesquisa);
    }

    public void telaTexto(View view){
        Intent tela = new Intent(this, TelaCampoTexto.class);
        startActivity(tela);
    }


    public void telaFala(View view){
        Intent tela = new Intent(this, TelaReconhecomentoDeVoz.class);
        startActivity(tela);
    }
}
