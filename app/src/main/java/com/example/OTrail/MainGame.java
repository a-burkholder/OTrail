package com.example.OTrail;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;

public class MainGame extends AppCompatActivity {
    public static final String GAME_MAP = "com.example.OTrail.GAME_MAP";
    public static final String GAME_INV = "com.example.OTrail.GAME_INV";
    public static final String GAME_PARTY = "com.example.OTrail.GAME_PARTY";
    public static final String GAME_DATE = "com.example.OTrail.GAME_DATE";
    public static final String EVENT_NUMBER = "com.example.OTrail.EVENT_NUMBER";
    public static final String PARTY_TO_HEALTH = "com.example.OTrail.PARTY_TO_HEALTH";
    //public static final String

    private static final String DATE_KEY = "com.example.OTrail.DATE";
    private static final String PARTY_KEY = "com.example.OTrail.PARTY";
    private static final String MAP_KEY = "com.example.OTrail.MAP";
    private static final String EVENT_KEY = "com.example.OTrail.EVENT";

    private static final int SHOP_RESULT = 1;
    private static final int RIVER_RESULT = 2;
    private static final int EVENT_RESULT = 3;

    private int[] startDate = {1, 3, 1847};
    private String[] names = {"", "", "", "", ""};

    private Date date;
    private Party party;
    private Inventory inv;
    private Map map;
    private Event event;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();

        if(getIntent().getSerializableExtra("passInventory") == null) inv = new Inventory();
        else inv = (Inventory)getIntent().getSerializableExtra("passInventory");


        if(savedInstanceState != null) {
            date = (Date) savedInstanceState.getSerializable(DATE_KEY);
            map = (Map) savedInstanceState.getSerializable(MAP_KEY);
            party = (Party) savedInstanceState.getSerializable(PARTY_KEY);
            event = (Event) savedInstanceState.getSerializable(EVENT_KEY);

            System.out.println("is not null");

        }
        else {

            startDate = intent.getIntArrayExtra(OpenDate.START_DATE);
            names = intent.getStringArrayExtra(OpenDate.NAMES2);

            date = Date.getInstance(startDate);
            names = intent.getStringArrayExtra(OpenDate.NAMES2);
            map = Map.getInstance();
            party = Party.getInstance(inv, names);
            event = Event.getInstance(inv, party, date);

            System.out.println("is null");
        }

