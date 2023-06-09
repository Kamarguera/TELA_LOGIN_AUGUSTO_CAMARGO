package com.example.tela_login_augusto_camargo.activity.activity;

import static android.app.PendingIntent.getActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tela_login_augusto_camargo.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;


public class FormLogin extends AppCompatActivity {
    private TextView text_tela_cadastro;
    private EditText edit_email, edit_senha;
    private Button bt_entrar;
    private ProgressBar progressBar;
    String[] mensagens = {"Preencha todos os campos", "Login efetuado com sucesso"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_login);
        Objects.requireNonNull(getSupportActionBar()).hide();
        IniciarComponentes();
        sharedPrefGetCredentials();
        setFieldText();





        text_tela_cadastro.setOnClickListener(v -> {
            Intent intent = new Intent(FormLogin.this, FormCadastro.class);
            startActivity(intent);
        });
        bt_entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edit_email.getText().toString();
                String senha = edit_senha.getText().toString();

                if (email.isEmpty() || senha.isEmpty()) {
                    Snackbar snackbar = Snackbar.make(v, mensagens[0], Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();
                } else AutenticarUsuario(v);
            }

            private void AutenticarUsuario(View v) {
                String email = edit_email.getText().toString();
                String senha = edit_senha.getText().toString();

                FirebaseAuth.getInstance().signInWithEmailAndPassword(email, senha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            progressBar.setVisibility(View.VISIBLE);

                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {

                                    TelaPrincipal();
                                }
                            }, 3000);
                        } else {

                            String erro;
                            try {
                                throw task.getException();
                            } catch (Exception e) {
                                erro = "Erro ao logar usuário";
                            }
                            Snackbar snackbar = Snackbar.make(v, erro, Snackbar.LENGTH_SHORT);
                            snackbar.setBackgroundTint(Color.WHITE);
                            snackbar.setTextColor(Color.BLACK);
                            snackbar.show();


                        }


                    }
                });
            }

        });


    }


    private void setFieldText() {
        edit_email.setText(sharedPrefGetEmail());
        edit_senha.setText(sharedPrefGetSenha());

    }

    private String sharedPrefGetSenha() {
        SharedPreferences sp = getSharedPreferences("AutoCompEmail", MODE_PRIVATE);
        String senha =  sp.getString("senha", "lol");
        return senha;
    }


    private String sharedPrefGetEmail() {
        SharedPreferences sp = getSharedPreferences("AutoCompEmail", MODE_PRIVATE);
        String email =  sp.getString("email", "lol");
        return email;

    }

    //    @Override
//    protected void onStart() {
//        super.onStart();
//        FirebaseUser usuarioAtual = FirebaseAuth.getInstance().getCurrentUser();
//        if(usuarioAtual!=null){
//            TelaPrincipal();
//        }
//    }




    private void TelaPrincipal() {
        Intent intent = new Intent(FormLogin.this, TelaPrincipal.class);
        startActivity(intent);
        finish();
    }

    private void IniciarComponentes() {
        text_tela_cadastro = findViewById(R.id.text_tela_cadastro);
        edit_email = findViewById(R.id.edit_email);
        edit_senha = findViewById(R.id.senha_login);
        bt_entrar = findViewById(R.id.bt_entrar);
        progressBar = findViewById(R.id.progress_bar);

    }
}