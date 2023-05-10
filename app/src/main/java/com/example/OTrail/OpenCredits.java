package com.example.OTrail;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
/**
 * Programming 2 Oregon Trail Project
 * @author Alex Casada
 * @since April 23, 2023
 *
 * Description: OpenCredits is the layout that displays the sources of all
 * images and information used in the production of the game. It has 5 different pages to view,
 * each with fully unique sources
 */
public class OpenCredits extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Sets up the credits layout.
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.credits1);

        // Buttons for choosing which credit to view.
        Button credits1 = (Button) findViewById(R.id.credits1);
        Button credits2 = (Button) findViewById(R.id.credits2);
        Button credits3 = (Button) findViewById(R.id.credits3);
        Button credits4 = (Button) findViewById(R.id.credits4);
        Button credits5 = (Button) findViewById(R.id.credits5);
        Button exitToGame = (Button) findViewById(R.id.exitToGame);

        // Images of the groups of credits.
        ImageView creditsImage1 = findViewById(R.id.creditsImage1);
        ImageView creditsImage2 = findViewById(R.id.creditsImage2);
        ImageView creditsImage3 = findViewById(R.id.creditsImage3);
        ImageView creditsImage4 = findViewById(R.id.creditsImage4);
        ImageView creditsImage5 = findViewById(R.id.creditsImage5);

        // Automatically sets all credits to invisible.
        creditsImage1.setVisibility(View.INVISIBLE);
        creditsImage2.setVisibility(View.INVISIBLE);
        creditsImage3.setVisibility(View.INVISIBLE);
        creditsImage4.setVisibility(View.INVISIBLE);
        creditsImage5.setVisibility(View.INVISIBLE);

        // Sets credit 1 group to visible.
        credits1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                creditsImage1.setVisibility(View.VISIBLE);
                creditsImage2.setVisibility(View.INVISIBLE);
                creditsImage3.setVisibility(View.INVISIBLE);
                creditsImage4.setVisibility(View.INVISIBLE);
                creditsImage5.setVisibility(View.INVISIBLE);
            }
        });

        // Sets credit 2 group to visible.
        credits2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                creditsImage1.setVisibility(View.INVISIBLE);
                creditsImage2.setVisibility(View.VISIBLE);
                creditsImage3.setVisibility(View.INVISIBLE);
                creditsImage4.setVisibility(View.INVISIBLE);
                creditsImage5.setVisibility(View.INVISIBLE);
            }
        });

        // Sets credit 3 group to visible.
        credits3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                creditsImage1.setVisibility(View.INVISIBLE);
                creditsImage2.setVisibility(View.INVISIBLE);
                creditsImage3.setVisibility(View.VISIBLE);
                creditsImage4.setVisibility(View.INVISIBLE);
                creditsImage5.setVisibility(View.INVISIBLE);
            }
        });

        // Sets credit 4 group to visible.
        credits4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                creditsImage1.setVisibility(View.INVISIBLE);
                creditsImage2.setVisibility(View.INVISIBLE);
                creditsImage3.setVisibility(View.INVISIBLE);
                creditsImage4.setVisibility(View.VISIBLE);
                creditsImage5.setVisibility(View.INVISIBLE);
            }
        });

        // Sets credit 5 group to visible.
        credits5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                creditsImage1.setVisibility(View.INVISIBLE);
                creditsImage2.setVisibility(View.INVISIBLE);
                creditsImage3.setVisibility(View.INVISIBLE);
                creditsImage4.setVisibility(View.INVISIBLE);
                creditsImage5.setVisibility(View.VISIBLE);
            }
        });

        // Takes the player back to the game screen.
        exitToGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                finish();
            }
        });
    }
}