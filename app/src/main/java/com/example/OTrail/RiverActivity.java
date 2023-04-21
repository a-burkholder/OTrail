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
        event = (Event) getIntent().getSerializableExtra("passEvent");
        inv = (Inventory) getIntent().getSerializableExtra("passInventory");

        final TextView textView92 = findViewById(R.id.textView92);

       Button learn = (Button) findViewById(R.id.learn);
       learn.setOnClickListener(new View.OnClickListener()
       {
           @Override
           public void onClick(View view)
           {
               textView92.setText(event.riverCrossing(1));
           }
       });

       Button buy = (Button) findViewById(R.id.buy);
           buy.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   event.riverCrossing(2);
                   Intent intent3 = new Intent(RiverActivity.this, MainGame.class);
                   intent3.putExtra("passEvent", event);
                   intent3.putExtra("passInventory", inv);
                   startActivity(intent3);
               }
           });

       Button cross = (Button) findViewById(R.id.cross);
       cross.setOnClickListener(new View.OnClickListener()
       {
           @Override
           public void onClick(View view)
           {
               event.riverCrossing(3);
               Intent intent3 = new Intent(RiverActivity.this, MainGame.class);
               intent3.putExtra("passEvent", event);
               intent3.putExtra("passInventory", inv);
               startActivity(intent3);
           }
       });
    }
}
