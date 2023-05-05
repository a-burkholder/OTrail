package com.example.OTrail;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SpeedActivity extends AppCompatActivity
{
    public static final String POST_GAME_SPEED = "com.example.OTrail.POST_GAME_SPEED";
    RadioGroup speedRadioGroup;
    Party party;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.speed_selector);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();


        speedRadioGroup = (RadioGroup) findViewById(R.id.speedRadioGroup);

        Intent intent = getIntent();
        party = (Party) intent.getSerializableExtra(MainGame.PARTY_TO_HEALTH);


        Button continueAlongTrail = (Button) findViewById(R.id.continueTheGame);
        continueAlongTrail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                switch(speedRadioGroup.getCheckedRadioButtonId())
                {
                    case R.id.speedEasy:
                    {
                        party.setSpeed(10);
                    }
                    break;
                    case R.id.speedMedium:
                    {
                        party.setSpeed(12);
                    }
                    break;
                    case R.id.speedExtreme:
                    {
                        party.setSpeed(15);
                    }
                    break;
                    default:
                    {
                        party.setSpeed(10);
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
