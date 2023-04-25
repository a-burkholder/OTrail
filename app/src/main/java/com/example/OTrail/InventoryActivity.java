/**
 * Programming 2 Oregon Trail Project
 * @author Alexander Casada
 * @since March 28, 2023
 *
 * Description: This java Inventory class stores all the player's
 * items along the Oregon Trail that they will buy or use. This class
 * also can check to make sure the player's wagon will be able to
 * move along the Oregon Trail.
 */
package com.example.OTrail;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.util.Random;
public class InventoryActivity extends AppCompatActivity {
    private Inventory inv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inventory);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        inv = (Inventory) getIntent().getSerializableExtra(MainGame.GAME_INV);

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
                finish();
            }
        });
    }


    /**
     * Default constructor for the Inventory class.
     */
    public InventoryActivity() {

    }
}