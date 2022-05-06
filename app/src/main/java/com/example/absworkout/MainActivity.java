package com.example.absworkout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView block;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        block  = findViewById(R.id.item1);
        block.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(String.valueOf(MainActivity.this), "CLick");
            }
        });
    }
}