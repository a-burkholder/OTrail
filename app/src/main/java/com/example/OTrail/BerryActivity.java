package com.example.OTrail;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.content.Intent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class BerryActivity extends AppCompatActivity {

    public static final String POST_GAME_INV = "com.example.OTrail.POST_GAME_INV";
    public static final String BERRY_TITLE_TO_GAME = "com.example.OTrail.BERRY_TITLE_TO_GAME";

    private static final int GAME_RESULT = 4;

    private Event event;
    private Inventory inv;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.berry_picking_title);
        Button startGame = (Button)findViewById(R.id.startGame);


        inv = (Inventory) getIntent().getSerializableExtra(MainGame.GAME_INV);



        startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i++;
                if(i == 1) {
                    Intent intent = new Intent(BerryActivity.this, BerryPickingMinigame.class);
                    intent.putExtra(BERRY_TITLE_TO_GAME, inv);
                    new CountDownTimer(3000, 3000) { // Timer added to fix bug about text box changing too early.
                        public void onTick(long millisUntilFinished) {
                        }
                        @SuppressLint("SetTextI18n")
                        public void onFinish() {
                            startGame.setText("Return to Trail");
                        }
                    }.start();

                    startActivityForResult(intent, GAME_RESULT);
                }
                else {
                    System.out.println("Berryactivity food 1= " + inv.getFoodCount());
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra(POST_GAME_INV, inv);
                    setResult(RESULT_OK, resultIntent);
                    finish();
                }
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GAME_RESULT){
            if (resultCode == RESULT_OK){
                inv = (Inventory) data.getSerializableExtra(BerryPickingMinigame.RESULT);
                System.out.println("Berryactivity food 2= " + inv.getFoodCount());
            }
        }
    }
}