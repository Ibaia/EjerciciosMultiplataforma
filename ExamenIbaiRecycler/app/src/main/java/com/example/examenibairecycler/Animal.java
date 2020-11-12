package com.example.examenibairecycler;

//Clase que contiene los campos de Animal, ademas del contructor y los getters que usaremos mas adelante

public class Animal {

    //Parametros
    private String nombre;
    private int img;

    //Constructor Animal
    public Animal(String nombre, int img) {
        this.nombre = nombre;
        this.img = img;
    }

    //Getters
    public String getNombre() {
        return nombre;
    }
    public int getImg() {
        return img;
    }
}
