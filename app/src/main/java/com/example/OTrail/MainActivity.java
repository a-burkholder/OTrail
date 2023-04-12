package com.example.OTrail;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.titlescreen);
        final Button start = findViewById(R.id.titleStart);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.titlescreen2);
                final Button toTrail = findViewById(R.id.title1);
                final Button toOTrailInfo = findViewById(R.id.title2);
                final Button toCattieInfo = findViewById(R.id.title3);
                final Button top10 = findViewById(R.id.title4);
                final Button graves = findViewById(R.id.title5);
                final Button options = findViewById(R.id.title6);
                toTrail.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Player is able to set Hattie's family members/pet names.
                        setContentView(R.layout.name_input);
                        //Display blurb about starting cash, what they could buy, and what they should buy.  (maybe add lore here based on class)
                        //Display graphic for "Beginning the journey"
                        //The main loop of the Oregon Trail game. Only runs if the player is not yet at the first fort (250 miles away) and their game is not yet over.
                            //MAIN LOOP
                    }
                });
                toOTrailInfo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        setContentView(R.layout.trail_info);
                    }
                });
                toCattieInfo.setOnClickListener(new View.OnClickListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onClick(View view) {
                        setContentView(R.layout.cattie_info);
                        final TextView hattietext = findViewById(R.id.hattieinfo);
                        hattietext.setText("@strings/hattie_info1");
                        //then wait for user to ask for next box.
                        hattietext.setText("@strings/hattie_info2");
                        //then wait for user to ask for next box.
                        hattietext.setText("@strings/hattie_info3");
                        //then wait for user to ask for return to menu.
                    }
                });
                top10.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        setContentView(R.layout.top_10);
                    }
                });
                graves.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        setContentView(R.layout.graveyard);
                    }
                });
                options.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        setContentView(R.layout.options);
                    }
                });
            }
        });
    }




}