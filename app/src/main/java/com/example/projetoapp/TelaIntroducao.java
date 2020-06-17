package com.example.projetoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TelaIntroducao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.introducao);
    }


    public void AvancarTipoPesquisa (View view){
        Intent tela = new Intent(this, TelaTiposDePesquisa.class);
        startActivity(tela);
    }
}
