package com.example.saborpacifico;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.saborpacifico.Adapters.AdapterCategorias;
import com.example.saborpacifico.BD.BD;
import com.example.saborpacifico.BD.ConexionSQLiteHelper;
import com.example.saborpacifico.Models.Categoria;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_Categorias#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_Categorias extends Fragment { 

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    EditText nombrecat;


    AdapterCategorias adapter;
    ArrayList<Categoria> listaCategorias;
    RecyclerView recyclerCategorias;

    public Fragment_Categorias() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_Categorias.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_Categorias newInstance(String param1, String param2) {
        Fragment_Categorias fragment = new Fragment_Categorias();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_categorias, container, false);

/**********************************************************************************************************/
        Button btnCrearCategoria = (Button)vista.findViewById(R.id.idbtnCrearCategoria);
        RecyclerView recyclerCategorias = (RecyclerView) vista.findViewById(R.id.RecyclerId);
        recyclerCategorias.setLayoutManager(new LinearLayoutManager(getContext()));

        listaCategorias = new ArrayList<>();

        consultarCategorias();
        AdapterCategorias adapter = new AdapterCategorias(getContext(), listaCategorias);
        recyclerCategorias.setAdapter(adapter);
        //ConexionSQLiteHelper conn = new ConexionSQLiteHelper(getContext(), "sabor_pacifico", null, 1);

/********************************************              CREAR CATEGORIA           *******************************************/
        btnCrearCategoria.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //Toast.makeText(getActivity(), "Categoria", Toast.LENGTH_SHORT).show();
                nombrecat = (EditText) vista.findViewById(R.id.idDesCategoria);

                ConexionSQLiteHelper conn = new ConexionSQLiteHelper(getContext(), "sabor_pacifico", null, 1);
                SQLiteDatabase db = conn.getWritableDatabase();
                ContentValues values = new ContentValues();

                values.put(BD.CAT_DESCRIPCION, nombrecat.getText().toString());

                Long idResultante = db.insert(BD.TABLA_CATEGORIAS, BD.CAT_ID, values);
                Toast.makeText(getContext(), "ID Registro: "+idResultante, Toast.LENGTH_SHORT).show();
                db.close();
            }
        });
/**********************************************************************************************************/
/* //CARGA CATEGORIAS MANUALES
        recyclerCategorias = vista.findViewById(R.id.RecyclerId);
        listaCategorias = new ArrayList<>();

        recyclerCategorias.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new AdapterCategorias(getContext(), listaCategorias);
        recyclerCategorias.setAdapter(adapter);

        listaCategorias.add(new Categoria(1, "Bebidas"));
        listaCategorias.add(new Categoria(2, "Desayunos"));
        listaCategorias.add(new Categoria(3, "Almuerzos"));

*/

        return vista;
    }

    private void consultarCategorias(){
        //Carga las categorias a listaCategorias
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(getContext(), "sabor_pacifico", null, 1);
        SQLiteDatabase db = conn.getReadableDatabase();

        Categoria cat = null;
        Cursor cursor = db.rawQuery("SELECT * FROM "+ BD.TABLA_CATEGORIAS, null);

        while(cursor.moveToNext()){
            cat = new Categoria();
            cat.setIdcategoria(cursor.getInt(0));
            cat.setDescategoria(cursor.getString(1));

            listaCategorias.add(cat);
        }
    }
}