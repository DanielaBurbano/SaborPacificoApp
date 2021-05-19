package com.example.saborpacifico.BD;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ConexionSQLiteHelper extends SQLiteOpenHelper {



    public ConexionSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(BD.CREAR_TABLA_CATEGORIAS);
        db.execSQL(BD.CREAR_TABLA_PLATOS);
        //db.execSQL(BD.CREAR_TABLA_MASCOTA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAntigua, int versionNueva) {
        db.execSQL("DROP TABLE IF EXISTS "+BD.TABLA_CATEGORIAS);
        db.execSQL("DROP TABLE IF EXISTS "+BD.TABLA_PLATOS);
        //db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_MASCOTA);
        onCreate(db);
    }
}