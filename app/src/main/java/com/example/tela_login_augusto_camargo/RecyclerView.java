package com.example.tela_login_augusto_camargo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

public class RecyclerView extends AppCompatActivity {
    private RecyclerView recyclerView_test;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        val recyclerView_test = findViewById<RecyclerView>(R.id.recyclerView_test);
        recyclerView_test.layoutManager


    }





}