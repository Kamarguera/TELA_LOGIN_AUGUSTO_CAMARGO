package com.example.tela_login_augusto_camargo.activity.activity;

import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tela_login_augusto_camargo.R;
import com.example.tela_login_augusto_camargo.activity.adapter.Adapter;
import com.example.tela_login_augusto_camargo.activity.model.Motoboy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TelaMotoboysRecyclerView extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Motoboy> listaMotoboys = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_tela_recycler_view);


        recyclerView = findViewById(R.id.recyclerView);

        //Listagem de motoboys
        this.criarMotoboys();





        //configurar adapter
        Adapter adapter = new Adapter(listaMotoboys);


        //configurar recycler view
        RecyclerView.LayoutManager layoutManager
                = new LinearLayoutManager(
                getApplicationContext());

        recyclerView.addItemDecoration( new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        //


    }


    public void criarMotoboys() {

        Motoboy motoboy = new Motoboy("51 1234-5678", "Lucas Oliveira", "1");
        this.listaMotoboys.add(motoboy);

        motoboy = new Motoboy("51 9876-5432", "Pedro Santos", "2");
        this.listaMotoboys.add(motoboy);

        motoboy = new Motoboy("51 2468-1357", "Ana Pereira", "3");
        this.listaMotoboys.add(motoboy);

        motoboy = new Motoboy("51 3698-0246", "Marcos Silva", "4");
        this.listaMotoboys.add(motoboy);

        motoboy = new Motoboy("51 8024-6813", "Luiza Mendes", "5");
        this.listaMotoboys.add(motoboy);


    }
}