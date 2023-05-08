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
        //no title bar and set layout
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.titlescreen);

        //button for continueing
        final Button start = findViewById(R.id.titleStart);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //set layout
                setContentView(R.layout.titlescreen2);

                //play game button
                final Button toTrail = findViewById(R.id.title1);
                toTrail.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MainActivity.this, OpenNames.class);
                        startActivity(intent);
                        finish();
                    }
                });

                //info button
                final Button toOTrailInfo = findViewById(R.id.title2);
                toOTrailInfo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MainActivity.this, OpenTrailInfo.class);
                        startActivity(intent);
                    }
                });

                //hattie story button
                final Button toHattieInfo = findViewById(R.id.title3);
                toHattieInfo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MainActivity.this, OpenHattieInfo.class);
                        startActivity(intent);
                    }
                });

                //credits
                final Button options = findViewById(R.id.title6);
                options.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MainActivity.this, OpenCredits.class);
                        startActivity(intent);
                    }
                });
            }
        });
    }




}