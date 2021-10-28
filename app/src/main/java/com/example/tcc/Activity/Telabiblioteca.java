package com.example.tcc.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tcc.R;

import java.util.Calendar;

public class Telabiblioteca extends AppCompatActivity {

    ImageView pericles , henrique_juliano , matue, racionais, metalica;
    TextView txtpericles, bomdia, txtMetaliaca, txtmatue, txtracionais, txthenriquejuliano;

    int passarDados;

    int horasFormatadoss;

    ImageView imgcasabiblioteca;
    ImageView imgbibliotecabiblioteca;
    ImageView imgbuscarbiblioteca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_biblioteca);
        conectarDados();
        atualizarHora();
        passandoInformacao();

        imgcasabiblioteca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Telabiblioteca.this,telaInicial.class));

            }
        });
        imgbuscarbiblioteca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Telabiblioteca.this,buscar.class));

            }
        });
        imgbibliotecabiblioteca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Telabiblioteca.this,Telabiblioteca.class));

            }
        });





    }

    private void passandoInformacao() {

        //Pagode
        pericles.setOnClickListener(event ->{
            startActivity(new Intent(Telabiblioteca.this,PlayerActivity.class));
            Intent intent = new Intent(getApplicationContext(),PlayerActivity.class);
            intent.putExtra("valor", "0");
            startActivity(intent);
        });
        txtpericles.setOnClickListener(event ->{
            startActivity(new Intent(Telabiblioteca.this,PlayerActivity.class));
            Intent intent = new Intent(getApplicationContext(),PlayerActivity.class);
            intent.putExtra("valor", "0");
            startActivity(intent);
        });

        //Rock
        metalica.setOnClickListener(event ->{
            startActivity(new Intent(Telabiblioteca.this,PlayerActivity.class));
            Intent intent = new Intent(getApplicationContext(),PlayerActivity.class);
            intent.putExtra("valor", "1");
            startActivity(intent);
        });
        txtMetaliaca.setOnClickListener(Event->{
            startActivity(new Intent(Telabiblioteca.this,PlayerActivity.class));
            Intent intent = new Intent(getApplicationContext(),PlayerActivity.class);
            intent.putExtra("valor", "1");
            startActivity(intent);
        });

        //Rap
        racionais.setOnClickListener(event ->{
            startActivity(new Intent(Telabiblioteca.this,PlayerActivity.class));
            Intent intent = new Intent(getApplicationContext(),PlayerActivity.class);
            intent.putExtra("valor", "2");
            startActivity(intent);
        });
        txtracionais.setOnClickListener(Event->{
            startActivity(new Intent(Telabiblioteca.this,PlayerActivity.class));
            Intent intent = new Intent(getApplicationContext(),PlayerActivity.class);
            intent.putExtra("valor", "2");
            startActivity(intent);
        });


        //trap
        matue.setOnClickListener(event ->{
            startActivity(new Intent(Telabiblioteca.this,PlayerActivity.class));
            Intent intent = new Intent(getApplicationContext(),PlayerActivity.class);
            intent.putExtra("valor", "3");
            startActivity(intent);
        });
        txtmatue.setOnClickListener(Event->{
            startActivity(new Intent(Telabiblioteca.this,PlayerActivity.class));
            Intent intent = new Intent(getApplicationContext(),PlayerActivity.class);
            intent.putExtra("valor", "3");
            startActivity(intent);
        });

        //Sertanejo
        henrique_juliano.setOnClickListener(event ->{
            startActivity(new Intent(Telabiblioteca.this,PlayerActivity.class));
            Intent intent = new Intent(getApplicationContext(),PlayerActivity.class);
            intent.putExtra("valor", "4");
            startActivity(intent);
        });
        txthenriquejuliano.setOnClickListener(Event->{
            startActivity(new Intent(Telabiblioteca.this,PlayerActivity.class));
            Intent intent = new Intent(getApplicationContext(),PlayerActivity.class);
            intent.putExtra("valor", "4");
            startActivity(intent);
        });

    }


    public void atualizarHora(){
        bomdia = findViewById(R.id.txtBomdia);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());

        String horasFormatados = String.format("%02d", calendar.get(Calendar.HOUR_OF_DAY));

        horasFormatadoss = Integer.parseInt(horasFormatados);

        if(horasFormatadoss >= 12 && horasFormatadoss <= 18){
            bomdia.setText("Boa Tarde");
        }
        if(horasFormatadoss >= 18 && horasFormatadoss <= 24){
            bomdia.setText("Boa Noite");
        }
        if(horasFormatadoss >= 0 && horasFormatadoss <= 12){
            bomdia.setText("Bom Dia");
        }
    }

    public void conectarDados(){
        henrique_juliano = findViewById(R.id.imghenriqueeJuliano);
        txthenriquejuliano = findViewById(R.id.txthenriqueejuliano);

        matue = findViewById(R.id.imgmatue);
        txtmatue = findViewById(R.id.txt04);

        racionais = findViewById(R.id.imgpop);
        txtracionais = findViewById(R.id.txt03);

        pericles = findViewById(R.id.imgPericles);
        txtpericles = findViewById(R.id.txt01);

        metalica = findViewById(R.id.imgparadas);
        txtMetaliaca = findViewById(R.id.txt02);

        imgbibliotecabiblioteca = findViewById(R.id.ImgBibliotecaBuscar);
        imgbuscarbiblioteca = findViewById(R.id.imgBuscarBuscar);
        imgcasabiblioteca = findViewById(R.id.ImgCasaBuscar);
    }


}