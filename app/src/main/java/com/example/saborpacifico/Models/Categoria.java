package com.example.saborpacifico.Models;

public class Categoria {
    int idcategoria;
    String descategoria;

    public Categoria(int idcategoria, String descategoria) {
        this.idcategoria = idcategoria;
        this.descategoria = descategoria;
    }

    public Categoria(){

    }

    public int getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(int idcategoria) {
        this.idcategoria = idcategoria;
    }

    public String getDescategoria() {
        return descategoria;
    }

    public void setDescategoria(String descategoria) {
        this.descategoria = descategoria;
    }
}
