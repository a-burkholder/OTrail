/**
 * Programming 2 Oregon Trail Project
 * @author Alexander Casada
 * @since April 30, 2023
 *
 * Description: This class allows the player to change the speed that they travel at. They can travel
 * at a speed of EASY, MEDIUM, or EXTREME. For each of these speeds the player's party will move at
 * 10 miles, 12 miles, or 15 miles a day respectively. Additionally, the faster your party travels,
 * the more food you will use.
 */

package com.example.OTrail;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;

public class SpeedActivity extends AppCompatActivity
{
    public static final String POST_GAME_SPEED = "com.example.OTrail.POST_GAME_SPEED";
    RadioGroup speedRadioGroup;
    Party party;

    protected void onCreate(Bundle savedInstanceState) {
        //sets layout
        super.onCreate(savedInstanceState);
        setContentView(R.layout.speed_selector);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        //initializes the buttons
        speedRadioGroup = (RadioGroup) findViewById(R.id.speedRadioGroup);

        //grabs data from main loop
        Intent intent = getIntent();
        party = (Party) intent.getSerializableExtra(MainGame.PARTY_TO_HEALTH);

        //deals with checking the radiogroup and sending the results back to main loop
        Button continueAlongTrail = (Button) findViewById(R.id.continueTheGame);
        continueAlongTrail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(speedRadioGroup.getCheckedRadioButtonId()) {
                    case R.id.speedEasy: {
                        party.setPace("Easy");
                    }
                    break;
                    case R.id.speedMedium: {
                        party.setPace("Medium");
                    }
                    break;
                    case R.id.speedExtreme: {
                        party.setPace("Extreme");
                    }
                    break;
                    default: {
                        party.setPace("Easy");
                    }
                }

                Intent resultIntent = new Intent();
                resultIntent.putExtra(POST_GAME_SPEED, party);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}
