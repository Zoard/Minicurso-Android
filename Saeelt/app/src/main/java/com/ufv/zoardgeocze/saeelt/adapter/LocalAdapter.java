package com.ufv.zoardgeocze.saeelt.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ufv.zoardgeocze.saeelt.R;
import com.ufv.zoardgeocze.saeelt.modelo.Local;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZoardGeocze on 11/08/2017.
 */

//Parte 8
public class LocalAdapter extends BaseAdapter {

    private Context context;
    private List<Local> locais = new ArrayList<>();

    public LocalAdapter(Context context, List<Local> locais) {
        this.context = context;
        this.locais = locais;
    }

    @Override
    public int getCount() {
        return this.locais.size();
    }

    @Override
    public Object getItem(int i) {
        return this.locais.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        Local local = this.locais.get(i);

        View myView = view;
        if (myView == null) {
            myView = LayoutInflater.from(this.context).inflate(R.layout.item_locais, viewGroup, false);
        }

        TextView localNome = (TextView) myView.findViewById(R.id.item_nome);
        localNome.setText(local.getNome());

        TextView localCategoria = (TextView) myView.findViewById(R.id.item_categoria);
        localCategoria.setText(local.getCategoria());

        return myView;
    }
}
