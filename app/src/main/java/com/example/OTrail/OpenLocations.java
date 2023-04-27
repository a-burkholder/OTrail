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
                break;
            }
            case "Kansas River Crossing":{
                setContentView(R.layout.locationb);
                Button button = findViewById(R.id.button9);
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
                break;
            }
            case "Fort Kearny":{
                setContentView(R.layout.locationd);
                break;
            }
            case "Chimney Rock":{
                setContentView(R.layout.locatione);
                break;
            }
            case "Fort Laramie":{
                setContentView(R.layout.locationf);
                break;
            }
            case "Independence Rock":{
                setContentView(R.layout.locationg);
                break;
            }
            case "South Pass":{
                setContentView(R.layout.locationh);
                break;
            }
            case "Fort Bridger":{
                setContentView(R.layout.locationi);
                break;
            }
            case "Green River":{
                setContentView(R.layout.locationj);
                break;
            }
            case "Soda Springs":{
                setContentView(R.layout.locationk);
                break;
            }
            case "Fort Hall":{
                setContentView(R.layout.locationl);
                break;
            }
            case "Snake River":{
                setContentView(R.layout.locationm);
                break;
            }
            case "Blue Mountains":{
                setContentView(R.layout.locationn);
                break;
            }
            case "The Dalles":{
                setContentView(R.layout.locationo);
                break;
            }
            case "Oregon City":{
                setContentView(R.layout.locationp);
                break;
            }
            default:setContentView(R.layout.locationa);
                break;
        }
    }
}