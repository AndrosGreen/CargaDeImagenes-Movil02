package com.example.cargadeimagenes;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.InputStream;

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

        new DownloadImageFromInternet(holder.imgPokemon).execute(urls[position]);
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

    private class DownloadImageFromInternet extends AsyncTask<String, Void, Bitmap> {
        ImageView imageView;
        public DownloadImageFromInternet(ImageView imageView) {
            this.imageView=imageView;
        }
        protected Bitmap doInBackground(String... urls) {
            String imageURL=urls[0];
            Bitmap bimage=null;
            try {
                InputStream in=new java.net.URL(imageURL).openStream();
                bimage= BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("aaa", e.getMessage());
                e.printStackTrace();
            }
            return bimage;
        }
        protected void onPostExecute(Bitmap result) {
            imageView.setImageBitmap(result);
        }
    }
}
