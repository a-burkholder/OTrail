/**
 * Programming 2 Oregon Trail Project
 * @author Alexander Casada
 * @since April 22, 2023
 *
 * Description: The PartyActivity class sets up a layout that allows the player to see all party members
 * individual health, and also see if they are alive of dead.
 */

package com.example.OTrail;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PartyActivity extends AppCompatActivity
{
    private Party party;
    private String names[] = {"", "", "", "", ""};
    private int health[] = {100, 100, 100, 100, 100};

    /**
     * Default constructor for PartyActivity.
     */
    public PartyActivity() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //sets the layout
        super.onCreate(savedInstanceState);
        setContentView(R.layout.health);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        //grabs party data
        Intent intent = getIntent();
        party = (Party) intent.getSerializableExtra(MainGame.PARTY_TO_HEALTH);
        names = party.getNames();
        health = party.getHealth();

        //for testing
        if(party.getNames() == null) {
            System.out.println("party get names is null and the start of PartyActivity");
        }

        //deals with death-cross sprites
        final ImageView hattieDead = findViewById(R.id.hattieDead);
        final ImageView member2Dead = findViewById(R.id.member2Dead);
        final ImageView member3Dead = findViewById(R.id.member3Dead);
        final ImageView member4Dead = findViewById(R.id.member4Dead);
        final ImageView petDead = findViewById(R.id.petDead);
        if(health[0] > 0) {
            hattieDead.setVisibility(View.GONE);
        }
        if(health[1] > 0) {
            member2Dead.setVisibility(View.GONE);
        }
        if(health[2] > 0) {
            member3Dead.setVisibility(View.GONE);
        }
        if(health[3] > 0) {
            member4Dead.setVisibility(View.GONE);
        }
        if(health[4] > 0) {
            petDead.setVisibility(View.GONE);
        }

        //displays party member names
        final TextView member2 = findViewById(R.id.member2);
        final TextView member3 = findViewById(R.id.member3);
        final TextView member4 = findViewById(R.id.member4);
        final TextView pet = findViewById(R.id.pet);
        final TextView hattieHealth = findViewById(R.id.hattieHealth);
        final TextView member2Health = findViewById(R.id.member2Health);
        final TextView member3Health = findViewById(R.id.member3Health);
        final TextView member4Health = findViewById(R.id.member4Health);
        final TextView petHealth = findViewById(R.id.petHealth);
        member2.setText(names[1]);
        member3.setText(names[2]);
        member4.setText(names[3]);
        pet.setText(names[4]);

        //displays party member health
        hattieHealth.setText("Health: " + String.valueOf(health[0]) + " / 100");
        member2Health.setText("Health: " + String.valueOf(health[1]) + " / 100");
        member3Health.setText("Health: " + String.valueOf(health[2]) + " / 100");
        member4Health.setText("Health: " + String.valueOf(health[3]) + " / 100");
        petHealth.setText("Health: " + String.valueOf(health[4]) + " / 100");

        //button for returning to the main loop
        Button continueAlongTrail = (Button) findViewById(R.id.continueAlongTheTrail);
        continueAlongTrail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
