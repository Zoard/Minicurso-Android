package com.ufv.zoardgeocze.saeelt;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.ufv.zoardgeocze.saeelt.modelo.Local;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Parte 2 (List<String>) - Parte 7 List<Local>
    private List<Local> locais = new ArrayList<>();
    //Parte 2
    private EditText nomeLocal;
    //Parte 3
    private static final int LISTA = 0;
    //Parte 6
    private String[] categorias = {"-","Restaurante","Bar","Cinema","Universidade","Estádio","Parque","outros"};
    //Parte 6
    private Spinner categoriaCombo;
    //Parte 7
    private String categoriaLocal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Parte 2
        this.nomeLocal = (EditText) findViewById(R.id.local_nome);

        //Parte 6
        this.categoriaCombo = (Spinner) findViewById(R.id.categoria_spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,this.categorias);
        this.categoriaCombo.setAdapter(adapter);

        this.categoriaCombo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String categoria = (String) adapterView.getAdapter().getItem(i);
                if(!categoria.equals("-")) {
                    Toast.makeText(view.getContext(), "Categoria escolhida é " + categoria, Toast.LENGTH_SHORT).show();
                    //parte 7
                }

                categoriaLocal = categoria;

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    //Parte 3 - Criação de um Menu e Item de Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        MenuItem item = menu.add(0,LISTA,1,"Lista de Locais");

        return true;
    }

    //Parte 4 - Selecionar um Menu e Navegar entre telas
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()) {
            case LISTA:
                if(!this.locais.isEmpty()) {
                    Intent intent = new Intent(this,LocaisActivity.class);
                    //intent.putExtra("local",this.locais.get(0));
                    //intent.putStringArrayListExtra("locais", (ArrayList<String>) this.locais); // Parte 5

                    //Parte 7
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("locais", (Serializable) this.locais);
                    intent.putExtras(bundle);

                    startActivity(intent);
                }

                //Toast.makeText(this,"Clicou para ver a lista de locais", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    //Parte 2
    public void checkIn(View view) {
        String local = String.valueOf(this.nomeLocal.getText());
        if (!local.equals("") && !categoriaLocal.equals("-")) {

            //Parte 7
            Local objetoLocal = new Local(local,this.categoriaLocal);

            this.locais.add(objetoLocal);
            Toast.makeText(this, objetoLocal.getNome() + " adicionado!" ,Toast.LENGTH_SHORT).show();

            this.nomeLocal.setText("");

        } else {
            Toast.makeText(this, "Nome do Local e Categoria são obrigatórios", Toast.LENGTH_SHORT).show();
        }

        //Parte 2
        Log.i("TAMANHO_VETOR_LOCAIS: ", String.valueOf(this.locais.size()));

    }
}
