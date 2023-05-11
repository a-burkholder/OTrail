/**
 * Programming 2 Oregon Trail Project
 * @author Alexander Burkholder
 * @author Alexander Casada
 * @since April 13, 2023
 *
 * Description: The OpenTrailInfo class sets up a layout that allows the player to learn more about
 * the Oregon Trail at the start of the game.
 */
package com.example.OTrail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class OpenTrailInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //sets layout format
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trail_info);

        //back button functionality
        Button backToTitleButton = (Button) findViewById(R.id.backToTitleButton);
        backToTitleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}