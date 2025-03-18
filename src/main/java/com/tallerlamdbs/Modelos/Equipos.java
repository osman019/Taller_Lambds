package com.tallerlamdbs.Modelos;

import java.util.ArrayList;


public class Equipos {
    private int id;
    private String name;
    private int yearfoundation;
    private ArrayList<Jugadores> Jugadores;
    private String coach;
    private ArrayList<Equipos> equiposJson;
    
    public Equipos(int id, String name, int yearfoundation, String coach) {
        this.id = id;
        this.name = name;
        this.yearfoundation = yearfoundation;
        this.coach = coach;
        this.equiposJson = new ArrayList<>();
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
     public String getCoach() {
        return coach;
    }
    public void setCoach(String coach) {
        this.coach = coach;
    }
    public ArrayList<Jugadores> getJugadores() {
        return Jugadores;
    }

    public ArrayList<Equipos> getEquiposJson() {
        return equiposJson;
    }

    public void setEquiposJson(ArrayList<Equipos> equiposJson) {
        this.equiposJson = equiposJson;
    }
}
