package com.example.tcc.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import java.util.Timer;
import java.util.TimerTask;

import com.example.tcc.Modelo.MainActivity;
import com.example.tcc.R;

public class TelaDeAberturaa extends AppCompatActivity {

    @SuppressLint("MissingSuperCall")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_de_abertura);
        final Timer timer = new Timer();
        TimerTask timerTask;

            timerTask = new TimerTask() {
                @Override
                public void run() {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            gotoMainActivity();
                        }

                        private void gotoMainActivity() {
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                            finish();
                        }
                    });
                }
            };
            timer.schedule(timerTask, 3000);
    }
}