package com.example.tcc.Modelo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tcc.Activity.TelaEsqueceuSenha;
import com.example.tcc.Activity.telaIncrever;
import com.example.tcc.Activity.telaInicial;
import com.example.tcc.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    Button btnEntrar;

    TextView inscrever;
    TextView redefinindo;

    String emailPattern = "[a-zA-Z0-9._-]+\\.+[a-z]+";
    ProgressDialog progressDialog;
    FirebaseAuth mAth;
    FirebaseUser mUser;

    EditText email;
    EditText senha;
    EditText SenhaConfirmar;

    int senhaaa;

    ArrayList<String> usuarioooo = new ArrayList();
    ArrayList<Integer> senhaaaa = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vincularComponentes();

            btnEntrar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    startActivity(new Intent(MainActivity.this, telaInicial.class));

                }
            });


        inscrever.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, telaIncrever.class));
            }
        });
        redefinindo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TelaEsqueceuSenha.class));

            }
        });

        email.setOnClickListener(event -> {
            email.setText("");
            nome();
        });

        senha.setOnClickListener(event -> {
            senha.setText("");
            senhaaaaaaaaaaaaaaaaaaaaaaaaaaaa();
        });

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PerforAuth();
            }
        });

    }

    private void PerforAuth() {
    String Email=email.getText().toString();
    String passoword = senha.getText().toString();
    String passowordConfere = SenhaConfirmar.getText().toString();

    if(!Email.matches(emailPattern)){

    email.setError("ENter Connext Email");

    }else if(passoword.isEmpty() || passoword.length()<6){

        senha.setError("Enter proper passord");

    }else if(passoword.equals(passowordConfere)){

        SenhaConfirmar.setError("Passoword Not match Both field");
    }else{
        progressDialog.setMessage("Please wait While Registration...");
        progressDialog.setTitle("Registration");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
        mAth.createUserWithEmailAndPassword(Email,passoword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    progressDialog.dismiss();
                    Toast.makeText(MainActivity.this, "Registaration Successful",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


    }

    public void nome() {
        usuarioooo.add(email.getText().toString());

    }

    public void senhaaaaaaaaaaaaaaaaaaaaaaaaaaaa() {
        senhaaaa.add(senhaaa);
    }

    public void vincularComponentes() {
        inscrever = findViewById(R.id.txtinscreverse);
        redefinindo = findViewById(R.id.txtredefinir);

        email = (EditText) findViewById(R.id.edit_email);
        senha = (EditText) findViewById(R.id.txnsenha);
        SenhaConfirmar = (EditText) findViewById(R.id.txnsenhaConfirmar);
        mAth = FirebaseAuth.getInstance();
        mUser = mAth.getCurrentUser();

        btnEntrar = findViewById(R.id.btnEntrar);

        progressDialog = new ProgressDialog(this);
    }





}
