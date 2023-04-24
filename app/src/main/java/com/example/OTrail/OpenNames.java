package com.example.OTrail;

import androidx.appcompat.app.AppCompatActivity;

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
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.name_input);

        final Button toGame = findViewById(R.id.toGame);
        EditText text2 = findViewById(R.id.name2);
        EditText text3 = findViewById(R.id.name3);
        EditText text4 = findViewById(R.id.name4);
        EditText text5 = findViewById(R.id.name5);


        toGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name1 = "Hattie";
                String name2 = text2.getText().toString();
                String name3 = text3.getText().toString();
                String name4 = text4.getText().toString();
                String name5 = text5.getText().toString();
                String[] names = {name1, name2, name3, name4, name5};

                Intent intent = new Intent(OpenNames.this, OpenDate.class);
                intent.putExtra(PARTY_NAMES, names);
                startActivity(intent);
            }
        });
    }
}