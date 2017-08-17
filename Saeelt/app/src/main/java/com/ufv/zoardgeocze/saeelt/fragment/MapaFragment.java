package com.ufv.zoardgeocze.saeelt.fragment;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.ufv.zoardgeocze.saeelt.modelo.Local;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZoardGeocze on 16/08/2017.
 */

public class MapaFragment extends SupportMapFragment implements OnMapReadyCallback {

    private GoogleMap mapa;
    private List<Local> locais = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getMapAsync(this);

    }

    public GoogleMap getMap() {
        return mapa;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.mapa = googleMap;
        this.mapa.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        if (ActivityCompat.checkSelfPermission(this.getContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this.getContext(), android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        this.mapa.setMyLocationEnabled(true);

        //this.locais = this.dataBaseController.buscaLugares();
        Bundle bundle = getArguments();
        this.locais = (List<Local>) bundle.getSerializable("locais");

        for(Local local: this.locais) {
            LatLng ll = new LatLng(local.getLatitude(),local.getLongitude());
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.position(ll);
            markerOptions.title(local.getNome());
            String catNome = local.getCategoria();
            markerOptions.snippet("Categoria: " + catNome);
            this.mapa.addMarker(markerOptions);
        }

    }
}
