package com.ufv.zoardgeocze.saeelt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Parte 2
    private List<String> locais = new ArrayList<>();
    //Parte 2
    private EditText nomeLocal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Parte 2
        this.nomeLocal = (EditText) findViewById(R.id.local_nome);
    }

    //Parte 2
    public void checkIn(View view) {
        String local = String.valueOf(this.nomeLocal.getText());
        if (!local.equals("")) {
            this.locais.add(local);
            Toast.makeText(this, local + " adicionado!" ,Toast.LENGTH_SHORT).show();

            this.nomeLocal.setText("");

        } else {
            Toast.makeText(this, "Nome do Local é obrigatório", Toast.LENGTH_SHORT).show();
        }

        //Parte 2
        Log.i("TAMANHO_VETOR_LOCAIS: ", String.valueOf(this.locais.size()));

    }
}
