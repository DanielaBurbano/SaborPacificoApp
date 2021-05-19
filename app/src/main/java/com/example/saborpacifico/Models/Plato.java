package com.example.saborpacifico.Models;

public class Plato {
    int idplato;
    String desplato;
    int precio;
    int fkcategoria;

    public Plato(int idplato, String desplato, int precio, int fkcategoria) {
        this.idplato = idplato;
        this.desplato = desplato;
        this.precio = precio;
        this.fkcategoria = fkcategoria;
    }

    public int getIdplato() {
        return idplato;
    }

    public void setIdplato(int idplato) {
        this.idplato = idplato;
    }

    public String getDesplato() {
        return desplato;
    }

    public void setDesplato(String desplato) {
        this.desplato = desplato;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getFkcategoria() {
        return fkcategoria;
    }

    public void setFkcategoria(int fkcategoria) {
        this.fkcategoria = fkcategoria;
    }
}
