package com.example.OTrail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class BerryActivity extends AppCompatActivity {

    private Event event;
    private Inventory inv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.berry_picking_title);
        Button startGame = (Button)findViewById(R.id.startGame);

        event = (Event) getIntent().getSerializableExtra("passEvent");
        inv = (Inventory) getIntent().getSerializableExtra("Inventory object");

        startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BerryActivity.this, BerryPickingMinigame.class);
                intent.putExtra("passEvent", event);
                intent.putExtra("Inventory object", inv);
                startActivity(intent);
            }
        });
    }
}