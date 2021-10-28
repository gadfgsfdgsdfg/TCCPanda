package com.example.tcc.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.tcc.R;

import java.util.Calendar;

import static com.example.tcc.R.*;

public class telaInicial extends AppCompatActivity {


    TextView bomdia;
    int horasFormatadoss;

    ImageView imgConfiguracoess;
    ImageView ImgCasaa;
    ImageView ImgBibliotecaa;
    ImageView imgBuscarr;
    ImageView imgLapis;




        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_tela_inicial);
            atualizarHora();

            imgLapis = findViewById(id.imgLapis);
            imgConfiguracoess = findViewById(R.id.imgConfiguracoes);
            imgBuscarr = findViewById(R.id.imgBuscarBuscar);
            ImgBibliotecaa = findViewById(R.id.ImgBibliotecaBuscar);
            ImgCasaa = findViewById(R.id.ImgCasaBuscar);



            imgLapis.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    startActivity(new Intent(telaInicial.this,partitura.class));

                }
            });

            ImgCasaa.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    startActivity(new Intent(telaInicial.this,telaInicial.class));

                }
            });

            ImgBibliotecaa.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                 startActivity(new Intent(telaInicial.this,Telabiblioteca.class));

                }
            });


            imgBuscarr.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    startActivity(new Intent(telaInicial.this,buscar.class));

                }
            });






         }


          public void atualizarHora(){
           bomdia = findViewById(id.txtBomdia);
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




}