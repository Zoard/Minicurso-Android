package com.ufv.zoardgeocze.saeelt;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ufv.zoardgeocze.saeelt.fragment.MapaFragment;
import com.ufv.zoardgeocze.saeelt.modelo.Local;

import java.util.ArrayList;
import java.util.List;

//Parte 10
public class MapaActivity extends AppCompatActivity {

    private MapaFragment mapaFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        this.mapaFragment = new MapaFragment();
        this.mapaFragment.setArguments(bundle);

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction tx = manager.beginTransaction();
        tx.replace(R.id.map, this.mapaFragment);
        tx.commit();
    }



}
