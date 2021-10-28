package com.example.TelasBuscar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.tcc.Activity.Telabiblioteca;
import com.example.tcc.R;

import java.util.ArrayList;


public class playerPop extends AppCompatActivity {

    ImageView play, prev, next, imageVeiw , voltar;
    TextView songTitle;
    SeekBar mSeekBarTime, mSeekBarVol;
    static MediaPlayer mMediaPlayer;
    private Runnable runnable;
    private AudioManager mAudioManager;
    int currentIndex;


    public int getCurrentIndex() {
        return currentIndex;
    }
    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_pop);


        Intent intent = getIntent();
        String valores = intent.getStringExtra("conta");
        currentIndex = Integer.parseInt(valores);

        play = findViewById(R.id.imgPlayy);
        voltar = findViewById(R.id.More);
        prev = findViewById(R.id.prev);
        next = findViewById(R.id.next);
        imageVeiw = findViewById(R.id.image_view);
        songTitle = findViewById(R.id.song_title);
        mSeekBarTime = findViewById(R.id.seek_bar_time);
        mSeekBarVol = findViewById(R.id.seek_bar_timyyy);

        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        final ArrayList<Integer> songs = new ArrayList<>();
        songs.add(R.raw.aqueda01);
        songs.add(R.raw.adeleeasyonme02);
        songs.add(R.raw.fakinglovefeatsaweetie03);
        songs.add(R.raw.gaabessasemana04);

        mMediaPlayer = MediaPlayer.create(getApplicationContext(),songs.get(currentIndex));
        int maxV = mAudioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int curV = mAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        mSeekBarVol.setMax(maxV);
        mSeekBarVol.setProgress(curV);

        mSeekBarVol.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSeekBarTime.setMax(mMediaPlayer.getDuration());
                if (mMediaPlayer != null && mMediaPlayer.isPlaying()) {
                    mMediaPlayer.pause();
                    play.setImageResource(R.drawable.ic_play);
                } else {
                    mMediaPlayer.start();
                    play.setImageResource(R.drawable.ic_pause);
                }
                songDetails();
            }
        });

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(playerPop.this, biblioteca_pop.class));


                if(mMediaPlayer.isPlaying()){
                    mMediaPlayer.stop();
                }
            }

        });


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mMediaPlayer != null){
                    play.setImageResource(R.drawable.ic_pause);
                }
                if(currentIndex < songs.size() - 1){
                    currentIndex++;
                }else{
                    currentIndex = 0;
                }
                if(mMediaPlayer.isPlaying()){
                    mMediaPlayer.stop();
                }
                mMediaPlayer = MediaPlayer.create(getApplicationContext(),songs.get(currentIndex));
                mMediaPlayer.start();
                songDetails();
            }
        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mMediaPlayer != null){
                    play.setImageResource(R.drawable.ic_pause);
                }
                if(currentIndex > 0 ){
                    currentIndex--;
                }else{
                    currentIndex = songs.size() -1;
                }
                if(mMediaPlayer.isPlaying()){
                    mMediaPlayer.stop();
                }
                mMediaPlayer = MediaPlayer.create(getApplicationContext(),songs.get(currentIndex));
                mMediaPlayer.start();
                songDetails();


            }
        });

        mSeekBarTime.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser){
                    mMediaPlayer.seekTo(progress);
                    mSeekBarTime.setProgress(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



    }
    private void songDetails(){
        if(currentIndex == 0){
            songTitle.setText("Gloria Groove - A Queda.");
            imageVeiw.setImageResource(R.drawable._1);
        }
        if(currentIndex == 1){
            songTitle.setText("Adele - Easy on me.");
            imageVeiw.setImageResource(R.drawable._2);
        }
        if(currentIndex == 2){
            songTitle.setText("Annita feat:Saweetíe - Fanking Love.");
            imageVeiw.setImageResource(R.drawable._3);
        }
        if(currentIndex == 3){
            songTitle.setText("Gaab - Essa Semana.");
            imageVeiw.setImageResource(R.drawable._4);
        }

        mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mSeekBarTime.setMax(mMediaPlayer.getDuration());
                mMediaPlayer.start();
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (mMediaPlayer != null){
                    try{
                        if(mMediaPlayer.isPlaying()){
                            Message message = new Message();
                            message.what = mMediaPlayer.getCurrentPosition();
                            handler.sendMessage(message);
                            Thread.sleep(1000);
                        }
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }
    @SuppressLint("HandlerLeak")
    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            mSeekBarTime.setProgress(msg.what);
        }
    };
}