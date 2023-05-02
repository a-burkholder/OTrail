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
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trade);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        int tradeNum = getIntent().getIntExtra(MainGame.TRADE_NUMBER, 0);
        Inventory inv = (Inventory) getIntent().getSerializableExtra(MainGame.GAME_INV);

        TextView tradeText = findViewById(R.id.textView169);
        Button accept = findViewById(R.id.button);
        Button decline = findViewById(R.id.button2);

        //displays the trade offer
        tradeText.setText(inv.getTrade(tradeNum));

        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inv.confirmTrade(true, tradeNum);
                Intent result = new Intent();
                result.putExtra(POST_TRADE_INV, inv);
                setResult(RESULT_OK, result);
                finish();
            }
        });

        decline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inv.confirmTrade(true, tradeNum);
                Intent result = new Intent();
                result.putExtra(POST_TRADE_INV, inv);
                setResult(RESULT_OK, result);
                finish();
            }
        });
    }
}