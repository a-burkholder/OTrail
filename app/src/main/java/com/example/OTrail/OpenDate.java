package com.example.OTrail;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
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
        RadioGroup radioGroup3 = findViewById(R.id.radioGroup3);

        toTrail.setOnClickListener(new View.OnClickListener() {

            int date[] = {0, 0, 0};
            @Override
            public void onClick(View view) {
                int id = radioGroup3.getCheckedRadioButtonId();
                switch(view.getId()) {
                    case R.id.march: {
                        date = new int[]{1, 3, 1847};
                        break;
                    }
                    case R.id.april: {
                        date = new int[]{1, 4, 1847};
                        break;
                    }
                    case R.id.may: {
                        date = new int[]{1, 5, 1847};
                        break;
                    }
                    case R.id.june: {
                        date = new int[]{1, 6, 1847};
                        break;
                    }
                    case R.id.july: {
                        date = new int[]{1, 7, 1847};
                        break;
                    }
                    case R.id.august: {
                        date = new int[]{1, 8, 1847};
                        break;
                    }
                    case R.id.september: {
                        date = new int[]{1, 9, 1847};
                        break;
                    }
                    default: {
                        date = new int[]{1, 3, 1847};
                        break;
                    }
                }
                Intent intent = new Intent(OpenDate.this, MainGame.class);
                intent.putExtra(START_DATE, date);
                startActivity(intent);
            }
        });
    }











}
