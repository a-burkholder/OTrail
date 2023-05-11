/**
 * Programming 2 Oregon Trail Project
 * @author Alexander Casada
 * @author Alexander Burkholder
 * @since April 13, 2023
 *
 * Description: OpenHattieInfo allows someone to open a new layout and
 * view educational information about our main character, Hattie Campbell
 */

package com.example.OTrail;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class OpenHattieInfo extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //sets layout format
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hattie_info);

        //sets up button to return to main menu
        Button backToTitle = (Button) findViewById(R.id.backToTitle);
        backToTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}