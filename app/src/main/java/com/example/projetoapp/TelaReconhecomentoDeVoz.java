package com.example.projetoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class TelaReconhecomentoDeVoz extends AppCompatActivity {
    private Button btnVoz, btnPesquisar;
    private TextView txtNota;
    private Locale locale;
    private final int ID_TEXTO_PARA_VOZ = 100;



    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reconhecimentodevoz);

        btnVoz = (Button)findViewById(R.id.btnFalar);
        txtNota = (TextView)findViewById(R.id.txtPesquisar);

        btnVoz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iVoz = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                iVoz.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);

                iVoz.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());

                iVoz.putExtra(RecognizerIntent.EXTRA_PROMPT, "Fale um acorde");

                try {
                    startActivityForResult(iVoz, ID_TEXTO_PARA_VOZ);
                }catch (ActivityNotFoundException a){
                    Toast.makeText(getApplicationContext(), "Seu celular não suporta comando de voz!", Toast.LENGTH_SHORT).show();
                }
            }
        });


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



    @Override
    protected void onActivityResult(int id, int resultCodeId, Intent dados){
        TelaReconhecomentoDeVoz.super.onActivityResult(id, resultCodeId, dados);

        switch (id){
            case ID_TEXTO_PARA_VOZ:
                if(resultCodeId == RESULT_OK && null != dados){
                    ArrayList<String> result = dados.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    String digitado = result.get(0);
                    Toast.makeText(getApplicationContext(), digitado, Toast.LENGTH_SHORT).show();
                    txtNota.setText(digitado);
                }
                break;
        }
    }




}
