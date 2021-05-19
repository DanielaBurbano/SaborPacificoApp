package com.example.saborpacifico.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.saborpacifico.Models.Categoria;
import com.example.saborpacifico.Models.Plato;
import com.example.saborpacifico.R;

import java.util.ArrayList;

public class AdapterPlatos extends RecyclerView.Adapter<AdapterPlatos.ViewHolder> implements View.OnClickListener{

    LayoutInflater inflater;
    ArrayList<Plato> listaplatos;

    private View.OnClickListener listener;

    public AdapterPlatos(Context context, ArrayList<Plato> listaplatos){
        this.inflater = LayoutInflater.from(context);
        this.listaplatos = listaplatos;
    }

    @NonNull
    @Override
    public AdapterPlatos.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_platos, parent, false);
        view.setOnClickListener(this);
        return new AdapterPlatos.ViewHolder(view);
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterPlatos.ViewHolder holder, int position) {
        String plato = listaplatos.get(position).getDesplato();
        int precio = listaplatos.get(position).getPrecio();
        int categoria = listaplatos.get(position).getFkcategoria();
        holder.descripcion.setText(plato);
        holder.descripcion.setText(precio);
        holder.descripcion.setText(categoria);
    }

    @Override
    public int getItemCount() {
        return listaplatos.size();
    }

    @Override
    public void onClick(View view) {
        if(listener!=null){
            listener.onClick(view);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView descripcion, precio, categoria;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            descripcion = itemView.findViewById(R.id.idCategoria);
            precio = itemView.findViewById(R.id.idCategoria);
            categoria = itemView.findViewById(R.id.idCategoria);

        }
    }

}