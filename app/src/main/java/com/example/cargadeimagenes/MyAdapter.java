package com.example.cargadeimagenes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    String nombres [];
    String urls[];
    Context context;

    public MyAdapter(Context ct, String nombres[], String urls[] ){
        this.context = ct;
        this.nombres = nombres;
        this.urls = urls;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.carta, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.txtNombre.setText(nombres[position]);
        holder.imgPokemon.setImageResource(R.drawable.ic_launcher_background);
    }

    @Override
    public int getItemCount() {
        return nombres.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView txtNombre;
        ImageView imgPokemon;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNombre = itemView.findViewById(R.id.txtNombre);
            imgPokemon = itemView.findViewById(R.id.imgPokemon);
        }
    }
}
