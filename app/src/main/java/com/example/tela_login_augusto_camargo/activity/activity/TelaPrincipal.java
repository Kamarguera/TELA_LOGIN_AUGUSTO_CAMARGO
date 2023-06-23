package com.example.tela_login_augusto_camargo.activity.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tela_login_augusto_camargo.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Objects;

public class TelaPrincipal extends AppCompatActivity {
    private Button btn_deslogar;
    private Button btn_encontrar_entregador;
    private TextView nomeUsuario, emailUsuario;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    String usuarioID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);
        Objects.requireNonNull(getSupportActionBar()).hide();
        IniciarComponentes();


        btn_deslogar.setOnClickListener(v -> {

            FirebaseAuth.getInstance().signOut();
            TelaLogin();

        });


        btn_encontrar_entregador.setOnClickListener(v -> TelaListaMotoboys());
    }


    @Override
    protected void onStart() {
        super.onStart();


        String email = Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getEmail();
        usuarioID = FirebaseAuth.getInstance().getCurrentUser().getUid();

        DocumentReference documentReference = db.collection("Usuarios").document(usuarioID);
        documentReference.addSnapshotListener((documentSnapshot, error) -> {

            if (documentSnapshot != null){
                nomeUsuario.setText(documentSnapshot.getString("nome"));
                emailUsuario.setText(email);
            }



        });


    }

    private void TelaLogin() {
        Intent intent = new Intent(TelaPrincipal.this, FormLogin.class);
        startActivity(intent);
        finish();
    }


    private void TelaListaMotoboys() {
        Intent intent = new Intent(TelaPrincipal.this, TelaMotoboysRecyclerView.class);
        startActivity(intent);
        finish();
    }
    private void IniciarComponentes() {
        nomeUsuario = findViewById(R.id.textNomeUsuario);
        emailUsuario = findViewById(R.id.textEmail);
        btn_deslogar = findViewById(R.id.btn_deslogar);
        btn_encontrar_entregador = findViewById(R.id.btn_encontrar_entregador);


    }


}