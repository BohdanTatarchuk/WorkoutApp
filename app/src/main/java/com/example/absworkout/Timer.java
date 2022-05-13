package com.example.absworkout;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

public class Timer extends AppCompatActivity {

    private final long START_TIME = 60000;

    TextView time;
    ImageView play, stop, pause;

    Animation anim = null;

    CountDownTimer timer;
    boolean timerRunning;
    long timeLeft = START_TIME;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        time = findViewById(R.id.time);
        play = findViewById(R.id.play);
        stop = findViewById(R.id.stop);
        pause = findViewById(R.id.pause);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    startTimer();
                    play.setVisibility(View.INVISIBLE);
                    pause.setVisibility(View.VISIBLE);
                    stop.setVisibility(View.VISIBLE);
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               resetTimer();
               pause.setVisibility(View.INVISIBLE);
               play.setVisibility(View.VISIBLE);
               stop.setVisibility(View.INVISIBLE);
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pauseTimer();
                play.setVisibility(View.VISIBLE);
                pause.setVisibility(View.INVISIBLE);
            }
        });
    }

    private void startTimer(){
        timer = new CountDownTimer(timeLeft, 1000) {
            @Override
            public void onTick(long l) {
                timeLeft = l;
                updateTime();
            }

            @Override
            public void onFinish() {
                timerRunning = false;
                play.setVisibility(View.VISIBLE);
                pause.setVisibility(View.INVISIBLE);
                stop.setVisibility(View.INVISIBLE);
            }
        }.start();

        timerRunning = true;
    }

    private void pauseTimer(){
        timer.cancel();
        timerRunning = false;
    }

    private void resetTimer(){
       timeLeft = START_TIME;
       pauseTimer();
       updateTime();
    }

    private void updateTime(){
        int minutes = (int) (timeLeft/1000)/60;
        int seconds = (int) (timeLeft/1000) % 60;

        String format = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        time.setText(format);
    }
}