package com.example.tela_login_augusto_camargo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Objects;


public class FormLogin extends AppCompatActivity {


    private TextView text_tela_cadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_login);





        Objects.requireNonNull(getSupportActionBar()).hide();
        IniciarComponentes();

        text_tela_cadastro.setOnClickListener(v -> {

            Intent intent = new Intent(FormLogin.this, FormCadastro.class);
            startActivity(intent);


        });
    }


    private void IniciarComponentes(){
        text_tela_cadastro = findViewById(R.id.text_tela_cadastro);

    }
}