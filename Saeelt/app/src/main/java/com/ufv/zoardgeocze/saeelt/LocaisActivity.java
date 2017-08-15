package com.ufv.zoardgeocze.saeelt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

//Parte 3 - Mostrar que Activity foi criada no Manifest
public class LocaisActivity extends AppCompatActivity {

    //parte 5
    private ListView listaLocais;
    //Parte 5
    private List<String> locais = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locais);

        //Parte 4
        Intent intent = getIntent();
        //String local = intent.getStringExtra("local");
        //Toast.makeText(this,local,Toast.LENGTH_SHORT).show();

        //Parte 5
        this.locais = intent.getStringArrayListExtra("locais");

        this.listaLocais = (ListView) findViewById(R.id.locais_lista);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.item_locais,this.locais);

        this.listaLocais.setAdapter(adapter);

        this.listaLocais.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String nome = (String) adapterView.getAdapter().getItem(i);
                Toast.makeText(view.getContext(),"Clicou em " + nome,Toast.LENGTH_SHORT).show();
            }
        });


    }
}
