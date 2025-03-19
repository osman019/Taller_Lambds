package com.tallerlamdbs.Modelos;

public class Jugadores {
    private int dorsal;
    private String name;
    private String nationality;
    private int age;
    private int height;
    private int weight;
    private String position;
    private Equipos equipo;


    public Jugadores(int age, String name, String position) {
        this.age = age;
        this.name = name;
        this.position = position;
    }
    
    public Jugadores(int dorsal, String name, String nationality, int age, int height, int weight, String position) {
        this.dorsal = dorsal;
        this.name = name;
        this.nationality = nationality;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.position = position;

    }
    public Equipos getEquipo() {
        return equipo;
    }
    
    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

}
