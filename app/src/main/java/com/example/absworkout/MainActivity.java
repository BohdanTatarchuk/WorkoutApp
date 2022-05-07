package com.example.absworkout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ConstraintLayout block1, block2, block3, block4, block5, block6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        block1  = findViewById(R.id.block1);
        block2  = findViewById(R.id.block2);
        block3  = findViewById(R.id.block3);
        block4  = findViewById(R.id.block4);
        block5  = findViewById(R.id.block5);
        block6  = findViewById(R.id.block6);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e(String.valueOf(MainActivity.this), "CLick");
                Context context = MainActivity.this;
                Intent intent = new Intent(context, Timer.class);
                startActivity(intent);
            }
        };

        block1.setOnClickListener(onClickListener);
        block2.setOnClickListener(onClickListener);
        block3.setOnClickListener(onClickListener);
        block4.setOnClickListener(onClickListener);
        block5.setOnClickListener(onClickListener);
        block6.setOnClickListener(onClickListener);
    }
}