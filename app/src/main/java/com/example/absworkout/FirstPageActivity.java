package com.example.absworkout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class FirstPageActivity extends AppCompatActivity {

    private ImageView b1, b2, b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);

        b1 = findViewById(R.id.imageView3);
        b2 = findViewById(R.id.imageView4);
        b3 = findViewById(R.id.imageView5);

        b1.setOnClickListener(onclick);
        b2.setOnClickListener(onclick);
        b3.setOnClickListener(onclick);
    }

    View.OnClickListener onclick = view -> {
        Log.e(String.valueOf(FirstPageActivity.this), "CLick");
        Context context = FirstPageActivity.this;
        Intent intent = new Intent(context, MainActivity.class);
        startActivity(intent);
    };
}