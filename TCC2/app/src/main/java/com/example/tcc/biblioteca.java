package com.example.tcc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.tcc.R;

import java.util.Calendar;

public class
biblioteca extends AppCompatActivity {

    int horasFormatadoss;
    TextView bomdia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_biblioteca);

         atualizarHora();

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

}