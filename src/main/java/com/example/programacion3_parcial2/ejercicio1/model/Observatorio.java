package com.example.programacion3_parcial2.ejercicio1.model;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

public class Observatorio implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    ArrayList<Sismo> listaSismos = new ArrayList<>();

    public Observatorio() {
    }

    public ArrayList<Sismo> getListaSismos() {
        return listaSismos;
    }

    public void setListaSismos(ArrayList<Sismo> listaSismos) {
        this.listaSismos = listaSismos;
    }
}
