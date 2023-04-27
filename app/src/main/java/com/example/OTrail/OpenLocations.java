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
                setContentView(R.layout.locationa);
                Button button = findViewById(buttonA);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
                break;
            }
            case "Kansas River Crossing":{
                setContentView(R.layout.locationb);
                Button button = findViewById(buttonB);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
                break;
            }
            case "Big Blue River Crossing":{
                setContentView(R.layout.locationc);
                Button button = findViewById(buttonC);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
                break;
            }
            case "Fort Kearny":{
                setContentView(R.layout.locationd);
                Button button = findViewById(buttonD);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
                break;
            }
            case "Chimney Rock":{
                setContentView(R.layout.locatione);
                Button button = findViewById(buttonE);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
                break;
            }
            case "Fort Laramie":{
                setContentView(R.layout.locationf);
                Button button = findViewById(buttonF);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
                break;
            }
            case "Independence Rock":{
                setContentView(R.layout.locationg);
                Button button = findViewById(buttonG);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
                break;
            }
            case "South Pass":{
                setContentView(R.layout.locationh);
                Button button = findViewById(buttonH);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
                break;
            }
            case "Fort Bridger":{
                setContentView(R.layout.locationi);
                Button button = findViewById(buttonI);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
                break;
            }
            case "Green River":{
                setContentView(R.layout.locationj);
                Button button = findViewById(buttonJ);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
                break;
            }
            case "Soda Springs":{
                setContentView(R.layout.locationk);
                Button button = findViewById(buttonK);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
                break;
            }
            case "Fort Hall":{
                setContentView(R.layout.locationl);
                Button button = findViewById(buttonL);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
                break;
            }
            case "Snake River":{
                setContentView(R.layout.locationm);
                Button button = findViewById(buttonM);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
                break;
            }
            case "Blue Mountains":{
                setContentView(R.layout.locationn);
                Button button = findViewById(buttonN);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
                break;
            }
            case "The Dalles":{
                setContentView(R.layout.locationo);
                Button button = findViewById(buttonO);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
                break;
            }
            case "Oregon City":{
                setContentView(R.layout.locationp);
                Button button = findViewById(buttonP);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
                break;
            }
            default:setContentView(R.layout.locationa);
                break;
        }
    }
}