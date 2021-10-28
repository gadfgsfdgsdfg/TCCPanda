package com.example.TelasBuscar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tcc.Activity.buscar;
import com.example.tcc.Activity.telaInicial;
import com.example.tcc.R;

import java.util.Calendar;

public class biblioteca_pop extends AppCompatActivity {

    ImageView pop1 , pop2 , pop3, pop4, voltarTela;
    TextView txtpop1, bomdia, txtpop2, txtpop3, txtpop4;

    int passarDados;

    int horasFormatadoss;

    ImageView imgcasabiblioteca;
    ImageView imgbibliotecabiblioteca;
    ImageView imgbuscarbiblioteca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biblioteca_pop);
        conectarDados();
        atualizarHora();
        passandoInformacao();

        imgcasabiblioteca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(biblioteca_pop.this, telaInicial.class));

            }
        });
        imgbuscarbiblioteca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(biblioteca_pop.this, buscar.class));

            }
        });
        imgbibliotecabiblioteca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(biblioteca_pop.this, biblioteca_pop.class));

            }
        });
        voltarTela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(biblioteca_pop.this, Tela_pop.class));
            }
        });




    }

    private void passandoInformacao() {

        //01
        pop1.setOnClickListener(event ->{
            startActivity(new Intent(biblioteca_pop.this,playerPop.class));
            Intent intent = new Intent(getApplicationContext(),playerPop.class);
            intent.putExtra("conta", "0");
            startActivity(intent);
        });
        txtpop1.setOnClickListener(Event->{
            startActivity(new Intent(biblioteca_pop.this,playerPop.class));
            Intent intent = new Intent(getApplicationContext(),playerPop.class);
            intent.putExtra("conta", "0");
            startActivity(intent);
        });

        //02
        pop2.setOnClickListener(event ->{
            startActivity(new Intent(biblioteca_pop.this,playerPop.class));
            Intent intent = new Intent(getApplicationContext(),playerPop.class);
            intent.putExtra("conta", "1");
            startActivity(intent);
        });
        txtpop2.setOnClickListener(Event->{
            startActivity(new Intent(biblioteca_pop.this,playerPop.class));
            Intent intent = new Intent(getApplicationContext(),playerPop.class);
            intent.putExtra("conta", "1");
            startActivity(intent);
        });


        //03
        pop3.setOnClickListener(event ->{
            startActivity(new Intent(biblioteca_pop.this,playerPop.class));
            Intent intent = new Intent(getApplicationContext(),playerPop.class);
            intent.putExtra("conta", "2");
            startActivity(intent);
        });
        txtpop3.setOnClickListener(Event->{
            startActivity(new Intent(biblioteca_pop.this,playerPop.class));
            Intent intent = new Intent(getApplicationContext(),playerPop.class);
            intent.putExtra("conta", "2");
            startActivity(intent);
        });

        //04
        pop4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(biblioteca_pop.this,playerPop.class));
                Intent intent = new Intent(getApplicationContext(),playerPop.class);
                intent.putExtra("conta", "3");
                startActivity(intent);
            }
        });
        txtpop4.setOnClickListener(Event->{
            startActivity(new Intent(biblioteca_pop.this,playerPop.class));
            Intent intent = new Intent(getApplicationContext(),playerPop.class);
            intent.putExtra("conta", "3");
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


        pop4 = findViewById(R.id.img04);
        txtpop4 = findViewById(R.id.txt04);

        pop3 = findViewById(R.id.img03);
        txtpop3 = findViewById(R.id.txt03);

        pop1 = findViewById(R.id.img01);
        txtpop1 = findViewById(R.id.txt01);

        pop2 = findViewById(R.id.img02);
        txtpop2 = findViewById(R.id.txt02);

        voltarTela = findViewById(R.id.imgvoltartela);
        imgbibliotecabiblioteca = findViewById(R.id.ImgBibliotecaBuscar);
        imgbuscarbiblioteca = findViewById(R.id.imgBuscarBuscar);
        imgcasabiblioteca = findViewById(R.id.ImgCasaBuscar);
    }


}