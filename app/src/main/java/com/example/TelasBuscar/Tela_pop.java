package com.example.TelasBuscar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tcc.R;

public class Tela_pop extends AppCompatActivity {

    ImageView imgPopBrasil;
    TextView txtPopBrasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_pop);

        imgPopBrasil = findViewById(R.id.imgPopBrasil);
        txtPopBrasil = findViewById(R.id.txtPopBrasil);

        imgPopBrasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Tela_pop.this,biblioteca_pop.class));

            }
        });

        txtPopBrasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Tela_pop.this,biblioteca_pop.class));

            }
        });
    }
}