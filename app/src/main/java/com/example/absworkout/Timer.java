package com.example.absworkout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

public class Timer extends AppCompatActivity {

    private final long START_TIME = 60000;

    TextView time;
    ImageView play, stop, pause;

    SpringForce force;
    SpringAnimation anim;

    private MediaPlayer finish;

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

        finish = MediaPlayer.create(this, R.raw.sound);

        //BUTTONS
        play.setOnClickListener(view -> {
                startTimer();
                play.setVisibility(View.INVISIBLE);
                pause.setVisibility(View.VISIBLE);
                stop.setVisibility(View.VISIBLE);
                animX(stop, 200f);
                animX(pause, -200f);
                animX(play, -200f);
        });

        stop.setOnClickListener(view -> {
           resetTimer();
           animX(play, 0f);
           animX(stop, 0f);
           animX(pause, 0f);
           pause.setVisibility(View.INVISIBLE);
           play.setVisibility(View.VISIBLE);
           stop.setVisibility(View.INVISIBLE);

        });

        pause.setOnClickListener(view -> {
            pauseTimer();
            play.setVisibility(View.VISIBLE);
            pause.setVisibility(View.INVISIBLE);
        });
    }

    //TIMER
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
                sound(finish);
            }
        }.start();

        timerRunning = true;
    }



    //TIMER FUNCTIONS
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



    //SOUND
    private void sound(MediaPlayer sfx){
        sfx.start();
    }



    //ANIMATION
    private void animX(View view, float position){
        anim = new SpringAnimation(view, DynamicAnimation.TRANSLATION_X);
        force = new SpringForce();
        force.setStiffness(SpringForce.STIFFNESS_LOW);
        force.setFinalPosition(position);
        force.setDampingRatio(SpringForce.DAMPING_RATIO_LOW_BOUNCY);
        anim.setSpring(force);
        anim.start();
    }
}