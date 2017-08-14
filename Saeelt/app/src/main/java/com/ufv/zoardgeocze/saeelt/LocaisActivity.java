package com.ufv.zoardgeocze.saeelt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

//Parte 3 - Mostrar que Activity foi criada no Manifest
public class LocaisActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locais);

        //Parte 4
        Intent intent = getIntent();
        String local = intent.getStringExtra("local");
        Toast.makeText(this,local,Toast.LENGTH_SHORT).show();

    }
}
