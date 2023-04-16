package com.example.OTrail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class MainGame extends AppCompatActivity {
    public static final String GAME_INV = "com.example.OTrail.GAME_INV";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        String[] names = intent.getStringArrayExtra(OpenNames.PARTY_NAMES);
        int[] startDate = intent.getIntArrayExtra(OpenDate.START_DATE);

        Inventory inv = new Inventory();
        Shop shop = new Shop(inv, inv.getPlayerMoneyCount());
        Map map = new Map();
        Party party = new Party(inv);
        Menu menu = new Menu(inv, party, map, shop);
        Date date = new Date(startDate);
        party.setNames(names);
        Event event = new Event(inv, party, date);


        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameplayscreen);

        final TextView dateDisplay = findViewById(R.id.dateDisplay);


        final Button actionsBut = findViewById(R.id.action);
        final Button invBut = findViewById(R.id.Inventory);
        invBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainGame.this, Inventory.class);
                startActivity(intent);
            }
        });
        final Button moveBut = findViewById(R.id.continueAction);
        moveBut.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                dateDisplay.setText(String.valueOf(date.getMonth()) + "/" + String.valueOf(date.getDate()) + "/" + String.valueOf(date.getYear()));
                inv.isWagonUsable();

                if (map.getPosition() < 2000 && !party.getGameOverStatus()) {
                    // 10 miles travelled per day only if the wagon is usable and the game is not yet over.
                    if (inv.isWagonUsable() && !party.getGameOverStatus()) {
                        map.setPosition(10);
                    }

                    // If river crossing
                    if (map.isRiver()) {
                        menu.riverCrossing(event);
                    }

                    // Prints the progress percentage.
                    map.progressBar();

                    // Increments the date for each loop.
                    date.setDate(1);

                    // Prints the current date out for the player to see.

                    // Prints out the player's health.

                    // Increment weather / terrian if needed.
                    map.setClimateZone();
                    date.setWeather(map.getClimate());
                    date.setTemp(map.getClimate());
                    date.setGrass(map.getClimate());

                    // Calculates the players food use.
                    party.dailyFoodUsed();

                    // Could generate a random number depending on the random number generated.
                    event.randomEvents();

                    // Lists the daily choices for the player.

                    // Increment distance to next location.
                    map.getDistToLM();
                }

            }
        });




//        final Button talkBut = findViewById(R.id.viewLocation);
        final Button shopBut = findViewById(R.id.Shop);
        shopBut.setOnClickListener(new View.OnClickListener()
            {

            @Override
            public void onClick(View view)
            {
                Intent intent1 = new Intent(MainGame.this, Shop.class);
                startActivity(intent1);
            }
        });

        final Button tradeBut = findViewById(R.id.Trade);
        final Button timelineBut = findViewById(R.id.timeline);

    }
}