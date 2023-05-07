package com.example.tela_login_augusto_camargo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.Objects;

public class TelaPrincipal extends AppCompatActivity {
    private Button btn_deslogar;
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
    private void IniciarComponentes() {
        nomeUsuario = findViewById(R.id.textNomeUsuario);
        emailUsuario = findViewById(R.id.textEmail);
        btn_deslogar = findViewById(R.id.btn_deslogar);


    }


}