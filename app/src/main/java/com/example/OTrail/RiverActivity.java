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
    private Event event;
    private Inventory inv;

    public RiverActivity()
    {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rivercrossing);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        Event event = (Event) getIntent().getSerializableExtra("passEvent");
        inv = (Inventory) getIntent().getSerializableExtra(MainGame.GAME_INV);

        final TextView textView92 = findViewById(R.id.textView92);

       Button learn = (Button) findViewById(R.id.learn);
       learn.setOnClickListener(new View.OnClickListener()
       {
           @Override
           public void onClick(View view)
           {
               textView92.setText(event.riverCrossing(inv, 1));
           }
       });

       Button buy = (Button) findViewById(R.id.buy);
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

       Button cross = (Button) findViewById(R.id.cross);
       cross.setOnClickListener(new View.OnClickListener()
       {
           @Override
           public void onClick(View view)
           {
               event.riverCrossing(inv,3);

               Intent resultIntent = new Intent();
               resultIntent.putExtra(POST_RIVER_INV, inv);

               setResult(RESULT_OK, resultIntent);
               finish();


           }
       });
    }
}
