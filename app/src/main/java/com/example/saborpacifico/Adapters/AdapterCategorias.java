package com.example.saborpacifico.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.saborpacifico.Models.Categoria;
import com.example.saborpacifico.R;

import java.util.ArrayList;

public class AdapterCategorias extends RecyclerView.Adapter<AdapterCategorias.ViewHolder> implements View.OnClickListener{

    LayoutInflater inflater;
    ArrayList<Categoria> listacategorias;

    private View.OnClickListener listener;

    public AdapterCategorias(Context context, ArrayList<Categoria> listacategorias){
        this.inflater = LayoutInflater.from(context);
        this.listacategorias = listacategorias;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_categorias, parent, false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String plato = listacategorias.get(position).getDescategoria();
        holder.descripcion.setText(plato);
    }

    @Override
    public int getItemCount() {
        return listacategorias.size();
    }

    @Override
    public void onClick(View view) {
        if(listener!=null){
            listener.onClick(view);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView descripcion;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            descripcion = itemView.findViewById(R.id.idCategoria);

        }
    }

}