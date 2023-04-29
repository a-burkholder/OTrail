package com.example.OTrail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class OpenLocations extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        Map thisMap = (Map) intent.getSerializableExtra(MainGame.GAME_MAP);
        System.out.println("Locations working");
        switch (thisMap.getLastLandmark()){
            case "Independence, Missouri":{
                setContentView(R.layout.independence);
                Button button = findViewById(R.id.buttonA);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
                break;
            }
            case "Kansas River Crossing":{
                setContentView(R.layout.kansasriver);
                Button button = findViewById(R.id.buttonB);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
                break;
            }
            case "Big Blue River Crossing":{
                setContentView(R.layout.blueriver);
                Button button = findViewById(R.id.buttonC);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
                break;
            }
            case "Fort Kearny":{
                setContentView(R.layout.fortkearney);
                Button button = findViewById(R.id.buttonD);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
                break;
            }
            case "Chimney Rock":{
                setContentView(R.layout.chimneyrock);
                Button button = findViewById(R.id.buttonE);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
                break;
            }
            case "Fort Laramie":{
                setContentView(R.layout.fortlaramie);
                Button button = findViewById(R.id.buttonF);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
                break;
            }
            case "Independence Rock":{
                setContentView(R.layout.independencerock);
                Button button = findViewById(R.id.buttonG);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
                break;
            }
            case "South Pass":{
                setContentView(R.layout.southpass);
                Button button = findViewById(R.id.buttonH);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
                break;
            }
            case "Fort Bridger":{
                setContentView(R.layout.fortbridger);
                Button button = findViewById(R.id.buttonI);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
                break;
            }
            case "Green River":{
                setContentView(R.layout.greenriver);
                Button button = findViewById(R.id.buttonJ);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
                break;
            }
            case "Soda Springs":{
                setContentView(R.layout.sodasprings);
                Button button = findViewById(R.id.buttonK);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
                break;
            }
            case "Fort Hall":{
                setContentView(R.layout.forthall);
                Button button = findViewById(R.id.buttonL);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
                break;
            }
            case "Snake River":{
                setContentView(R.layout.snakeriver);
                Button button = findViewById(R.id.buttonM);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
                break;
            }
            case "Blue Mountains":{
                setContentView(R.layout.bluemountains);
                Button button = findViewById(R.id.buttonN);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
                break;
            }
            case "The Dalles":{
                setContentView(R.layout.dalles);
                Button button = findViewById(R.id.buttonO);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
                break;
            }
            case "Oregon City":{
                setContentView(R.layout.oregoncity);
                Button button = findViewById(R.id.buttonP);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
                break;
            }
            default:setContentView(R.layout.independence);
                break;
        }
    }
}