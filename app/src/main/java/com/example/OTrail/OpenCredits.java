package com.example.OTrail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

public class OpenCredits extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.credits1);

        Button credits1 = (Button) findViewById(R.id.credits1);
        Button credits2 = (Button) findViewById(R.id.credits2);
        Button credits3 = (Button) findViewById(R.id.credits3);
        Button credits4 = (Button) findViewById(R.id.credits4);
        Button credits5 = (Button) findViewById(R.id.credits5);
        Button exitToGame = (Button) findViewById(R.id.exitToGame);

        ImageView creditsImage1 = findViewById(R.id.creditsImage1);
        ImageView creditsImage2 = findViewById(R.id.creditsImage2);
        ImageView creditsImage3 = findViewById(R.id.creditsImage3);
        ImageView creditsImage4 = findViewById(R.id.creditsImage4);
        ImageView creditsImage5 = findViewById(R.id.creditsImage5);

        creditsImage1.setVisibility(View.INVISIBLE);
        creditsImage2.setVisibility(View.INVISIBLE);
        creditsImage3.setVisibility(View.INVISIBLE);
        creditsImage4.setVisibility(View.INVISIBLE);
        creditsImage5.setVisibility(View.INVISIBLE);

        credits1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                creditsImage1.setVisibility(View.VISIBLE);
                creditsImage2.setVisibility(View.INVISIBLE);
                creditsImage3.setVisibility(View.INVISIBLE);
                creditsImage4.setVisibility(View.INVISIBLE);
                creditsImage5.setVisibility(View.INVISIBLE);
            }
        });

        credits2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                creditsImage1.setVisibility(View.INVISIBLE);
                creditsImage2.setVisibility(View.VISIBLE);
                creditsImage3.setVisibility(View.INVISIBLE);
                creditsImage4.setVisibility(View.INVISIBLE);
                creditsImage5.setVisibility(View.INVISIBLE);
            }
        });

        credits3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                creditsImage1.setVisibility(View.INVISIBLE);
                creditsImage2.setVisibility(View.INVISIBLE);
                creditsImage3.setVisibility(View.VISIBLE);
                creditsImage4.setVisibility(View.INVISIBLE);
                creditsImage5.setVisibility(View.INVISIBLE);
            }
        });

        credits4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                creditsImage1.setVisibility(View.INVISIBLE);
                creditsImage2.setVisibility(View.INVISIBLE);
                creditsImage3.setVisibility(View.INVISIBLE);
                creditsImage4.setVisibility(View.VISIBLE);
                creditsImage5.setVisibility(View.INVISIBLE);
            }
        });

        credits5.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                creditsImage1.setVisibility(View.INVISIBLE);
                creditsImage2.setVisibility(View.INVISIBLE);
                creditsImage3.setVisibility(View.INVISIBLE);
                creditsImage4.setVisibility(View.INVISIBLE);
                creditsImage5.setVisibility(View.VISIBLE);
            }
        });

        exitToGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                finish();
            }
        });
    }
}