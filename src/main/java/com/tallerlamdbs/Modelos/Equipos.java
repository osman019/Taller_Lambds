package com.tallerlamdbs.Modelos;

import java.util.ArrayList;

public class Equipos {
    private int id;
    private String name;
    private int yearfoundation;
     private ArrayList<Jugadores> Jugadores;
    public Equipos(int id, String name, int yearfoundation) {
        this.id = id;
        this.name = name;
        this.yearfoundation = yearfoundation;
        this.Jugadores = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearfoundation() {
        return yearfoundation;
    }

    public void setYearfoundation(int yearfoundation) {
        this.yearfoundation = yearfoundation;
    }

    public ArrayList<Jugadores> getJugadores() {
        return Jugadores;
    }

}
