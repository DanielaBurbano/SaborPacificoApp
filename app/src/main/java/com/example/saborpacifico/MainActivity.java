package com.example.saborpacifico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.saborpacifico.BD.ConexionSQLiteHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "sabor_pacifico", null, 1);
    }

    public void Login(View view){
        Intent ingresar = new Intent(this, Activity_NDrawer.class);
        startActivity(ingresar);
    }
}