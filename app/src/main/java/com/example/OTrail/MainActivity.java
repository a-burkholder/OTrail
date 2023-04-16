package com.example.OTrail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.titlescreen);
        final Button start = findViewById(R.id.titleStart);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.titlescreen2);
                final Button toTrail = findViewById(R.id.title1);
                final Button toOTrailInfo = findViewById(R.id.title2);
                final Button toHattieInfo = findViewById(R.id.title3);
                final Button top10 = findViewById(R.id.title4);
                final Button graves = findViewById(R.id.title5);
                final Button options = findViewById(R.id.title6);
                toTrail.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MainActivity.this, OpenNames.class);
                        startActivity(intent);
                    }
                });
                toOTrailInfo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MainActivity.this, OpenTrailInfo.class);
                        startActivity(intent);
                    }
                });
                toHattieInfo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MainActivity.this, OpenHattieInfo.class);
                        startActivity(intent);
                    }
                });
                top10.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MainActivity.this, OpenTop.class);
                        startActivity(intent);
                    }
                });
                graves.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MainActivity.this, OpenGrave.class);
                        startActivity(intent);
                    }
                });
                options.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MainActivity.this, OpenOptions.class);
                        startActivity(intent);
                    }
                });
            }
        });
    }




}