package com.example.OTrail;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
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
    public static final String PARTY_SPEED = "com.example.OTrail.PARTY_SPEED";
    public static final String TRADE_NUMBER = "com.example.OTrail.TRADE_NUMBER";


    private static final String DATE_KEY = "com.example.OTrail.DATE";
    private static final String PARTY_KEY = "com.example.OTrail.PARTY";
    private static final String MAP_KEY = "com.example.OTrail.MAP";
    private static final String EVENT_KEY = "com.example.OTrail.EVENT";

    private static final int SHOP_RESULT = 1;
    private static final int RIVER_RESULT = 2;
    private static final int BERRY_RESULT = 3;
    private static final int SPEED_RESULT = 4;
    private static final int TRADE_RESULT = 5;


    private int[] startDate = {1, 3, 1847};
    private String[] names = {"", "", "", "", ""};

    private Date date;
    private Party party;
    private Inventory inv;
    private Map map;
    private Event event;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //grab data from previous activities
        Intent intent = getIntent();
        if(getIntent().getSerializableExtra("passInventory") == null) inv = new Inventory();
        else inv = (Inventory)getIntent().getSerializableExtra("passInventory");

        //dont re-initialize
        if(savedInstanceState != null) {
            date = (Date) savedInstanceState.getSerializable(DATE_KEY);
            map = (Map) savedInstanceState.getSerializable(MAP_KEY);
            party = (Party) savedInstanceState.getSerializable(PARTY_KEY);
            event = (Event) savedInstanceState.getSerializable(EVENT_KEY);
        }

        //initialize everything
        else {
            startDate = intent.getIntArrayExtra(OpenDate.START_DATE);
            names = intent.getStringArrayExtra(OpenDate.NAMES2);
            date = Date.getInstance(startDate);
            names = intent.getStringArrayExtra(OpenDate.NAMES2);
            map = Map.getInstance();
            party = Party.getInstance(inv, names);
            event = Event.getInstance(inv, party, date);
        }

        //sets the speed to a default
        party.setSpeed(10);

        //forces the shop to open
        if(map.getPosition()==0) {
            Intent intent1 = new Intent(MainGame.this, Shop.class);
            intent1.putExtra("Inventory object", inv);
            intent1.putExtra("passParty", party);
            startActivityForResult(intent1, SHOP_RESULT);
        }

        //gets rid of title bar and sets layout
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameplayscreen);

        //defines text boxes
        final TextView dateDisplay = findViewById(R.id.dateDisplay);
        final TextView weatherDisplay = findViewById(R.id.weatherdisplay);
        final TextView temperatureDisplay = findViewById(R.id.temperatureDisplay);
        final TextView speedDisplay = findViewById(R.id.speedDisplay);
        final TextView announcement = findViewById(R.id.announcementstextbox);
        final TextView foodDisplay = findViewById(R.id.foodremainingdisplay);

        //defines buttons
        final Button invBut = findViewById(R.id.Inventory);
        final Button moveBut = findViewById(R.id.continueAction);
        final Button shopBut = findViewById(R.id.Shop);
        final Button healthBut = findViewById(R.id.healthBut);
        final Button tradeBut = findViewById(R.id.Trade);
        final Button speedBut = findViewById(R.id.speed);

        //define weather icon
        final ImageView weather = findViewById(R.id.weatherBar);

        //defines wagon images
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

        // Wagon images to show game progress.
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

        //initial text values filled in
        System.out.println(date.getMonth() + "/" + date.getDay() + "/" + date.getYear());
        dateDisplay.setText(date.getMonth() + "/" + date.getDay() + "/" + date.getYear());
        weatherDisplay.setText(date.getWeather());
        date.setTemp(map.getClimate());
        temperatureDisplay.setText(" "+date.getTemp());
        foodDisplay.setText(" "+ inv.getFoodCount());

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
                //dialog for if win or loose
                AlertDialog alertDialog = new AlertDialog.Builder(MainGame.this).create();

                //update food
                if(inv.getFoodCount() > 0) {
                    switch(party.getPace()){
                        case "Easy":
                            inv.setFoodCount(-party.getNumberOfPeopleAlive()*2);
                            break;
                        case "Medium":inv.setFoodCount(-party.getNumberOfPeopleAlive()*3);
                            break;
                        case "Extreme":inv.setFoodCount(-party.getNumberOfPeopleAlive()*5);
                            break;
                        default:inv.setFoodCount(-party.getNumberOfPeopleAlive()*2);
                            break;
                    }
                }
                if (inv.getFoodCount() < 0){
                    inv.setFoodCount(-inv.getFoodCount());
                }

                //updates health
                if(inv.getFoodCount() == 0) {
                    party.setHealth(-10);
                }
                else {
                    party.setHealth(2);
                }

                //if win
                if((map.getPosition() >= 2000) && (party.getAtLeastSomeoneAlive())) {
                    moveBut.setEnabled(false);
                    alertDialog.setTitle("YOU WIN!");
                    alertDialog.setMessage("Congratulations, you have made it to Oregon City!!!");
                    alertDialog.show();
                    alertDialog.setCancelable(true);
                    alertDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                        @Override
                        public void onCancel(DialogInterface dialog) {
                            android.os.Process.killProcess(android.os.Process.myPid());
                        }
                    });
                }

                int zeros[] = {0, 0, 0, 0, 0};
                System.out.println(Arrays.toString(party.getHealth()));

                //if lose
                if(Arrays.equals(party.getHealth(), zeros)) {
                    moveBut.setEnabled(false);
                    alertDialog.setTitle("YOU LOST.");
                    alertDialog.setMessage("Your party died!");
                    alertDialog.show();
                    alertDialog.setCancelable(true);
                    alertDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                        @Override
                        public void onCancel(DialogInterface dialog) {
                            android.os.Process.killProcess(android.os.Process.myPid());
                        }
                    });
                }

                //if game goes on
                if (map.getPosition() < 2000 && !party.getGameOverStatus()) {

                    // if cart works, increment position
                    if (inv.isWagonUsable() && !party.getGameOverStatus()) {
                        System.out.println("Increments the position");
                        map.setPosition(party.getSpeed()); // default of 10 speed, but could be changed to 12 or 15
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

                    //for setting progress bar visibility
                    int temp = map.getPosition();
                    int number;
                    for (number = 0; temp > 0; number++) {
                        temp -= 100;
                    }
                    switch(number) {
                        case 0: {wagon1.setVisibility(View.VISIBLE);}
                        break;
                        case 1: {wagon2.setVisibility(View.VISIBLE);}
                        break;
                        case 2: {wagon3.setVisibility(View.VISIBLE);}
                        break;
                        case 3: {wagon4.setVisibility(View.VISIBLE);}
                        break;
                        case 4: {wagon5.setVisibility(View.VISIBLE);}
                        break;
                        case 5: {wagon6.setVisibility(View.VISIBLE);}
                        break;
                        case 6: {wagon7.setVisibility(View.VISIBLE);}
                        break;
                        case 7: {wagon8.setVisibility(View.VISIBLE);}
                        break;
                        case 8: {wagon9.setVisibility(View.VISIBLE);}
                        break;
                        case 9: {wagon10.setVisibility(View.VISIBLE);}
                        break;
                        case 10: {wagon11.setVisibility(View.VISIBLE);}
                        break;
                        case 11: {wagon12.setVisibility(View.VISIBLE);}
                        break;
                        case 12: {wagon13.setVisibility(View.VISIBLE);}
                        break;
                        case 13: {wagon14.setVisibility(View.VISIBLE);}
                        break;
                        case 14: {wagon15.setVisibility(View.VISIBLE);}
                        break;
                        case 15: {wagon16.setVisibility(View.VISIBLE);}
                        break;
                        case 16: {wagon17.setVisibility(View.VISIBLE);}
                        break;
                        case 17: {wagon18.setVisibility(View.VISIBLE);}
                        break;
                        case 18: {wagon19.setVisibility(View.VISIBLE);}
                        break;
                        case 19: {wagon20.setVisibility(View.VISIBLE);}
                        break;
                        case 20: {wagon21.setVisibility(View.VISIBLE);}
                        break;
                        default:
                    }

                    //prints the progress percentage for troubleshooting
                    map.progressBar();

                    //increments the date
                    date.setDate(1);

                    //river check
                    if(map.isRiver()) {
                        Intent intent4 = new Intent(MainGame.this, RiverActivity.class);
                        intent4.putExtra("passEvent", event);
                        intent4.putExtra(GAME_INV, inv);
                        startActivityForResult(intent4, RIVER_RESULT);
                    }

                    //shop check
                    if(map.isShop()) {
                        shopBut.setEnabled(true);
                    }
                    else {
                        shopBut.setEnabled(false);
                    }

                    //landmark check
                    if(map.isLandmark()){
                        Intent locationIntent = new Intent(MainGame.this, OpenLocations.class);
                        locationIntent.putExtra(GAME_MAP, map);
                        startActivity(locationIntent);
                    }

                    //if no landmark, event stuff
                    else {
                        // generates rand number
                        int eventNum = event.eventNum();

                        //if rand is in range
                        if (eventNum <= 50) {

                            //generate the event
                            event.randomEvents(inv, party, date);

                            //creates the announcement on a timer
                            announcement.setElevation(Float.parseFloat("40"));
                            announcement.setVisibility(View.VISIBLE);
                            announcement.setText(event.getEventMessage());
                            new CountDownTimer( 3000, 1000) {
                                public void onTick(long millisUntilFinished) {
                                }
                                // Timer Finishes
                                @SuppressLint("SetTextI18n")
                                public void onFinish() {
                                    announcement.setVisibility(View.INVISIBLE);
                                    announcement.setElevation(Float.parseFloat("-40"));
                                }
                            }.start();

                            //starts the game if it is a berry event
                            if (event.getEventMessage() == "You found a berry bush!"){
                                Intent intent = new Intent(MainGame.this, BerryActivity.class);
                                intent.putExtra(GAME_INV, inv);
                                startActivityForResult(intent, BERRY_RESULT);
                            }
                        }
                    }

                    //increment weather / terrian if needed.
                    map.setClimateZone();
                    date.setWeather(map.getClimate());
                    date.setTemp(map.getClimate());
                    date.setGrass(map.getClimate());

                    //Increment distance to next location.
                    map.getDistToLM();

                    //updates the screen text
                    dateDisplay.setText(date.getMonth() + "/" + date.getDay() + "/" + date.getYear());
                    weatherDisplay.setText(date.getWeather());
                    temperatureDisplay.setText(" " + date.getTemp());
                    speedDisplay.setText(""+party.getSpeed());
                    foodDisplay.setText(" " + inv.getFoodCount());

                    //updates the weather icons
                    switch (date.getWeather()){
                        case ("Clear"):{weather.setImageResource(R.drawable.trailinfo_sunny);} break;
                        case ("Rain"):{weather.setImageResource(R.drawable.trailinforain);} break;
                        case ("Heavy rain"):{weather.setImageResource(R.drawable.trailinfo_rain_h);} break;
                        case ("snow"):{weather.setImageResource(R.drawable.trailinfo_snow);} break;
                        case ("Heavy snow"):{weather.setImageResource(R.drawable.trailinfo_snow_h);} break;
                        default: {weather.setImageResource(R.drawable.trailinfo_sunny);} break;
                    }
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

        //Speed tab stuff
        speedBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int temp = 0;
                if (temp == 0){
                    temp ++;
                    Intent intent1 = new Intent(MainGame.this, SpeedActivity.class);
                    intent1.putExtra(PARTY_TO_HEALTH, party);
                    startActivityForResult(intent1, SPEED_RESULT);
                }
                else if (temp == 1) {
                    System.out.println("" + party.getSpeed());
                    speedDisplay.setText("" + party.getSpeed());
                }
            }
        });

        //Trade tab stuff
        tradeBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tradeNum = inv.canTrade(map);
                if (tradeNum == -1){
                    String noTrade = "No trades available today";
                    System.out.println(noTrade);
                    //creates the announcement on a timer
                    announcement.setElevation(Float.parseFloat("40"));
                    announcement.setVisibility(View.VISIBLE);
                    announcement.setText(noTrade);
                    new CountDownTimer( 3000, 1000) {
                        public void onTick(long millisUntilFinished) {
                        }
                        // Timer Finishes
                        @SuppressLint("SetTextI18n")
                        public void onFinish() {
                            announcement.setVisibility(View.INVISIBLE);
                            announcement.setElevation(Float.parseFloat("-40"));
                        }
                    }.start();
                }
                else {
                    Intent intent = new Intent(MainGame.this, OpenTrades.class);
                    intent.putExtra(GAME_INV, inv);
                    intent.putExtra(TRADE_NUMBER, tradeNum);
                    startActivityForResult(intent, TRADE_RESULT);
                }
            }
        });
    }

    //proper updating of stuff when coming back from an activity
    @SuppressLint("SetTextI18n")
    @Override
    protected void onResume (){
        super.onResume();
        TextView speedDisplay = findViewById(R.id.speedDisplay);
        TextView foodDisp = findViewById(R.id.foodremainingdisplay);
        speedDisplay.setText(""+party.getSpeed());
        foodDisp.setText(""+inv.getFoodCount());

    }
    //allows for proper pulling of data back from other activities
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
        if (requestCode == BERRY_RESULT){
            if (resultCode == RESULT_OK){
                inv = (Inventory) data.getSerializableExtra(BerryActivity.POST_GAME_INV);
                System.out.println("final berry update = " + inv.getFoodCount());
            }
        }
        if(requestCode == SPEED_RESULT) {
            if(resultCode == RESULT_OK) {
                party = (Party) data.getSerializableExtra(SpeedActivity.POST_GAME_SPEED);
            }
        }
        if (requestCode == TRADE_RESULT){
            if (resultCode == RESULT_OK){
                inv = (Inventory) data.getSerializableExtra(OpenTrades.POST_TRADE_INV);
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