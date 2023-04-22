package com.example.OTrail;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PartyActivity extends AppCompatActivity
{
    private Party party;

    public PartyActivity()
    {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.health);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        party = (Party) getIntent().getSerializableExtra("passParty");

        final TextView textView32 = findViewById(R.id.textView32);
        final TextView textView33 = findViewById(R.id.textView33);
        final TextView textView34 = findViewById(R.id.textView34);
        final TextView textView35 = findViewById(R.id.textView35);
        final TextView textView36 = findViewById(R.id.textView36);
        final TextView textView37 = findViewById(R.id.textView37);
        final TextView textView38 = findViewById(R.id.textView38);
        final TextView textView39 = findViewById(R.id.textView39);
        final TextView textView40 = findViewById(R.id.textView40);

        textView32.setText(String.valueOf(inv.getPlayerMoneyCount()));
        textView33.setText(String.valueOf(inv.getFoodCount()));
        textView34.setText(String.valueOf(inv.getClothingCount()));
        textView35.setText(String.valueOf(inv.getBasketCount()));
        textView36.setText(String.valueOf(inv.getOxenCount()));
        textView37.setText(String.valueOf(inv.getWagonWheelCount()));
        textView38.setText(String.valueOf(inv.getWagonAxleCount()));
        textView39.setText(String.valueOf(inv.getWagonTongueCount()));
        textView40.setText(String.valueOf(inv.getMedicalSupplyCount()));


        Button continueAlongTrail = (Button) findViewById(R.id.continueAlongTrail);
        continueAlongTrail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(InventoryActivity.this, MainGame.class);
                intent3.putExtra("passInventory", inv);
                startActivity(intent3);
            }
        });


}
