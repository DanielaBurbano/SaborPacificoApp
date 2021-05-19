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
import com.example.saborpacifico.Adapters.AdapterPlatos;
import com.example.saborpacifico.BD.BD;
import com.example.saborpacifico.BD.ConexionSQLiteHelper;
import com.example.saborpacifico.Models.Categoria;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_Platos#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_Platos extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    EditText desPlato, prePlato;

    ArrayList<Categoria> listaPlatos;


    public Fragment_Platos() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_Platos.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_Platos newInstance(String param1, String param2) {
        Fragment_Platos fragment = new Fragment_Platos();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_platos, container, false);



/*******************************************             CARGAR CATEGORIAS EN SPINNER            **********************************************/


        Button btnCrearPlato = (Button)vista.findViewById(R.id.IdbtnCrearPlato);
        Spinner comboCategorias = (Spinner) vista.findViewById(R.id.comboCategorias);
        EditText desplato = (EditText) vista.findViewById(R.id.iddesPlato);
        ArrayList<String> listaCategorias;
        ArrayList<Categoria> CategoriaList;

        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(getContext(), "sabor_pacifico", null, 1);
        SQLiteDatabase db = conn.getReadableDatabase();

        Categoria cat = null;
        CategoriaList = new ArrayList<Categoria>();

        Cursor cursor = db.rawQuery("SELECT * FROM "+ BD.TABLA_CATEGORIAS, null);

        while(cursor.moveToNext()){
            cat = new Categoria();
            cat.setIdcategoria(cursor.getInt(0));
            cat.setDescategoria(cursor.getString(1));

            CategoriaList.add(cat);
        }

        listaCategorias = new ArrayList<String>();
        listaCategorias.add("Seleccione");

        for (int i = 0; i < CategoriaList.size(); i++){
            listaCategorias.add(CategoriaList.get(i).getIdcategoria()+" - "+CategoriaList.get(i).getDescategoria());
        }

        ArrayAdapter<CharSequence> adapter = new ArrayAdapter(
                getContext(), android.R.layout.simple_spinner_item, listaCategorias
        );

        comboCategorias.setAdapter(adapter);
/***************************************                 CARGAR PLATOS                  *****************************************/
        //RecyclerView recyclerPlatos = (RecyclerView) vista.findViewById(R.id.RecyclerId);
        //recyclerPlatos.setLayoutManager(new LinearLayoutManager(getContext()));

        //listaPlatos = new ArrayList<>();

        //consultarPlatos();
        //AdapterPlatos adapterp = new AdapterPlatos(getContext(), listaPlatos);
        //recyclerPlatos.setAdapter(adapterp);

/********************************                      CREAR PLATO                ***********************************/

        btnCrearPlato.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //Toast.makeText(getActivity(), "Descripción: "+desplato.getText()+"  Categoria: "+comboCategorias.getSelectedItemId(), Toast.LENGTH_SHORT).show();
                desPlato = (EditText) vista.findViewById(R.id.iddesPlato);
                prePlato = (EditText) vista.findViewById(R.id.idprePlato);

                ConexionSQLiteHelper conn = new ConexionSQLiteHelper(getContext(), "sabor_pacifico", null, 1);
                SQLiteDatabase db = conn.getWritableDatabase();
                ContentValues values = new ContentValues();

                values.put(BD.PLA_DESCRIPCION, desPlato.getText().toString());
                values.put(BD.PLA_PRECIO, prePlato.getText().toString());
                values.put(BD.PLA_FK_CATEGORIA, comboCategorias.getSelectedItemId());

                Long idResultante = db.insert(BD.TABLA_PLATOS, BD.PLA_ID, values);
                Toast.makeText(getContext(), "ID Registro: "+idResultante, Toast.LENGTH_SHORT).show();
                db.close();
            }
        });
/**********************************************************************************************************/
        return vista;
    }

    private void consultarPlatos(){
        //Carga las categorias a listaCategorias
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(getContext(), "sabor_pacifico", null, 1);
        SQLiteDatabase db = conn.getReadableDatabase();

        Categoria cat = null;
        Cursor cursor = db.rawQuery("SELECT * FROM "+ BD.TABLA_CATEGORIAS, null);

        while(cursor.moveToNext()){
            cat = new Categoria();
            cat.setIdcategoria(cursor.getInt(0));
            cat.setDescategoria(cursor.getString(1));

            listaPlatos.add(cat);
        }
    }

}