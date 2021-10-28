package com.example.tcc.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.Toast;

import com.example.tcc.Modelo.MainActivity;
import com.example.tcc.Modelo.Usuario;
import com.example.tcc.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class telaIncrever extends AppCompatActivity {

    private EditText etEmail;
    private EditText etSenha;
    private EditText etConfirmarSenha;
    private EditText etDia;
    private EditText etMes;
    private EditText etAno;
    private Switch sMasculino;
    private Switch sFeminino;
    private Switch sOutros;
    private Button btnCadastrar;
    private FirebaseAuth mAuth;
    private Usuario u;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inscrever);

        etEmail = findViewById(R.id.edtEmail);
        etSenha = findViewById(R.id.edtSenha);
        etConfirmarSenha = findViewById(R.id.edtConfirmarSenha);
        etDia = findViewById(R.id.edtDia);
        etMes = findViewById(R.id.edtMes);
        etAno = findViewById(R.id.edtAno);
        sMasculino = findViewById(R.id.sMasculino);
        sFeminino = findViewById(R.id.sFeminino);
        sOutros = findViewById(R.id.sOutros);
        mAuth = FirebaseAuth.getInstance();

        btnCadastrar = findViewById(R.id.btnCadastrar);


        etAno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(etAno.getHint().equals("Ano")){
                    etAno.setHint("");

                }

            }
        });

        etMes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(etMes.getHint().equals("Mês")){
                    etMes.setHint("");

                }

            }
        });
        etDia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(etDia.getHint().equals("Dia")){
                    etDia.setHint("");

                }
            }
        });
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recuperarDados();
                criarLogin();

            }
        });

    }

    private void criarLogin() {
        mAuth.createUserWithEmailAndPassword(u.getEmail(), u.getSenha())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){


                            FirebaseUser user = mAuth.getCurrentUser();
                            u.setId(user.getUid());
                            u.salvardados();
                            startActivity(new Intent(telaIncrever.this,telaInicial.class ));

                        }else{

                            Toast.makeText(telaIncrever.this,"Erro ao criar um login",Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    }

    private void recuperarDados() {

        if (etEmail.getText().toString() == "" || etSenha.getText().toString() == "" || etConfirmarSenha.getText().toString() == "" || etDia.getText().toString() == "" || etMes.getText().toString() == "" || etAno.getText().toString() == "") {
            ;
            Toast.makeText(this, "Você deve preencher todos os dados", Toast.LENGTH_LONG);

        } else {
             u = new Usuario();
             u.setEmail(etEmail.getText().toString());
             u.setSenha(etSenha.getText().toString());
             u.setConfirmarSenha(etConfirmarSenha.getText().toString());
             u.setDia(etDia.getText().toString());
             u.setMes(etMes.getText().toString());
             u.setAno(etAno.getText().toString());
             u.setMasculino(sMasculino.getShowText());
             u.setFeminino(sFeminino.getShowText());
             u.setOutros(sOutros.getShowText());
        }
    }
}