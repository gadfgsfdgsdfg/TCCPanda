package com.example.tcc.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.tcc.Modelo.MainActivity;
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




        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_tela_inicial);
            atualizarHora();

            imgConfiguracoess = findViewById(R.id.imgConfiguracoes);
            imgBuscarr = findViewById(R.id.imgBuscar);
            ImgBibliotecaa = findViewById(R.id.ImgBiblioteca);
            ImgCasaa = findViewById(R.id.ImgCasa);


            ImgBibliotecaa.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    startActivity(new Intent(telaInicial.this,telabiblioteca.class));

                }
            });


            imgBuscarr.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    startActivity(new Intent(telaInicial.this,buscar.class));

                }
            });


            imgConfiguracoess.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    startActivity(new Intent(telaInicial.this,telaConfiguracao.class));

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