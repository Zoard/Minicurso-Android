package com.ufv.zoardgeocze.saeelt.modelo;

import java.io.Serializable;

/**
 * Created by ZoardGeocze on 11/08/2017.
 */

//Parte 7
public class Local implements Serializable {

    private String nome;
    private String categoria;
    private Double latitude;
    private Double longitude;

    public Local(String nome, String categoria, Double latitude, Double longitude) {
        this.nome = nome;
        this.categoria = categoria;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
