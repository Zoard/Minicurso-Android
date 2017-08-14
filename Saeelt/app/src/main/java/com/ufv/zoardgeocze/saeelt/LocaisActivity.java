package com.ufv.zoardgeocze.saeelt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

//Parte 3 - Mostrar que Activity foi criada no Manifest
public class LocaisActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locais);
    }
}
