/**
 * Programming 2 Oregon Trail Project
 * @author Alexander Burkholder
 * @since May 2, 2023
 *
 * Description: The OpenTrades class sets up a layout that allows the player to trade with the
 * legend Kento Akazawa.
 */

package com.example.OTrail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class OpenTrades extends AppCompatActivity {
    public static final String POST_TRADE_INV = "com.example.OTrail.POST_TRADE_INV";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //sets layout format
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trade);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        //grabs inventory from main loop
        int tradeNum = getIntent().getIntExtra(MainGame.TRADE_NUMBER, 0);
        Inventory inv = (Inventory) getIntent().getSerializableExtra(MainGame.GAME_INV);

        //initializes all layout objects
        TextView tradeText = findViewById(R.id.textView169);
        Button accept = findViewById(R.id.button);
        Button decline = findViewById(R.id.button2);

        //displays the trade offer
        tradeText.setText(inv.getTrade(tradeNum));

        //accept functionality
        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //confirms trade and passes it to main loop
                inv.confirmTrade(true, tradeNum);
                Intent result = new Intent();
                result.putExtra(POST_TRADE_INV, inv);
                setResult(RESULT_OK, result);
                finish();
            }
        });

        //decline functionality
        decline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //no trade and passes old inv back to main loop
                Intent result = new Intent();
                result.putExtra(POST_TRADE_INV, inv);
                setResult(RESULT_OK, result);
                finish();
            }
        });
    }
}