/**
 * Programming 2 Oregon Trail Project
 * @author Alexander Casada and Alexander Burkholder
 * @since April 20, 2023
 *
 * Description: This RiverActivity class allows the player to interact with the river crossings. They
 * can choose to learn about the river which tells them its height and width, they can cross the river
 * on a ferry for $75, or they can try to cross without a ferry and risk their wagon and items.
 */

package com.example.OTrail;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RiverActivity extends AppCompatActivity
{
    public static final String POST_RIVER_INV = "com.example.OTrail.POST_RIVER_INV";
    public static final String POST_RIVER_EVENT = "com.example.OTrail.POST_RIVER_EVENT";


    /**
     * Default class constructor.
     */
    public RiverActivity() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Sets the river activity layout.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rivercrossing);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        //grabs data from main loop
        Event event = (Event) getIntent().getSerializableExtra("passEvent");
        Inventory inv = (Inventory) getIntent().getSerializableExtra(MainGame.GAME_INV);

        //defines the text display
        final TextView textView92 = findViewById(R.id.textView92);

        //deals with learning about the river
        Button learn = (Button) findViewById(R.id.learn);
        final int[] temp1 = {0};

        // learn about the river button
       learn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if(temp1[0] % 2 == 1) {
                   textView92.setText("");
               }
               else {
                   textView92.setText(event.riverCrossing(inv, 1));
               }
               temp1[0]++;
           }
        });

        //deals with buy the way across
        Button buy = (Button) findViewById(R.id.buy);

        // If they do not have enough money ($75 to cross by ferry).
        if(inv.getPlayerMoneyCount() < 75) {
            buy.setEnabled(false);
        }
        else{
            buy.setEnabled(true);
        }
        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                event.riverCrossing(inv, 2);
                Intent resultIntent = new Intent();
                resultIntent.putExtra(POST_RIVER_INV, inv);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });

        //deals with crossing without a boat
        Button cross = (Button) findViewById(R.id.cross);
        cross.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               event.riverCrossing(inv,3);
               Intent resultIntent = new Intent();
               resultIntent.putExtra(POST_RIVER_INV, inv);
               setResult(RESULT_OK, resultIntent);
               finish();
           }
        });
    }
}
