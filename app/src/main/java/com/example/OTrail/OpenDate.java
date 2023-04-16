package com.example.OTrail;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class OpenDate extends AppCompatActivity
{

    RadioGroup radioGroup3;
    RadioButton march;
    RadioButton april;
    RadioButton may;
    RadioButton june;
    RadioButton july;
    RadioButton august;
    RadioButton september;

    public static final String START_DATE = "com.example.OTrail.START_DATE";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.starting_date);

        Button toTrail = findViewById(R.id.toTrail);

        toTrail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                swich(radioGroup3)
                {
                    case 
                }












                Intent intent = new Intent(OpenDate.this, MainGame.class);
                intent.putExtra(START_DATE, date);
                startActivity(intent);
            }
        });
    }











}
