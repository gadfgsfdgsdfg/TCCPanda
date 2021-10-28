package com.example.tcc.Modelo;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tcc.Activity.telaIncrever;
import com.example.tcc.Activity.telaInicial;
import com.example.tcc.R;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;


public class MainActivity extends AppCompatActivity {


    private SignInButton signInButton;
    private GoogleSignInClient mGoogleSignInClient;
    private String TAG = "MainActivity";
    private FirebaseAuth mAuth;
    private int RC_SING_IN = 1;


    private EditText etEmail;
    private EditText etSenha;
    private Button btnEntrar;
    private Usuario u;


    TextView btnIncreverr;
    TextView btnRedefinirSenha;
    TextView btnPreferenciass;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signInButton = findViewById(R.id.btnGoogle);


        mAuth = FirebaseAuth.getInstance();
        etEmail = findViewById(R.id.etEmail);
        etSenha = findViewById(R.id.etSenha);
        btnEntrar = findViewById(R.id.btnEntrar);

        btnIncreverr = findViewById(R.id.btnIncrever);
        btnRedefinirSenha = findViewById(R.id.btnRedefinirSenha);


        btnRedefinirSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                RecuperarSenha();


            }
        });


        GoogleSignInOptions gso=new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                signIn();
            }
        });

        btnIncreverr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity.this,telaIncrever.class));

            }
        });




        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mAuth.signOut();
                receberDados();
                logar();
                startActivity(new Intent(MainActivity.this,telaInicial.class));

            }
        });

    }

    private void RecuperarSenha() {

        String ema= etEmail.getText().toString();
        if(ema.isEmpty()){

            Toast.makeText(getBaseContext(),"Insira pelo menos seu E-mail para poder  Recuperar sua senha",Toast.LENGTH_LONG);

        }else{
            etEmail.setText(ema);
            EnviarEmail(ema);

        }

    }

    private void EnviarEmail(String etEmail) {

        mAuth.sendPasswordResetEmail(etEmail).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {

                Toast.makeText(getBaseContext(), "Enviamos uma MSG para o seu email com um link para você redefinir a sua senha",
                        Toast.LENGTH_LONG).show();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

                String erro = e.toString();
                Util.opcoesErro(getBaseContext(), erro);

            }
        });

    }



    private void logar() {

        mAuth.signInWithEmailAndPassword(u.getEmail(), u.getSenha())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = mAuth.getCurrentUser();
                            startActivity(new Intent(MainActivity.this,telaInicial.class));
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(MainActivity.this, "Autenticação falhou.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }

    private void receberDados() {
        u = new Usuario();

        u.setEmail(etEmail.getText().toString());
        u.setSenha(etSenha.getText().toString());


    }

    private void signIn(){

        Intent signIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signIntent, RC_SING_IN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        try {
            if (requestCode == RC_SING_IN) {
                Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
                HandleSingInResult(task);

            }
        }catch (Exception e){

        }
    }

    private void HandleSingInResult(Task<GoogleSignInAccount> completedrTask){

        try {
            try {
                GoogleSignInAccount acc = completedrTask.getResult(ApiException.class);
                Toast.makeText(MainActivity.this, "Conectado com sucesso", Toast.LENGTH_SHORT).show();
                FirebaseGoogleAuth(acc);

            } catch (ApiException e) {

                Toast.makeText(MainActivity.this, "A entrada falhou", Toast.LENGTH_SHORT).show();
                FirebaseGoogleAuth(null);
            }
        }catch (Exception e){

        }
    }
    private  void  FirebaseGoogleAuth(GoogleSignInAccount acct){

        AuthCredential authCredential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        mAuth.signInWithCredential(authCredential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()) {

                    Toast.makeText(MainActivity.this,"Com sucesso", Toast.LENGTH_SHORT).show();
                    FirebaseUser user = mAuth.getCurrentUser();
                    updateUI(user);
                }else{

                    Toast.makeText(MainActivity.this,"Sem sucesso", Toast.LENGTH_SHORT).show();
                    updateUI(null);

                }
            }
        });
    }

    private void updateUI(FirebaseUser fUser){
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(getApplicationContext());
        if(account != null){
            String personName = account.getDisplayName();
            String personGivenName = account.getGivenName();
            String personFamilyName = account.getFamilyName();
            String personEmail = account.getEmail();
            String personId = account.getId();
            Uri personPhoto = account.getPhotoUrl();

            Toast.makeText(MainActivity.this,personName + personEmail,Toast.LENGTH_SHORT).show();
        }

    }

}

