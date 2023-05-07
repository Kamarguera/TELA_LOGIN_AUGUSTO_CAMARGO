package com.example.tela_login_augusto_camargo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class TelaPrincipal extends AppCompatActivity {
    private Button btn_deslogar;

    private TextView nomeUsuario, emailUsuario;

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