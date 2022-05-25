package com.example.absworkout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ConstraintLayout block1, block2, block3, block4, block5, block6;
    private final static String TAG = "TAG";

    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       getCurrentTime();

        block1  = findViewById(R.id.block1);
        block2  = findViewById(R.id.block2);
        block3  = findViewById(R.id.block3);
        block4  = findViewById(R.id.block4);
        block5  = findViewById(R.id.block5);
        block6  = findViewById(R.id.block6);

        text = findViewById(R.id.text);

        View.OnClickListener onClickListener = view -> {
            Log.e(String.valueOf(MainActivity.this), "CLick");
            Context context = MainActivity.this;
            Intent intent = new Intent(context, Timer.class);
            startActivity(intent);
        };

        block1.setOnClickListener(onClickListener);
        block2.setOnClickListener(onClickListener);
        block3.setOnClickListener(onClickListener);
        block4.setOnClickListener(onClickListener);
        block5.setOnClickListener(onClickListener);
        block6.setOnClickListener(onClickListener);
    }

    private Date getCurrentTime(){
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        Log.e(TAG, formatter.format(date));
        return date;
    }

}