package com.example.saborpacifico.BD;

public class BD {

    //Constantes campos tabla categorias
    public static final String TABLA_CATEGORIAS="categorias";
    public static final String CAT_ID="id_cat";
    public static final String CAT_DESCRIPCION="des_cat";
    //Constantes campos tabla platos
    public static final String TABLA_PLATOS="platos";
    public static final String PLA_ID="id_pla";
    public static final String PLA_DESCRIPCION="des_pla";
    public static final String PLA_PRECIO="pre_pla";
    public static final String PLA_FK_CATEGORIA="fk_cat";

    public static final String CREAR_TABLA_CATEGORIAS="CREATE TABLE "+TABLA_CATEGORIAS+" ("+CAT_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+CAT_DESCRIPCION+")";
    public static final String CREAR_TABLA_PLATOS="CREATE TABLE "+TABLA_PLATOS+" ("+PLA_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+PLA_DESCRIPCION+", "+PLA_PRECIO+" INT, "+PLA_FK_CATEGORIA+" INT)";

}
