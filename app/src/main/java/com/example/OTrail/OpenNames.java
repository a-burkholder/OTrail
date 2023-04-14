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
    public static String Name1 = "Name1";
    public static String Name2 = "Name2";
    public static String Name3 = "Name3";
    public static String Name4 = "Name4";
    public static String Name5 = "Name5";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.name_input);

        final Button toGame = findViewById(R.id.toGame);
        EditText text1 = findViewById(R.id.name1);
        EditText text2 = findViewById(R.id.name2);
        EditText text3 = findViewById(R.id.name3);
        EditText text4 = findViewById(R.id.name4);
        EditText text5 = findViewById(R.id.name5);


        toGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name1 = text1.getText().toString();
                String name2 = text2.getText().toString();
                String name3 = text3.getText().toString();
                String name4 = text4.getText().toString();
                String name5 = text5.getText().toString();

                Intent intent = new Intent(OpenNames.this, MainGame.class);
                intent.putExtra(Name1, name1);
                intent.putExtra(Name2, name2);
                intent.putExtra(Name3, name3);
                intent.putExtra(Name4, name4);
                intent.putExtra(Name5, name5);
                startActivity(intent);
            }
        });
    }
}