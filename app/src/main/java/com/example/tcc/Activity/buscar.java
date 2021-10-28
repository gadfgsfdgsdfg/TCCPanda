package com.example.tcc.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.TelasBuscar.Tela_Shows;
import com.example.TelasBuscar.Tela_paradas;
import com.example.TelasBuscar.Tela_podcast;
import com.example.TelasBuscar.Tela_pop;
import com.example.tcc.R;

public class buscar extends AppCompatActivity {

    ImageView imgcasabuscar;
    ImageView imgbibliotecabuscar;
    ImageView imgbuscarbuscar;

    TextView txtpodcast;
    ImageView imgpodcast;

    TextView txtpop;
    ImageView imgpop;

    TextView txtparadas;
    ImageView imgparadas;

    TextView txtshows;
    ImageView imgshows;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);

       imgbibliotecabuscar = findViewById(R.id.ImgBibliotecaBuscar);
       imgcasabuscar = findViewById(R.id.ImgCasaBuscar);
       imgbuscarbuscar = findViewById(R.id.imgBuscarBuscar);

       txtpodcast = findViewById(R.id.txtpodcast);
       imgpodcast = findViewById(R.id.imgpodcast);

        txtpop = findViewById(R.id.txtpop);
        imgpop = findViewById(R.id.imgpop);

        txtparadas = findViewById(R.id.txt02);
        imgparadas  = findViewById(R.id.imgparadas );

        txtshows= findViewById(R.id.txtshows);
        imgshows = findViewById(R.id.imgshows);


       txtpodcast.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               startActivity(new Intent(buscar.this, Tela_podcast.class));

           }
       });
        imgpodcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(buscar.this, Tela_podcast.class));

            }
        });


        txtpop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(buscar.this, Tela_pop.class));

            }
        });
        imgpop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(buscar.this, Tela_pop.class));

            }
        });

        txtparadas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(buscar.this, Tela_paradas.class));

            }
        });
        imgparadas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(buscar.this, Tela_paradas.class));

            }
        });


        txtshows.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(buscar.this, Tela_Shows.class));

            }
        });
        imgshows.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(buscar.this, Tela_Shows.class));

            }
        });



       imgbibliotecabuscar.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               startActivity(new Intent(buscar.this,Telabiblioteca.class));

           }
       });
        imgcasabuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(buscar.this,telaInicial.class));

            }
        });
        imgbuscarbuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(buscar.this,buscar.class));

            }
        });




    }
}