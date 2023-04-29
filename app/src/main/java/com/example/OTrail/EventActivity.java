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
    public static final String POST_EVENT_INV = "com.example.OTrail.POST_EVENT_INV";
    public static final String POST_EVENT_DATE = "com.example.OTrail.POST_EVENT_DATE";
    public static final String POST_EVENT_PARTY = "com.example.OTrail.POST_EVENT_PARTY";

    private static final int BERRY_RESULT = 1;

    private String eventMessage;
    Inventory inv;
    Party party;
    Date date;

    int i = 0;

    public EventActivity()
    {}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_events);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();


        inv = (Inventory) getIntent().getSerializableExtra(MainGame.GAME_INV);
        party = (Party) getIntent().getSerializableExtra(MainGame.GAME_PARTY);
        date = (Date) getIntent().getSerializableExtra(MainGame.GAME_DATE);

        Event event = new Event(inv, party, date);
        event.randomEvents(inv, party, date);
        eventMessage = event.getEventMessage();

        final TextView eventInformation = findViewById(R.id.eventInformation);

        eventInformation.setText(eventMessage);

        Button buttonForContinuing = (Button) findViewById(R.id.buttonForContinuing);
        buttonForContinuing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i++;



                if (i==1) {
                    if (eventMessage == "You found a berry bush.") {

                        buttonForContinuing.setText("To trail");
                        Intent startBerries = new Intent(EventActivity.this, BerryActivity.class);
                        startBerries.putExtra("passParty", event);
                        startBerries.putExtra("Inventory object", inv);
                        startActivityForResult(startBerries, BERRY_RESULT);
                    }
                }

                else {
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra(POST_EVENT_INV, inv);
                    resultIntent.putExtra(POST_EVENT_DATE, date);
                    resultIntent.putExtra(POST_EVENT_PARTY, party);
                    setResult(RESULT_OK, resultIntent);
                    finish();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == BERRY_RESULT){
            if (resultCode == RESULT_OK){
                System.out.println("Eventactivity food 2= " + inv.getFoodCount());
                inv = (Inventory) data.getSerializableExtra(BerryActivity.POST_GAME_INV);
            }
        }
    }
}
