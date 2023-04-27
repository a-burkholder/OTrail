package com.example.OTrail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class OpenLocations extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        Map thisMap = (Map) intent.getSerializableExtra(MainGame.GAME_MAP);

        switch (thisMap.getLastLandmark()){
            case "Independence, Missouri":{
                setContentView(R.layout.locationa);

            }
            case "Kansas River Crossing":{
                setContentView(R.layout.locationb);

            }
            case "Big Blue River Crossing":{
                setContentView(R.layout.locationc);

            }
            case "Fort Kearny":{
                setContentView(R.layout.locationd);

            }
            case "Chimney Rock":{
                setContentView(R.layout.locatione);

            }
            case "Fort Laramie":{
                setContentView(R.layout.locationf);

            }
            case "Independence Rock":{
                setContentView(R.layout.locationg);

            }
            case "South Pass":{
                setContentView(R.layout.locationh);

            }
            case "Fort Bridger":{
                setContentView(R.layout.locationi);

            }
            case "Green River":{
                setContentView(R.layout.locationj);

            }
            case "Soda Springs":{
                setContentView(R.layout.locationk);

            }
            case "Fort Hall":{
                setContentView(R.layout.locationl);

            }
            case "Snake River":{
                setContentView(R.layout.locationm);

            }
            case "Blue Mountains":{
                setContentView(R.layout.locationn);

            }
            case "The Dalles":{
                setContentView(R.layout.locationo);

            }
            case "Oregon City":{
                setContentView(R.layout.locationp);

            }
            default:break;
        }
    }
}