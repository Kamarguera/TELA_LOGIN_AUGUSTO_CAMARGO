package com.example.tela_login_augusto_camargo.activity.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.tela_login_augusto_camargo.R;
import com.example.tela_login_augusto_camargo.activity.model.Motoboy;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {


    private List<Motoboy> listaMotoboys;
    public Adapter(List<Motoboy> lista) {
        this.listaMotoboys = lista;

    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_lista, parent, false);

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Motoboy motoboy = listaMotoboys.get(position);

        holder.contatoMotoboy.setText(motoboy.getContatoMotoboy());
        holder.nomeMotoboy.setText(motoboy.getNomeMotoboy());
        holder.avaliacaoMotoboy.setText(motoboy.getAvaliacaoMotoboy());
    }

    @Override
    public int getItemCount() {
        return listaMotoboys.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView nomeMotoboy;
        TextView contatoMotoboy ;
        TextView avaliacaoMotoboy;

        public MyViewHolder(View itemView) {
            super(itemView);

            nomeMotoboy = itemView.findViewById(R.id.textnomeMotoboy);
            contatoMotoboy = itemView.findViewById(R.id.textcontatoMotoboy);
            avaliacaoMotoboy = itemView.findViewById(R.id.textAvaliacaoMotoboy);
        }

    }

}