        Shop shop = new Shop();
        Menu menu = new Menu(inv, party, map, shop);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameplayscreen);

        final TextView dateDisplay = findViewById(R.id.dateDisplay);
        final TextView weatherDisplay = findViewById(R.id.weatherdisplay);
        final TextView temperatureDisplay = findViewById(R.id.temperatureDisplay);
        final TextView speedDisplay = findViewById(R.id.speedDisplay);
        final TextView rationsDisplay = findViewById(R.id.distanceDisplay);

        final TextView foodDisplay = findViewById(R.id.foodremainingdisplay);
        final TextView distanceDisplay = findViewById(R.id.distanceDisplay);

        final Button invBut = findViewById(R.id.Inventory);
        final Button moveBut = findViewById(R.id.continueAction);
        final Button shopBut = findViewById(R.id.Shop);
        final Button healthBut = findViewById(R.id.healthBut);
        final Button tradeBut = findViewById(R.id.Trade);

        ImageView wagon1 = findViewById(R.id.wagon1);
        ImageView wagon2 = findViewById(R.id.wagon2);
        ImageView wagon3 = findViewById(R.id.wagon3);
        ImageView wagon4 = findViewById(R.id.wagon4);
        ImageView wagon5 = findViewById(R.id.wagon5);
        ImageView wagon6 = findViewById(R.id.wagon6);
        ImageView wagon7 = findViewById(R.id.wagon7);
        ImageView wagon8 = findViewById(R.id.wagon8);
        ImageView wagon9 = findViewById(R.id.wagon9);
        ImageView wagon10 = findViewById(R.id.wagon10);
        ImageView wagon11 = findViewById(R.id.wagon11);
        ImageView wagon12 = findViewById(R.id.wagon12);
        ImageView wagon13 = findViewById(R.id.wagon13);
        ImageView wagon14 = findViewById(R.id.wagon14);
        ImageView wagon15 = findViewById(R.id.wagon15);
        ImageView wagon16 = findViewById(R.id.wagon16);
        ImageView wagon17 = findViewById(R.id.wagon17);
        ImageView wagon18 = findViewById(R.id.wagon18);
        ImageView wagon19 = findViewById(R.id.wagon19);
        ImageView wagon20 = findViewById(R.id.wagon20);
        ImageView wagon21 = findViewById(R.id.wagon21);

        wagon1.setVisibility(View.INVISIBLE);
        wagon2.setVisibility(View.INVISIBLE);
        wagon3.setVisibility(View.INVISIBLE);
        wagon4.setVisibility(View.INVISIBLE);
        wagon5.setVisibility(View.INVISIBLE);
        wagon6.setVisibility(View.INVISIBLE);
        wagon7.setVisibility(View.INVISIBLE);
        wagon8.setVisibility(View.INVISIBLE);
        wagon9.setVisibility(View.INVISIBLE);
        wagon10.setVisibility(View.INVISIBLE);
        wagon11.setVisibility(View.INVISIBLE);
        wagon12.setVisibility(View.INVISIBLE);
        wagon13.setVisibility(View.INVISIBLE);
        wagon14.setVisibility(View.INVISIBLE);
        wagon15.setVisibility(View.INVISIBLE);
        wagon16.setVisibility(View.INVISIBLE);
        wagon17.setVisibility(View.INVISIBLE);
        wagon18.setVisibility(View.INVISIBLE);
        wagon19.setVisibility(View.INVISIBLE);
        wagon20.setVisibility(View.INVISIBLE);
        wagon21.setVisibility(View.INVISIBLE);





        dateDisplay.setText(date.getMonth() + "/" + date.getDay() + "/" + date.getYear());
        weatherDisplay.setText(date.getWeather());
        date.setTemp(map.getClimate());
        temperatureDisplay.setText(" "+date.getTemp());
        speedDisplay.setText("10");
        foodDisplay.setText(" "+ inv.getFoodCount());
        distanceDisplay.setText(" "+map.getPosition());




        //Inventory button stuff
        invBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainGame.this, InventoryActivity.class);
                intent.putExtra(GAME_INV, inv);
                startActivity(intent);
            }
        });

        //Move button stuff
        moveBut.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                System.out.println(map.getLastLandmark());
                shopBut.setEnabled(false);
                //______________________________________________________________________________________
                AlertDialog alertDialog = new AlertDialog.Builder(MainGame.this).create();


                if((map.getPosition() >= 2000) && (party.getAtLeastSomeoneAlive()))
                {
                    moveBut.setEnabled(false);

                    alertDialog.setTitle("YOU WIN!");
                    alertDialog.setMessage("Congratulations, you have made it to Oregon City!!!");
                    alertDialog.show();
                }
                if(party.getAtLeastSomeoneAlive() == false)
                {
                    moveBut.setEnabled(false);
                    alertDialog.setTitle("YOU LOST.");
                    alertDialog.setMessage("Your party died!");
                    alertDialog.show();
                }
                //________________________________________________________________________________________

                if (map.getPosition() < 2000 && !party.getGameOverStatus()) {
                    // 10 miles travelled per day only if the wagon is usable and the game is not yet over.
                    if (inv.isWagonUsable() && !party.getGameOverStatus()) {
                        System.out.println("Increments the position");
                        map.setPosition(10);
                    }

                    wagon1.setVisibility(View.INVISIBLE);
                    wagon2.setVisibility(View.INVISIBLE);
                    wagon3.setVisibility(View.INVISIBLE);
                    wagon4.setVisibility(View.INVISIBLE);
                    wagon5.setVisibility(View.INVISIBLE);
                    wagon6.setVisibility(View.INVISIBLE);
                    wagon7.setVisibility(View.INVISIBLE);
                    wagon8.setVisibility(View.INVISIBLE);
                    wagon9.setVisibility(View.INVISIBLE);
                    wagon10.setVisibility(View.INVISIBLE);
                    wagon11.setVisibility(View.INVISIBLE);
                    wagon12.setVisibility(View.INVISIBLE);
                    wagon13.setVisibility(View.INVISIBLE);
                    wagon14.setVisibility(View.INVISIBLE);
                    wagon15.setVisibility(View.INVISIBLE);
                    wagon16.setVisibility(View.INVISIBLE);
                    wagon17.setVisibility(View.INVISIBLE);
                    wagon18.setVisibility(View.INVISIBLE);
                    wagon19.setVisibility(View.INVISIBLE);
                    wagon20.setVisibility(View.INVISIBLE);
                    wagon21.setVisibility(View.INVISIBLE);

                    int temp = map.getPosition();
                    int number;
                    for (number = 0; temp > 0; number++) {
                        temp -= 100;
                    }

                    switch(number)
                    {
                        case 0:
                        {
                            wagon1.setVisibility(View.VISIBLE);
                        }
                        break;
                        case 1:
                        {
                            wagon2.setVisibility(View.VISIBLE);

                        }
                        break;
                        case 2:
                        {
                            wagon3.setVisibility(View.VISIBLE);

                        }
                        break;
                        case 3:
                        {
                            wagon4.setVisibility(View.VISIBLE);

                        }
                        break;
                        case 4:
                        {
                            wagon5.setVisibility(View.VISIBLE);

                        }
                        break;
                        case 5:
                        {
                            wagon6.setVisibility(View.VISIBLE);

                        }
                        break;
                        case 6:
                        {
                            wagon7.setVisibility(View.VISIBLE);

                        }
                        break;
                        case 7:
                        {
                            wagon8.setVisibility(View.VISIBLE);

                        }
                        break;
                        case 8:
                        {
                            wagon9.setVisibility(View.VISIBLE);

                        }
                        break;
                        case 9:
                        {
                            wagon10.setVisibility(View.VISIBLE);

                        }
                        break;
                        case 10:
                        {
                            wagon11.setVisibility(View.VISIBLE);

                        }
                        break;
                        case 11:
                        {
                            wagon12.setVisibility(View.VISIBLE);

                        }
                        break;
                        case 12:
                        {
                            wagon13.setVisibility(View.VISIBLE);

                        }
                        break;
                        case 13:
                        {
                            wagon14.setVisibility(View.VISIBLE);

                        }
                        break;
                        case 14:
                        {
                            wagon15.setVisibility(View.VISIBLE);

                        }
                        break;
                        case 15:
                        {
                            wagon16.setVisibility(View.VISIBLE);

                        }
                        break;
                        case 16:
                        {
                            wagon17.setVisibility(View.VISIBLE);

                        }
                        break;
                        case 17:
                        {
                            wagon18.setVisibility(View.VISIBLE);

                        }
                        break;
                        case 18:
                        {
                            wagon19.setVisibility(View.VISIBLE);

                        }
                        break;
                        case 19:
                        {
                            wagon20.setVisibility(View.VISIBLE);

                        }
                        break;
                        case 20:
                        {
                            wagon21.setVisibility(View.VISIBLE);
                        }
                        break;
                        default:
                    }


                    // Prints the progress percentage.
                    map.progressBar();

                    // Increments the date for each loop.
                    date.setDate(1);

                    if(map.isRiver()) {
                        Intent intent4 = new Intent(MainGame.this, RiverActivity.class);
                        intent4.putExtra("passEvent", event);
                        intent4.putExtra(GAME_INV, inv);
                        startActivityForResult(intent4, RIVER_RESULT);
                    }

                    if(map.isLandmark()){
                        Intent locationIntent = new Intent(MainGame.this, OpenLocations.class);
                        locationIntent.putExtra(GAME_MAP, map);
                        startActivity(locationIntent);

                        if(map.isRiver()) {
                            shopBut.setEnabled(true);
                        }
                    }
                    // Could generate a random number depending on the random number generated.
                    System.out.println("generate event");
                    int eventNum = event.eventNum();
                    System.out.println(" " + eventNum);
                    if (eventNum <= 200){
                        Intent intent = new Intent(MainGame.this, EventActivity.class);
                        intent.putExtra(GAME_PARTY, party);
                        intent.putExtra(GAME_DATE, date);
                        intent.putExtra(GAME_INV, inv);
                        intent.putExtra(EVENT_NUMBER, eventNum);
                        startActivityForResult(intent, EVENT_RESULT);
                    }

                    // Increment weather / terrian if needed.
                    map.setClimateZone();
                    date.setWeather(map.getClimate());
                    date.setTemp(map.getClimate());
                    date.setGrass(map.getClimate());

                    // Calculates and updates the players food use.
                    party.dailyFoodUsed(inv);

                    // Increment distance to next location.
                    map.getDistToLM();

                    // updates the screen
                    dateDisplay.setText(date.getMonth() + "/" + date.getDay() + "/" + date.getYear());
                    weatherDisplay.setText(date.getWeather());
                    temperatureDisplay.setText(" " + date.getTemp());
                    speedDisplay.setText("10");
                    rationsDisplay.setText(String.valueOf(inv.getFoodCount())); // change this
                    foodDisplay.setText(" " + inv.getFoodCount());
                    distanceDisplay.setText(" " + map.getPosition());



                }
            }
        });

        //Heath tab stuff
        healthBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(Arrays.toString(party.getNames()));
                Intent intent4 = new Intent(MainGame.this, PartyActivity.class);
                intent4.putExtra(PARTY_TO_HEALTH, party);
                startActivity(intent4);
            }
        });

        //Shop tab stuff
        if(map.isShop() || map.getPosition()==0) { shopBut.setEnabled(true);}
        else {shopBut.setEnabled(false);}
        shopBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainGame.this, Shop.class);
                intent1.putExtra("Inventory object", inv);
                intent1.putExtra("passParty", party);
                startActivityForResult(intent1, SHOP_RESULT);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SHOP_RESULT){
            if (resultCode == RESULT_OK){
                inv = (Inventory) data.getSerializableExtra(Shop.POST_SHOP);
            }
        }
        if (requestCode == RIVER_RESULT){
            if (resultCode == RESULT_OK){
                inv = (Inventory) data.getSerializableExtra(RiverActivity.POST_RIVER_INV);
            }
        }
        if (requestCode == EVENT_RESULT){
            if (resultCode == RESULT_OK){
                inv = (Inventory) data.getSerializableExtra(EventActivity.POST_EVENT_INV);
                date = (Date) data.getSerializableExtra(EventActivity.POST_EVENT_DATE);
                party = (Party) data.getSerializableExtra(EventActivity.POST_EVENT_PARTY);
                System.out.println(inv.getFoodCount());

            }
        }
    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(DATE_KEY, date);
        outState.putSerializable(PARTY_KEY, party);
        outState.putSerializable(MAP_KEY, map);
        outState.putSerializable(EVENT_KEY, event);
    }
}