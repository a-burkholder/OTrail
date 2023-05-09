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

import java.util.Arrays;

public class OpenDate extends AppCompatActivity {
    public static final String START_DATE = "com.example.OTrail.START_DATE";
    public static final String NAMES2 = "com.example.OTrail.NAMES2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Sets up the date layout
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.starting_date);

        //pulls data from previous activity
        Intent intent = getIntent();
        String[] names = intent.getStringArrayExtra(OpenNames.PARTY_NAMES);

        //initializes the radio group for date selection
        RadioGroup radioGroup3 = findViewById(R.id.radioGroup3);

        //does button to continue stuff
        Button toTrail = findViewById(R.id.toTrail);
        toTrail.setOnClickListener(new View.OnClickListener() {
            int date[] = {0, 0, 0};
            @Override
            public void onClick(View view) {
                //checks which date is filled
                if (radioGroup3.getCheckedRadioButtonId() == R.id.march) {
                    date = new int[]{1, 3, 1847};
                }
                else if (radioGroup3.getCheckedRadioButtonId() == R.id.april){
                    date = new int[]{1, 4, 1847};
                }
                else if (radioGroup3.getCheckedRadioButtonId() == R.id.may){
                    date = new int[]{1, 5, 1847};
                }
                else if (radioGroup3.getCheckedRadioButtonId() == R.id.june){
                    date = new int[]{1, 6, 1847};
                }
                else if (radioGroup3.getCheckedRadioButtonId() == R.id.july) {
                    date = new int[]{1, 7, 1847};
                }
                else if (radioGroup3.getCheckedRadioButtonId() == R.id.august){
                    date = new int[]{1, 8, 1847};
                }
                else if (radioGroup3.getCheckedRadioButtonId() == R.id.september){
                    date = new int[]{1, 9, 1847};
                }
                else date = new int[]{1, 3, 1847};

                //creates next activity and passes some data to it
                Intent intent = new Intent(OpenDate.this, MainGame.class);
                intent.putExtra(START_DATE, date);
                intent.putExtra(NAMES2, names);
                startActivity(intent);
                finish();
            }
        });
    }











}
