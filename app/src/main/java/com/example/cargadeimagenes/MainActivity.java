package com.example.cargadeimagenes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    String nombres [] = {
        "Charmander",
        "Squirtle",
        "Bulbasaur",
        "Hoothoot",
        "Elekid"
    };

    String urls [] = {
        "https://assets.pokemon.com/assets/cms2/img/pokedex/full/004.png",
        "https://assets.pokemon.com/assets/cms2/img/pokedex/full/007.png",
        "https://assets.pokemon.com/assets/cms2/img/pokedex/full/001.png",
        "https://assets.pokemon.com/assets/cms2/img/pokedex/full/163.png",
        "https://assets.pokemon.com/assets/cms2/img/pokedex/full/239.png"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.miRecycler);

        MyAdapter myAdapter = new MyAdapter(this, nombres, urls);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}