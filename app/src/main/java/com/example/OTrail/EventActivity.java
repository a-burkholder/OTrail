package com.example.OTrail;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EventActivity extends AppCompatActivity
{
    Event event;
    private String eventMessage;

    public EventActivity()
    {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_events);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        event = (Event) getIntent().getSerializableExtra("passEvent");
        eventMessage = event.getEventMessage();

        final TextView eventInformation = findViewById(R.id.eventInformation);

        eventInformation.setText(eventMessage);

        if(eventMessage == "You found a berry bush.");
        {
            Intent intent3 = new Intent(EventActivity.this, berryPickingMinigame.class);
            startActivity(intent3);
        }

        Button buttonForContinuing = (Button) findViewById(R.id.buttonForContinuing);
        buttonForContinuing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(EventActivity.this, MainGame.class);
                startActivity(intent3);
            }
        });
    }
}
