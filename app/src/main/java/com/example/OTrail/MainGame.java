package com.example.OTrail;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class MainGame extends AppCompatActivity {
    public static final String GAME_INV = "com.example.OTrail.GAME_INV";

    private static final String DATE_KEY = "com.example.OTrail.DATE";
    private static final String PARTY_KEY = "com.example.OTrail.PARTY";
    private int[] startDate = {1, 3, 1847};
    private Date date;
    private Party party;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        String[] names = intent.getStringArrayExtra(OpenNames.PARTY_NAMES);


        Inventory inv;
        if(getIntent().getSerializableExtra("passInventory") == null) inv = new Inventory();
        else inv = (Inventory)getIntent().getSerializableExtra("passInventory");

        if(savedInstanceState != null)
        {
            date = (Date) savedInstanceState.getSerializable(DATE_KEY);

            party = (Party) savedInstanceState.getSerializable(PARTY_KEY);

        }
        else
        {
            startDate = intent.getIntArrayExtra(OpenDate.START_DATE);
            date = Date.getInstance(startDate);

            party = Party.getInstance(inv);

        }


        Shop shop = new Shop();
        Map map = new Map();

        Menu menu = new Menu(inv, party, map, shop);
        party.setNames(names);
        Event event = new Event(inv, party, date);


        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameplayscreen);

        final TextView dateDisplay = findViewById(R.id.dateDisplay);
        final TextView weatherDisplay = findViewById(R.id.weatherdisplay);
        final TextView temperatureDisplay = findViewById(R.id.temperatureDisplay);
        final TextView speedDisplay = findViewById(R.id.speedDisplay);
        final TextView rationsDisplay = findViewById(R.id.rationDisplay);
        final TextView healthDisplay = findViewById(R.id.healthDisplay);
        final TextView foodDisplay = findViewById(R.id.foodremainingdisplay);


        final Button actionsBut = findViewById(R.id.action);
        final Button invBut = findViewById(R.id.Inventory);
        invBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainGame.this, InventoryActivity.class);
                intent.putExtra("passInventory", inv);
                startActivity(intent);
            }
        });
        final Button moveBut = findViewById(R.id.continueAction);
        moveBut.setOnClickListener(new View.OnClickListener()
        {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {

                dateDisplay.setText(date.getMonth() + "/" + date.getDay() + "/" + date.getYear());
                weatherDisplay.setText(date.getWeather());
                temperatureDisplay.setText(String.valueOf(date.getTemp()) + "F");
                speedDisplay.setText("10");
                rationsDisplay.setText(String.valueOf(inv.getFoodCount())); // change this
                healthDisplay.setText(""); // update this
                foodDisplay.setText(String.valueOf(inv.getFoodCount()));

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
                intent1.putExtra("Inventory object", inv);
                startActivity(intent1);
            }
        });


        final Button tradeBut = findViewById(R.id.Trade);
        final Button timelineBut = findViewById(R.id.timeline);
    }

    protected void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        outState.putSerializable(DATE_KEY, date);
        outState.putSerializable(PARTY_KEY, party);
    }

}