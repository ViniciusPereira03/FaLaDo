package com.example.projetoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TelaCampoTexto extends AppCompatActivity {

    private EditText txtNota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.campodetexto);

        txtNota = (EditText)findViewById(R.id.edtNota);
    }

    public void pesquisar(View view){
        String nota;
        nota = String.valueOf(txtNota.getText().toString());

        Intent tela = new Intent(this, TelaResultadoFinal.class);

        Bundle parametros = new Bundle();

        parametros.putString("chave_nota", nota);
        tela.putExtras(parametros);

        startActivity(tela);


    }
}
