/**
 * Programming 2 Oregon Trail Project
 * @author Alexander Burkholder
 * @since April 13, 2023
 *
 * Description: The OpenNames class sets up a layout that allows the player to enter names for the
 * four family member that are on the trail with Hattie, and their family pet.
 */

package com.example.OTrail;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class OpenNames extends AppCompatActivity {
    public static final String PARTY_NAMES = "com.example.OTrail.PARTY_NAMES";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //sets layout format
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.name_input);

        //initialize edit text boxes
        EditText text2 = findViewById(R.id.name2);
        EditText text3 = findViewById(R.id.name3);
        EditText text4 = findViewById(R.id.name4);
        EditText text5 = findViewById(R.id.name5);

        //continue button functionality
        final Button toGame = findViewById(R.id.toGame);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) final Button hintsButton = findViewById(R.id.HintsButton);
        toGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //grabs all the input names
                String name1 = "Hattie";
                String name2 = text2.getText().toString();
                String name3 = text3.getText().toString();
                String name4 = text4.getText().toString();
                String name5 = text5.getText().toString();
                String[] names = {name1, name2, name3, name4, name5};

                //starts new activity and passes the names into it
                Intent intent = new Intent(OpenNames.this, OpenDate.class);
                intent.putExtra(PARTY_NAMES, names);
                startActivity(intent);
                finish();
            }
        });
        hintsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get rid of hints button
                hintsButton.setVisibility(View.INVISIBLE);
                hintsButton.setEnabled(false);
                hintsButton.setElevation(Float.parseFloat("40.0"));
            }
        });

    }
}